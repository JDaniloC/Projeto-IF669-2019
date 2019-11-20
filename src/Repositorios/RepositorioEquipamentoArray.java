package Repositorios;

import java.util.Arrays;

import ClassesBasicas.Equipamento;
import Excecoes.EquipamentoJaCadastradoException;
import Excecoes.EquipamentoNaoEncontradoException;

public class RepositorioEquipamentoArray implements RepositorioEquipamento {
	private Equipamento[] ListaEquipamento;
	private int posicao;
	
	public RepositorioEquipamentoArray(int tam) {
		this.ListaEquipamento = new Equipamento[tam];
		this.posicao = 0;
	}
	
	public void inserir(Equipamento equipamento) throws EquipamentoJaCadastradoException {
		/*
		 Insere um novo Equipamento, e dobra o Array caso esteja cheio
		 */
		
		if (existe(equipamento.getNome())) {
			throw new EquipamentoJaCadastradoException();
		} else if (this.posicao < ListaEquipamento.length) {
            this.ListaEquipamento[this.posicao] = equipamento;
            this.posicao = this.posicao + 1;
		} else {
			Equipamento[] newlista = Arrays.copyOfRange(ListaEquipamento, 0, ListaEquipamento.length*2);
			this.ListaEquipamento = newlista;
			this.inserir(equipamento);
		}
	}
  
	public void remover(String nome) throws EquipamentoNaoEncontradoException {
		/*
		 Procura o nome do Equipamento e o remove
		 */
		
		if (existe(nome)) {
			for (int i = 0; i < ListaEquipamento.length; i++) {
                if (nome.equals(this.ListaEquipamento[i].getNome())) {
                    this.ListaEquipamento[i] = null;
                    this.posicao = this.posicao - 1;
                    i = ListaEquipamento.length;
                }
            }
			/*
			 Reorgarniza o array
			 */
			for(int i = 0; i < ListaEquipamento.length-1; i++){
                if(this.ListaEquipamento[i] == null && this.ListaEquipamento[i+1] != null){
                    this.ListaEquipamento[i] = this.ListaEquipamento[i+1];
                    this.ListaEquipamento[i+1] = null;
                }
            }
		}
		else {
			throw new EquipamentoNaoEncontradoException();
		}
	}
	/*
	 * Atualiza um Equipamento ja inserido
	 */
	public void atualizar(Equipamento equipamento) throws EquipamentoNaoEncontradoException {
		if(existe(equipamento.getNome())) {
			for (int i = 0; i < ListaEquipamento.length; i++) {
                if (this.ListaEquipamento[i] == equipamento) {
                    this.ListaEquipamento[i] = equipamento;
                }
            }
        } else {
            throw new EquipamentoNaoEncontradoException();
        }
	}
	/*
	 Informa se o equipamento esta inserido 
	 */
	public boolean existe(String nome) {
		for (int i = 0; i < ListaEquipamento.length; i++) {
            if (ListaEquipamento[i]!= null && nome.equals(ListaEquipamento[i].getNome())) {
                return true;
            }
        }
        return false;
    }
	/*
	 Procura e retorna o equipamento caso esteja inserido
	 */
	public Equipamento procurar(String nome) throws EquipamentoNaoEncontradoException {
		for (int i = 0; i < ListaEquipamento.length; i++) {
            if (this.ListaEquipamento[i].getNome().equals(nome)) {
                return ListaEquipamento[i];
            }
        }
		if(!existe(nome)){
            throw new EquipamentoNaoEncontradoException();
		}
        return null;
	}
}