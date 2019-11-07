package Repositorios;
import ClassesBasicas.Personagem;

public interface RepositorioPersonagem{
    void inserir(Personagem mob);
    void atualizar(Personagem mob);
    void remover(String nome);
    Personagem procurar(String nome);
    boolean existe(String nome);
}