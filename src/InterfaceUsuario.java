import ClassesBasicas.*;
import Excecoes.*;
import Repositorios.*;
import FachadaGeral.*;
import ClassesFachadaIndividual.*;

public class InterfaceUsuario {

    public static void main(String[] args) {
        RepositorioEquipamento repEquipamento = new RepositorioEquipamentoArray(2);
        
        try {
            Equipamento equipamento01 = new Equipamento("TornozeleiraBerserk", 150, 0, 40, 20, "Aumenta sua Defesa e Vida");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        try {
            Equipamento equipamento01 = new Equipamento("Gargantuilha", 350, 100, 0, 0, "Aumenta consideravelmente seu Ataque");
        } catch (Exception e) {
            System.out.println(e.getMessage());
    }
}