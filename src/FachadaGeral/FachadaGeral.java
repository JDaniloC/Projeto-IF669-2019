package FachadaGeral;

import FachadasNegocio.*;
import ClassesBasicas.Cidade;
import ClassesBasicas.Equipamento;
import ClassesBasicas.Heroi;
import ClassesBasicas.Magia;
import ClassesBasicas.Personagem;
import FachadasNegocio.FachadaEquipamento;
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
    
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// Personagem
// Padrão
    public void adicionarPersonagem(Personagem novo) throws PersonagemJaExisteException, EquipamentoNaoEncontradoException, 
    MagiaNaoEncontradoException{
        procurarMagia(novo.getPoderes().getNome());
        procurarEquipamento(novo.getLoot().getNome());
        fachadaPersonagem.inserir(novo);
    }
    public void atualizarPersonagem(Personagem novo) throws EquipamentoNaoEncontradoException, MagiaNaoEncontradoException, 
    PersonagemNaoExisteException{ 
        procurarEquipamento(novo.getLoot().getNome());
        procurarMagia(novo.getPoderes().getNome());
        fachadaPersonagem.atualizar(novo); 
    }
    public void removerPersonagem(String nome) throws PersonagemNaoExisteException{ fachadaPersonagem.remover(nome); }
    public Personagem procurarPersonagem(String nome) throws PersonagemNaoExisteException{ return fachadaPersonagem.procurar(nome); }

// Modificar Personagem
    public void normalizarPersonagem(String nome, String escolha) throws PersonagemNaoExisteException, EntradaInvalidaException{ 
        fachadaPersonagem.normalizar(nome, escolha); 
    }
    public void upgradePersonagem(String nome, String escolha, int quant) throws PersonagemNaoExisteException, EntradaInvalidaException{ 
        fachadaPersonagem.upgrade(nome, escolha, quant); 
    }
    public void plusPersonagem(String nome, String escolha, int quant) throws PersonagemNaoExisteException, EntradaInvalidaException{ 
        fachadaPersonagem.plus(nome, escolha, quant); 
    }
    public void danoPersonagem(String nome, String escolha, int quant) throws PersonagemNaoExisteException, EntradaInvalidaException{ 
        fachadaPersonagem.dano(nome, escolha, quant); 
    }
    public Equipamento danoVidaPersonagem(String nome, String condicao, int quant) throws PersonagemNaoExisteException, EntradaInvalidaException{
        return fachadaPersonagem.danoVida(nome, condicao, quant);
    }
    public void UpPersonagem(String nome) throws PersonagemNaoExisteException{ fachadaPersonagem.Up(nome); }
    public void mataPersonagem(String nome) throws PersonagemNaoExisteException{ fachadaPersonagem.Morre(nome); }
    public void reestruturaPersonagem(String nome) throws PersonagemNaoExisteException{ fachadaPersonagem.reestrutura(nome); }

// Getters
    public int getVidaPersonagem(String nome) throws PersonagemNaoExisteException{ return fachadaPersonagem.getVida(nome); }
    public int getMpPersonagem(String nome) throws PersonagemNaoExisteException { return fachadaPersonagem.getMp(nome); }
    public int getAtaquePersonagem(String nome) throws PersonagemNaoExisteException{ return fachadaPersonagem.getAtaque(nome); }
    public int getDefesaPersonagem(String nome) throws PersonagemNaoExisteException { return fachadaPersonagem.getDefesa(nome); }
    public int getMovimentosPersonagem(String nome) throws PersonagemNaoExisteException { return fachadaPersonagem.getMovimentos(nome); }
    public int getNivelPersonagem(String nome) throws PersonagemNaoExisteException { return fachadaPersonagem.getNivel(nome); }
    public String getNomePersonagem(String nome) throws PersonagemNaoExisteException{ return fachadaPersonagem.getNome(nome); }
    public String[] getFraquezaPersonagem(String nome) throws PersonagemNaoExisteException{ return fachadaPersonagem.getFraqueza(nome); }
    public Equipamento getLootPersonagem(String nome) throws PersonagemNaoExisteException{ return fachadaPersonagem.getLoot(nome); }
    public Magia getMagiaPersonagem(String nome) throws PersonagemNaoExisteException{ return fachadaPersonagem.getMagia(nome); }
    public String[] getInformacoes(String nome) throws PersonagemNaoExisteException{ return fachadaPersonagem.getInformacoes(nome); }
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// Cidade

    public void cadastrarCidade(Cidade cidade) throws CidadeJaExisteException, PopulacaoInvalidaException, CidadeInvalidaException,
    MissaoInvalidaException, PersonagemNaoExisteException, EquipamentoNaoEncontradoException {
        if (cidade != null) {
            procurarEquipamento(cidade.getVendedor().getNome());
            procurarPersonagem(cidade.getMonstro().getNome());
            fachadaCidade.inserir(cidade);
        } else{
            throw new CidadeInvalidaException();
        }
    }
    
    public void atualizarCidade(Cidade cidade) throws CidadeNaoExisteException, CidadeInvalidaException, EquipamentoNaoEncontradoException, 
    PersonagemNaoExisteException {
        procurarEquipamento(cidade.getVendedor().getNome());
        procurarPersonagem(cidade.getMonstro().getNome());
        fachadaCidade.atualizar(cidade);
    }
    public Cidade procurarLocal(String nome) throws CidadeInvalidaException, CidadeNaoExisteException { 
        return fachadaCidade.procurar(nome); 
    }
    public void removerCidade(String nome) throws CidadeNaoExisteException, CidadeInvalidaException { fachadaCidade.remover(nome); }

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// Equipamento
    public void cadastrarEquipamento(Equipamento equipamento) throws EquipamentoJaCadastradoException  { 
        fachadaEquipamento.cadastrar(equipamento); 
    }
    public void atualizarEquipamento(Equipamento equipamento) throws EquipamentoNaoEncontradoException { 
        fachadaEquipamento.atualizar(equipamento); 
    }
    public Equipamento procurarEquipamento(String nome) throws EquipamentoNaoEncontradoException { 
        return fachadaEquipamento.procurar(nome); 
    }
    public void removerEquipamento(String nome) throws EquipamentoNaoEncontradoException { fachadaEquipamento.remover(nome); }
    
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// Magia
    public void cadastrarMagia(Magia magia) throws MagiaJaExisteException { fachadaMagia.inserir(magia); }
    public void atualizarMagia(Magia magia) throws MagiaNaoEncontradoException { fachadaMagia.atualizar(magia); }
    public void removerMagia(String nome) throws MagiaNaoEncontradoException { fachadaMagia.remover(nome); }
    public Magia procurarMagia(String nome) throws MagiaNaoEncontradoException { return fachadaMagia.procurar(nome); }
    public boolean existeMagia(String nome) { return fachadaMagia.existe(nome); }
}
