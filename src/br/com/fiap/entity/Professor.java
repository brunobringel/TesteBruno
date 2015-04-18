package br.com.fiap.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@SequenceGenerator(name="seqProf", sequenceName="SEQ_PROFESSOR", allocationSize=1)
@Table(name="TDST_PROFESSOR")
public class Professor {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seqProf")
	private int codigo;
	
	private String nome;
	
	//Relacionamento Muitos para Muitos
	//Jointable é opcional
	
	@ManyToMany(cascade=CascadeType.PERSIST)
	@JoinTable(name="TDST_PROFESSOR_PROJETO", joinColumns={@JoinColumn(name="CD_PROFESSOR")},
		inverseJoinColumns={@JoinColumn(name="CD_PROJETO")})
	private List<ProjetoAm> projetos;

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<ProjetoAm> getProjetos() {
		return projetos;
	}

	public void setProjetos(List<ProjetoAm> projetos) {
		this.projetos = projetos;
	}
	
	
	
	
	
}
