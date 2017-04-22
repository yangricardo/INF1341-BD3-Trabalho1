package model;

public class Modalidade {
	private int codModalidade;
	private String nome;
	private String sexo;
	public Modalidade(int codModalidade, String nome, String sexo) {
		super();
		this.codModalidade = codModalidade;
		this.nome = nome;
		this.sexo = sexo;
	}
	public Modalidade(String nome, String sexo) {
		super();
		this.nome = nome;
		this.sexo = sexo;
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
