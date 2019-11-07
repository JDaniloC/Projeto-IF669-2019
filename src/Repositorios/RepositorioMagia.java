package Repositorios;

import ClassesBasicas.Magia;

public interface RepositorioMagia {
	void inserir(Magia mag);
    void atualizar(Magia magia);
    void remover(String nome);
    Magia procurar(String nome);    
    boolean existe(String nome);

}
