package Excecoes;

public class MagiaNaoEncontradoException extends Exception {
	public MagiaNaoEncontradoException() {
		/*
		Caso não encontrar a Magia.
		*/
		super("Magia nao encontrado.");
	}
}
