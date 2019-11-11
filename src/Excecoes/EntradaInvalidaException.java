package Excecoes;

public class EntradaInvalidaException extends Exception {
    public EntradaInvalidaException() {
		super("Comando não reconhecido.");
	}
}
