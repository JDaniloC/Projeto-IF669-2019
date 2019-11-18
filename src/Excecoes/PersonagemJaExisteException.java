package Excecoes;

public class PersonagemJaExisteException extends Exception{
    public PersonagemJaExisteException(){
        /*
        Quando o personagem já existe, não podendo cadastra-lo novamente.
        */
        super("Personagem ja existe!");
    }
}