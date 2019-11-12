package FachadaGeral;

import ClasseRegraNegocio.*;
import Repositorios.*;
import Excecoes.*;

public class FachadaGeral{
    private RepositorioPersonagem repPersonagem;
    private FachadaCidade fachadaCidade;

    public FachadaGeral(String dados){
        String informacoes[] = dados.split(" ");
        RepositorioPersonagem rep1 = informacoes[0].equals("Lista") ? new RepositorioPersonagemLista() : new RepositorioPersonagemArray();
        repPersonagem = new FachadaPersonagem(rep1);
    }
    public void Adicionar(String informacoes) throws PersonagemJaExisteException{
        String[] inf = informacoes.split(" ");
        // Verifica se tem as magias, equipamentos, e adiciona.
    }

    //Cidade

    public void cadastrarCidade(Cidade cidade) throws CidadeJaExisteException, CidadeNaoExisteException, PopulacaoInvalidaException, MissaoInvalidaException,
            CidadeInvalidaException, PersonagemNaoExisteException{
        if (cidade != null)
        {
            if (!fachadaCidade.existe(cidade.getCidade()))
            {
                if (cidade.populcao>0)
                {
                    if (cidade.getVendedor() != null)
                    {
                        if(cidade.getMissao() != null){
                            if(cidade.getMonstro() != null){
                                fachadaCidade.inserir(cidade);
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

    public void removerCidade(String nome) throws CidadeInvalidaException, CidadeNaoExisteException {
        if (nome != null)
        {
            if (fachadaCidade.existe(nome))
            {
                fachadaCidade.remover(nome);
            }
            else
                throw new CidadeNaoExisteException();
        }
        else
            throw new CidadeInvalidaException();
    }

    public Local procurarLocal(String nome) throws CidadeInvalidaException, CidadeNaoExisteException {
        if (nome != null)
        {
            if (fachadaCidade.existe(nome))
            {
                return fachadaCidade.procurar(nome);
            }
            else
                throw new CidadeNaoExisteException();
        }
        else
            throw new CidadeInvalidaException();
    }
}