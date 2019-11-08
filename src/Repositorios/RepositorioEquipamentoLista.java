package Repositorios;

import ClassesBasicas.Equipamento;

public class RepositorioEquipamentoLista implements RepositorioEquipamento {
	private Equipamento equipamento;
	private RepositorioEquipamentoLista proximo;

	public RepositorioEquipamentoLista() {
		this.equipamento = null;
		this.proximo = null;
	}

	@Override
	public void inserir(Equipamento equipamento) {
		if (this.proximo == null) {
			this.equipamento = equipamento;
			this.proximo = new RepositorioEquipamentoLista();
		} else {
			this.proximo.inserir(equipamento);
		}
	}

	@Override
	public void remover(String nome) {
		if (this.equipamento != null && this.equipamento.getNome() == nome) {
			if (this.proximo != null) {
				this.equipamento = this.proximo.equipamento;
				this.proximo = this.proximo.proximo;
			}
		} else {
			this.proximo.remover(nome);
		}
	}

	@Override
	public void atualizar(Equipamento equipamento) {

		if (this.equipamento == null) {

		} else if (this.equipamento.getNome() == equipamento.getNome()) {
			this.equipamento = equipamento;
		} else {
			this.proximo.atualizar(equipamento);
		}
	}
	@Override
	public Equipamento procurar(String nome) {
		if (this.equipamento != null && this.equipamento.getNome().equals(nome)) {
			return equipamento;
		} else if (this.proximo != null) {
			return this.proximo.procurar(nome);
		} else {
			return null;
		}
	}
	@Override
	public boolean existe(String nome) {
		if (this.procurar(nome).equals(null)) {
			return false;
		} else {
			return true;
		}
	}
}