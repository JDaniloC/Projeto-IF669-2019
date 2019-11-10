package Repositorios;

import ClassesBasicas.Magia;
import Excecoes.MagiaJaExisteException;
import Excecoes.MagiaNaoEncontradoException;

public interface RepositorioMagia {
	void inserir(Magia mag);
    void atualizar(Magia magia) throws MagiaNaoEncontradoException;
    void remover(String nome) throws MagiaNaoEncontradoException;
    Magia procurar(String nome) throws MagiaNaoEncontradoException;    
    boolean existe(String nome) ;

}
