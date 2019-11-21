package ClassesBasicas;

import Repositorios.RepositorioEquipamentoArray;
import Repositorios.RepositorioMagiaArray;

public class Monstro extends Personagem{
    private String[] informacoes;
    private String nome;
    private int vida;
    private int mp;
    private int ataque;
    private int defesa;
    private int movimentos;
    private int nivel;
    private String[] fraqueza;
    private Magia poderes;
    private Equipamento loot;

    public Monstro (String nome, int vida, int mp, int ataque, int defesa, int movimentos, int nivel, String[] fraqueza, Magia poder, Equipamento loot){
        super(nome, vida, mp, ataque, defesa, movimentos, nivel, fraqueza, poder, loot);
    }

    public Equipamento morre() {
        /*
        Ele apenas retorna o loot ao morrer, não esqueça de o remover do repositório!
        */
        setVida(0);
        return loot;
    }
    public void Up(){ } // Monstros não upam!
}