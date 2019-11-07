public class Cidade {
    private String nome;
    private int populacao;
    private Equipamento vendedor;
    private String missao;
    private String monstro;

    public Cidade(String nome, int populacao, Equipamento vendedor, String Missao, String monstro){
        this.nome = nome;
        this.populacao = populacao;
        //pegar dados de equipamentos para vendedor;
        this.Missao = Missao;
        //this.monstro = Monstro.getNome();
    }

    public void setCidade(String nome){ this.nome = nome; }
    public void setPopulacao(int populacao){ this.populacao = populacao; }
    public void setVendedor(Equipamento vendedor){ /*vendedor.getInfo;*/   }
    public void setMissao(String missao){  this.missao = missao;  }
    public void setMonstro(String monstro){ this.monstro = monstro;  }

    public String getCidade(){ return this.nome; }
    public int getPopulacao(){ return this.populacao; }
    public Equipamento getVendedor(){ return this.vendedor.getInfo();  }
    public String getMissao(){ return this.missao;  }
    public String getMonstro(){ return this.monstro; }

    public Equipamento compra(){
    }
}
