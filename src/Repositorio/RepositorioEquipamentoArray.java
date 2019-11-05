package Repositorio;

import ClassesBasicas.Equipamentos;

public class RepositorioEquipamentoArray implements RepositorioEquipamentos{

	private Equipamentos [] ListaEquipamento ;
	
	public void inserir(Equipamentos equipamento) {
		if (existe(equipamento.getNome())) {
			
		}
		else {
			
		}
		
	}

	
	public void remover(String nome) {
		
		
	}

	
	public void atualizar(Equipamentos equipamentos) {
		
		
	}

	
	public boolean existe(String nome) {
		
		return false;
	}

	
	public Equipamentos procurar(String nome) {
		
		return null;
	}

}
