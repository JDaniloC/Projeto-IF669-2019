package FachadasNegocio;

import ClassesBasicas.Equipamento;
import Excecoes.EquipamentoJaCadastradoException;
import Excecoes.EquipamentoNaoEncontradoException;
import Excecoes.InventarioCheioException;
import Repositorios.RepositorioEquipamento;

public class FachadaEquipamento {

	private RepositorioEquipamento repEquipamento;
    
    public FachadaEquipamento(RepositorioEquipamento rep){
        repEquipamento = rep;
    }
	public void cadastrar(Equipamento equipamento) throws EquipamentoJaCadastradoException, InventarioCheioException {
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
    public boolean existe(String nome) {
        return repEquipamento.existe(nome);
    }

    public void atualizar(Equipamento equipamento) throws EquipamentoNaoEncontradoException {
        if (this.existe(equipamento.getNome())) {
        	repEquipamento.atualizar(equipamento);
        } else {
            throw new EquipamentoNaoEncontradoException();
        }
    }

    public Equipamento procurar(String nome) throws EquipamentoNaoEncontradoException {
        if (this.existe(nome)) {
            return this.repEquipamento.procurar(nome);
        } else {
        	throw new EquipamentoNaoEncontradoException();
        }
    }
    public int getVidaPlus(String nome) throws EquipamentoNaoEncontradoException{
        Equipamento equip = procurar(nome);
        return equip.getVidaPlus(); 
    }
    public String getAtributosEsp(String nome) throws EquipamentoNaoEncontradoException {
        Equipamento equip = procurar(nome); 
        return equip.getAtributosEsp(); 
    }
    public int getAtaque(String nome) throws EquipamentoNaoEncontradoException{
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
    public String getNome(String nome) throws EquipamentoNaoEncontradoException{
        Equipamento equip = procurar(nome);
        return equip.getNome(); 
    }
}
