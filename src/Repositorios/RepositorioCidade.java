package Repositorios;
import ClassesBasicas.Cidade;
import Excecoes.CidadeJaExisteException;
import Excecoes.CidadeNaoExisteException;

// Interface com os métodos do repositório da classe Cidade
public interface RepositorioCidade {
    void inserir (Cidade cidade) throws CidadeJaExisteException;
    void remover (String nome);
    boolean existe(String nome);
    Cidade procurar(String nome) throws CidadeNaoExisteException;
}