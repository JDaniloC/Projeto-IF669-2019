package Excecoes;

public class EntradaInvalidaException extends Exception {
    public EntradaInvalidaException() {
			/*
			Uma classe que mostra que o comando não é o esperado.
			*/
			super("Comando não reconhecido.");
		}
}
