package model;

public class ProvaInscritos {

	private int codProva;
	private int codAtleta;

	public ProvaInscritos(int codProva, int codAtleta) {
		super();
		this.codProva = codProva;
		this.codAtleta = codAtleta;
	}

	public int getCodProva() {
		return codProva;
	}

	public void setCodProva(int codProva) {
		this.codProva = codProva;
	}

	public int getCodAtleta() {
		return codAtleta;
	}

	public void setCodAtleta(int codAtleta) {
		this.codAtleta = codAtleta;
	}
	
	
	
}
