package FachadasNegocio;

import ClassesBasicas.Cidade;
import Excecoes.CidadeInvalidaException;
import Excecoes.CidadeJaExisteException;
import Excecoes.CidadeNaoExisteException;
import Excecoes.MissaoInvalidaException;
import Excecoes.PersonagemNaoExisteException;
import Excecoes.PopulacaoInvalidaException;
import Repositorios.RepositorioCidade;
import Repositorios.RepositorioCidadeArray;
import Repositorios.RepositorioCidadeLista;

public class FachadaCidade{
    private RepositorioCidade repositorioCidade;

    // VerificaÃ§Ã£o para definir o tipo de repositÃ³rio a ser usado
    public FachadaCidade(RepositorioCidade repositorio) { repositorioCidade = repositorio; }

    // VerificaÃ§Ã£o de existÃªncia da cidade
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

    // Remove uma cidade do repositÃ³rio
    public void remover(String nome) throws CidadeNaoExisteException, CidadeInvalidaException{
        if (nome != null)
        {
            if (repositorioCidade.existe(nome))
            {
                repositorioCidade.remover(nome);
            }
            else
                throw new CidadeNaoExisteException();
        }
        else
            throw new CidadeInvalidaException();
    }

}
