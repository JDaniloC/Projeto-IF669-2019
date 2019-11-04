public abstract class Personagem {
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

    public Equipamento morre() { return null; }
    public void Up(){
        upgradeVida(100);
        upgradeAtaque(10);
        upgradeDefesa(5);
        upgradeMovimentos(2);
    }

    public void reestrutura(){
        /*
        Coloca a vida, ataque, defesa e movimentos em seus valores naturais.
         */
        vida = Integer.parseInt(informacoes[0]);
        ataque = Integer.parseInt(informacoes[1]);
        defesa = Integer.parseInt(informacoes[2]);
        movimentos = Integer.parseInt(informacoes[3]);
    }
    public void normalizeAtaque() { this.ataque = Integer.parseInt(informacoes[1]); }
    public void normalizeDefesa() { this.defesa = Integer.parseInt(informacoes[2]); }
    public void normalizeMovimento() { this.movimentos = Integer.parseInt(informacoes[3]); }

    /*
    Funções upgrade aumentam os atributos modificando o natural.
     */
    public void upgradeVida(int plus){
        /*
        Aumenta a vida natural em certo valor.
        int plus: O valor que será acrescentado.
         */
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

    /*
    Funções plus aumentam os atributos sem modificar o natural.
     */
    public void plusVida(int plus){
        /*
        Recupera vida do personagem.
        int plus: Valor recuperado.
         */
        this.vida += plus;
        if (vida > Integer.parseInt(informacoes[0])){
            vida = Integer.parseInt(informacoes[0]);
        }
    }
    public void plusAtaque(int plus) { this.ataque += plus; }
    public void plusDefesa(int plus) { this.defesa += plus; }
    public void plusMovimentos(int plus) { this.movimentos += plus; }

    /*
    Funções dano diminuem o valor dos atributos.
     */
    public void danoVida(int dano){
        this.vida -= dano;
        if (this.vida <= 0){
            this.morre();
        }
    }
    public void danoAtaque(int dano){ this.ataque -= dano; }
    public void danoDefesa(int dano){ this.defesa -= dano; }
    public void danoMovimento(int dano){ this.movimentos -= dano; }

    /*
    Funções get devolvem o valor requisitado.
     */
    public int getVida(){ return vida; }
    public int getAtaque(){ return ataque; }
    public int getDefesa() { return defesa; }
    public int getMovimentos() { return movimentos; }
    public int getNivel() { return nivel; }
    public String getNome(){ return nome; }

    public void setNome(String nome){ this.nome = nome; }
    public void setVida(int vida){ this.vida = vida; }
    public void setAtaque(int ataque){ this.ataque = ataque; }
    public void setDefesa(int defesa) { this.defesa = defesa; }
    public void setMovimentos(int movimentos) { this.movimentos = movimentos; }
    public void setNivel(int nivel){ this.nivel = nivel; }
    public void setPoderes (Magia poderes){ this.poderes = poderes; }
    public void setFraqueza(String[] fraqueza) { this.fraqueza = fraqueza; }
}
