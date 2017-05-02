package model;

public class Serie {

	private int codSerie;
	private int codProva;
	private String etapa;
	private String data;
	private String status;
	private String hora;
	public Serie(int codSerie, int codProva, String etapa, String data,String hora, String status) {
		super();
		this.codSerie = codSerie;
		this.codProva = codProva;
		this.etapa = etapa;
		this.data = data;
		this.setHora(hora);
		this.status = status;
	}
	public Serie(int codProva, String etapa, String data,String hora, String status) {
		super();
		this.codProva = codProva;
		this.etapa = etapa;
		this.data = data;
		this.setHora(hora);
		this.status = status;
	}
	
	
	
	public Serie(String etapa, String data, String status, String hora) {
		super();
		this.etapa = etapa;
		this.data = data;
		this.status = status;
		this.hora = hora;
	}
	public Serie() {
		super();
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
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public String getHora() {
		return hora;
	}
	public void setHora(String hora) {
		this.hora = hora;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
}
