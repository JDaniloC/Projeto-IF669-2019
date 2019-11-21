package ClassesBasicas;
import Repositorios.RepositorioEquipamentoArray;
import Repositorios.RepositorioMagiaArray;

public class Heroi extends Personagem{
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

    public Heroi (String nome, int vida, int mp, int ataque, int defesa, int movimentos, int nivel, String[] fraqueza, Magia poder, Equipamento loot){
        super(nome, vida, mp, ataque, defesa, movimentos, nivel, fraqueza, poder, loot);
    }

    public Equipamento morre() {
        /*
        Ao morrer ele não devolve nada.
        */
        setVida(0);
        return null;
    }
    public void Up(){ 
        /*
        Ele aumenta os atributos.
        */
        setNivel(getNivel()+1);
        upgradeVida(100);
        upgradeMp(20);
        upgradeAtaque(10);
        upgradeDefesa(5);
        upgradeMovimentos(2);
     }
}