package model;

public class Prova {

	private int codProva;
	private int codTorneio;
	private int codModalidade;
	
	public Prova(int codTorneio, int codModalidade) {
		super();
		this.codTorneio = codTorneio;
		this.codModalidade = codModalidade;
	}
	public Prova(int codProva, int codTorneio, int codModalidade) {
		super();
		this.codProva = codProva;
		this.codTorneio = codTorneio;
		this.codModalidade = codModalidade;
	}
	public int getCodProva() {
		return codProva;
	}
	public void setCodProva(int codProva) {
		this.codProva = codProva;
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
	
	
	
}
