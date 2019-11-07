package Repositorios;
import ClassesBasicas.Personagem;
import Excecoes.PersonagemNaoExisteException;

import java.util.Arrays;

public class RepositorioPersonagemArray implements RepositorioPersonagem{
    private Personagem[] colecao;
    private int quantidade;

    public RepositorioPersonagemArray() {
        colecao = new Personagem[1];
        quantidade = 0;
    }
    public void inserir(Personagem mob){
        if (quantidade < colecao.length){
            colecao[quantidade] = mob;
            quantidade ++;
        } else{
            Personagem[] novo = Arrays.copyOfRange(colecao, 0, colecao.length*2);
            this.colecao = novo;
            inserir(mob);
        }
    }
    public void atualizar(Personagem mob) throws PersonagemNaoExisteException{
        boolean encontrou = false;
        for (int i = 0; i < quantidade && !encontrou; i++){
            if (colecao[i].getNome().equals(mob.getNome())){
                colecao[i] = mob;
                encontrou = true;
            }
        }
        if (!encontrou){
            throw new PersonagemNaoExisteException();
        }
    }
    public void remover(String nome) throws PersonagemNaoExisteException{
        boolean encontrou = false;
        for (int i = 0; i < quantidade; i++){
            if (colecao[i] != null && colecao[i].getNome().equals(nome) && i < colecao.length-1){
                Personagem aux = colecao[i];
                colecao[i] = colecao[i+1];
                colecao[i+1] = aux;
                encontrou = true;
            } else if (colecao[i] != null && colecao[i].getNome().equals(nome)){
                colecao[i] = null;
                quantidade --;
                encontrou = true;
            }
        }
        if (!encontrou){
            throw new PersonagemNaoExisteException();
        }
    }
    public Personagem procurar(String nome) throws PersonagemNaoExisteException{
        for (int i = 0; i < quantidade; i++){
            if (colecao[i].getNome().equals(nome)){
                return colecao[i];
            }
        }
        throw new PersonagemNaoExisteException();
    }
    public boolean existe(String nome){
        for (int i = 0; i < quantidade; i++){
            if (colecao[i].getNome().equals(nome)){
                return true;
            }
        }
        return false;
    }
}