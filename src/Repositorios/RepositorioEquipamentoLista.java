package Repositorios;

import ClassesBasicas.Equipamento;
import Excecoes.EquipamentoJaCadastradoException;
import Excecoes.EquipamentoNaoEncontradoException;

public class RepositorioEquipamentoLista implements RepositorioEquipamento {
	private Equipamento equipamento;
	private RepositorioEquipamentoLista proximo;

	public RepositorioEquipamentoLista() {
		this.equipamento = null;
		this.proximo = null;
	}

	@Override
	public void inserir(Equipamento equipamento) throws EquipamentoJaCadastradoException {
		/*
		 Adiciona um Equipamento e, caso necessário, um apontador para o proximo elemento da lista
		 */
		if (this.proximo == null) {
			this.equipamento = equipamento;
			this.proximo = new RepositorioEquipamentoLista();
		} 
		else if (existe(this.equipamento.getNome())) {
			throw new EquipamentoJaCadastradoException();
		}
		else {
			this.proximo.inserir(equipamento);
		}
	}

	@Override
	/*
	 * Remove um Equipamento (caso exista) e recebe atributos do próximo elemento 
	 */
	public void remover(String nome) throws EquipamentoNaoEncontradoException {
		if (!existe(nome)) {
			throw new EquipamentoNaoEncontradoException();
		}
		else if (this.equipamento != null && this.equipamento.getNome().equals(nome)) {
			 if (this.proximo != null) {
				this.equipamento = this.proximo.equipamento;
				this.proximo = this.proximo.proximo;
			}
		} else {
			this.proximo.remover(nome);
		}
	}
	
	@Override
	/*
	 * Atualiza um Equipamento ja inserido
	 */
	public void atualizar(Equipamento equipamento) throws EquipamentoNaoEncontradoException {
		if (this.equipamento == null) {
			throw new EquipamentoNaoEncontradoException();
		} else if (this.equipamento.getNome().equals(equipamento.getNome())) {
			this.equipamento = equipamento;
		} else {
			this.proximo.atualizar(equipamento);
		}
	}
	@Override
	/*
	 * Procura e retorna o equipamento cajo esteja inserido
	 */
	public Equipamento procurar(String nome) throws EquipamentoNaoEncontradoException {
		if (this.equipamento == null) {
			throw new EquipamentoNaoEncontradoException();
		}
		else if (this.equipamento.getNome().equals(nome)) {
			return equipamento;
		} 
		return this.proximo.procurar(nome);
	}
	@Override
	/*
	 * Informa se o equipamento esta inserido na Lista
	 */
	public boolean existe(String nome) {
		if (this.equipamento.getNome().equals(nome)) {
			return true;
		} else if (this.proximo != null){
			return this.proximo.existe(nome);
		} else{
			return false;
		}
	}
}