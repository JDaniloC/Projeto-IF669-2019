import ClassesBasicas.*;
import Excecoes.*;
import Repositorios.*;
import FachadaGeral.*;
import FachadasNegocio.*;
import java.util.Random;

public class InterfaceUsuario {
    private static Heroi criaHeroi(String nome, Equipamento loot, Magia poder){
        Random gerador = new Random();
        return new Heroi(nome, gerador.nextInt(100), gerador.nextInt(20),
                gerador.nextInt(10), gerador.nextInt(20), gerador.nextInt(10),
                gerador.nextInt(5), criaFraqueza(), poder, loot);
    }
    private static Monstro criaMonstro(String nome, Equipamento loot, Magia poder){
        Random gerador = new Random();
        return new Monstro(nome, gerador.nextInt(100),
                gerador.nextInt(20), gerador.nextInt(10), gerador.nextInt(20),
                gerador.nextInt(10), gerador.nextInt(5), criaFraqueza(), poder, loot);
    }
    private static String[] criaFraqueza(){
        Random gerador = new Random();
        String[] fraquezas = {"Fogo", "Agua", "Terra", "Ar", "Avatar"};
        String[] escolhidos = {fraquezas[gerador.nextInt(4)], fraquezas[gerador.nextInt(4)]};
        return escolhidos;
    }

    public static void main(String[] args) {

        // Criação das fachadas
        FachadaEquipamento equipamento = new FachadaEquipamento(new RepositorioEquipamentoArray(3));
        FachadaCidade cidade = new FachadaCidade(new RepositorioCidadeArray());
        FachadaPersonagem personagem = new FachadaPersonagem(new RepositorioPersonagemArray());
        FachadaMagia magia = new FachadaMagia(new RepositorioMagiaArray());
        /*
        FachadaEquipamento equipamento = new FachadaEquipamento(new RepositorioEquipamentoLista());
        FachadaCidade cidade = new FachadaCidade(new RepositorioCidadeLista());
        FachadaPersonagem personagem = new FachadaPersonagem(new RepositorioPersonagemLista());
        FachadaMagia magia = new FachadaMagia(new RepositorioMagiaLista());
        */
        // Criação da fachada geral
        FachadaGeral programa = new FachadaGeral(personagem, equipamento, cidade, magia);

        // Equipamento
        System.out.println("EQUIPAMENTO\n");
        // Cadastro, atualização e procura
        System.out.println("CADASTRO, ATUALIZAÇÃO E PROCURA:");
        Equipamento equipamento01 = new Equipamento("TornozeleiraBerserk", 150, 0, 40, 20, "Aumenta sua Defesa e Vida");
        try {
            // Cadastrar
            programa.cadastrarEquipamento(equipamento01);
            System.out.println("TornozeleiraBerserk cadastrado.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        Equipamento equipamento02 = new Equipamento("Gargantuilha", 350, 100, 0, 0, "Aumenta consideravelmente seu Ataque");
        try {
            programa.cadastrarEquipamento(equipamento02);
            System.out.println("Gargantuilha cadastradoa.");
            // Mudando o ataque e atualizando.
            equipamento02.setAtaque(250);
            programa.atualizarEquipamento(equipamento02);
            System.out.println("Gargantuilha modificada.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        Equipamento equipamento03 = new Equipamento("ColarDeCaveira", 1000, 150, 200, 150, "Aumenta consideravelmente seu Ataque, Defesa e Vida");
        try {
            // Procurar
            programa.cadastrarEquipamento(equipamento03);
            System.out.println("ColarDeCaveira cadastrado.");
            programa.procurarEquipamento("ColarDeCaveira");
            System.out.println("Encontrou ColarDeCaveira.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        // Test exceções
        System.out.println("\nTESTES DE EXCEÇÕES:");
        try {
            // EquipamentoNaoEncontradoException
            Equipamento erro = programa.procurarEquipamento("SuddenDeath");
        } catch (Exception e){
            System.out.println(e.getMessage());
        }

        try {
            // EquipamentoJaCadastradoException
            Equipamento equipamento04 = new Equipamento("ColarDeCaveira", 1000, 150, 200, 150, "Aumenta consideravelmente seu Ataque, Defesa e Vida");
            programa.cadastrarEquipamento(equipamento04);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }

        // Test repositórios
        System.out.println("\nTESTES REPOSITÓRIOS:");
        try{
            // Removeu certo
            programa.removerEquipamento("TornozeleiraBerserk");
            System.out.println("Removeu TornozeleiraBerserk");
            programa.procurarEquipamento("TornozeleiraBeserk");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        try {
            // Removendo todos
            programa.procurarEquipamento("Gargantuilha");
            System.out.println("Encontrou Gargantuilha.");
            programa.removerEquipamento("Gargantuilha");
            System.out.println("Removeu Gargantuilha.");
            programa.removerEquipamento("ColarDeCaveira");
            System.out.println("Removeu Gargantuilha.");
            programa.cadastrarEquipamento(equipamento01);
            System.out.println("Adicionou TornozeleiraBerserk");
            programa.cadastrarEquipamento(equipamento02);
            System.out.println("Adicionou Gargantuilha");
            programa.cadastrarEquipamento(equipamento03);
            System.out.println("Adicionou ColarDeCaveira");
        } catch (Exception e){
            System.out.println(e.getMessage());
        }

        // Magia
        System.out.println("\nMAGIA\n");
        // Cadastro, atualização, exite e procura
        System.out.println("CADASTRO, ATUALIZAÇÃO, EXISTE E PROCURA:");

        Magia magia01 = new Magia("Soltar Fogo", 10, 1, 0, "Queima", "Fogo");
        try{
            // Cadastro e existe
            programa.cadastrarMagia(magia01);
            System.out.println("Soltar Fogo cadastrado.");
            System.out.println("Existe Soltar Fogo?");
            System.out.println(programa.existeMagia("Soltar Fogo"));
        } catch (Exception e){
            System.out.println(e.getMessage());
        }

        Magia magia02 = new Magia("Curar", 0, 2, 10, "Restaura estado", "Restauração");
        try{
            programa.cadastrarMagia(magia02);
            System.out.println("Curar cadastrado.");
            // Mudando o gasto e atualizando.
            magia02.setGasto(10);
            programa.atualizarMagia(magia02);
            System.out.println("Curar modificado");
        } catch (Exception e){
            System.out.println(e.getMessage());
        }

        Magia magia03 = new Magia("Divine Smite", 100, 20, 0, "SUPER Poderoso", "divino");
        try{
            // Procurar
            programa.cadastrarMagia(magia03);
            System.out.println("Divine Smite cadastrado");
            programa.procurarMagia("Divine Smite");
            System.out.println("Divine Smite encontrado.");
        } catch (Exception e){
            System.out.println(e.getMessage());
        }

        // Test exceções
        System.out.println("\nTESTES DE EXCEÇÕES:");
        try{
            // MagiaNaoEncontradoException
            programa.procurarMagia("Transformar");
        } catch (Exception e){
            System.out.println(e.getMessage());
        }

        try{
            // MagiaJaExisteException
            programa.cadastrarMagia(magia01);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }

        // Test repositórios
        System.out.println("\nTESTES REPOSITÓRIOS:");
        try{
            // Remoção correta
            programa.removerMagia("Curar");
            System.out.println("Curar removido.");
            programa.procurarMagia("Curar");
        } catch (Exception e){
            System.out.println(e.getMessage());
        }

        try{
            // Removendo todos
            programa.procurarMagia("Divine Smite");
            System.out.println("Encontrou Divine Smite");
            programa.removerMagia("Soltar Fogo");
            System.out.println("Removeu Soltar Fogo");
            programa.removerMagia("Divine Smite");
            System.out.println("Removeu Divine Smite");
            programa.cadastrarMagia(magia01);
            System.out.println("Adicionou Soltar Fogo");
            programa.cadastrarMagia(magia02);
            System.out.println("Adicionou Curar");
            programa.cadastrarMagia(magia03);
            System.out.println("Adicionou Divine Smite");
        } catch (Exception e){
            System.out.println(e.getMessage());
        }

        // Personagem
        System.out.println("\nPERSONAGEM\n");
        // Cadastro, atualização e procura
        System.out.println("CADASTRO, ATUALIZAÇÃO E PROCURA:");
        Heroi personagem01 = criaHeroi("Danilo", equipamento01, magia01);
        try{
            // Cadastrar
            programa.adicionarPersonagem(personagem01);
            System.out.println("Danilo cadastrado.");
        } catch (Exception e){
            System.out.println(e.getMessage());
        }

        Heroi personagem02 = criaHeroi("Julio", equipamento02, magia02);
        try{
            programa.adicionarPersonagem(personagem02);
            System.out.println("Julio cadastrado.");
            System.out.printf("Nível: %d\n", programa.getNivelPersonagem("Julio"));
            personagem02.Up();
            // Mudando o nível e atualizando.
            programa.atualizarPersonagem(personagem02);
            System.out.println("Julio modificado.");
            System.out.printf("Nível: %d\n", programa.getNivelPersonagem("Julio"));
        } catch (Exception e){
            System.out.println(e.getMessage());
        }

        Monstro personagem03 = criaMonstro("João", equipamento03, magia03);
        try{
            // Procurar
            programa.adicionarPersonagem(personagem03);
            System.out.println("João cadastrado.");
            programa.procurarPersonagem("João");
            System.out.println("Encontrou João.");
        } catch (Exception e){
            System.out.println(e.getMessage());
        }

        // Test exceções
        System.out.println("\nTESTES DE EXCEÇÕES:");
        try{
            // PersonagemJaExisteException
            programa.adicionarPersonagem(personagem01);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }

        try{
            // PersonagemNaoExisteException
            programa.procurarPersonagem("Thiago");
        } catch (Exception e){
            System.out.println(e.getMessage());
        }

        try{
            // EntradaInvalidaException
            programa.danoPersonagem("Thiago", "Mp", 2);
            System.out.printf("Mp: %d\n", programa.getMpPersonagem("Thiago"));
            System.out.println("Thiago sofreu dano!");
            System.out.printf("Mp: %d\n", programa.getMpPersonagem("Thiago"));
            programa.danoPersonagem("Danilo", "Errado", 10);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }

        // Test repositórios
        System.out.println("\nTESTES REPOSITÓRIOS:");
        try{
            // Removeu certo
            programa.removerPersonagem("Julio");
            System.out.println("Removeu Julio");
            programa.procurarPersonagem("Julio");
        } catch (Exception e){
            System.out.println(e.getMessage());
        }

        try{
            // Removendo todos
            programa.procurarPersonagem("João");
            System.out.println("Encontrou João");
            programa.removerPersonagem("Danilo");
            System.out.println("Removeu Danilo");
            programa.removerPersonagem("João");
            System.out.println("Removeu João");
            programa.adicionarPersonagem(personagem01);
            System.out.println("Adicionou Danilo");
            programa.adicionarPersonagem(personagem02);
            System.out.println("Adicionou Julio");
            programa.adicionarPersonagem(personagem03);
            System.out.println("Adicionou João");
        } catch (Exception e){
            System.out.println(e.getMessage());
        }

        // Cidade
        System.out.println("\nCIDADE\n");
        // Cadastro, atualização e procura
        System.out.println("CADASTRO, ATUALIZAÇÃO E PROCURA:");

        // Test exceções
        System.out.println("\nTESTES DE EXCEÇÕES:");

        // Test repositórios
        System.out.println("\nTESTES REPOSITÓRIOS:");

    }
}