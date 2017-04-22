package model;

public class Torneio {

	private int codTorneio;
	private String nome;
	private int grauDificuldade;
	private String status;
	
		
	public Torneio(String nome, int grauDificuldade, String status) {
		super();
		this.nome = nome;
		this.grauDificuldade = grauDificuldade;
		this.status = status;
	}
	public Torneio(int codTorneio, String nome, int grauDificuldade, String status) {
		super();
		this.codTorneio = codTorneio;
		this.nome = nome;
		this.grauDificuldade = grauDificuldade;
		this.status = status;
	}
	public int getCodTorneio() {
		return codTorneio;
	}
	public void setCodTorneio(int codTorneio) {
		this.codTorneio = codTorneio;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getGrauDificuldade() {
		return grauDificuldade;
	}
	public void setGrauDificuldade(int grauDificuldade) {
		this.grauDificuldade = grauDificuldade;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
}
