package br.com.fiap.entity;

import java.util.Calendar;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@SequenceGenerator(name="seqProjeto", sequenceName="SEQ_PROJETO_AM", allocationSize=1)
@Table(name="TDST_PROJETO_AM")
public class ProjetoAm {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seqProjeto")
	private int codigo;
	
	private String nome;
	
	private String tema;
	
	private float nota;

	private boolean entregue;
	
	@Temporal(TemporalType.DATE)
	@Column(name="DT_ENTREGA")
	private Calendar dataEntrega;

	@OneToOne(mappedBy="projeto", fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	private GrupoAm grupo;
	
	//Mapeamento bi-direcional Muitos para Muitos
	@ManyToMany(mappedBy="projetos")
	private List<Professor> profs;
	
	public GrupoAm getGrupo() {
		return grupo;
	}

	public void setGrupo(GrupoAm grupo) {
		this.grupo = grupo;
	}

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

	public String getTema() {
		return tema;
	}

	public void setTema(String tema) {
		this.tema = tema;
	}

	public float getNota() {
		return nota;
	}

	public void setNota(float nota) {
		this.nota = nota;
	}

	public boolean isEntregue() {
		return entregue;
	}

	public void setEntregue(boolean entregue) {
		this.entregue = entregue;
	}

	public Calendar getDataEntrega() {
		return dataEntrega;
	}

	public void setDataEntrega(Calendar dataEntrega) {
		this.dataEntrega = dataEntrega;
	}

	public List<Professor> getProfs() {
		return profs;
	}

	public void setProfs(List<Professor> profs) {
		this.profs = profs;
	}
	
	
	
	
}
