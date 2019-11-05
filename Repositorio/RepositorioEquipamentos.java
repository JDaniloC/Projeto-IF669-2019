package Repositorio;

import ClassesBasicas.Equipamentos;

public interface RepositorioEquipamentos {
	void inserir (Equipamentos equipamentos);
	void remover (String nome);
	void atualizar (Equipamentos equipamentos);
	boolean existe (String nome);
	Equipamentos procurar (String nome);
}

