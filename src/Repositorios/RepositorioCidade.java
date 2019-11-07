package Repositorios

import ClassesBasicas.Cidade;

public interface RepositorioCidade {
    void inserir (Cidade cidade)
    void remover (String nome);
    boolean existe(String nome);
    Cidade procurar(String nome);
}

