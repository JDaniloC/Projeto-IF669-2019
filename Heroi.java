public class Heroi extends Personagem{
    private String[] informacoes;
    private String nome;
    private int vida;
    private int ataque;
    private int defesa;
    private int movimentos;
    private int nivel;
    private String[] fraqueza;
    private Magia poderes;
    private Equipamento loot;

    public Heroi (String nome, int vida, int ataque, int defesa, int movimentos, int nivel, String[] fraqueza, Magia poder; Equipamento loot){
        this.nome = nome;
        this.vida = vida;
        this.ataque = ataque;
        this.defesa = defesa;
        this.movimentos = movimentos;
        this.nivel = nivel;
        this.fraqueza = fraqueza;
        this.poderes = poder;
        this.loot = loot;
        informacoes = new String[]{Integer.toString(vida), Integer.toString(ataque),
                Integer.toString(defesa), Integer.toString(movimentos)};
    }

    public Equipamento morre() {
        return super.morre();
    }
    public void Up(){ super.Up(); }

    public void reestrutura(){ super.reestrutura(); }
    public void normalizeAtaque() { super.normalizeAtaque(); }
    public void normalizeDefesa() { super.normalizeDefesa(); }
    public void normalizeMovimento() { super.normalizeMovimento(); }

    public void upgradeVida(int plus){ super.upgradeVida(plus); }
    public void upgradeAtaque(int plus){ super.upgradeAtaque(plus); }
    public void upgradeDefesa(int plus){ super.upgradeDefesa(plus); }
    public void upgradeMovimentos(int plus){ super.upgradeMovimentos(plus); }

    public void plusVida(int plus){ super.plusVida(plus); }
    public void plusAtaque(int plus) { super.plusAtaque(plus); }
    public void plusDefesa(int plus) { super.plusDefesa(plus); }
    public void plusMovimentos(int plus) { super.plusMovimentos(plus); }

    public void danoVida(int dano){ this.vida -= dano; }
    public void danoAtaque(int dano){ super.danoAtaque(dano); }
    public void danoDefesa(int dano){ super.danoDefesa(dano); }
    public void danoMovimento(int dano){ super.danoMovimento(dano); }

    public int getVida(){ return vida; }
    public int getAtaque(){ return ataque; }
    public int getDefesa() { return defesa; }
    public int getMovimentos() { return movimentos; }
    public String getNome(){ return nome; }

    public void setNome(String nome){ super.setNome(nome); }
    public void setVida(int vida){ super.setVida(vida); }
    public void setAtaque(int ataque){ super.setAtaque(ataque); }
    public void setDefesa(int defesa) { super.setDefesa(defesa); }
    public void setMovimentos(int movimentos) { super.setMovimentos(movimentos); }
    public void setNivel(int nivel){ super.setNivel(nivel); }
    public void setPoderes (Magia poderes){ super.setPoderes(poderes); }
    public void setFraqueza(String[] fraqueza) { super.setFraqueza(fraqueza); }

}