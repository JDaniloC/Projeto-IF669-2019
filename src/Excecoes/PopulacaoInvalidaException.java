package Excecoes;

//retorna o erro de cidade existente caso a cidade já esteja no repositório

public class PopulacaoInvalidaException extends Exception{
    public PopulacaoInvalidaException(){
        super("Valor para população inválido!")
    }
}