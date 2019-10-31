public class Monstro {
    private String[] informacoes;
    private String nome;
    private int vida;
    private int ataque;
    private int defesa;
    private int movimentos;
    private String[] fraqueza;
    private Magia poderes;
    private Equipamento loot;
    // Vai ter equipamentos ou não e magias.

    public Monstro (String nome, int vida, int ataque, int defesa, int movimentos, String[] fraqueza, Magia poder; Equipamento loot){
        this.nome = nome;
        this.vida = vida;
        this.ataque = ataque;
        this.defesa = defesa;
        this.movimentos = movimentos;
        this.fraqueza = fraqueza;
        this.poderes = poder;
        this.loot = loot;
        informacoes = new String[]{Integer.toString(vida), Integer.toString(ataque),
                Integer.toString(defesa), Integer.toString(movimentos)};
    }

    public Equipamento morre() {
        if (this.vida <= 0) {
            return loot;
        }
        return null;
    }

    public void reestrutura(){
        vida = Integer.parseInt(informacoes[0]);
        ataque = Integer.parseInt(informacoes[1]);
        defesa = Integer.parseInt(informacoes[2]);
        movimentos = Integer.parseInt(informacoes[3]);
    }
    public void normalizeAtaque() { this.ataque = Integer.parseInt(informacoes[1]); }
    public void normalizeDefesa() { this.defesa = Integer.parseInt(informacoes[2]); }
    public void normalizeMovimento() { this.movimentos = Integer.parseInt(informacoes[3]); }

    public void upgradeVida(int plus){
        informacoes[0] += plus;
        vida += plus;
    }
    public void upgradeAtaque(int plus){
        informacoes[1] += plus;
        ataque += plus;
    }
    public void upgradeDefesa(int plus){
        informacoes[2] += plus;
        defesa += plus;
    }
    public void upgradeMovimentos(int plus){
        informacoes[3] += plus;
        movimentos += plus;
    }

    public void plusVida(int plus){
        this.vida += plus;
        if (vida > Integer.parseInt(informacoes[0])){
            vida = Integer.parseInt(informacoes[0]);
        }
    }
    public void plusAtaque(int plus) { this.ataque += plus; }
    public void plusDefesa(int plus) { this.defesa += plus; }
    public void plusMovimentos(int plus) { this.movimentos += plus; }

    public void danoVida(int dano){ this.vida -= dano; }
    public void danoAtaque(int dano){ this.ataque -= dano; }
    public void danoDefesa(int dano){ this.defesa -= dano; }
    public void danoMovimento(int dano){ this.movimentos -= dano;}

    public int getVida(){ return vida; }
    public int getAtaque(){ return ataque; }
    public int getDefesa() { return defesa; }
    public int getMovimentos() { return movimentos; }
    public String getNome(){ return nome; }

    public void setNome(String nome){ this.nome = nome; }
    public void setVida(int vida){ this.vida = vida; }
    public void setAtaque(int ataque){ this.ataque = ataque; }
    public void setDefesa(int defesa) { this.defesa = defesa; }
    public void setMovimentos(int movimentos) { this.movimentos = movimentos; }

}