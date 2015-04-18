package br.com.fiap.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.entity.GrupoAm;
import br.com.fiap.interfaceDAO.GrupoAmDAO;

public class GrupoAmDAOImpl extends DAOImpl<GrupoAm, Integer> implements GrupoAmDAO {

	public GrupoAmDAOImpl(EntityManager em) {
		super(em);
		
	}

}
