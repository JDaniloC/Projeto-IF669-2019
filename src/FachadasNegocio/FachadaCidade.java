package FachadasNegocio;

import Repositorios;
import ClassesBasicas.Cidade;
import Excecoes.CidadeJaExisteException;
import Excecoes.CidadeNaoExisteException;
import Repositorios.RepositorioCidade;
import Repositorios.RepositorioCidadeArray;
import Repositorios.RepositorioCidadeLista;

public class FachadaCidade{
    private RepositorioCidade repositorioCidade;

    // Verificação para definir o tipo de repositório a ser usado
    public FachadaCidade(RepositorioCidade repositorio) { repositorioCidade = repositorio; }

    // Verificação de existência da cidade
    public boolean existe(String nome){ return repositorioCidade.existe(nome);}

    public void inserir(Cidade cidade) throws CidadeJaExisteException, CidadeInvalidaException, PopulacaoInvalidaException, CidadeInvalidaException,
            MissaoInvalidaException, PersonagemNaoExisteException{
        if (cidade != null)
        {
            if (!repositorioCidade.existe(cidade.getCidade()))
            {
                if (cidade.getPopulacao()>0)
                {
                    if (cidade.getVendedor() != null)
                    {
                        if(cidade.getMissao() != null){
                            if(cidade.getMonstro() != null){
                                repositorioCidade.inserir(cidade);
                            }
                            else throw new PersonagemNaoExisteException();
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
        if (nome != null)
        {
            if (repositorioCidade.existe(nome))
            {
                return repositorioCidade.procurar(nome);
            }
            else
                throw new CidadeNaoExisteException();
        }
        else
            throw new CidadeInvalidaException();
    }

    // Remove uma cidade do repositório
    public void remover(String nome) throws CidadeNaoExisteException, CidadeInvalidaException{
        if (nome != null)
        {
            if (repositorioCidade.existe(nome))
            {
                repositorio.remover(nome);
            }
            else
                throw new CidadeNaoExisteException();
        }
        else
            throw new CidadeInvalidaException();
    }

}