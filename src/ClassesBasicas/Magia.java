package ClassesBasicas;

public class Magia {
	private String nome;
	private int dano;
	private int gasto;
	private int cura;
	private String efeito;
	private String tipo;
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getDano() {
		return dano;
	}
	public void setDano(int dano) {
		this.dano = dano;
	}
	public int getGasto() {
		return gasto;
	}
	public void setGasto(int gasto) {
		this.gasto = gasto;
	}
	public int getCura() {
		return cura;
	}
	public void setCura(int cura) {
		this.cura = cura;
	}
	public String getEfeito() {
		return efeito;
	}
	public void setEfeito(String efeito) {
		this.efeito = efeito;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	public Magia() {
		this.nome = null;
		this.dano = 0;
		this.gasto = 0;
		this.cura = 0;
		this.efeito = null;
		this.tipo = null;
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
