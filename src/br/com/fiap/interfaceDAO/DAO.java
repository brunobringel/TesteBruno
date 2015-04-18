package br.com.fiap.interfaceDAO;

import br.com.fiap.exceptions.BDException;
import br.com.fiap.exceptions.IdNaoEncontradoException;

// T = Entidade passada como parâmentro 
// K = Número passado como parâmetro
public interface DAO<T,K> {

	T registrar(T entidade) throws BDException;
	
	void atualizar(T entidade) throws BDException;
	
	void excluir(K id) throws BDException, IdNaoEncontradoException;
	
	T buscarPorId(K id);
	
	
}
