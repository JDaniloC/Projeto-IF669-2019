package FachadaGeral;

import FachadasNegocio.*;
import ClassesBasicas.Equipamento;
import ClassesBasicas.Heroi;
import ClassesBasicas.Magia;
import ClassesBasicas.Personagem;
import Repositorios.*;
import Excecoes.*;

public class FachadaGeral{
    private FachadaPersonagem fachadaPersonagem;
    private FachadaCidade fachadaCidade;

    public FachadaGeral(FachadaPersonagem person, FachadaCidade cidade){
        /*
        Construtor da classe, recebendo todas as fachadas.
        */
        fachadaPersonagem = person;
        fachadaCidade = cidade;
    }
    
    public void adicionarPersonagem(Personagem novo) throws PersonagemJaExisteException, EquipamentoNaoEncontradoException, MagiaNaoEncontradaException, EntradaInvalidaException{ fachadaPersonagem.inserir(novo); }
    public void atualizarPersonagem(Personagem novo) throws PersonagemJaExisteException, EquipamentoNaoEncontradoException, MagiaNaoEncontradaException, EntradaInvalidaException{ fachadaPersonagem.atualizar(novo); }
    public void removerPersonagem(String nome) throws PersonagemNaoExisteException{ fachadaPersonagem.remover(nome); }
    public Personagem procurarPersonagem(String nome) throws PersonagemNaoExisteException{ return fachadaPersonagem.procurar(nome); }

    public void UpPersonagem(String nome) throws PersonagemNaoExisteException{ fachadaPersonagem.Up(); }
    public void mataPersonagem(String nome) throws PersonagemNaoExisteException{ fachadaPersonagem.Morre(); }
    public void reestruturaPersonagem(String nome) throws PersonagemNaoExisteException{ fachadaPersonagem.reestrutura(); }
    public void normalizarPersonagem(String nome, String escolha) throws PersonagemNaoExisteException, EntradaInvalidaException{ fachadaPersonagem.normalizarPersonagem(nome, escolha); }
    public void upgradePersonagem(String nome, String escolha, int quant) throws PersonagemNaoExisteException, EntradaInvalidaException{ fachadaPersonagem.upgrade(nome, escolha, quant); }
    public void plusPersonagem(String nome, String escolha, int quant) throws PersonagemNaoExisteException, EntradaInvalidaException{ fachadaPersonagem.plus(nome, escolha, quant); }
    public void danoPersonagem(String nome, String escolha, int quant) throws PersonagemNaoExisteException, EntradaInvalidaException{ fachadaPersonagem.dano(nome, escolha, quant); }
    public void danoVidaPersonagem(String nome, String condicao, int quant) throws PersonagemNaoExisteException, EntradaInvalidaException{ fachadaPersonagem.danoVida(nome, condicao, quant); }

    public int getVidaPersonagem(String nome) throws PersonagemNaoExisteException{ return fachadaPersonagem.getVida(nome); }
    public int getMpPersonagem(String nome) throws PersonagemNaoExisteException { return fachadaPersonagem.getMp(nome); }
    public int getAtaquePersonagem(String nome) throws PersonagemNaoExisteException{ return fachadaPersonagem.getAtaque(nome); }
    public int getDefesaPersonagem(String nome) throws PersonagemNaoExisteException { return fachadaPersonagem.getDefesa(nome); }
    public int getMovimentosPersonagem(String nome) throws PersonagemNaoExisteException { return fachadaPersonagem.getMovimentos(nome); }
    public int getNivelPersonagem(String nome) throws PersonagemNaoExisteException { return fachadaPersonagem.getNivel(nome); }
    public String getNomePersonagem(String nome) throws PersonagemNaoExisteException{ return fachadaPersonagem.getNome(nome); }

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