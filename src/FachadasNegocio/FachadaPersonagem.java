package ClasseRegraNegocio;

import ClassesBasicas.Personagem;
import Excecoes.PersonagemJaExisteException;
import Excecoes.PersonagemNaoExisteException;
import Repositorios.RepositorioPersonagem;

public class FachadaPersonagem{
    RepositorioPersonagem repositorio;

    public FachadaPersonagem(RepositorioPersonagem repositorio){
        this.repositorio = repositorio;
    }
    public void inserir(Personagem person) throws PersonagemJaExisteException{
        if (repositorio.existe(person.getNome())){
            throw new PersonagemJaExisteException();
        } else{
            repositorio.inserir(person);
        }
    }
    public void atualizar(Personagem person) throws PersonagemNaoExisteException{
        repositorio.atualizar(person);
    }
    public Personagem procurar(String nome) throws PersonagemNaoExisteException{
        return repositorio.procurar(nome);
    }
    public void remover(String nome) throws PersonagemNaoExisteException{
        repositorio.remover(nome);
    }
    public boolean existe(String nome){
        return repositorio.existe(nome);
    }
    // Colocar mais regras.
}