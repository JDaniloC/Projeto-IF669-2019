package Repositorios;
import ClassesBasicas.Personagem;
import Excecoes.PersonagemNaoExisteException;

public interface RepositorioPersonagem{
    void inserir(Personagem mob);
    void atualizar(Personagem mob) throws PersonagemNaoExisteException;
    void remover(String nome) throws PersonagemNaoExisteException;
    Personagem procurar(String nome) throws PersonagemNaoExisteException;
    boolean existe(String nome);
}