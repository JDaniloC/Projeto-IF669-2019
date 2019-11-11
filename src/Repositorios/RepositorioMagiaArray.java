package Repositorios;

import java.util.Arrays;

import ClassesBasicas.Magia;
import ClassesBasicas.Personagem;
import Excecoes.MagiaNaoEncontradoException;
import Excecoes.PersonagemNaoExisteException;

public class RepositorioMagiaArray implements RepositorioMagia {

	private Magia[] colecao;
	private int quantidade;
	
	public RepositorioMagiaArray() {
		colecao = new Magia[1];
		quantidade = 0;
	}
	
	
	@Override
	public void inserir(Magia mag) {
		if (quantidade < colecao.length) {
			colecao[quantidade] = mag;
            quantidade ++;
		}
		else {
				Magia[] novo = Arrays.copyOfRange(colecao, 0, colecao.length*2);
	            this.colecao = novo;
	            inserir(mag);
		}
		
	}

	@Override
	public void atualizar(Magia magia) throws MagiaNaoEncontradoException {
		 boolean encontrou = false;
	        for (int i = 0; i < quantidade && !encontrou; i++){
	            if (colecao[i].getNome().equals(magia.getNome())){
	                colecao[i] = magia;
	                encontrou = true;
	            }
	        }
	        if (!encontrou){
	           throw new MagiaNaoEncontradoException();
	        }
		
	}

	@Override
	public void remover(String nome) throws MagiaNaoEncontradoException {
		boolean encontrou = false;
        for (int i = 0; i < quantidade; i++){
            if (colecao[i] != null && colecao[i].getNome().equals(nome) && i < colecao.length-1){
                Magia aux = colecao[i];
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
           throw new MagiaNaoEncontradoException();
        }
		
	}

	@Override
	public Magia procurar(String nome) throws MagiaNaoEncontradoException {
		for (int i = 0; i < quantidade; i++){
            if (colecao[i].getNome().equals(nome)){
                return colecao[i];
            }
        }
		throw new MagiaNaoEncontradoException();
	}

	@Override
	public boolean existe(String nome) {
		for (int i = 0; i < quantidade; i++){
            if (colecao[i].getNome().equals(nome)){
                return true;
            }
        }
		return false;
	}

}
