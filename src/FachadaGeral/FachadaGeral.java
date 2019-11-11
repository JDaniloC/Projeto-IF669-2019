package FachadaGeral;

import ClasseRegraNegocio.*;
import Repositorios.*;
import Excecoes.*;

public class FachadaGeral{
    private RepositorioPersonagem repPersonagem;

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
}