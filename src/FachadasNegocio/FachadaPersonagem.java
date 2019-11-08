package ClasseRegraNegocio;

import ClassesBasicas.Personagem;
import Excecoes.PersonagemJaExisteException;
import Excecoes.PersonagemNaoExisteException;
import Repositorios.RepositorioPersonagem;

public class FachadaPersonagem{
    RepositorioPersonagem repositorio;

    public FachadaPersonagem(RepositorioPersonagem repositorio){
        this.repositorio = repositorio;
    }
    public void inserir(Personagem person) throws PersonagemJaExisteException{
        if (repositorio.existe(person.getNome())){
            throw new PersonagemJaExisteException();
        } else{
            repositorio.inserir(person);
        }
    }
    public void atualizar(Personagem person) throws PersonagemNaoExisteException{
        repositorio.atualizar(person);
    }
    public Personagem procurar(String nome) throws PersonagemNaoExisteException{
        return repositorio.procurar(nome);
    }
    public void remover(String nome) throws PersonagemNaoExisteException{
        repositorio.remover(nome);
    }
    public boolean existe(String nome){
        return repositorio.existe(nome);
    }

    public void Up(String nome) throws PersonagemNaoExisteException{
        procurar(nome).Up();
    }
    public void Morre(String nome) throws PersonagemNaoExisteException{
        procurar(nome).morre(); 
    }
    public void reestrutura(String nome) throws PersonagemNaoExisteException{
        procurar(nome).reestrutura();
    }
    public void normalizar(String nome, String escolha) throws PersonagemNaoExisteException{
        person = procurar(nome);
        switch (escolha){
            case "Ataque":
                person.normalizeAtaque();
                break;
            case "Mp":
                person.normalizeMp();
                break;
            case "Defesa":
                person.normalizeDefesa();
                break;
            case "Movimento":
                person.normalizeMovimento();
                break;
            default:
                person.reestrutura(); // ???
        }
    }
    public void upgrade(String nome, String escolha, int quant) throws PersonagemNaoExisteException{
        person = procurar(nome);
        switch (escolha){ // Verificar se não é negativo
            case "Ataque":
                person.upgradeAtaque(quant);
                break;
            case "Mp":
                person.upgradeMp(quant);
                break;
            case "Defesa":
                person.upgradeDefesa(quant);
                break;
            case "Movimento":
                person.UpgradeMovimento(quant);
                break;
            case "Vida":
                person.UpgradeVida(quant);
                break;
            default:
                person.Up(); // ???
        }
    }
    public void plus(String nome, String escolha, int quant) throws PersonagemNaoExisteException{
        person = procurar(nome);
        switch (escolha){ // Verificar se nenhum é negativo!!
            case "Ataque":
                person.plusAtaque(quant);
                break;
            case "Mp":
                person.plusMp(quant);
                break;
            case "Defesa":
                person.plusDefesa(quant);
                break;
            case "Movimento":
                person.plusMovimento(quant);
                break;
            default:
                person.plusVida(quant);
                break;
        }
    }
    public void dano(String nome, String escolha, int quant) throws PersonagemNaoExisteException{
        person = procurar(nome);
        switch (escolha){
            case "Ataque": // Verificar se tem fraqueza
                person.danoAtaque(quant);
                break;
            case "Mp":
                person.gastaMp(quant);
                break;
            case "Defesa":
                person.danoDefesa(quant);
                break;
            case "Movimento":
                person.danoMovimento(quant);
                break;
            default:
                person.danoVida(quant);
                break;
        }
    }
    public int getVida(String nome) throws PersonagemNaoExisteException{
        person = procurar(nome);
        return person.getVida; 
    }
    public int getMp(String nome) throws PersonagemNaoExisteException {
        person = procurar(nome); 
        return person.getMp; 
    }
    public int getAtaque(String nome) throws PersonagemNaoExisteException{
        person = procurar(nome);
        return person.getAtaque; 
    }
    public int getDefesa(String nome) throws PersonagemNaoExisteException {
        person = procurar(nome); 
        return person.getDefesa; 
    }
    public int getMovimentos(String nome) throws PersonagemNaoExisteException {
        person = procurar(nome); 
        return person.getMovimentos; 
    }
    public int getNivel(String nome) throws PersonagemNaoExisteException {
        person = procurar(nome); 
        return person.getNivel; 
    }
    public String getNome(String nome) throws PersonagemNaoExisteException{
        person = procurar(nome);
        return person.getNome; 
    }

    public void setNome(String nome, String novo) throws PersonagemNaoExisteException{ 
        procurar(nome).setNome(novo);; // Verificar se o nome já existe!!
    }
    public void setVida(String nome, int vida) throws PersonagemNaoExisteException{ 
        procurar(nome).setVida(vida); 
    }
    public void setMp(String nome, int mp) throws PersonagemNaoExisteException{ 
        procurar(nome).setMp(mp); 
    }
    public void setAtaque(String nome, int ataque) throws PersonagemNaoExisteException{ 
        procurar(nome).setAtaque(ataque); 
    }
    public void setDefesa(String nome, int defesa) throws PersonagemNaoExisteException{ 
        procurar(nome).setDefesa(defesa); 
    }
    public void setMovimentos(String nome, int movimentos) throws PersonagemNaoExisteException{ 
        procurar(nome).setMovimentos(movimentos); 
    }
    public void setNivel(String nome, int nivel) throws PersonagemNaoExisteException{ 
        procurar(nome).setNivel(nivel); 
    }
    public void setPoderes (String nome, Magia poderes) throws PersonagemNaoExisteException{ 
        procurar(nome).setPoderes(poderes); 
    }
    public void setFraqueza(String nome, String[] fraqueza) throws PersonagemNaoExisteException{ 
        procurar(nome).setFraqueza(fraqueza); 
    }
}