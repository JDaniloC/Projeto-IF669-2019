package Repositorios;

import ClassesBasicas.Cidade

public class RepositorioCidadeLista implements RepositorioCidade{
    private Cidade cidade;
    private repositorioCidadeLista prox;

    public repositorioCidadeLista(){
        this.cidade = null;
        this.prox = null;
    }

    // Insere uma cidade na lista
    public void inserir(Cidade cidade){
        if(this.prox==null){
            this.cidade.setCidade(cidade.getCidade());
            this.cidade.setPopulacao(cidade.getPopulacao());
            this.cidade.setVendedor(cidade.getVendedor());
            this.cidade.setMissao(cidade.getMissao());
            this.cidade.setMonstro(cidade.getMonstro());
        }else inserir(cidade);
    }

    public boolean existe(String nome){
        if(nome.equals(cidade.getCidade())){
            return true;
        }else if(this.prox==null){
            return false;
        }else{
            return this.prox.existe(nome);
        }
    }

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

    public Cidade procurar(String nome){
        if(nome.equals(cidade.getCidade())||nome.equals(cidade.getMissao())||nome.equals(cidade.getMonstro())){
            //printar os dados da cidade
        }else this.prox.procurar(nome);
        return null;
    }

}
