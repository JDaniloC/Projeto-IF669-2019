package Repositorios;

import ClassesBasicas.Cidade;
import ClassesBasicas.Equipamento;
import ClassesBasicas.Monstro;

// Definição e criação do repositório de Cidade com lista
public class RepositorioCidadeLista implements RepositorioCidade{
    private Cidade cidade;
    private repositorioCidadeLista prox;

    public repositorioCidadeLista(){
        this.cidade = null;
        this.prox = null;
    }

    // Insere uma cidade na lista
    public void inserir(Cidade cidade){
        if(this.cidade==null){
            this.cidade.setCidade(cidade.getCidade());
            this.cidade.setPopulacao(cidade.getPopulacao());
            this.cidade.vendedor = cidade.vendedor;
            this.cidade.setMissao(cidade.getMissao());
            this.cidade.setMonstro(cidade.getMonstro());
            this.prox = new RepositorioCidadeLista();
        }else this.prox.inserir(cidade);
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
    public void remover (Cidade cidade){
        if(this.cidade==null) //cidade não existe para remover
            return;
        if(this.cidade.getCidade().equals(cidade.getCidade())){
            this.cidade.setCidade(this.prox.cidade.getCidade());
            this.cidade.setPopulacao(this.prox.cidade.getPopulacao());
            this.cidade.setVendedor(this.prox.cidade.getVendedor());
            this.cidade.setMissao(this.prox.cidade.getMissao());
            this.cidade.setMonstro(this.prox.cidade.getMonstro());
        }else this.prox.remover(this.cidade.getCidade());
    }

    // Procura uma cidade na lista
    public Cidade procurar(String nome){
        if(nome.equals(cidade.getCidade())||nome.equals(cidade.getMissao())||nome.equals(cidade.getMonstro())){
            return this.cidade;
        }else this.prox.procurar(nome);
        return null;
    }

}
