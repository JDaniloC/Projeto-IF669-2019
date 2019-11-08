package ClassesBasicas;
import ClassesBasicas.Equipamento;
import ClassesBasicas.Monstro;

public class Cidade {
    private String nome;
    private int populacao;
    private Equipamento vendedor;
    private String missao;
    private Monstro monstro;

    public Cidade(String nome, int populacao, Equipamento vendedor, String Missao, Monstro monstro){
        this.nome = nome;
        this.populacao = populacao;
        //pegar dados de equipamentos para vendedor;
        this.missao = Missao;
        //this.monstro = Monstro.getNome();
    }

    public void setCidade(String nome){ this.nome = nome; }
    public void setPopulacao(int populacao){ this.populacao = populacao; }
    public void setVendedor(Equipamento vendedor){ this.vendedor = vendedor; }
    public void setMissao(String missao){  this.missao = missao;  }
    public void setMonstro(Monstro monstro){ this.monstro = monstro;  }

    public String getCidade(){ return this.nome; }
    public int getPopulacao(){ return this.populacao; }
    public Equipamento getVendedor(){ return this.vendedor;  }
    public String getMissao(){ return this.missao;  }
    public Monstro getMonstro(){ return this.monstro; }

    public Equipamento compra(){
    }
}
