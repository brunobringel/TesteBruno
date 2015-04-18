package br.com.fiap.teste;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.fiap.dao.impl.GrupoAmDAOImpl;
import br.com.fiap.entity.Aluno;
import br.com.fiap.entity.GrupoAm;
import br.com.fiap.interfaceDAO.GrupoAmDAO;
import br.com.fiap.singleton.EMFactorySingleton;

public class BuscaGrupoView {

	public static void main(String[] args) {
		//Buscar o grupo e exibir os alunos;
		
		EntityManager em = EMFactorySingleton.getInstance().createEntityManager();
		
		GrupoAmDAO dao = new GrupoAmDAOImpl(em);
		//Busca o grupo 1 no Banco
		GrupoAm grupo = dao.buscarPorId(3);
		//recupera a lista de alinos do grupo
		
		List<Aluno> lista = grupo.getAlunos();
		System.out.println("Grupo: " + grupo.getNome());
			for (Aluno aluno : lista) {
				System.out.println(aluno.getNome());
			}
		
	}

}
