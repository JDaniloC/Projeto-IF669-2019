package Excecoes;

//Retorna o erro caso o Equipamento nao exista

public class EquipamentoNaoEncontradoException extends Exception{
	public EquipamentoNaoEncontradoException() {
		super("Equipamento nao encontrado.");
	}
}
