package Repositorios;
import ClassesBasicas.Personagem;
import Excecoes.PersonagemNaoExisteException;

import java.util.Arrays;

public class RepositorioPersonagemArray implements RepositorioPersonagem{
    private Personagem[] colecao;
    private int quantidade;

    public RepositorioPersonagemArray() {
        /*
        Construtor da classe, criando o primeiro espaço do array.
        */
        colecao = new Personagem[1];
        quantidade = 0;
    }
    public void inserir(Personagem mob){
        /*
        Adiciona um novo personagem, dobrando o array se necessário.
        */
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
        /*
        Atualiza um personagem já existente, procurando no array iterativamente.
        */
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
        /*
        Remove um objeto procurando ele e repassando para o próximo do array, e recrementando o índice do último.
        */
        boolean encontrou = false;
        for (int i = 0; i < quantidade; i++){
            if (colecao[i] != null && colecao[i].getNome().equals(nome) && i < colecao.length-1){
                Personagem aux = colecao[i];
                colecao[i] = colecao[i+1];
                colecao[i+1] = aux;
                encontrou = true;
                quantidade --;
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
        /*
        Procura e devolve um personagem se ele existir, de forma iterativa.
        */
        for (int i = 0; i < quantidade; i++){
            if (colecao[i].getNome().equals(nome)){
                return colecao[i];
            }
        }
        throw new PersonagemNaoExisteException();
    }
    public boolean existe(String nome){
        /*
        Procura de forma iterativa e devolve true se encontrou, false caso contrário.
        */
        for (int i = 0; i < quantidade; i++){
            if (colecao[i].getNome().equals(nome)){
                return true;
            }
        }
        return false;
    }
}