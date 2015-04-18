package br.com.fiap.teste;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.fiap.dao.impl.ProfessorDAOImpl;
import br.com.fiap.entity.Professor;
import br.com.fiap.entity.ProjetoAm;
import br.com.fiap.exceptions.BDException;
import br.com.fiap.interfaceDAO.ProfessorDAO;
import br.com.fiap.singleton.EMFactorySingleton;

public class CadastroProjetoProfessoresView {

	public static void main(String[] args) {
		//Cadastrar Professores e Projetos (ao menos 2)
		
		EntityManager em = EMFactorySingleton.getInstance().createEntityManager();
		
		
		
		ProjetoAm projeto1 = new ProjetoAm();
		projeto1.setNome("Projeto 1");
		
		ProjetoAm projeto2 = new ProjetoAm();
		projeto2.setNome("Projeto 2");
		
		Professor p1 = new Professor();
		p1.setNome("Professor 1");
		
		Professor p2 = new Professor();
		p2.setNome("Professor 2");
		
		List<ProjetoAm> lista = new ArrayList<ProjetoAm>();
		lista.add(projeto1);
		lista.add(projeto2);
		
		//Associar o Professor com o projeto
		p1.setProjetos(lista);
		p2.setProjetos(lista);
				
		ProfessorDAO dao = new ProfessorDAOImpl(em);
		//Cadastra os dosi professores
		
		try {
			dao.registrar(p1);
			dao.registrar(p2);
		} catch (BDException e) {
			e.printStackTrace();
		}
		

	}

}
