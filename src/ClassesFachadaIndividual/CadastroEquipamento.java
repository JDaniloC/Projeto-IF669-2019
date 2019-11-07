package ClassesFachadaIndividual;

import ClassesBasicas.Equipamento;
import Repositorios.RepositorioEquipamento;

public class CadastroEquipamento {

	private RepositorioEquipamento repEquipamento;
	
	public void cadastrar(Equipamento equipamento) {
		if (!this.repEquipamento.existe(equipamento.getNome())) {
			repEquipamento.inserir(equipamento);
		}
	}
	
	public void remover(String nome) {
        if (this.repEquipamento.existe(nome)) {
        	repEquipamento.remover(nome);
        } 
    }

    public boolean existe(String codigo) {
        return repEquipamento.existe(codigo);
    }

    public void atualizar(Equipamento equipamento)   {
        if (this.existe(equipamento.getNome())) {
        	repEquipamento.atualizar(equipamento);
        } 
    }

    public Equipamento procurar(String nome)   {
        if (this.existe(nome)) {
            return this.repEquipamento.procurar(nome);
        } else {
        	return null;
        }
    }
}