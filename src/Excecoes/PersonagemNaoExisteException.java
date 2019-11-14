package Excecoes;

public class PersonagemNaoExisteException extends Exception{
    public PersonagemNaoExisteException(){
        /*
        Quando não foi encontrado o personagem.
        */
        super("Personagem nao encontrado!");
    }
}