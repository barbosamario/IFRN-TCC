package oitbpm.nc.bd_8bpm.negocio;

import java.util.List;
import java.util.ArrayList;

public class Policial {

	private int id;
	private String nome;
	private String matricula;
	
	private List<Dependente>dependente;
	
	public Policial(){
		super();
		dependente = new ArrayList<>();
	}
	
	public Policial(int id, String nome, String matricula, List<Dependente>dependente){
		super();
		this.id = id;
		this.nome = nome;
		this.matricula = matricula;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public List<Dependente> getDependente() {
		return dependente;
	}

	public void setDependente(List<Dependente> dependente) {
		this.dependente = dependente;
	}

}
