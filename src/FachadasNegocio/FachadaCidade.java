package FachadasNegocio;

import Repositorios;
import ClassesBasicas.Cidade;

public class FachadaCidade{
    private RepositorioCidade repositorioCidade;

    // Verificação para definir o tipo de repositório a ser usado
    public FachadaCidade(String tipo) throws TipoDeRepositorioInvalidoException {
        if(tipo.equals("array")) {
            repositorioCidade = new RepositorioCidadeArray();
        }else if(tipo.equals("lista")){
            repositorioCidade = new RepositorioCidadeLista();
        }else{
            throw TipoDeRepositorioInvalidoException();
        }
    }

    // Verificação de existência da cidade
    public boolean existe(String nome){ return repositorioCidade.existe(nome);}

    public void inserir(Cidade cidade) throws CidadeJaExisteException{
        if(!existe(cidade.getCidade())){
            repositorioCidade.inserir(cidade);
        }else{
            throw new CidadeJaExisteException();
        }
    }

    // Procura uma cidade caso exista
    public Cidade procurar(String nome) throws CidadeNaoExisteException{
        if(existe(nome)){
            return repositorioCidade.procurar(nome);
        }else{
            throw new CidadeNaoExisteException();
        }
    }

    // Remove uma cidade do repositório
    public void remover(String nome) throws CidadeNaoExisteException{
        if(existe(nome)){
            repositorioCidade.remover(nome);
        }else{
            throw new CidadeNaoExisteException()
        }
    }

}