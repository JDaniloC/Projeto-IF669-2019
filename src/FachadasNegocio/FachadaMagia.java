package FachadasNegocio;
import Repositorios.RepositorioMagia;
import ClassesBasicas.Magia;
import Excecoes.MagiaJaExisteException;
import Excecoes.MagiaNaoEncontradoException;

public class FachadaMagia {
	private RepositorioMagia repositorio;
	
	public FachadaMagia(RepositorioMagia resp) {
		this.repositorio = resp;
	}
	
	public void inserir(Magia magia) throws MagiaJaExisteException {
		boolean existe = this.repositorio.existe(magia.getNome());
		if (!existe) {
			this.repositorio.inserir(magia);
		}
		else {
			throw new MagiaJaExisteException();
		}
	}
	
	public void atualizar(Magia magia) throws MagiaNaoEncontradoException {
		this.repositorio.atualizar(magia);
	}
	
	public void remover(String nome) throws MagiaNaoEncontradoException {
		this.repositorio.remover(nome);
	}
	
	public Magia procurar(String nome) throws MagiaNaoEncontradoException {
		return this.repositorio.procurar(nome);
	}
	
	public boolean existe(String nome) {
		return this.repositorio.existe(nome);
	}
	
}
