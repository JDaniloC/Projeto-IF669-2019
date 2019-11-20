package Repositorios;

import ClassesBasicas.Cidade;
import ClassesBasicas.Equipamento;
import ClassesBasicas.Monstro;
import Excecoes.CidadeNaoExisteException;

// Definição e criação do repositório de Cidade com lista
public class RepositorioCidadeArray implements RepositorioCidade {
    private Cidade[] cidadeArray = new Cidade [0];
    private int numero = 0;

    // Insere uma nova cidade na lista substituindo o array antigo por um maior em 1 posição
    public void inserir(Cidade cidade){
        Cidade[] aux = new Cidade[this.cidadeArray.length + 1];
        for(int i = 0; i < this.cidadeArray.length; i++){
            aux[i] = this.cidadeArray[i];
        }
        aux[cidadeArray.length] = cidade;
        this.cidadeArray = aux;
    }

    // Verifica a existência de uma cidade
    public boolean existe(String nome){
        for(int i = 0; i < this.cidadeArray.length; i++){
            if(nome.equals(this.cidadeArray[i].getCidade())){
                return true;
            }
        }
        return false;
    }

    // Procura uma cidade e retorna suas informações caso encontrada
    public Cidade procurar(String nome) throws CidadeNaoExisteException {
            for(int i = 0; i < this.cidadeArray.length && cidadeArray[i] != null; i++){
                if (nome.equals(cidadeArray[i].getCidade())){
                    return cidadeArray[i];
                }
            }
            throw new CidadeNaoExisteException();
        }

        // Remove uma cidade do array
    public void remover(String nome) throws CidadeNaoExisteException{
        boolean achou = false;
        for (int i = 0; i < this.cidadeArray.length; i++){
            if (nome.equals(cidadeArray[i].getCidade())) {
                achou = true;
                cidadeArray[i] = cidadeArray[cidadeArray.length - 1];
                Cidade[] aux = new Cidade[cidadeArray.length - 1];
                for (int j = 0; j < cidadeArray.length - 1; j++) {
                    aux[j] = cidadeArray[j];
                }
                cidadeArray = aux;
            }
        }
        if (!achou){
            throw new CidadeNaoExisteException();
        }
    }
    
    // Atualiza uma cidade do array
    public void atualizar(Cidade cidade) throws CidadeNaoExisteException{
        boolean achou = false;
        for (int i = 0; i < this.cidadeArray.length && cidadeArray[i] != null; i++){
            if (cidade.getCidade().equals(cidadeArray[i].getCidade())){
                cidadeArray[i] = cidade;
                achou = true;
            }
        }
        if (!achou){
            throw new CidadeNaoExisteException();
        }
    }
}
