package FachadasNegocio;

import ClassesBasicas.Magia;
import ClassesBasicas.Personagem;
import Excecoes.EntradaInvalidaException;
import Excecoes.PersonagemJaExisteException;
import Excecoes.PersonagemNaoExisteException;
import Repositorios.RepositorioEquipamento;
import Repositorios.RepositorioMagia;
import Repositorios.RepositorioPersonagem;

public class FachadaPersonagem{
    RepositorioPersonagem repositorio;

    public FachadaPersonagem(RepositorioPersonagem repositorio){
        /*
        Construtor da classe, recebendo um repositório (array ou lista).
        */
        this.repositorio = repositorio;
    }
    public void inserir(Personagem person) throws PersonagemJaExisteException{
        /*
        Insere um novo objeto, caso ele ainda não existir.
        */
        if (repositorio.existe(person.getNome())){
            throw new PersonagemJaExisteException();
        } else{
            repositorio.inserir(person);
        }
    }
    /*
    Métodos que conversão com o repositório: Atualizar, Procurar, Remover e se Existe.
    */
    public void atualizar(Personagem person) throws PersonagemNaoExisteException{ repositorio.atualizar(person); }
    public Personagem procurar(String nome) throws PersonagemNaoExisteException{ return repositorio.procurar(nome); }
    public void remover(String nome) throws PersonagemNaoExisteException{ repositorio.remover(nome); }
    public boolean existe(String nome){ return repositorio.existe(nome); }

    /*
    Métodos que conversam diretamente com o personagem: Upar, Morrer, Reestruturar.
    */
    public void Up(String nome) throws PersonagemNaoExisteException{ procurar(nome).Up(); }
    public void Morre(String nome) throws PersonagemNaoExisteException{ procurar(nome).morre(); }
    public void reestrutura(String nome) throws PersonagemNaoExisteException{ procurar(nome).reestrutura(); }
    
    public void normalizar(String nome, String escolha) throws PersonagemNaoExisteException, EntradaInvalidaException{
        /*
        Método que normaliza os atributos do personagem, é dado o nome, e qual atributo irá ser normalizado.
        */
        Personagem person = procurar(nome);
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
                throw new EntradaInvalidaException();                
        }
    }
    public void upgrade(String nome, String escolha, int quant) throws PersonagemNaoExisteException, EntradaInvalidaException{
        /*
        Método que aumenta os atributos básicos do personagem.
        Recebe o nome dele, qual atributo será aumentado, e quanto.
        Não pode ser menor que 0, claro.
        */
        if (quant > 0){
            Personagem person = procurar(nome);
            switch (escolha){
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
                    person.upgradeMovimentos(quant);
                    break;
                case "Vida":
                    person.upgradeVida(quant);
                    break;
                default:
                    throw new EntradaInvalidaException();
                    
            }
        } else{
            throw new EntradaInvalidaException();
        }
    }
    public void plus(String nome, String escolha, int quant) throws PersonagemNaoExisteException, EntradaInvalidaException{
        /*
        Aumenta os atributos do personagem, sem modificar a base.
        Recebe o nome, qual atributo será aumentado e em quanto.
        Não pode ser menor que 0.
        */
        if (quant > 0){
            Personagem person = procurar(nome);
            switch (escolha){ 
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
                    person.plusMovimentos(quant);
                    break;
                case "Vida":
                    person.plusVida(quant);
                    break;
                default:
                    throw new EntradaInvalidaException();
                    
            }
        } else{
            throw new EntradaInvalidaException();
        }
    }
    public void dano(String nome, String escolha, int quant) throws PersonagemNaoExisteException, EntradaInvalidaException{
        /*
        Decrementa o valor dos atributos de um personagem.
        Recebe o nome, qual atributo e em quanto.
        Não pode ser menor que 0!
        */
        Personagem person = procurar(nome);
        if (quant > 0){
            switch (escolha){
                case "Ataque":
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
                    throw new EntradaInvalidaException();
            }
        } else{
            throw new EntradaInvalidaException();
        }
    }
    public void danoVida(String nome, String condicao, int quant) throws PersonagemNaoExisteException, EntradaInvalidaException{
        /*
        Decrementa a vida de um personagem.
        Recebe o nome, a condição (para ver se é uma fraqueza do mesmo) e a quantidade de dano.
        Não pode ser menor que 0.
        */
        if (quant > 0){
            Personagem person = procurar(nome);
            String[] fraco = person.getFraqueza();
            for (int i = 0; i < fraco.length; i++){
                if (fraco[i].equals(condicao)){
                    quant += 10;
                }
            }
            person.danoVida(quant);
        } else{
            throw new EntradaInvalidaException();
        }
    }
    /*
    Métodos que devolvem atributos do personagem.
    */
    public int getVida(String nome) throws PersonagemNaoExisteException{
        Personagem person = procurar(nome);
        return person.getVida(); 
    }
    public int getMp(String nome) throws PersonagemNaoExisteException {
        Personagem person = procurar(nome); 
        return person.getMp(); 
    }
    public int getAtaque(String nome) throws PersonagemNaoExisteException{
        Personagem person = procurar(nome);
        return person.getAtaque(); 
    }
    public int getDefesa(String nome) throws PersonagemNaoExisteException {
        Personagem person = procurar(nome); 
        return person.getDefesa(); 
    }
    public int getMovimentos(String nome) throws PersonagemNaoExisteException {
        Personagem person = procurar(nome); 
        return person.getMovimentos(); 
    }
    public int getNivel(String nome) throws PersonagemNaoExisteException {
        Personagem person = procurar(nome); 
        return person.getNivel(); 
    }
    public String getNome(String nome) throws PersonagemNaoExisteException{
        Personagem person = procurar(nome);
        return person.getNome(); 
    }
    public RepositorioEquipamento getLoot(String nome) throws PersonagemNaoExisteException{
        Personagem person = procurar(nome);
        return person.getLoot();
    }
    public RepositorioMagia getMagia(String nome) throws PersonagemNaoExisteException{
        Personagem person = procurar(nome);
        return person.getPoderes();
    }

    /*
    Métodos que modificam os atributos do personagem.
    */
    public void setNome(String nome, String novo) throws PersonagemNaoExisteException, PersonagemJaExisteException{ 
        /*
        Método que modifica o nome, não pode ser um nome já usado.
        */
        try {
            procurar(novo);
            throw new PersonagemJaExisteException();
        } catch (Exception e) {
            procurar(nome).setNome(novo);
        }
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
    public void setPoderes (String nome, RepositorioMagia poderes) throws PersonagemNaoExisteException{ 
        procurar(nome).setPoderes(poderes); 
    }
    public void setFraqueza(String nome, String[] fraqueza) throws PersonagemNaoExisteException{ 
        procurar(nome).setFraqueza(fraqueza); 
    }
    public void setLoot(String nome, RepositorioEquipamento loot) throws PersonagemNaoExisteException{
        procurar(nome).setLoot(loot);
    }
}