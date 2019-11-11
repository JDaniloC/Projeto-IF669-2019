package FachadasNegocio;
import Repositorios.RepositorioMagia;
import ClassesBasicas.Magia;
import Excecoes.MagiaJaExisteException;

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
	
	public void 
	
}
