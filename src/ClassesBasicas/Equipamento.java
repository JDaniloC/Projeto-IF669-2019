package ClassesBasicas;

public class Equipamento {
	private String nome;
	private int preco;
	private int ataque;
	private int defesa;
	private int vidaPlus;
	private String atributosEsp;

	/*
	 * Atribuicao de valores aos seus atributos quando um Equipamento for criado
	 */
	public Equipamento(String nome, int preco, int ataque, int defesa, int vidaPlus, String atributosEsp) {
		this.nome = nome;
		this.preco = preco;
		this.ataque = ataque;
		this.defesa = defesa;
		this.vidaPlus = vidaPlus;
		this.atributosEsp = atributosEsp;
	}

	/*
	 * Gets irao retornar os atributos
	 */
	public String getNome() { return nome; }
	public int getPreco() { return preco; }
	public int getAtaque() { return ataque; }
	public int getDefesa() { return defesa; }
	public int getVidaPlus() { return vidaPlus; }
	public String getAtributosEsp() { return atributosEsp; }

	/*
	 * Sets irao modificar os atributos
	 */
	public void setNome(String nome) { this.nome = nome; }
	public void setPreco(int preco) { this.preco = preco; }
	public void setAtaque(int ataque) { this.ataque = ataque; }
	public void setDefesa(int defesa) { this.defesa = defesa; }
	public void setVidaPlus(int vidaPlus) { this.vidaPlus = vidaPlus; }
	public void setAtributosEsp(String atributosEsp) { this.atributosEsp = atributosEsp; }
}