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
        
        
        //inicio do teste de Cidade
            try{
                Cidade cidade1 = new Cidade("Paracetamol",1000,Equipamento equipamentoC1 = new Equipamento("Cotaspirina", 150, 0, 40, 20, "Aumenta sua Defesa e Vida"),
                        "Mate 5 goblins",Monstro monstroC1 = new Monstro("DDC", 100, 0, 50, 10, 0, 1, null, null, null));
                programa.cadastrarCidade(cidade1);
            } catch (Exception e){
                System.out.println(e.getMessage());
            }
            try{
                Cidade cidade2 = new Cidade("Cidadelonge",10,Equipamento equipamentoC2 = new Equipamento("Rina", 200, 0, 40, 20, "Aumenta sua Defesa e Vida"),
                        null,Monstro monstroC1 = new Monstro("DDC", 100, 0, 50, 10, 0, 1, null, null, null));
                programa.cadastrarCidade(cidade2);
            } catch (Exception e){
                System.out.println(e.getMessage());
            }
            try{
                Cidade cidade3 = new Cidade("Cidadeperto",0,Equipamento equipamentoC3 = new Equipamento("Cota", 150, 0, 50, 20, "Aumenta sua Defesa e Vida"),
                        "Mate 5 lobos",Monstro monstroC1 = new Monstro("DDC", 100, 0, 50, 10, 0, 1, null, null, null));
                programa.cadastrarCidade(cidade3);
            } catch (Exception e){
                System.out.println(e.getMessage());
            }
            try{
                Cidade cidade4 = new Cidade(null,2000,Equipamento equipamentoC4 = new Equipamento("Cotirina", 150, 0, 40, 20, "Aumenta sua Defesa e Vida"),
                        "Mate 5 trolls",Monstro monstroC1 = new Monstro("DDC", 100, 0, 50, 10, 0, 1, null, null, null));
                programa.cadastrarCidade(cidade4);
            } catch (Exception e){
                System.out.println(e.getMessage());
            }
            try{
                Cidade cidade5 = new Cidade("Cidadeali",500,Equipamento equipamentoC5 = new Equipamento("Coina", 150, 0, 40, 20, "Aumenta sua Defesa e Vida"),
                        "Mate 3 goblins",Monstro monstroC1 = new Monstro("DDC", 100, 0, 50, 10, 0, 1, null, null, null));
                programa.cadastrarCidade(cidade5);
            } catch (Exception e){
                System.out.println(e.getMessage());
            }
            try{
                programa.procurarLocal("Paracetamol")
            }catch (Exception e){
                System.out.println(e.getMessage);
            }
            try{
                programa.procurarLocal("tamol")
            }catch (Exception e){
                System.out.println(e.getMessage);
            }
            try{
                programa.removerCidade("Paracetamol")
            }catch (Exception e){
                System.out.println(e.getMessage);
            }
            try{
                programa.procurarLocal("Paracetamol")
            }catch (Exception e){
                System.out.println(e.getMessage);
            }
            //Fim do teste de Cidade
    }
}
