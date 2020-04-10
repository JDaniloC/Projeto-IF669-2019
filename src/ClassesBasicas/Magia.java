package ClassesBasicas;

public class Magia {
	// Atributos da classe
	private String nome;
	private int dano;
	private int gasto;
	private int cura;
	private String efeito;
	private String tipo;
	//Gets
	public String getNome() {
		return nome;
	}
	public int getDano() {
		return dano;
	}
	public int getGasto() {
		return gasto;
	}
	public int getCura() {
		return cura;
	}
	public String getEfeito() {
		return efeito;
	}
	public String getTipo() {
		return tipo;
	}
	
	//Sets
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public void setDano(int dano) {
		this.dano = dano;
	}
	
	public void setGasto(int gasto) {
		this.gasto = gasto;
	}
	
	public void setCura(int cura) {
		this.cura = cura;
	}
	
	public void setEfeito(String efeito) {
		this.efeito = efeito;
	}
	
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	//Construtores 
	public Magia(String nome) {
		this.nome = nome;
		this.dano = 0;
		this.gasto = 0;
		this.cura = 0;
		this.efeito = "nenhum";
		this.tipo = "normal";
	}
	
	public Magia(String nome, int dano, int gasto, int cura, String efeito, String tipo) {
		this.nome = nome;
		this.dano = dano;
		this.gasto = gasto;
		this.cura = cura;
		this.efeito = efeito;
		this.tipo = tipo;
	}

}
