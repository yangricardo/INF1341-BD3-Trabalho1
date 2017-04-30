package model;

public class Prova {

	private int codProva;
	private int codTorneio;
	private int codModalidade;
	private String sexo;
	
	public Prova(int codTorneio, int codModalidade, String sexo) {
		super();
		this.codTorneio = codTorneio;
		this.codModalidade = codModalidade;
		this.setSexo(sexo);
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
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	
	
	
}
