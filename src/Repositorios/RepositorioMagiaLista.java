package Repositorios;

import ClassesBasicas.Magia;
import Excecoes.MagiaNaoEncontradoException;

public class RepositorioMagiaLista implements RepositorioMagia {
	private Magia magia;
	private RepositorioMagiaLista proximo;
	
	public RepositorioMagiaLista() {
		this.magia = null;
		this.proximo = null;
	}
		
	@Override
	public void inserir(Magia mag) {		
		if (this.proximo == null) {
			this.magia = mag;
			this.proximo = new RepositorioMagiaLista();			
		}
		else if(this.proximo != null) {
			this.proximo.inserir(mag);
		}
		
	}

	@Override
	public void atualizar(Magia magia) throws MagiaNaoEncontradoException {		
		if (this.proximo != null && this.magia.getNome().equals(magia.getNome())) {
			this.magia = magia;
		}
		else if (this.proximo != null) {
			this.atualizar(magia);
		}
		else {
			throw new MagiaNaoEncontradoException();
		}
		
	}

	@Override
	public void remover(String nome) throws MagiaNaoEncontradoException {
		if (this.proximo != null && this.magia.getNome().equals(nome)) {
			this.magia = this.proximo.magia;
			this.proximo = this.proximo.proximo;
		}
		else if(this.proximo != null) {
			this.proximo.remover(nome);
		}
		else {
			throw new MagiaNaoEncontradoException();
		}
		
	}

	@Override
	public Magia procurar(String nome) {
		Magia magia = null;
		if (this.proximo != null && this.magia.getNome().equals(nome)) {
			magia = this.magia;
		}
		else if (this.proximo != null) {
			magia = this.procurar(nome);
		}
		return magia;
	}

	@Override
	public boolean existe(String nome) {
		boolean existe = false;
		if (this.proximo != null && this.magia.getNome().equals(nome)) {
			existe = true;
		}
		else if (this.proximo != null) {
			existe = this.proximo.existe(nome);
		}
		return existe;
	}

}
