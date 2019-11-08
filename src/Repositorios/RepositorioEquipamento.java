package Repositorios;

import ClassesBasicas.Equipamento;

public interface RepositorioEquipamento {
	void inserir (Equipamento equipamentos);
	void remover (String nome);
	void atualizar (Equipamento equipamentos);
	boolean existe (String nome);
	Equipamento procurar (String nome);
}
