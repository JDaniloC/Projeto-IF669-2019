package Excecoes;

//retorna o erro de cidade existente caso a cidade já esteja no repositório

public class CidadeInvalidaException extends Exception{
    public CidadeInvalidaException(){
        super("Entrada de cidade inválida!")
    }
}