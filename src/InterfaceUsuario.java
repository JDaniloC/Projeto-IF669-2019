import ClassesBasicas.*;
import Excecoes.*;
import Repositorios.*;
import FachadaGeral.*;
import ClassesFachadaIndividual.*;

public class InterfaceUsuario {

    public static void main(String[] args) {
        RepositorioEquipamento repEquipamento = new RepositorioEquipamentoArray(3);
        RepositorioPersonagem repPersonagem = new RepositorioPersonagemArray();
        RepositorioCidade repCidade = new RepositorioCidadeArray();
        FachadaEquipamento equipamento = new FachadaEquipamento(repEquipamento);
        FachadaCidade cidade = new FachadaCidade(repCidade);
        FahcadaPersonagem personagem = new FachadaPersonagem(repPersonagem);
        FachadaGeral programa = new FachadaGeral(personagem, equipamento, cidade);
        
        try {
            Equipamento equipamento01 = new Equipamento("TornozeleiraBerserk", 150, 0, 40, 20, "Aumenta sua Defesa e Vida");
            programa.cadastrarEquipamento(equipamento01);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        try {
            Equipamento equipamento02 = new Equipamento("Gargantuilha", 350, 100, 0, 0, "Aumenta consideravelmente seu Ataque");
            programa.cadastrarEquipamento(equipamento02);
            equipamento02.setAtaque(150);
            programa.atualizarEquipamento(equipamento02);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}