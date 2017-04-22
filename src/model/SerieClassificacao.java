package model;

public class SerieClassificacao {
	
	private int codSerie;
	private int codAtleta;
	private double marca;
	private int colocacao;
	private String statusClassificacaoAtleta;
		
	public SerieClassificacao(int codSerie, int codAtleta, double marca, int colocacao,
			String statusClassificacaoAtleta) {
		super();
		this.codSerie = codSerie;
		this.codAtleta = codAtleta;
		this.marca = marca;
		this.colocacao = colocacao;
		this.statusClassificacaoAtleta = statusClassificacaoAtleta;
	}

	public int getCodSerie() {
		return codSerie;
	}

	public void setCodSerie(int codSerie) {
		this.codSerie = codSerie;
	}

	public int getCodAtleta() {
		return codAtleta;
	}

	public void setCodAtleta(int codAtleta) {
		this.codAtleta = codAtleta;
	}

	public double getMarca() {
		return marca;
	}

	public void setMarca(double marca) {
		this.marca = marca;
	}

	public int getColocacao() {
		return colocacao;
	}

	public void setColocacao(int colocacao) {
		this.colocacao = colocacao;
	}

	public String getStatusClassificacaoAtleta() {
		return statusClassificacaoAtleta;
	}

	public void setStatusClassificacaoAtleta(String statusClassificacaoAtleta) {
		this.statusClassificacaoAtleta = statusClassificacaoAtleta;
	}
	
	
}
