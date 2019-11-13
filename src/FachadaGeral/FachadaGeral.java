package FachadaGeral;

import FachadasNegocio.*;
import ClassesBasicas.Equipamento;
import ClassesBasicas.Heroi;
import ClassesBasicas.Magia;
import ClassesBasicas.Personagem;
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
    public void adicionarPersonagem(String informacoes, String[] fraqueza) throws PersonagemJaExisteException, EquipamentoNaoEncontradoException, MagiaNaoEncontradaException, EntradaInvalidaException{
        String[] inf = informacoes.split(" ");
        if (inf.length == 10){
            String nome = inf[0];
            int vida = Integer.parseInt(inf[1]);
            int mp = Integer.parseInt(inf[2]);
            int ataque = Integer.parseInt(inf[3]);
            int defesa = Integer.parseInt(inf[4]);
            int movimentos = Integer.parseInt(inf[5]);
            int nivel = Integer.parseInt(inf[6]);
            Magia poder = procuraPoder(inf[7]);
            Equipamento loot = procuraEquipamento(inf[8]);
            Personagem novo = inf[9].equals("Heroi") ? new Heroi(nome, vida, mp, ataque, defesa, movimentos, nivel, fraqueza, poder, loot) : new Monstro(nome, vida, mp, ataque, defesa, movimentos, nivel, fraqueza, poder, loot);
            repPersonagem.inserir(novo);
        } else{
            throw new EntradaInvalidaException();
        }
    }
    
    public void atualizaPersonagem(){
        
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