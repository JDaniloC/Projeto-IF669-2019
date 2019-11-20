package Excecoes;

public class MagiaJaExisteException extends Exception {
	public MagiaJaExisteException() {
		/*
		Caso a Magia já existir, e não inserir duplicado.
		*/
		super("Magia ja cadastrado.");
	}
}
