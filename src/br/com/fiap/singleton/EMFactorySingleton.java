package br.com.fiap.singleton;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EMFactorySingleton {

	//Contrutor privado -> Ninguém consegue instanciar
	private EMFactorySingleton(){ }
	
	private static EntityManagerFactory factory;
	
	public static EntityManagerFactory getInstance(){
		if(factory == null){  						// O valor vem do persistence.xml
			factory = Persistence.createEntityManagerFactory("CLIENTE_ORACLE"); 
		}
		return factory;
	}
	
	
	
	
}
