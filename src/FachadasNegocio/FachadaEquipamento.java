package ClassesFachadaIndividual;

import ClassesBasicas.Equipamento;
import Excecoes.EquipamentoJaCadastradoException;
import Excecoes.EquipamentoNaoEncontradoException;
import Repositorios.RepositorioEquipamento;

public class FachadaEquipamento {

	private RepositorioEquipamento repEquipamento;
    
    public FachadaEquipamento(RepositorioEquipamento rep){
        repEquipamento = rep;
    }
	public void cadastrar(Equipamento equipamento) {
		if (!this.repEquipamento.existe(equipamento.getNome())) {
			repEquipamento.inserir(equipamento);
		} else {
            throw new EquipamentoJaCadastradoException();
        }
	}
	
	public void remover(String nome) throws EquipamentoNaoEncontradoException{
        if (this.repEquipamento.existe(nome)) {
        	repEquipamento.remover(nome);
        } else {
            throw new EquipamentoNaoEncontradoException();
        }
    }

    public boolean existe(String codigo) {
        return repEquipamento.existe(codigo);
    }

    public void atualizar(Equipamento equipamento)   {
        if (this.existe(equipamento.getNome())) {
        	repEquipamento.atualizar(equipamento);
        } else {
            throw new EquipamentoNaoEncontradoException();
        }
    }

    public Equipamento procurar(String nome)   {
        if (this.existe(nome)) {
            return this.repEquipamento.procurar(nome);
        } else {
        	throw new EquipamentoNaoEncontradoException();
        }
    }
}