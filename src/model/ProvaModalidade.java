package model;

public class ProvaModalidade {
	private int codProva;
	private int codTorneio;
	private int codModalidade;
	private String nome;
	private String sexo;
	
	public ProvaModalidade(int codProva, int codTorneio, int codModalidade, String nome, String sexo) {
		super();
		this.codProva = codProva;
		this.codTorneio = codTorneio;
		this.codModalidade = codModalidade;
		this.nome = nome;
		this.sexo = sexo;
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

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	
	
	
}
