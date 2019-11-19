import ClassesBasicas.*;
import Excecoes.*;
import Repositorios.*;
import FachadaGeral.*;
import FachadasNegocio.*;

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
            equipamento02.setAtaque(250);
            programa.atualizarEquipamento(equipamento02);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        try {
            Equipamento equipamento03 = new Equipamento("ColarDeCaveira", 1000, 150, 200, 150, "Aumenta consideravelmente seu Ataque, Defesa e Vida");
            programa.procurarEquipamento("ColarDeCaveira");
            programa.cadastrarEquipamento(equipamento03);
            programa.procurarEquipamento("ColarDeCaveira");
            equipamento03.setAtaque(200);
            programa.atualizarEquipamento(equipamento03);
            programa.removerEquipamento("Gargantuilha");
            programa.removerEquipamento("ColarDeCaveira");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}