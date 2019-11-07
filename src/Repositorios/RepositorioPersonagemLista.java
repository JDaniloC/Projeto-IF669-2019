package Repositorios;
import ClassesBasicas.Personagem;

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
    public void atualizar(Personagem person){
        // Implementar!
    }
    public void remover(String nome){
        if (person != null && person.getNome().equals(nome)){
            if (next != null){
                person = next.person;
                next = next.next;
            } else{
                person = null;
            }
        } else if (next != null) {
            next.remover(nome);
        }
    }
    public Personagem procurar(String nome){
        if (person != null && person.getNome().equals(nome)){
            return person;
        } else if (next != null){
            return next.procurar(nome);
        } 
        return null;
    }
    public boolean existe(String nome){
        return procurar(nome) == null ? false : true;
    }
}