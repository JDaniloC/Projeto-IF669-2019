package ClassesBasicas;
import ClassesBasicas.Equipamento;
import ClassesBasicas.Monstro;

// Definição os atributos da classe Cidade
public class Cidade {
    private String nome;
    private int populacao;
    private Equipamento vendedor;
    private String[] missao;
    private Monstro monstro;

    // Atribuição de valores aos seus devidos atributos quando uma Cidade for criada
    public Cidade(String nome, int populacao, Equipamento vendedor, String[] missao, Monstro monstro){
        this.nome = nome;
        this.populacao = populacao;
        this.vendedor = vendedor;
        this.missao = missao;
        this.monstro = monstro;
    }

    // Definição dos métodos básicos para atribuir valores aos atributos
    public void setCidade(String nome){ this.nome = nome; }
    public void setPopulacao(int populacao){ this.populacao = populacao; }
    public void setVendedor(Equipamento vendedor){ this.vendedor = vendedor; }
    public void setMissao(String missao){  this.missao = missao;  }
    public void setMonstro(Monstro monstro){ this.monstro = monstro;  }

    // Definição dos métodos básicos para retornar os valores dos atributos
    public String getCidade(){ return this.nome; }
    public int getPopulacao(){ return this.populacao; }
    public Equipamento getVendedor(){ return this.vendedor;  }
    public String getMissao(){ return this.missao;  }
    public Monstro getMonstro(){ return this.monstro; }


}
