package Excecoes;

//Retorna o erro caso o Equipamento ja esteja inserido no repositorio

public class EquipamentoJaCadastradoException extends Exception {
	public EquipamentoJaCadastradoException() {
		super("Equipamento ja cadastrado.");
	}

}
