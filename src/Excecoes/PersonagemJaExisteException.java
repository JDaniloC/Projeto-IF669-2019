package Excecoes;

public class PersonagemJaExisteException extends Exception{
    public PersonagemJaExisteException(){
        super("Personagem ja existe!");
    }
}