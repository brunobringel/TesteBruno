package br.com.fiap.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@SequenceGenerator(name="seqGrupo", sequenceName="SEQ_GRUPO_AM", allocationSize=1)
@Table(name="TDST_GRUPO_AM")
public class GrupoAm {

	public GrupoAm(){
		//Inicializando a lista de Alunos
		alunos = new ArrayList<Aluno>();
	}
	
	@Id
	@GeneratedValue(generator="seqGrupo", strategy=GenerationType.SEQUENCE)
	private int codigo;
	
	private String nome;
	
	//Relaciomento Um para Um
	@OneToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	private ProjetoAm projeto;
	
	//Relacionamento Um para muitod bi-direcional
	@OneToMany(mappedBy="grupo", cascade=CascadeType.PERSIST)
	private List<Aluno> alunos;
		
	public void addAluno(Aluno aluno){
		//Adiciona o aluno na lista
		alunos.add(aluno);
		//Relaciona o aluno com o grupo
		aluno.setGrupo(this);
	}
	
	public ProjetoAm getProjeto() {
		return projeto;
	}

	public void setProjeto(ProjetoAm projeto) {
		this.projeto = projeto;
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

	public List<Aluno> getAlunos() {
		return alunos;
	}

	public void setAlunos(List<Aluno> alunos) {
		this.alunos = alunos;
	}
	
	
	
	
}
