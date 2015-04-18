package br.com.fiap.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.entity.Professor;
import br.com.fiap.interfaceDAO.ProfessorDAO;

public class ProfessorDAOImpl extends DAOImpl<Professor, Integer> implements ProfessorDAO {

	public ProfessorDAOImpl(EntityManager em) {
		super(em);
		
	}

}
