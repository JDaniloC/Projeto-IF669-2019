package Excecoes;

//retorna o erro de cidade existente caso a cidade já esteja no repositório

public class CidadeJaExisteException extends Exception{
    public CidadeJaExisteException(){
        super("Cidade ja existe!")
    }
}