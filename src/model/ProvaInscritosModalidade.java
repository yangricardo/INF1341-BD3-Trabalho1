package model;

public class ProvaInscritosModalidade {

	private int codProva;
	private int codTorneio;
	private int codModalidade;
	private String nomeModalidade;
	private int codAtleta;
	private String nomeAtleta;
	private String sexo;
	private float notaGeral;
	
	public ProvaInscritosModalidade() {
		super();
	}
	public ProvaInscritosModalidade(int codProva, int codTorneio, int codModalidade, String nomeModalidade,
			int codAtleta, String nomeAtleta, String sexo, float notaGeral) {
		super();
		this.codProva = codProva;
		this.codTorneio = codTorneio;
		this.codModalidade = codModalidade;
		this.nomeModalidade = nomeModalidade;
		this.codAtleta = codAtleta;
		this.nomeAtleta = nomeAtleta;
		this.sexo = sexo;
		this.notaGeral = notaGeral;
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
	public String getNomeModalidade() {
		return nomeModalidade;
	}
	public void setNomeModalidade(String nomeModalidade) {
		this.nomeModalidade = nomeModalidade;
	}
	public int getCodAtleta() {
		return codAtleta;
	}
	public void setCodAtleta(int codAtleta) {
		this.codAtleta = codAtleta;
	}
	public String getNomeAtleta() {
		return nomeAtleta;
	}
	public void setNomeAtleta(String nomeAtleta) {
		this.nomeAtleta = nomeAtleta;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public float getNotaGeral() {
		return notaGeral;
	}
	public void setNotaGeral(float notaGeral) {
		this.notaGeral = notaGeral;
	}

}
