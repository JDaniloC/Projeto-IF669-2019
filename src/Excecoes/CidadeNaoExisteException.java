package Excecoes;

//retorna o erro de cidade inexistente caso a cidade não seja encontrada no repositório

public class CidadeNaoExisteException extends Exception{
    public CidadeNaoExisteException(){
        super("Cidade nao existe!")
    }
}