package Repositorios;

import ClassesBasicas.Equipamento;
import Excecoes.EquipamentoJaCadastradoException;
import Excecoes.EquipamentoNaoEncontradoException;

public interface RepositorioEquipamento {
	void inserir (Equipamento equipamentos) throws EquipamentoJaCadastradoException;
	void remover (String nome) throws EquipamentoNaoEncontradoException;  
	void atualizar (Equipamento equipamentos) throws EquipamentoNaoEncontradoException;
	boolean existe (String nome);
	Equipamento procurar (String nome) throws EquipamentoNaoEncontradoException;
}