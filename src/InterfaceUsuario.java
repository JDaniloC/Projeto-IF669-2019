import ClassesBasicas.*;
import Excecoes.*;
import FachadaGeral.FachadaGeral;
import FachadasNegocio.*;
import Repositorios.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class InterfaceUsuario extends JFrame {
    FachadaGeral programa;
    JButton voltar = new JButton("Cancelar");

    public InterfaceUsuario() {
        voltar.addActionListener(actionEvent -> {
            setSize(400, 300);
            menuPrincipal();
        });
        setSize(400, 300);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridBagLayout());
        setVisible(true);

        init();
    }

    private JLabel titulo(String frase) {
        JLabel titulo = new JLabel(frase);
        titulo.setFont(new Font("Times new roman", Font.BOLD, 20));
        return titulo;
    }

    public static void main(String[] args) {
        new InterfaceUsuario();
    }

    private void init() {
        GridBagConstraints posicao = new GridBagConstraints();
        posicao.fill = GridBagConstraints.HORIZONTAL;
        posicao.ipadx = 100;
        posicao.ipady = 50;
        posicao.gridwidth = 40;
        posicao.gridx = 0;
        posicao.gridy = 0;

        add(titulo("Escolha os tipos de repositório"), posicao);
        posicao.gridwidth = 1;
        posicao.ipadx = 0;
        posicao.ipady = 0;
        posicao.gridy = 1;

        JRadioButton[] equipamento = criarRadio(
                "Repositório de equipamentos", new String[] {"Lista", "Array"}, posicao, 2
        );

        posicao.gridy = 3;
        JRadioButton[] cidade = criarRadio(
                "Repositório de cidades", new String[] {"Lista", "Array"}, posicao, 4
        );

        posicao.gridy = 5;
        JRadioButton[] personagem = criarRadio(
                "Repositório de personagens", new String[] {"Lista", "Array"}, posicao, 6
        );

        posicao.gridy = 7;
        JRadioButton[] magia = criarRadio(
                "Repositório de Magias", new String[] {"Lista", "Array"}, posicao, 8
        );

        JButton iniciar = new JButton("Início");
        iniciar.addActionListener( actionEvent -> load(new boolean[] {
            equipamento[0].isSelected(),
            cidade[0].isSelected(),
            personagem[0].isSelected(),
            magia[0].isSelected()
        }));

        posicao.gridx = 0;
        posicao.gridy = 9;
        posicao.gridwidth = GridBagConstraints.REMAINDER;
        add(iniciar, posicao);

        setVisible(true);
    }
    private void load(boolean[] opcoes) {
        FachadaEquipamento equipamento = (opcoes[0]) ?
                new FachadaEquipamento(new RepositorioEquipamentoLista()) :
                new FachadaEquipamento(new RepositorioEquipamentoArray(10));

        FachadaCidade cidade = (opcoes[1]) ?
                new FachadaCidade(new RepositorioCidadeLista()) :
                new FachadaCidade(new RepositorioCidadeArray());

        FachadaPersonagem personagem = (opcoes[2]) ?
                new FachadaPersonagem(new RepositorioPersonagemLista()) :
                new FachadaPersonagem(new RepositorioPersonagemArray());

        FachadaMagia magia = (opcoes[3]) ?
                new FachadaMagia(new RepositorioMagiaLista()) :
                new FachadaMagia(new RepositorioMagiaArray());

        programa = new FachadaGeral(personagem, equipamento, cidade, magia);

        menuPrincipal();
    }
    private void menuPrincipal() {
        GridBagConstraints posicao = limparTela();

        add(titulo("Repositório RPG"), posicao);
        JButton equipamento = new JButton("Gerenciar equipamentos");
        JButton magia = new JButton("Gerenciar magias");
        JButton personagem = new JButton("Gerenciar personagens");
        JButton cidade = new JButton("Gerenciar cidades");

        equipamento.addActionListener(actionEvent -> gerenciamento("equipamentos"));
        magia.addActionListener(actionEvent -> gerenciamento("magias"));
        personagem.addActionListener(actionEvent -> gerenciamento("personagens"));
        cidade.addActionListener(actionEvent -> gerenciamento("cidades"));

        posicao.weighty = 1;
        posicao.ipady = 50;

        layoutQuadrado(posicao, equipamento, personagem, magia, cidade);
    }
    private void gerenciamento(String opcao) {
        GridBagConstraints posicao = limparTela();

        posicao.gridwidth = GridBagConstraints.REMAINDER;
        add(titulo("         Gerenciar " + opcao), posicao);

        posicao.gridwidth = 1;
        posicao.weightx = 1;
        posicao.weighty = 1;
        posicao.ipady = 50;
        posicao.ipadx = 10;

        JButton cadastro = new JButton("Cadastrar");
        JButton atualizacao = new JButton("Atualizar");
        JButton procura = new JButton("Procurar");

        cadastro.addActionListener( actionEvent -> {
                    switch (opcao) {
                        case "equipamentos":
                            cadastrarEquipamento();
                            break;
                        case "magias":
                            cadastrarMagia();
                            break;
                        case "personagens":
                            cadastrarPersonagem();
                            break;
                        default:
                            cadastrarCidade();
                            break;
                    }
        });

        atualizacao.addActionListener( actionEvent -> {
                    switch (opcao) {
                        case "equipamentos":
                            atualizarEquipamento();
                            break;
                        case "magias":
                            atualizarMagia();
                            break;
                        case "personagens":
                            atualizarPersonagem();
                            break;
                        default:
                            atualizarCidade();
                            break;
                    }
        });

        procura.addActionListener( actionEvent -> {
                    switch (opcao) {
                        case "equipamentos":
                            procurarEquipamento();
                            break;
                        case "magias":
                            procurarMagia();
                            break;
                        case "personagens":
                            procurarPersonagem();
                            break;
                        default:
                            procurarCidade();
                            break;
                    }
        });

        layoutQuadrado(posicao, cadastro, atualizacao, procura, voltar);
    }

    private void layoutQuadrado(
            GridBagConstraints posicao, JButton tLeft, JButton tRight, JButton dLeft, JButton dRight
    ) {
        posicao.gridy = 1;
        add(tLeft, posicao);
        posicao.gridy = 2;
        add(dLeft, posicao);
        posicao.gridx = 1;
        posicao.gridy = 1;
        add(tRight, posicao);
        posicao.gridy = 2;
        add(dRight, posicao);

        repaint();
        setVisible(true);
    }

    private void cadastrarEquipamento() {
        GridBagConstraints posicao = limparTela();
        add(titulo("Cadastrar equipamento"), posicao);

        Placeholder[] variaveis = posicionar(new String[]{
                "Nome", "Preço", "Ataque", "Defesa", "Vida", "Especial"
        }, new String[]{
                "Obrigatório", "Número inteiro", "Número inteiro", "Número inteiro", "Número inteiro", ""
        });

        JButton cadastrar = new JButton("Cadastrar");

        cadastrar.addActionListener(
                actionEvent -> {
                    if (verificacao(
                            new Placeholder[]{variaveis[0]},
                            new Placeholder[]{variaveis[1], variaveis[2], variaveis[3], variaveis[4]})
                    ) {
                        try {
                            programa.cadastrarEquipamento(new Equipamento(
                                    variaveis[0].getText(),
                                    Integer.parseInt(variaveis[1].getText()),
                                    Integer.parseInt(variaveis[2].getText()),
                                    Integer.parseInt(variaveis[3].getText()),
                                    Integer.parseInt(variaveis[4].getText()),
                                    variaveis[5].getText()
                            ));

                            JOptionPane.showMessageDialog(null, "Equipamento cadastrado.");
                            gerenciamento("equipamentos");
                        } catch (EquipamentoJaCadastradoException e) {
                            JOptionPane.showMessageDialog(null, e.getMessage());
                        }
                    }
                }
        );

        layoutLinha(posicao, new JButton[]{cadastrar, voltar}, 7);
    }

    private void cadastrarMagia() {
        GridBagConstraints posicao = limparTela();
        add(titulo("Cadastrar Magia"), posicao);

        Placeholder[] variaveis = posicionar(new String[] {
                "Nome", "Dano", "Gasto", "Cura", "Efeito", "Tipo"
        }, new String[]{
                "Obrigatório", "Número inteiro", "Número inteiro", "Número inteiro", "", "" });

        JButton cadastrar = new JButton("Cadastrar");
        cadastrar.addActionListener(
                actionEvent -> {
                    if (variaveis[0].estaVazio()) { variaveis[0].changeColor(Color.RED);
                    } else {
                        Magia magic;
                        if (verificacao(
                                new Placeholder[]{ variaveis[1], variaveis[4], variaveis[5]},
                                new Placeholder[] {variaveis[1], variaveis[2], variaveis[3]})
                        ) {
                            magic = new Magia(variaveis[0].getText(),
                                    Integer.parseInt(variaveis[1].getText()),
                                    Integer.parseInt(variaveis[2].getText()),
                                    Integer.parseInt(variaveis[3].getText()),
                                    variaveis[4].getText(),
                                    variaveis[5].getText()
                            );
                        } else { magic = new Magia(variaveis[0].getText()); }
                        try {
                            programa.cadastrarMagia(magic);
                            JOptionPane.showMessageDialog(null, "Magia cadastrada");
                            gerenciamento("magias");
                        } catch (MagiaJaExisteException e) {
                            JOptionPane.showMessageDialog(null, e.getMessage());
                        }
                    }
                }
        );

        layoutLinha(posicao, new JButton[]{cadastrar, voltar}, 7);
    }

    private void cadastrarPersonagem() {
        GridBagConstraints posicao = limparTela();
        setSize(400, 400);
        add(titulo("Cadastrar personagem"), posicao);

        Placeholder[] variaveis = posicionar(new String[] {
                "Nome", "Vida", "Mana", "Ataque", "Defesa", "Movimentos",
                "Nivel", "Fraqueza", "Magia", "Equipamento"
        }, new String[] {
                "Nome do personagem, obrigatório", "Número inteiro, obrigatório", "Número inteiro, obrigatório",
                "Número inteiro, obrigatório", "Número inteiro, obrigatório", "Número inteiro, obrigatório",
                "Número inteiro, obrigatório", "Fraquezas separadas por espaço, obrigatório",
                "Nome do magia, obrigatório", "Nome do equipamento, obrigatório"
        });

        posicao.gridy = 11;
        JRadioButton[] heroi = criarRadio(
                "Tipo de personagem",
                new String[]{ "Heroi", "Monstro" },
                posicao,
                12
        );

        JButton cadastrar = new JButton("Cadastrar");
        cadastrar.addActionListener(
                actionEvent -> {
                    if (verificacao(
                            new Placeholder[]{ variaveis[0], variaveis[7], variaveis[9], variaveis[8] },
                            new Placeholder[]{
                                    variaveis[1], variaveis[2], variaveis[3],
                                    variaveis[4], variaveis[5], variaveis[6]
                            })
                    ) {
                        try {
                            Personagem person;
                            if (heroi[0].isSelected()) {
                               person = new Heroi(
                                   variaveis[0].getText(),
                                   Integer.parseInt(variaveis[1].getText()),
                                   Integer.parseInt(variaveis[2].getText()),
                                   Integer.parseInt(variaveis[3].getText()),
                                   Integer.parseInt(variaveis[4].getText()),
                                   Integer.parseInt(variaveis[5].getText()),
                                   Integer.parseInt(variaveis[6].getText()),
                                   variaveis[7].getText().split(" "),
                                   programa.procurarMagia(variaveis[8].getText()),
                                   programa.procurarEquipamento(variaveis[9].getText())
                               );
                            } else {
                                person = new Monstro(
                                    variaveis[0].getText(),
                                    Integer.parseInt(variaveis[1].getText()),
                                    Integer.parseInt(variaveis[2].getText()),
                                    Integer.parseInt(variaveis[3].getText()),
                                    Integer.parseInt(variaveis[4].getText()),
                                    Integer.parseInt(variaveis[5].getText()),
                                    Integer.parseInt(variaveis[6].getText()),
                                    variaveis[7].getText().split(" "),
                                    programa.procurarMagia(variaveis[8].getText()),
                                    programa.procurarEquipamento(variaveis[9].getText())
                                );
                            }
                            programa.adicionarPersonagem(person);
                            JOptionPane.showMessageDialog(null, "Personagem cadastrado");
                            setSize(400, 300);
                            gerenciamento("personagens");
                        } catch (Exception e) {
                            JOptionPane.showMessageDialog(null, e.getMessage());
                        }
                    }
                }
        );

        layoutLinha(posicao, new JButton[]{cadastrar, voltar}, 13);
    }

    private void cadastrarCidade() {
        GridBagConstraints posicao = limparTela();

        add(titulo("Cadastrar cidade"), posicao);

        Placeholder[] variaveis = posicionar(new String[] {
                "Nome", "Populacao", "Equipamento", "Missao", "Monstro"
        }, new String[] {
                "Nome da cidade, obrigatório", "Número inteiro, obrigatório",
                "Nome do equipamento, obrigatório",
                "", "Nome do monstro, obrigatório"});

        JButton cadastrar = new JButton("Cadastrar");
        cadastrar.addActionListener(
                actionEvent -> {
                    if (verificacao(
                            new Placeholder[]{ variaveis[0], variaveis[2], variaveis[4] },
                            new Placeholder[]{ variaveis[1] })
                    ) {
                        try {
                            programa.cadastrarCidade(new Cidade(
                                    variaveis[0].getText(),
                                    Integer.parseInt(variaveis[1].getText()),
                                    programa.procurarEquipamento(variaveis[2].getText()),
                                    variaveis[3].getText(),
                                    (Monstro) programa.procurarPersonagem(variaveis[4].getText())
                            ));
                            JOptionPane.showMessageDialog(null, "Cidade cadastrada");
                            gerenciamento("cidades");
                        } catch (Exception e) {
                            JOptionPane.showMessageDialog(null, e.getMessage());
                        }
                    }
                }
        );

        layoutLinha(posicao, new JButton[]{cadastrar, voltar}, 6);
    }

    private void atualizarEquipamento() {
        GridBagConstraints posicao = limparTela();
        add(titulo("Atualizar equipamento"), posicao);

        Placeholder[] variaveis = posicionar(new String[]{
                "Nome do equipamento", "Alterar nome", "Alterar preço",
                "Alterar ataque", "Alterar defesa", "Alterar vida extra", "Alterar atributo especial"
        }, new String[]{
                "Obrigatório", "", "Número inteiro", "Número inteiro", "Número inteiro", "Número inteiro", ""});

        JButton atualizar = new JButton("Alterar");

        atualizar.addActionListener(
                actionEvent -> {
                    if (verificacao(
                            new Placeholder[]{variaveis[0]},
                            new Placeholder[]{variaveis[2], variaveis[3], variaveis[4], variaveis[5]})
                    ) {
                        try {
                            Equipamento equip = programa.procurarEquipamento(variaveis[0].getText());

                            if (!variaveis[1].estaVazio()) {
                                equip.setNome(variaveis[1].getText()); }
                            if (!variaveis[2].estaVazio()) {
                                equip.setPreco(Integer.parseInt(variaveis[2].getText())); }
                            if (!variaveis[3].estaVazio()) {
                                equip.setAtaque(Integer.parseInt(variaveis[3].getText())); }
                            if (!variaveis[4].estaVazio()) {
                                equip.setDefesa(Integer.parseInt(variaveis[4].getText())); }
                            if (!variaveis[5].estaVazio()) {
                                equip.setVidaPlus(Integer.parseInt(variaveis[5].getText())); }
                            if (!variaveis[6].estaVazio()) {
                                equip.setAtributosEsp(variaveis[6].getText()); }
                            programa.atualizarEquipamento(equip);
                            JOptionPane.showMessageDialog(null, "Equipamento atualizado.");
                            gerenciamento("equipamentos");
                        } catch (EquipamentoNaoEncontradoException e) {
                            JOptionPane.showMessageDialog(null, e.getMessage());
                        }
                    }
                }
        );

        layoutLinha(posicao, new JButton[]{atualizar, voltar}, 8);
    }

    private void atualizarMagia() {
        GridBagConstraints posicao = limparTela();
        add(titulo("Atualizar Magia"), posicao);

        Placeholder[] variaveis = posicionar(new String[]{
                "Nome da magia", "Alterar nome", "Alterar dano", "Alterar gasto",
                "Alterar cura", "Alterar efeito", "Alterar tipo"
        }, new String[] {
                "Obrigatório", "", "Número inteiro", "Número inteiro", "Número inteiro", "", ""});

        JButton atualizar = new JButton("Atualizar");
        atualizar.addActionListener(
                actionEvent -> {
                    if (verificacao(
                            new Placeholder[]{variaveis[0]},
                            new Placeholder[]{variaveis[2], variaveis[3], variaveis[4]})
                    ) {
                        try {
                            Magia magic = programa.procurarMagia(variaveis[0].getText());

                            if (!variaveis[1].estaVazio()) { magic.setNome(variaveis[1].getText()); }
                            if (!variaveis[2].estaVazio()) { magic.setDano(Integer.parseInt(variaveis[2].getText())); }
                            if (!variaveis[3].estaVazio()) { magic.setGasto(Integer.parseInt(variaveis[3].getText())); }
                            if (!variaveis[4].estaVazio()) { magic.setCura(Integer.parseInt(variaveis[4].getText())); }
                            if (!variaveis[5].estaVazio()) { magic.setEfeito(variaveis[5].getText()); }
                            if (!variaveis[6].estaVazio()) { magic.setTipo(variaveis[6].getText()); }
                            programa.atualizarMagia(magic);
                            JOptionPane.showMessageDialog(null, "Magia Atualizada");
                            gerenciamento("magias");
                        } catch (MagiaNaoEncontradoException e) {
                            JOptionPane.showMessageDialog(null, e.getMessage());
                        }
                    }
                }
        );

        layoutLinha(posicao, new JButton[]{atualizar, voltar}, 8);
    }

    private void atualizarPersonagem() {
        GridBagConstraints posicao = limparTela();
        setSize(400, 400);
        add(titulo("Atualizar personagem"), posicao);

        Placeholder[] variaveis = posicionar(new String[] {
                "Nome do personagem", "Alterar Nome", "Alterar Vida", "Alterar Mana",
                "Alterar Ataque", "Alterar Defesa", "Alterar Movimentos",
                "Alterar Nivel", "Alterar Fraqueza", "Alterar Magia", "Alterar Equipamento"
        }, new String[] {
                "Obrigatório", "", "Número inteiro", "Número inteiro", "Número inteiro", "Número inteiro",
                "Número inteiro", "Número inteiro", "Separado por espaço", "Nome da magia", "Nome do equipamento"
        });

        JButton atualizar = new JButton("Atualizar");
        atualizar.addActionListener(
                actionEvent -> {
                    if (verificacao(
                            new Placeholder[]{variaveis[0]},
                            new Placeholder[]{variaveis[2], variaveis[3], variaveis[4],
                                    variaveis[5], variaveis[6], variaveis[7]})
                    ) {
                        try {
                            Personagem person = programa.procurarPersonagem(variaveis[0].getText());

                            if (!variaveis[1].estaVazio()) {
                                person.setNome(variaveis[1].getText()); }
                            if (!variaveis[2].estaVazio()) {
                                person.setVida(Integer.parseInt(variaveis[2].getText())); }
                            if (!variaveis[3].estaVazio()) {
                                person.setMp(Integer.parseInt(variaveis[3].getText())); }
                            if (!variaveis[4].estaVazio()) {
                                person.setAtaque(Integer.parseInt(variaveis[4].getText())); }
                            if (!variaveis[5].estaVazio()) {
                                person.setDefesa(Integer.parseInt(variaveis[5].getText())); }
                            if (!variaveis[6].estaVazio()) {
                                person.setMovimentos(Integer.parseInt(variaveis[6].getText())); }
                            if (!variaveis[7].estaVazio()) {
                                person.setNivel(Integer.parseInt(variaveis[7].getText())); }
                            if (!variaveis[8].estaVazio()) {
                                person.setFraqueza(variaveis[8].getText().split(" ")); }
                            if (!variaveis[9].estaVazio()) {
                                person.setPoderes(programa.procurarMagia(variaveis[9].getText())); }
                            if (!variaveis[10].estaVazio()) {
                                person.setLoot(programa.procurarEquipamento(variaveis[10].getText())); }
                            programa.atualizarPersonagem(person);
                            JOptionPane.showMessageDialog(null, "Personagem atualizado");
                            setSize(400, 300);
                            gerenciamento("personagens");
                        } catch (PersonagemNaoExisteException |
                                MagiaNaoEncontradoException |
                                EquipamentoNaoEncontradoException e) {
                            JOptionPane.showMessageDialog(null, e.getMessage());
                        }
                    }
                }
        );

        layoutLinha(posicao, new JButton[]{atualizar, voltar}, 12);
    }

    private void atualizarCidade() {
        GridBagConstraints posicao = limparTela();
        add(titulo("Atualizar cidade"), posicao);

        Placeholder[] variaveis = posicionar(new String[] {
                "Nome da cidade", "Alterar Nome", "Alterar Populacao",
                "Alterar Equipamento", "Alterar Missao", "Alterar Monstro"
        }, new String[] {"Obrigatório", "", "Número inteiro", "Nome do equipamento", "", "Nome do monstro"});

        JButton atualizar = new JButton("Atualizar");
        atualizar.addActionListener(
                actionEvent -> {
                    if (verificacao(new Placeholder[]{variaveis[0]}, new Placeholder[]{variaveis[2]})) {
                        try {
                            Cidade city = programa.procurarLocal(variaveis[0].getText());

                            if (!variaveis[1].estaVazio()) { city.setCidade(variaveis[1].getText()); }
                            if (!variaveis[2].estaVazio()) {
                                city.setPopulacao(Integer.parseInt(variaveis[2].getText()));
                            }
                            if (!variaveis[3].estaVazio()) {
                                city.setVendedor(programa.procurarEquipamento(variaveis[3].getText()));
                            }
                            if (!variaveis[4].estaVazio()) { city.setMissao(variaveis[4].getText()); }
                            if (!variaveis[5].estaVazio()) {
                                city.setMonstro((Monstro) programa.procurarPersonagem(variaveis[5].getText()));
                            }
                            programa.atualizarCidade(city);
                            JOptionPane.showMessageDialog(null, "Cidade atualizada");
                            gerenciamento("cidades");
                        } catch (CidadeInvalidaException |
                                CidadeNaoExisteException |
                                EquipamentoNaoEncontradoException |
                                PersonagemNaoExisteException e) {
                            JOptionPane.showMessageDialog(null, e.getMessage());
                        }
                    }
                }
        );

        layoutLinha(posicao, new JButton[]{atualizar, voltar}, 7);
    }

    private void procurarEquipamento() {
        GridBagConstraints posicao = limparTela();
        add(titulo("Procurar equipamento"), posicao);

        Placeholder[] variaveis = posicionar(new String[]{
                "Nome do equipamento", "Preço", "Ataque", "Defesa", "Vida", "Especial"
        }, new String[]{"Obrigatório", "", "", "", "", ""});

        JButton procurar = new JButton("Procurar");
        JButton remover = new JButton("Remover");

        procurar.addActionListener(
                actionEvent -> {
                    if (variaveis[0].estaVazio()) {
                        variaveis[0].changeColor(Color.RED);
                    } else {
                        try {
                            Equipamento equip = programa.procurarEquipamento(variaveis[0].getText());
                            colocarTexto(variaveis, new String[] {Integer.toString(equip.getPreco()),
                                    Integer.toString(equip.getAtaque()), Integer.toString(equip.getDefesa()),
                                    Integer.toString(equip.getVidaPlus()), equip.getAtributosEsp()});
                        } catch (Exception e) {
                            JOptionPane.showMessageDialog(null, e.getMessage());
                        }
                    }
                }
        );
        remover.addActionListener(actionEvent -> delete(variaveis, "equipamentos"));

        layoutLinha(posicao, new JButton[]{procurar, remover, voltar}, 7);
    }

    private void procurarMagia() {
        GridBagConstraints posicao = limparTela();
        add(titulo("Procurar Magia"), posicao);

        Placeholder[] variaveis = posicionar(new String[]{
                "Nome da magia", "Dano", "Gasto", "Cura", "Efeito", "Tipo"
        }, new String[]{"Obrigatório", "", "", "", "", ""});

        JButton procurar = new JButton("Procurar");
        JButton remover = new JButton("Remover");

        procurar.addActionListener(
                actionEvent -> {
                    if (variaveis[0].estaVazio()) {
                        variaveis[0].changeColor(Color.RED);
                    } else {
                        try {
                            Magia magic = programa.procurarMagia(variaveis[0].getText());
                            colocarTexto(variaveis, new String[] {Integer.toString(magic.getDano()),
                                    Integer.toString(magic.getGasto()), Integer.toString(magic.getCura()),
                                    magic.getEfeito(), magic.getTipo()});
                        } catch (MagiaNaoEncontradoException e) {
                            JOptionPane.showMessageDialog(null, e.getMessage());
                        }
                    }
                }
        );
        remover.addActionListener(actionEvent -> delete(variaveis, "magias"));

        layoutLinha(posicao, new JButton[]{procurar, remover, voltar}, 7);
    }

    private void procurarPersonagem() {
        GridBagConstraints posicao = limparTela();
        add(titulo("Procurar personagem"));

        Placeholder[] variaveis = posicionar(new String[] {
                "Nome do personagem", "Vida", "Mana", "Ataque", "Defesa",
                "Movimentos", "Nivel", "Fraqueza", "Magia", "Equipamento"
        }, new String[] {"Obrigatório", "", "", "", "", "", "", "", "", ""});

        JButton procurar = new JButton("Procurar");
        JButton remover = new JButton("Remover");

        procurar.addActionListener(
                actionEvent -> {
                    if (variaveis[0].estaVazio()) {
                        variaveis[0].changeColor(Color.RED);
                    } else {
                        try {
                            Personagem person = programa.procurarPersonagem(variaveis[0].getText());
                            colocarTexto(variaveis, new String[] {person.getNome(), Integer.toString(person.getMp()),
                                    Integer.toString(person.getAtaque()), Integer.toString(person.getDefesa()),
                                    Integer.toString(person.getMovimentos()), Integer.toString(person.getNivel()),
                                    String.join(", ", person.getFraqueza()), person.getPoderes().getNome(),
                                    person.getLoot().getNome()});
                        } catch (PersonagemNaoExisteException e) {
                            JOptionPane.showMessageDialog(null, e.getMessage());
                        }
                    }
                }
        );
        remover.addActionListener(actionEvent -> delete(variaveis, "personagens"));

        layoutLinha(posicao, new JButton[]{procurar, remover, voltar}, 11);
    }

    private void procurarCidade() {
        GridBagConstraints posicao = limparTela();
        add(titulo("Procurar cidade"), posicao);

        Placeholder[] variaveis = posicionar(new String[] {
                "Nome da cidade", "Nome", "Populacao", "Equipamento", "Missao", "Monstro"
        }, new String[] {"Obrigatorio", "", "", "", "", "",});

        JButton procurar = new JButton("Procurar");
        JButton remover = new JButton("Remover");

        procurar.addActionListener(
                actionEvent -> {
                    if (variaveis[0].estaVazio()) {
                        variaveis[0].changeColor(Color.RED);
                    } else {
                        try {
                            Cidade city = programa.procurarLocal(variaveis[0].getText());
                            colocarTexto(variaveis, new String[]{city.getCidade(),
                                    Integer.toString(city.getPopulacao()), city.getVendedor().getNome(),
                                    city.getMissao(), city.getMonstro().getNome()});
                        } catch (CidadeNaoExisteException | CidadeInvalidaException e) {
                            JOptionPane.showMessageDialog(null, e.getMessage());
                        }
                    }
                }
        );
        remover.addActionListener(actionEvent -> delete(variaveis, "cidades"));

        layoutLinha(posicao, new JButton[]{procurar, remover, voltar}, 7);
    }

    private void colocarTexto(Placeholder[] variaveis, String[] valores) {
        for (int i = 0; i < valores.length; i++) {
            variaveis[i + 1].setText(valores[i]);
        }
    }

    private boolean verificacao(Placeholder[] cheios, Placeholder[] numericos) {
        boolean verificador = true;
        for (Placeholder campo: cheios) {
            if (campo.estaVazio()) {
                campo.changeColor(Color.RED);
                verificador = false;
            }
        }
        for (Placeholder campo: numericos) {
            if (!campo.estaVazio() && campo.notNumeric()) {
                campo.changeColor(Color.RED);
                verificador = false;
            }
        }
        return verificador;
    }

    private void delete(Placeholder[] variaveis, String tipo) {
        if (variaveis[0].estaVazio()) {
            variaveis[0].changeColor(Color.RED);
        } else {
            try {
                switch (tipo) {
                    case "cidades":
                        programa.removerCidade(variaveis[0].getText());
                        break;
                    case "personagens":
                        programa.removerPersonagem(variaveis[0].getText());
                        break;
                    case "magias":
                        programa.removerMagia(variaveis[0].getText());
                        break;
                    default:
                        programa.removerEquipamento(variaveis[0].getText());
                        break;
                }
                JOptionPane.showMessageDialog(null, "Removido com sucesso");
                gerenciamento(tipo);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        }
    }

    private void layoutLinha(GridBagConstraints posicao, JButton[] botoes, int y) {
        posicao.gridy = y;
        for (int i = 0; i < botoes.length; i++) {
            posicao.gridx = i;
            add(botoes[i], posicao);
        }

        repaint();
        setVisible(true);
    }

    private JRadioButton[] criarRadio(String label, String[] radioLabels, GridBagConstraints posicao, int y) {
        posicao.gridx = 0;
        add(new JLabel(label), posicao);
        JRadioButton primeiro = new JRadioButton(radioLabels[0]);
        JRadioButton segundo = new JRadioButton(radioLabels[1]);
        ButtonGroup grupo = new ButtonGroup();
        grupo.add(primeiro);
        grupo.add(segundo);
        grupo.setSelected(grupo.getElements().nextElement().getModel(), true);

        posicao.gridy = y;
        posicao.gridx = 0;
        add(primeiro, posicao);
        posicao.gridx = 1;
        add(segundo, posicao);

        return new JRadioButton[] {primeiro, segundo};
    }

    private GridBagConstraints limparTela() {
        getContentPane().removeAll();
        GridBagConstraints posicao = new GridBagConstraints();
        posicao.fill = GridBagConstraints.HORIZONTAL;
        return posicao;
    }

    private Placeholder[] posicionar(String[] titulos, String[] avisos) {
        Placeholder[] widgets = new Placeholder[avisos.length];
        if (titulos.length == avisos.length) {
            GridBagConstraints posicao = new GridBagConstraints();
            posicao.fill = GridBagConstraints.HORIZONTAL;
            for (int i = 0; i < titulos.length; i++) {
                posicao.gridy = i + 1;
                posicao.gridx = 0;
                add(new JLabel(titulos[i]), posicao);
                posicao.gridx = 1;
                widgets[i] = new Placeholder(avisos[i]);
                add(widgets[i], posicao);
            }
        }
        return widgets;
    }

    private static class Placeholder extends JTextField {
        private final String reservado;

        public Placeholder(String reservado) {
            super(reservado, 15);
            this.reservado = reservado;
            setForeground(Color.GRAY);
            addFocusListener(new FocusListener() {
                @Override
                public void focusGained(FocusEvent focusEvent) {
                    if (getText().equals(reservado)) {
                        setText("");
                        setForeground(Color.BLACK);
                    }
                }

                @Override
                public void focusLost(FocusEvent focusEvent) {
                    if (getText().isEmpty()) {
                        setText(reservado);
                        setForeground(Color.GRAY);
                    }
                }
            });
        }

        public void changeColor(Color cor) {
            setText(reservado);
            setForeground(cor);
        }

        public boolean estaVazio() {
            return getText().equals(reservado);
        }

        public boolean notNumeric() {
            try {
                Integer.parseInt(getText());
            } catch (NumberFormatException nfe) {
                return true;
            }
            return false;
        }
    }
}
