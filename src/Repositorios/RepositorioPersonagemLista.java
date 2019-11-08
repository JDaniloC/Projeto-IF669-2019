package Repositorios;
import ClassesBasicas.Personagem;
import Excecoes.PersonagemNaoExisteException;

public class RepositorioPersonagemLista implements RepositorioPersonagem{
    private Personagem person;
    private RepositorioPersonagemLista next;

    public RepositorioPersonagemLista(){
        person = null;
        next = null;
    }
    public void inserir(Personagem person){
        if (person == null){
            this.person = person;
        } else{
            if (next == null){
                next = new RepositorioPersonagemLista();
            } 
            next.inserir(person);
        }
    }
    public void atualizar(Personagem person) throws PersonagemNaoExisteException{
        if (this.person != null && person.getNome().equals(this.person.getNome())){
            this.person = person;
        } else{
            if (next != null){
                next.atualizar(person);
            } else{
                throw new PersonagemNaoExisteException();
            }
        }
    }
    public void remover(String nome) throws PersonagemNaoExisteException{
        if (person != null && person.getNome().equals(nome)){
            if (next != null){
                person = next.person;
                next = next.next;
            } else{
                person = null;
            }
        } else if (next != null) {
            next.remover(nome);
        } else{
            throw new PersonagemNaoExisteException();
        }
    }
    public Personagem procurar(String nome) throws PersonagemNaoExisteException{
        if (person != null && person.getNome().equals(nome)){
            return person;
        } else if (next != null){
            return next.procurar(nome);
        } else{
            throw new PersonagemNaoExisteException();
        }
    }
    public boolean existe(String nome){
        if (person != null && person.getNome().equals(nome)){
            return true;
        } else if (next != null){
            return next.existe(nome);
        } else{
            return false;
        }
    }
}