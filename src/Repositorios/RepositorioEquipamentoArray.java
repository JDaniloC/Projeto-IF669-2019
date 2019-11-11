package Repositorios;

import ClassesBasicas.Equipamento;
import Excecoes.EquipamentoJaCadastradoException;
import Excecoes.EquipamentoNaoEncontradoException;
import Excecoes.InventarioCheioException;

public class RepositorioEquipamentoArray implements RepositorioEquipamento {
	private Equipamento[] ListaEquipamento;
	private int posicao;
	
	public RepositorioEquipamentoArray(int tam) {
		this.ListaEquipamento = new Equipamento[tam];
		this.posicao = 0;
	}
	
	public void inserir(Equipamento equipamento) throws EquipamentoJaCadastradoException, InventarioCheioException {
		if (existe(equipamento.getNome())) {
			throw new EquipamentoJaCadastradoException();
		} else if (this.posicao < ListaEquipamento.length) {
            this.ListaEquipamento[this.posicao] = equipamento;
            this.posicao = this.posicao + 1;
		} else {
			throw new InventarioCheioException();
		}
	}
	public void remover(String nome) throws EquipamentoNaoEncontradoException {
		if (existe(nome)) {
			for (int i = 0; i < ListaEquipamento.length; i++) {
                if (nome.equals(this.ListaEquipamento[i].getNome())) {
                    this.ListaEquipamento[i] = null;
                    this.posicao = this.posicao - 1;
                    i = ListaEquipamento.length;
                }
            }
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

	public boolean existe(String nome) {
		for (int i = 0; i < ListaEquipamento.length; i++) {
            if (ListaEquipamento[i]!= null && nome.equals(ListaEquipamento[i].getNome())) {
                return true;
            }
        }
        return false;
    }

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