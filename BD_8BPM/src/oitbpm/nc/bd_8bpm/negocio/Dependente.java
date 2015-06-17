package oitbpm.nc.bd_8bpm.negocio;

public class Dependente {

	private int id;
	private String conjuge;
	private String filhos;
	private String filiacao;
	
	
	private Policial responsavel;
	
	public Dependente(){
		super();
	}
	
	public Dependente(int id, String conjuge, String filhos, String filiacao, Policial responsavel){
		super();
		this.id = id;
		this.conjuge = conjuge;
		this.responsavel = responsavel;
		this.filhos = filhos;
		this.filiacao = filiacao;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getConjuge() {
		return conjuge;
	}

	public void setConjuge(String conjuge) {
		this.conjuge = conjuge;
	}

	public String getFilhos() {
		return filhos;
	}

	public void setFilhos(String filhos) {
		this.filhos = filhos;
	}

	public String getFiliacao() {
		return filiacao;
	}

	public void setFiliacao(String filiacao) {
		this.filiacao = filiacao;
	}

	public Policial getResponsavel() {
		return responsavel;
	}

	public void setResponsavel(Policial responsavel) {
		this.responsavel = responsavel;
	}

	public void setPolicial(Policial policiais) {
		// TODO Auto-generated method stub
		
	}

	public String getPolicial() {
		// TODO Auto-generated method stub
		return null;
	}


}
