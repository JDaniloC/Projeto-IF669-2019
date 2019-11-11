package FachadaGeral;

import ClasseRegraNegocio.*;
import Repositorios.*;
import Excecoes.*;

public class FachadaGeral{
    private RepositorioPersonagem repPersonagem;

    public FachadaGeral(String dados){
        String informacoes[] = dados.split(" ");
        RepositorioPersonagem rep1 = informacoes[0].equals("Lista") ? new RepositorioPersonagemLista() : new RepositorioPersonagemArray();
        repPersonagem = new FachadaPersonagem(rep1);
    }
    public void Adicionar(String informacoes) throws PersonagemJaExisteException{
        String[] inf = informacoes.split(" ");
        // Verifica se tem as magias, equipamentos, e adiciona.
    }
}