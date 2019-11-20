package Repositorios;

import ClassesBasicas.Cidade;
import ClassesBasicas.Equipamento;
import ClassesBasicas.Monstro;
import Excecoes.CidadeNaoExisteException;

// Definição e criação do repositório de Cidade com lista
public class RepositorioCidadeLista implements RepositorioCidade{
    private Cidade cidade;
    private RepositorioCidadeLista prox;

    public RepositorioCidadeLista(){
        this.cidade = null;
        this.prox = null;
    }

    // Insere uma cidade na lista
    public void inserir(Cidade cidade){
        if (this.cidade == null){
            this.cidade = cidade;
            this.prox = new RepositorioCidadeLista();
        } else this.prox.inserir(cidade);
    }

    // Verifica se uma cidade existe
    public boolean existe(String nome){
        if(nome.equals(cidade.getCidade())){
            return true;
        }else if(this.prox==null){
            return false;
        }else{
            return this.prox.existe(nome);
        }
    }

    // Remove uma cidade da lista
    public void remover (String nome) throws CidadeNaoExisteException{
        if (this.cidade != null && this.cidade.getCidade().equals(nome)){
            if (this.prox != null){
                this.cidade = this.prox.cidade;
                this.prox = this.prox.prox;
            } else{
                this.cidade = null;
            }
        } else if (this.prox != null) { 
            this.prox.remover(this.cidade.getCidade());
        }
        throw new CidadeNaoExisteException();
    }

    // Procura uma cidade na lista
    public Cidade procurar(String nome) throws CidadeNaoExisteException {
        if(nome.equals(cidade.getCidade())|| nome.equals(cidade.getMissao()) || nome.equals(cidade.getMonstro().getNome())){
            return this.cidade;
        } else if (this.prox != null){
            this.prox.procurar(nome);
        }
        throw new CidadeNaoExisteException();
    }

}
