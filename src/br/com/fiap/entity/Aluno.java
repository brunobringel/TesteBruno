package br.com.fiap.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.com.fiap.enums.Sexo;

@Entity
@Table(name="TDST_ALUNO")
public class Aluno {

	@Id
	private String rm;
	
	private String nome;
	
	private Sexo sexo;
	
	@ManyToOne(cascade=CascadeType.PERSIST)
	private GrupoAm grupo;

	
	public GrupoAm getGrupo() {
		return grupo;
	}

	public void setGrupo(GrupoAm grupo) {
		this.grupo = grupo;
	}

	public String getRm() {
		return rm;
	}

	public void setRm(String rm) {
		this.rm = rm;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Sexo getSexo() {
		return sexo;
	}

	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}
	
	
	
}
