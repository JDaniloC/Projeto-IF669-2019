package FachadaGeral;

import FachadasNegocio.*;
import ClassesBasicas.Cidade;
import ClassesBasicas.Equipamento;
import ClassesBasicas.Heroi;
import ClassesBasicas.Magia;
import ClassesBasicas.Personagem;
import ClassesFachadaIndividual.FachadaEquipamento;
import Repositorios.*;
import Excecoes.*;

public class FachadaGeral{
    private FachadaPersonagem fachadaPersonagem;
    private FachadaCidade fachadaCidade;
    private FachadaEquipamento fachadaEquipamento;
    private FachadaMagia fachadaMagia;

    public FachadaGeral(FachadaPersonagem person, FachadaEquipamento equips, FachadaCidade cidade, FachadaMagia magia){

        /*
        Construtor da classe, recebendo todas as fachadas.
        */
        fachadaPersonagem = person;
        fachadaEquipamento = equips;
        fachadaCidade = cidade;
        fachadaMagia = magia;
    }
    
    public void adicionarPersonagem(Personagem novo) throws PersonagemJaExisteException, EquipamentoNaoEncontradoException, MagiaNaoEncontradoException, EntradaInvalidaException{ fachadaPersonagem.inserir(novo); }
    public void atualizarPersonagem(Personagem novo) throws PersonagemJaExisteException, EquipamentoNaoEncontradoException, MagiaNaoEncontradoException, EntradaInvalidaException, PersonagemNaoExisteException{ fachadaPersonagem.atualizar(novo); }
    public void removerPersonagem(String nome) throws PersonagemNaoExisteException{ fachadaPersonagem.remover(nome); }
    public Personagem procurarPersonagem(String nome) throws PersonagemNaoExisteException{ return fachadaPersonagem.procurar(nome); }

    public void UpPersonagem(String nome) throws PersonagemNaoExisteException{ fachadaPersonagem.Up(nome); }
    public void mataPersonagem(String nome) throws PersonagemNaoExisteException{ fachadaPersonagem.Morre(nome); }
    public void reestruturaPersonagem(String nome) throws PersonagemNaoExisteException{ fachadaPersonagem.reestrutura(nome); }
    public void normalizarPersonagem(String nome, String escolha) throws PersonagemNaoExisteException, EntradaInvalidaException{ fachadaPersonagem.normalizar(nome, escolha); }
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

    public void cadastrarCidade(Cidade cidade) throws CidadeJaExisteException, CidadeInvalidaException, PopulacaoInvalidaException, CidadeInvalidaException,
            MissaoInvalidaException, PersonagemNaoExisteException { fachadaCidade.inserir(cidade); }
    public void removerCidade(String nome) throws CidadeNaoExisteException, CidadeInvalidaException { fachadaCidade.remover(nome);    }
    public Cidade procurarLocal(String nome) throws CidadeInvalidaException, CidadeNaoExisteException { fachadaCidade.procurar(nome);  }

    
    public void  adicionarMagia(String nome) {
    	
    }

    public void cadastrarEquipamento(Equipamento equipamento) throws EquipamentoNaoEncontradoException, EquipamentoJaCadastradoException  {
        fachadadaEquipamento.inserir(equipamento);
    }
    public void removerEquipamento(String nome) {
         fachadaEquipamento.remover(nome);
    }
    public void atualizarEquipamento(Equipamento equipamento) {
        fachadaEquipamento.atualizar(equipamento);
    }
    public Equipamento procurarEquipamento(String nome)   {
        fachadaEquipamento.procurar(nome);
    }
}