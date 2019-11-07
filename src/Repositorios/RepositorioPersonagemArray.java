package Repositorios;
import ClassesBasicas.Personagem;
import java.util.Arrays;

public class RepositorioPersonagemArray implements RepositorioPersonagem {
    private Personagem[] colecao;
    private int quantidade;

    public RepositorioPersonagemArray() {
        colecao = new Personagem[1];
        quantidade = 0;
    }
    public void inserir(Personagem mob) {
        if (quantidade < colecao.length){
            colecao[quantidade] = mob;
            quantidade ++;
        } else{
            Personagem[] novo = Arrays.copyOfRange(colecao, 0, colecao.length*2);
            this.colecao = novo;
            inserir(mob);
        }
    }
    public void atualizar(Personagem mob){
        // Não sei o que isso faz por enquanto.
    }
    public void remover(String nome){
        for (int i = 0; i < quantidade; i++){
            if (colecao[i].getNome().equals(nome) && i < colecao.length-1){
                Personagem aux = colecao[i];
                colecao[i] = colecao[i+1];
                colecao[i+1] = aux;
            } else if (colecao[i].getNome().equals(nome){
                colecao[i] = null;
                quantidade --;
            }
        }
    }
    public Personagem procurar(String nome){
        for (int i = 0; i < quantidade; i++){
            if (colecao[i].getNome().equals(nome)){
                return colecao[i];
            }
        }
        return null;
    }
    public boolean existe(String nome){
        return procurar(nome) == null ? false : true;
    }
}