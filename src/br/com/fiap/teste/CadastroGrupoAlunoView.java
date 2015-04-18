package br.com.fiap.teste;

import javax.persistence.EntityManager;

import br.com.fiap.dao.impl.GrupoAmDAOImpl;
import br.com.fiap.entity.Aluno;
import br.com.fiap.entity.GrupoAm;
import br.com.fiap.enums.Sexo;
import br.com.fiap.exceptions.BDException;
import br.com.fiap.interfaceDAO.GrupoAmDAO;
import br.com.fiap.singleton.EMFactorySingleton;

public class CadastroGrupoAlunoView {

	public static void main(String[] args) {
		
		//Cadastrar o grupo e os alunos.
		EntityManager em = EMFactorySingleton.getInstance().createEntityManager();
		
		GrupoAm grupo = new GrupoAm();
		grupo.setNome("2TDST Solutions");
	
		
		Aluno aluno1 = new  Aluno();
		aluno1.setNome("João");
		aluno1.setRm("RM156415");
		aluno1.setSexo(Sexo.MASCULINO);
		
		Aluno aluno2 = new Aluno();
		aluno2.setNome("Maria");
		aluno2.setRm("RM15155");
		aluno2.setSexo(Sexo.FEMININO);
		
		//Assiciar o grupo com o aluno
		grupo.addAluno(aluno1);
		grupo.addAluno(aluno2);
		
		//Persistir o grupo (alunos vão em cascata)
		GrupoAmDAO dao = new GrupoAmDAOImpl(em);
		try {
			dao.registrar(grupo);
		} catch (BDException e) {
			e.printStackTrace();
		}
	
		
	}

}
