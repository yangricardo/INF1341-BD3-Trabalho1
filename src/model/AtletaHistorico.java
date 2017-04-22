package model;

public class AtletaHistorico {

	private int codAtleta;
	private int codTorneio;
	private int codModalidade;
	private double marca;
	private int colocacao;
	private int nota;
	
	public AtletaHistorico(int codAtleta, int codTorneio, int codModalidade, double marca, int colocacao) {
		super();
		this.codAtleta = codAtleta;
		this.codTorneio = codTorneio;
		this.codModalidade = codModalidade;
		this.marca = marca;
		this.colocacao = colocacao;
	}
	public AtletaHistorico(int codAtleta, int codTorneio, int codModalidade, double marca, int colocacao, int nota) {
		super();
		this.codAtleta = codAtleta;
		this.codTorneio = codTorneio;
		this.codModalidade = codModalidade;
		this.marca = marca;
		this.colocacao = colocacao;
		this.nota = nota;
	}
	public int getCodAtleta() {
		return codAtleta;
	}
	public void setCodAtleta(int codAtleta) {
		this.codAtleta = codAtleta;
	}
	public int getCodTorneio() {
		return codTorneio;
	}
	public void setCodTorneio(int codTorneio) {
		this.codTorneio = codTorneio;
	}
	public int getCodModalidade() {
		return codModalidade;
	}
	public void setCodModalidade(int codModalidade) {
		this.codModalidade = codModalidade;
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
	public int getNota() {
		return nota;
	}
	public void setNota(int nota) {
		this.nota = nota;
	}
	
	
}
