package Excecoes;

//retorna o erro de cidade existente caso a cidade já esteja no repositório

public class MissaoInvalidaException extends Exception{
    public MissaoInvalidaException(){ super("Missão inválida!")   }
}