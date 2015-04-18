package br.com.fiap.dao.impl;

import java.lang.reflect.ParameterizedType;

import javax.persistence.EntityManager;

import br.com.fiap.exceptions.BDException;
import br.com.fiap.exceptions.IdNaoEncontradoException;
import br.com.fiap.interfaceDAO.DAO;

public class DAOImpl<T, K> implements DAO<T, K>{

	private EntityManager em;
	
	//Esse atributo só é recuperado em tempo de execusão
	private Class<T> classe;
	
	@SuppressWarnings("unchecked")
	public DAOImpl(EntityManager em) {
		this.em = em;
		this.classe = (Class<T>)((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}

	@Override
	public T registrar(T entidade) throws BDException {
		try{
		em.getTransaction().begin();
		em.persist(entidade);
		em.getTransaction().commit();
		}catch(Exception e){
			if(em.getTransaction().isActive())
				em.getTransaction().rollback();
			throw new BDException("Erro ao persistir");
		}
		return entidade;
	}

	@Override
	public void atualizar(T entidade) throws BDException {
		try{
			em.getTransaction().begin();
			em.merge(entidade);
			em.getTransaction().commit();
		}catch(Exception e){
			if(em.getTransaction().isActive())
				em.getTransaction().rollback();
			throw new BDException("Erro ao Atualizar!");
		}
		
	}

	@Override
	public void excluir(K id) throws BDException, IdNaoEncontradoException {
		T entidade = buscarPorId(id);
		if(entidade == null)
			throw new IdNaoEncontradoException("ID não encontrado!");
		try{
			em.getTransaction().begin();
			em.remove(entidade);
			em.getTransaction().commit();
		}catch(Exception e){
			if(em.getTransaction().isActive())
				em.getTransaction().rollback();
			throw new BDException("Erro ao Remover!");
		}	
		
	}

	@Override
	public T buscarPorId(K id) {
		return em.find(classe, id);
	}

}
