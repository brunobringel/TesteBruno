package br.com.fiap.teste;

import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.persistence.EntityManager;

import br.com.fiap.dao.impl.ProjetoAmDAOImpl;
import br.com.fiap.entity.GrupoAm;
import br.com.fiap.entity.ProjetoAm;
import br.com.fiap.exceptions.BDException;
import br.com.fiap.interfaceDAO.ProjetoAmDAO;
import br.com.fiap.singleton.EMFactorySingleton;

public class CadastroProjetoGrupoView {

	public static void main(String[] args) {
		EntityManager em = EMFactorySingleton
				.getInstance().createEntityManager();
		
		//Cadastar um Grupo e um Projeto de AM
		GrupoAm grupo = new GrupoAm();
		grupo.setNome("Java Project");
		
		ProjetoAm projeto = new ProjetoAm();
		projeto.setEntregue(false);
		projeto.setNome("Lava jato");
		projeto.setTema("Carro");
		projeto.setDataEntrega(
				new GregorianCalendar(2015,Calendar.OCTOBER,15));
		//Associar o projeto ao grupo
		projeto.setGrupo(grupo);
		//Sempre preencher o lado que não tem o mappedBy ** se não não vincula o mapeamento.
		grupo.setProjeto(projeto);
		
		ProjetoAmDAO dao = new ProjetoAmDAOImpl(em);
		try {
			//Cadastrando um projeto
			dao.registrar(projeto);
		} catch (BDException e) {
			e.printStackTrace();
		}
		
	}
	
}



