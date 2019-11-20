package Repositorios;
import ClassesBasicas.Cidade;
import Excecoes.CidadeJaExisteException;
import Excecoes.CidadeNaoExisteException;

// Interface com os métodos do repositório da classe Cidade
public interface RepositorioCidade {
    void inserir (Cidade cidade);
    void remover (String nome) throws CidadeNaoExisteException;
    boolean existe(String nome);
    Cidade procurar(String nome) throws CidadeNaoExisteException;
    void atualizar(Cidade cidade) throws CidadeNaoExisteException;
}