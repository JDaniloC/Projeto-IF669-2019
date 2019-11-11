package Repositorios;
import ClassesBasicas.Cidade;

public class RepositorioCidadeArray implements RepositorioCidade {
    private Cidade[] cidadeArray = new Cidade [0];
    private int numero = 0;

    public void inserir(Cidade cidade){
        Cidade[] aux = new Cidade[this.cidadeArray.length + 1];
        for(int i = 0; i < this.cidadeArray.length; i++){
            aux[i] = this.cidadeArray[i];
        }
        aux[cidadeArray.length] = cidade;
        this.cidadeArray = aux;
    }

    public boolean existe(String nome){
        for(int i = 0; i < this.cidadeArray.length; i++){
            if(nome.equals(this.cidadeArray[i].getCidade())){
                return true;
            }
        }
        return false;
    }

    public Cidade procurar(String nome){

            for(int i = 0; i < this.cidadeArray.length; i++){
                if (nome.equals(cidadeArray[i].getCidade())){
                    return cidadeArray[i];
                }
            }
            return null;
        }

    public void remove(String nome){
        for(int i = 0; i < this.cidadeArray.length; i++){
            if (nome.equals(cidadeArray[i].getCidade())) {
                cidadeArray[i] = cidadeArray[cidadeArray.length - 1];
                Cidade[] aux = new Cidade[cidadeArray.length - 1];
                for (int j = 0; j < cidadeArray.length - 1; j++) {
                    aux[i] = cidadeArray[i];
                }
                cidadeArray = aux;
            }
        }
    }
}

