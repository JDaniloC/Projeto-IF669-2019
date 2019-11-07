package Excecoes;

public class PersonagemNaoExisteException extends Exception{
    public PersonagemNaoExisteException(){
        super("Personagem nao encontrado!");
    }
}