package model;

public class Atleta {

	private int codAtleta;
	private String cpf;
	private String nome;
	private String sexo;
	private String dataNascimento;
	private String nacionalidade;
	
	public Atleta() {
		super();
	}
	public Atleta(String cpf, String nome, String sexo, String dataNascimento, String nacionalidade) {
		super();
		this.cpf = cpf;
		this.nome = nome;
		this.sexo = sexo;
		this.dataNascimento = dataNascimento;
		this.nacionalidade = nacionalidade;
	}
	public Atleta(int codAtleta, String cpf, String nome, String sexo, String dataNascimento, String nacionalidade) {
		super();
		this.codAtleta = codAtleta;
		this.cpf = cpf;
		this.nome = nome;
		this.sexo = sexo;
		this.dataNascimento = dataNascimento;
		this.nacionalidade = nacionalidade;
	}
	
	public int getCodAtleta() {
		return codAtleta;
	}
	public void setCodAtleta(int codAtleta) {
		this.codAtleta = codAtleta;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public String getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	public String getNacionalidade() {
		return nacionalidade;
	}
	public void setNacionalidade(String nacionalidade) {
		this.nacionalidade = nacionalidade;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
}
