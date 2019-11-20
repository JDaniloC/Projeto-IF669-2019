package FachadasNegocio;

import ClassesBasicas.Equipamento;
import Excecoes.EquipamentoJaCadastradoException;
import Excecoes.EquipamentoNaoEncontradoException;
import Repositorios.RepositorioEquipamento;

public class FachadaEquipamento {
	/*
	 * Construtor da classe, onde recebe um repositorio (array ou lista)
	 */
	private RepositorioEquipamento repEquipamento;

	public FachadaEquipamento(RepositorioEquipamento rep) {
		repEquipamento = rep;
	}

	/*
	 * Cadastra um Equipamento, caso ele ainda nao tenha sido cadastrado
	 */
	public void cadastrar(Equipamento equipamento) throws EquipamentoJaCadastradoException {
		if (!this.repEquipamento.existe(equipamento.getNome())) {
			repEquipamento.inserir(equipamento);
		} else {
			throw new EquipamentoJaCadastradoException();
		}
	}

	/*
	 * Remove um equipamento do repositorio
	 */
	public void remover(String nome) throws EquipamentoNaoEncontradoException {
		if (this.repEquipamento.existe(nome)) {
			repEquipamento.remover(nome);
		} else {
			throw new EquipamentoNaoEncontradoException();
		}
	}

	/*
	 * Verifica a existencia de um Equipamento
	 */
	public boolean existe(String nome) {
		return repEquipamento.existe(nome);
	}

	/*
	 * Atualiza um Equipamento ja cadastrado
	 */
	public void atualizar(Equipamento equipamento) throws EquipamentoNaoEncontradoException {
		if (this.existe(equipamento.getNome())) {
			repEquipamento.atualizar(equipamento);
		} else {
			throw new EquipamentoNaoEncontradoException();
		}
	}

	/*
	 * Procura e retorna um Quipamento (caso exista)
	 */
	public Equipamento procurar(String nome) throws EquipamentoNaoEncontradoException {
		if (this.existe(nome)) {
			return this.repEquipamento.procurar(nome);
		} else {
			throw new EquipamentoNaoEncontradoException();
		}
	}
/*
 * Devolve os atributos do Equipamento
 */
	public int getVidaPlus(String nome) throws EquipamentoNaoEncontradoException {
		Equipamento equip = procurar(nome);
		return equip.getVidaPlus();
	}

	public String getAtributosEsp(String nome) throws EquipamentoNaoEncontradoException {
		Equipamento equip = procurar(nome);
		return equip.getAtributosEsp();
	}

	public int getAtaque(String nome) throws EquipamentoNaoEncontradoException {
		Equipamento equip = procurar(nome);
		return equip.getAtaque();
	}

	public int getDefesa(String nome) throws EquipamentoNaoEncontradoException {
		Equipamento equip = procurar(nome);
		return equip.getDefesa();
	}

	public int getPreco(String nome) throws EquipamentoNaoEncontradoException {
		Equipamento equip = procurar(nome);
		return equip.getPreco();
	}

	public String getNome(String nome) throws EquipamentoNaoEncontradoException {
		Equipamento equip = procurar(nome);
		return equip.getNome();
	}
}
