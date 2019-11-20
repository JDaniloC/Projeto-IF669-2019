package Repositorios;
import ClassesBasicas.Equipamento;
import Excecoes.EquipamentoNaoEncontradoException;

public interface RepositorioEquipamento {
	// Interface para os repositórios de equipamento. 

	void inserir (Equipamento equipamentos);
	void remover (String nome) throws EquipamentoNaoEncontradoException;  
	void atualizar (Equipamento equipamentos) throws EquipamentoNaoEncontradoException;
	boolean existe (String nome);
	Equipamento procurar (String nome) throws EquipamentoNaoEncontradoException;
}