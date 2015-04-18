package br.com.fiap.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.entity.ProjetoAm;
import br.com.fiap.interfaceDAO.ProjetoAmDAO;

public class ProjetoAmDAOImpl extends DAOImpl<ProjetoAm, Integer> implements ProjetoAmDAO{

	public ProjetoAmDAOImpl(EntityManager em) {
		super(em);
	
	}

}
