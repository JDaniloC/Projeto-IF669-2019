package FachadasNegocio;

import Excecoes.*;
import Repositorios.RepositorioCidade;
import ClassesBasicas.Cidade;
import Repositorios.RepositorioCidade;
import Repositorios.RepositorioCidadeArray;
import Repositorios.RepositorioCidadeLista;

public class FachadaCidade{
    private RepositorioCidade repositorioCidade;

    public FachadaCidade (RepositorioCidade rep){
        repositorioCidade = rep;
    }

    // Verificação de existência da cidade
    public boolean existe(String nome){ return repositorioCidade.existe(nome);}

    public void inserir(Cidade cidade) throws CidadeJaExisteException, PopulacaoInvalidaException,
    CidadeInvalidaException, MissaoInvalidaException{
        if (cidade != null)
        {
            if (!repositorioCidade.existe(cidade.getCidade()))
            {
                if (cidade.getPopulacao() > 0)
                {
                    if (cidade.getVendedor() != null)
                    {
                        if(cidade.getMissao() != null){
                            repositorioCidade.inserir(cidade);
                        }
                        else throw new MissaoInvalidaException();
                    }
                    else throw new CidadeInvalidaException();
                }
                else
                    throw new PopulacaoInvalidaException();
            }
            else
                throw new CidadeJaExisteException();
        }
        else
            throw new CidadeInvalidaException();
    }

    // Procura uma cidade caso exista
    public Cidade procurar(String nome) throws CidadeNaoExisteException, CidadeInvalidaException{
        if (nome != null) {
            return repositorioCidade.procurar(nome);
        } else
            throw new CidadeInvalidaException();
    }

    // Remove uma cidade do repositório
    public void remover(String nome) throws CidadeNaoExisteException, CidadeInvalidaException{
        if (nome != null) {
            repositorioCidade.remover(nome);
        } else
            throw new CidadeInvalidaException();
    }

    // Atualiza uma cidade do repositório
    public void atualizar(Cidade cidade) throws CidadeNaoExisteException, CidadeInvalidaException{
        if (cidade.getCidade() != null){
            repositorioCidade.atualizar(cidade);
        } else{
            throw new CidadeInvalidaException();
        }
    }
}
