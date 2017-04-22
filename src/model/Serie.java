package model;

public class Serie {

	private int codSerie;
	private int codProva;
	private String etapa;
	private String dataRealizacao;
	private String status;
	public Serie(int codSerie, int codProva, String etapa, String dataRealizacao, String status) {
		super();
		this.codSerie = codSerie;
		this.codProva = codProva;
		this.etapa = etapa;
		this.dataRealizacao = dataRealizacao;
		this.status = status;
	}
	public Serie(int codProva, String etapa, String dataRealizacao, String status) {
		super();
		this.codProva = codProva;
		this.etapa = etapa;
		this.dataRealizacao = dataRealizacao;
		this.status = status;
	}
	public int getCodSerie() {
		return codSerie;
	}
	public void setCodSerie(int codSerie) {
		this.codSerie = codSerie;
	}
	public int getCodProva() {
		return codProva;
	}
	public void setCodProva(int codProva) {
		this.codProva = codProva;
	}
	public String getEtapa() {
		return etapa;
	}
	public void setEtapa(String etapa) {
		this.etapa = etapa;
	}
	public String getDataRealizacao() {
		return dataRealizacao;
	}
	public void setDataRealizacao(String dataRealizacao) {
		this.dataRealizacao = dataRealizacao;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
}
