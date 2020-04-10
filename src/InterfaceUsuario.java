import ClassesBasicas.*;
import Excecoes.*;
import FachadaGeral.FachadaGeral;
import FachadasNegocio.FachadaCidade;
import FachadasNegocio.FachadaEquipamento;
import FachadasNegocio.FachadaMagia;
import FachadasNegocio.FachadaPersonagem;
import Repositorios.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class InterfaceUsuario extends JFrame {
    FachadaGeral programa;
    JButton voltar = new JButton("Cancelar");

    public InterfaceUsuario() {
        voltar.addActionListener(actionEvent -> menuPrincipal());
        setSize(400, 300);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridBagLayout());
        setVisible(true);

        //init();
        load(new boolean[] {true, true, true, true});
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

        add(new JLabel("Escolha os tipos de repositório"), posicao);
//////////////////////////////////////////////////////////////////////////
        posicao.gridwidth = 1;
        posicao.ipadx = 0;
        posicao.ipady = 0;
        posicao.gridy = 1;
        add(new JLabel("Repositório de equipamentos"), posicao);
        JRadioButton eLista = new JRadioButton("lista");
        JRadioButton eArray = new JRadioButton("array");
        ButtonGroup equipamento = new ButtonGroup();
        equipamento.add(eLista);
        equipamento.add(eArray);
        equipamento.setSelected(equipamento.getElements().nextElement().getModel(), true);

        posicao.gridy = 2;
        add(eLista, posicao);
        posicao.gridx = 1;
        add(eArray, posicao);
//////////////////////////////////////////////////////////////////////////
        posicao.gridx = 0;
        posicao.gridy = 3;
        add(new JLabel("Repositório de cidades"), posicao);
        JRadioButton cLista = new JRadioButton("lista");
        JRadioButton cArray = new JRadioButton("array");
        ButtonGroup cidade = new ButtonGroup();
        cidade.add(cLista);
        cidade.add(cArray);
        cidade.setSelected(cidade.getElements().nextElement().getModel(), true);

        posicao.gridy = 4;
        add(cLista, posicao);
        posicao.gridx = 1;
        add(cArray, posicao);
//////////////////////////////////////////////////////////////////////////
        posicao.gridx = 0;
        posicao.gridy = 5;
        add(new JLabel("Repositório de personagens"), posicao);
        JRadioButton pLista = new JRadioButton("lista");
        JRadioButton pArray = new JRadioButton("array");
        ButtonGroup personagem = new ButtonGroup();
        personagem.add(pLista);
        personagem.add(pArray);
        personagem.setSelected(personagem.getElements().nextElement().getModel(), true);

        posicao.gridy = 6;
        add(pLista, posicao);
        posicao.gridx = 1;
        add(pArray, posicao);
//////////////////////////////////////////////////////////////////////////
        posicao.gridx = 0;
        posicao.gridy = 7;
        add(new JLabel("Repositório de Magias"), posicao);
        JRadioButton mLista = new JRadioButton("lista");
        JRadioButton mArray = new JRadioButton("array");
        ButtonGroup magia = new ButtonGroup();
        magia.add(mLista);
        magia.add(mArray);
        magia.setSelected(magia.getElements().nextElement().getModel(), true);

        posicao.gridy = 8;
        add(mLista, posicao);
        posicao.gridx = 1;
        add(mArray, posicao);
//////////////////////////////////////////////////////////////////////////
        JButton iniciar = new JButton("Início");
        iniciar.addActionListener(
                actionEvent -> {
                    boolean[] tipos = {
                            eLista.isSelected(),
                            cLista.isSelected(),
                            pLista.isSelected(),
                            mLista.isSelected()
                    };

                    load(tipos);
                }
        );

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

        add(new JLabel("Repositório RPG"), posicao);
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

        posicao.gridy = 1;
        add(equipamento, posicao);
        posicao.gridy = 2;
        add(magia, posicao);
        posicao.gridx = 1;
        posicao.gridy = 1;
        add(personagem, posicao);
        posicao.gridy = 2;
        add(cidade, posicao);

        repaint();
        setVisible(true);
    }
    private void gerenciamento(String opcao) {
        GridBagConstraints posicao = limparTela();

        add(new JLabel("Gerenciar " + opcao), posicao);
        JButton cadastro = new JButton("Cadastrar");
        JButton atualizacao = new JButton("Atualizar");
        JButton procura = new JButton("Procurar");

        cadastro.addActionListener(
                actionEvent -> {
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
                }
        );
        atualizacao.addActionListener(
                actionEvent -> {
                    if (opcao.equals("equipamentos")) {
                        atualizarEquipamento();
                    } else if (opcao.equals("magias")) {
                        atualizarMagia();
                    }
                }
        );
        procura.addActionListener(
                actionEvent -> {
                    if (opcao.equals("equipamentos")) {
                        procurarEquipamento();
                    } else if (opcao.equals("magias")) {
                        procurarMagia();
                    }
                }
        );

        posicao.gridy = 1;
        add(cadastro, posicao);
        posicao.gridy = 2;
        add(atualizacao, posicao);
        posicao.gridy = 3;
        add(procura, posicao);
        posicao.gridy = 4;
        add(voltar, posicao);

        repaint();
        setVisible(true);
    }
    private void cadastrarEquipamento() {
        GridBagConstraints posicao = limparTela();

        add(new JLabel("Cadastrar equipamento"), posicao);

        Placeholder nome = new Placeholder("Obrigatório", 15);
        Placeholder preco = new Placeholder("Número inteiro");
        Placeholder ataque = new Placeholder("Número inteiro");
        Placeholder defesa = new Placeholder("Número inteiro");
        Placeholder vida = new Placeholder("Número inteiro");
        JTextField especial = new JTextField();

        posicionar(new String[]{
                "Nome",
                "Preço",
                "Ataque",
                "Defesa",
                "Vida",
                "Especial"
        }, new JComponent[]{
                nome,
                preco,
                ataque,
                defesa,
                vida,
                especial
        }, 1);

        JButton cadastrar = new JButton("Cadastrar");

        cadastrar.addActionListener(
                actionEvent -> {
                    boolean verificador = true;
                    if (nome.estaVazio()) {
                        nome.changeColor(Color.RED);
                        verificador = false;
                    }
                    Placeholder[] numericos = new Placeholder[]{preco, ataque, defesa, vida};
                    for (Placeholder campo: numericos) {
                        if (campo.notNumeric()) {
                            campo.changeColor(Color.RED);
                            verificador = false;
                        }
                    }
                    if (verificador) {
                        try {
                            programa.cadastrarEquipamento(new Equipamento(
                                    nome.getText(),
                                    Integer.parseInt(preco.getText()),
                                    Integer.parseInt(ataque.getText()),
                                    Integer.parseInt(defesa.getText()),
                                    Integer.parseInt(vida.getText()),
                                    especial.getText()
                            ));

                            JOptionPane.showMessageDialog(null, "Equipamento cadastrado.");
                            gerenciamento("equipamentos");
                        } catch (EquipamentoJaCadastradoException e) {
                            JOptionPane.showMessageDialog(null, e.getMessage());
                        }
                    }
                }
        );
        posicao.gridx = 0;
        posicao.gridy = 7;
        add(cadastrar, posicao);
        posicao.gridx = 1;
        add(voltar, posicao);

        repaint();
        setVisible(true);
    }

    private void cadastrarMagia() {
        GridBagConstraints posicao = limparTela();

        add(new JLabel("Cadastrar Magia"), posicao);
        Placeholder nome = new Placeholder("Obrigatório");
        Placeholder dano = new Placeholder("Número inteiro");
        Placeholder gasto = new Placeholder("Número inteiro");
        Placeholder cura = new Placeholder("Número inteiro");
        JTextField efeito = new JTextField();
        JTextField tipo = new JTextField();

        posicionar(new String[] {
                "Nome",
                "Dano",
                "Gasto",
                "Cura",
                "Efeito",
                "Tipo"
        }, new JComponent[]{
                nome,
                dano,
                gasto,
                cura,
                efeito,
                tipo
        }, 1);

        JButton cadastrar = new JButton("Cadastrar");
        cadastrar.addActionListener(
                actionEvent -> {
                    if (nome.estaVazio()) {
                        nome.changeColor(Color.RED);
                    } else {
                        Magia magic = null;
                        boolean verificador = true;
                        if (!dano.estaVazio()) {
                            for (Placeholder numericos: new Placeholder[] {dano, gasto, cura}) {
                                if (numericos.notNumeric()) {
                                    numericos.changeColor(Color.RED);
                                    verificador = false;
                                }
                            }
                            if (efeito.getText().isEmpty() || tipo.getText().isEmpty()) {
                                verificador = false;
                            }
                            if (verificador) {
                                magic = new Magia(nome.getText(),
                                        Integer.parseInt(dano.getText()),
                                        Integer.parseInt(gasto.getText()),
                                        Integer.parseInt(cura.getText()),
                                        efeito.getText(),
                                        tipo.getText()
                                );
                            }
                        } else {
                            magic = new Magia(nome.getText());
                        }
                        if (verificador) {
                            try {
                                programa.cadastrarMagia(magic);
                                JOptionPane.showMessageDialog(null, "Magia cadastrada");
                                gerenciamento("magias");
                            } catch (MagiaJaExisteException e) {
                                JOptionPane.showMessageDialog(null, e.getMessage());
                            }
                        }
                    }
                }
        );

        posicao.gridx = 0;
        posicao.gridy = 7;
        add(cadastrar, posicao);
        posicao.gridx = 1;
        add(voltar, posicao);

        repaint();
        setVisible(true);
    }

    private void cadastrarPersonagem() {
        GridBagConstraints posicao = limparTela();

        add(new JLabel("Cadastrar personagem"), posicao);

        Placeholder nome = new Placeholder("Nome do personagem, obrigatório");
        Placeholder vida = new Placeholder("Número inteiro, obrigatório");
        Placeholder mana = new Placeholder("Número inteiro, obrigatório");
        Placeholder ataque = new Placeholder("Número inteiro, obrigatório");
        Placeholder defesa = new Placeholder("Número inteiro, obrigatório");
        Placeholder movimentos = new Placeholder("Número inteiro, obrigatório");
        Placeholder nivel = new Placeholder("Número inteiro, obrigatório");
        Placeholder fraqueza = new Placeholder("Fraquezas separadas por espaço, obrigatório");
        Placeholder magia = new Placeholder("Nome do magia, obrigatório");
        Placeholder equipamento = new Placeholder("Nome do equipamento, obrigatório");
        posicionar(new String[] {
                "Nome",
                "Vida",
                "Mana",
                "Ataque",
                "Defesa",
                "Movimentos",
                "Nivel",
                "Fraqueza",
                "Magia",
                "Equipamento"
        }, new JComponent[] {
                nome,
                vida,
                mana,
                ataque,
                defesa,
                movimentos,
                nivel,
                fraqueza,
                magia,
                equipamento
        }, 1);

        ButtonGroup tipo = new ButtonGroup();
        JRadioButton heroi = new JRadioButton("Herói");
        JRadioButton monstro = new JRadioButton("Monstro");
        tipo.add(heroi);
        tipo.add(monstro);
        tipo.setSelected(tipo.getElements().nextElement().getModel(), true);

        JButton cadastrar = new JButton("Cadastrar");
        cadastrar.addActionListener(
                actionEvent -> {
                    boolean verificador = true;
                    for (Placeholder campo: new Placeholder[]{ nome, fraqueza, equipamento, magia }) {
                        if (campo.estaVazio()) {
                            verificador = false;
                            campo.changeColor(Color.RED);
                        }
                    }
                    for (Placeholder campo: new Placeholder[]{ vida, mana, ataque, defesa, movimentos, nivel }) {
                        if (campo.estaVazio() || campo.notNumeric()) {
                            verificador = false;
                            campo.changeColor(Color.RED);
                        }
                    }
                    if (verificador) {
                        try {
                            Magia magic = programa.procurarMagia(magia.getText());
                            Equipamento loot = programa.procurarEquipamento(equipamento.getText());
                            Personagem person;
                            if (heroi.isSelected()) {
                               person = new Heroi(
                                   nome.getText(),
                                   Integer.parseInt(vida.getText()),
                                   Integer.parseInt(mana.getText()),
                                   Integer.parseInt(ataque.getText()),
                                   Integer.parseInt(defesa.getText()),
                                   Integer.parseInt(movimentos.getText()),
                                   Integer.parseInt(nivel.getText()),
                                   fraqueza.getText().split(" "),
                                   magic,
                                   loot
                               );
                            } else {
                                person = new Monstro(
                                    nome.getText(),
                                    Integer.parseInt(vida.getText()),
                                    Integer.parseInt(mana.getText()),
                                    Integer.parseInt(ataque.getText()),
                                    Integer.parseInt(defesa.getText()),
                                    Integer.parseInt(movimentos.getText()),
                                    Integer.parseInt(nivel.getText()),
                                    fraqueza.getText().split(" "),
                                    magic,
                                    loot
                                );
                            }
                            programa.adicionarPersonagem(person);
                            JOptionPane.showMessageDialog(null, "Personagem cadastrado");
                            gerenciamento("personagens");
                        } catch (MagiaNaoEncontradoException |
                                EquipamentoNaoEncontradoException |
                                PersonagemJaExisteException e) {
                            JOptionPane.showMessageDialog(null, e.getMessage());
                        }
                    }
                }
        );

        posicao.gridx = 0;
        posicao.gridy = 4;
        add(heroi, posicao);
        posicao.gridy = 5;
        add(cadastrar, posicao);
        posicao.gridx = 1;
        add(voltar, posicao);
        posicao.gridy = 4;
        add(monstro, posicao);

        repaint();
        setVisible(true);
    }

    private void cadastrarCidade() {
        GridBagConstraints posicao = limparTela();

        add(new JLabel("Cadastrar cidade"), posicao);

        Placeholder nome = new Placeholder("Nome da cidade, obrigatório");
        Placeholder populacao = new Placeholder("Número inteiro, obrigatório");
        Placeholder equipamento = new Placeholder("Nome do equipamento, obrigatório");
        JTextField missao = new JTextField();
        Placeholder monstro = new Placeholder("Nome do monstro, obrigatório");
        posicionar(new String[] {
                "Nome",
                "Populacao",
                "Equipamento",
                "Missao",
                "Monstro"
        }, new JComponent[] {
                nome,
                populacao,
                equipamento,
                missao,
                monstro,
        }, 1);

        JButton cadastrar = new JButton("Cadastrar");
        cadastrar.addActionListener(
                actionEvent -> {
                    boolean verificador = true;
                    for (Placeholder campo: new Placeholder[]{ nome, equipamento, monstro }) {
                        if (campo.estaVazio()) {
                            verificador = false;
                            campo.changeColor(Color.RED);
                        }
                    }
                    if (populacao.estaVazio() | populacao.notNumeric()) {
                        verificador = false;
                        populacao.changeColor(Color.RED);
                    }

                    if (verificador) {
                        try {
                            programa.cadastrarCidade(new Cidade(
                                    nome.getText(),
                                    Integer.parseInt(populacao.getText()),
                                    programa.procurarEquipamento(equipamento.getText()),
                                    missao.getText(),
                                    (Monstro) programa.procurarPersonagem(monstro.getText())
                            ));
                            JOptionPane.showMessageDialog(null, "Cidade cadastrada");
                            gerenciamento("cidades");
                        } catch (CidadeJaExisteException |
                                PopulacaoInvalidaException |
                                CidadeInvalidaException |
                                MissaoInvalidaException |
                                PersonagemNaoExisteException |
                                EquipamentoNaoEncontradoException e) {
                            JOptionPane.showMessageDialog(null, e.getMessage());
                        }
                    }
                }
        );

        posicao.gridx = 0;
        posicao.gridy = 6;
        add(cadastrar, posicao);
        posicao.gridx = 1;
        add(voltar, posicao);

        repaint();
        setVisible(true);
    }

    private void atualizarEquipamento() {
        GridBagConstraints posicao = limparTela();

        add(new JLabel("Atualizar equipamento"), posicao);

        Placeholder equipamento = new Placeholder("Obrigatório", 15);
        JTextField nome = new JTextField();
        Placeholder preco = new Placeholder("Número inteiro");
        Placeholder ataque = new Placeholder("Número inteiro");
        Placeholder defesa = new Placeholder("Número inteiro");
        Placeholder vida = new Placeholder("Número inteiro");
        JTextField especial = new JTextField();

        posicionar(new String[]{
                "Nome do equipamento",
                "Alterar nome",
                "Alterar preço",
                "Alterar ataque",
                "Alterar defesa",
                "Alterar vida extra",
                "Alterar atributo especial"
        }, new JComponent[]{
                equipamento,
                nome,
                preco,
                ataque,
                defesa,
                vida,
                especial
        }, 1);

        JButton atualizar = new JButton("Alterar");

        atualizar.addActionListener(
                actionEvent -> {
                    boolean verificador = true;
                    if (equipamento.estaVazio()) {
                        equipamento.changeColor(Color.RED);
                        verificador = false;
                    }
                    Placeholder[] numericos = new Placeholder[]{preco, ataque, defesa, vida};
                    for (Placeholder campo: numericos) {
                        if (!campo.estaVazio() && campo.notNumeric()) {
                            campo.changeColor(Color.RED);
                            verificador = false;
                        }
                    }
                    if (verificador) {
                        try {
                            Equipamento equip = programa.procurarEquipamento(equipamento.getText());

                            if (!nome.getText().isEmpty()) {
                                equip.setNome(nome.getText());
                            }
                            if (!preco.estaVazio()) {
                                equip.setPreco(Integer.parseInt(preco.getText()));
                            }
                            if (!ataque.estaVazio()) {
                                equip.setAtaque(Integer.parseInt(ataque.getText()));
                            }
                            if (!defesa.estaVazio()) {
                                equip.setDefesa(Integer.parseInt(defesa.getText()));
                            }
                            if (!vida.estaVazio()) {
                                equip.setVidaPlus(Integer.parseInt(vida.getText()));
                            }
                            if (!especial.getText().isEmpty()) {
                                equip.setAtributosEsp(especial.getText());
                            }
                            programa.atualizarEquipamento(equip);
                            JOptionPane.showMessageDialog(null, "Equipamento atualizado.");
                            gerenciamento("equipamentos");
                        } catch (EquipamentoNaoEncontradoException e) {
                            JOptionPane.showMessageDialog(null, e.getMessage());
                        }
                    }
                }
        );

        posicao.gridx = 0;
        posicao.gridy = 8;
        add(atualizar, posicao);
        posicao.gridx = 1;
        add(voltar, posicao);

        repaint();
        setVisible(true);
    }

    private void atualizarMagia() {
        GridBagConstraints posicao = limparTela();
        add(new JLabel("Atualizar Magia"), posicao);

        Placeholder magia = new Placeholder("Obrigatório");
        JTextField nome = new JTextField();
        Placeholder dano = new Placeholder("Número inteiro");
        Placeholder gasto = new Placeholder("Número inteiro");
        Placeholder cura = new Placeholder("Número inteiro");
        JTextField efeito = new JTextField();
        JTextField tipo = new JTextField();

        posicionar(new String[]{
                "Nome da magia",
                "Alterar nome",
                "Alterar dano",
                "Alterar gasto",
                "Alterar cura",
                "Alterar efeito",
                "Alterar tipo"
        }, new JComponent[] {
                magia,
                nome,
                dano,
                gasto,
                cura,
                efeito,
                tipo
        }, 1);

        JButton atualizar = new JButton("Atualizar");
        atualizar.addActionListener(
                actionEvent -> {
                    boolean verificador = true;
                    if (magia.estaVazio()) {
                        magia.changeColor(Color.RED);
                        verificador = false;
                    }
                    for (Placeholder campo: new Placeholder[]{dano, gasto, cura}) {
                        if (!campo.estaVazio() && campo.notNumeric()) {
                            campo.changeColor(Color.RED);
                            verificador = false;
                        }
                    }
                    if (verificador) {
                        try {
                            Magia magic = programa.procurarMagia(magia.getText());

                            if (!nome.getText().isEmpty()) {
                                magic.setNome(nome.getText());
                            }
                            if (!dano.estaVazio()) {
                                magic.setDano(Integer.parseInt(dano.getText()));
                            }
                            if (!gasto.estaVazio()) {
                                magic.setGasto(Integer.parseInt(gasto.getText()));
                            }
                            if (!cura.estaVazio()) {
                                magic.setCura(Integer.parseInt(cura.getText()));
                            }
                            if (!efeito.getText().isEmpty()) {
                                magic.setEfeito(efeito.getText());
                            }
                            if (!tipo.getText().isEmpty()) {
                                magic.setTipo(tipo.getText());
                            }
                            programa.atualizarMagia(magic);
                            JOptionPane.showMessageDialog(null, "Magia Atualizada");
                            gerenciamento("magias");
                        } catch (MagiaNaoEncontradoException e) {
                            JOptionPane.showMessageDialog(null, e.getMessage());
                        }
                    }
                }
        );

        posicao.gridx = 0;
        posicao.gridy = 8;
        add(atualizar, posicao);
        posicao.gridx = 1;
        add(voltar, posicao);

        repaint();
        setVisible(true);
    }

    private void atualizarPersonagem() {
        GridBagConstraints posicao = limparTela();
        add(new JLabel("Atualizar personagem"), posicao);

        Placeholder personagem = new Placeholder("Obrigatório");
        JTextField nome = new JTextField();
        Placeholder vida = new Placeholder("Número inteiro");
        Placeholder mana = new Placeholder("Número inteiro");
        Placeholder ataque = new Placeholder("Número inteiro");
        Placeholder defesa = new Placeholder("Número inteiro");
        Placeholder movimentos = new Placeholder("Número inteiro");
        Placeholder nivel = new Placeholder("Número inteiro");
        Placeholder fraqueza = new Placeholder("Separado por espaço");
        Placeholder magia = new Placeholder("Nome do magia");
        Placeholder equipamento = new Placeholder("Nome do equipamento");
        posicionar(new String[] {
                "Nome do personagem",
                "Alterar Nome",
                "Alterar Vida",
                "Alterar Mana",
                "Alterar Ataque",
                "Alterar Defesa",
                "Alterar Movimentos",
                "Alterar Nivel",
                "Alterar Fraqueza",
                "Alterar Magia",
                "Alterar Equipamento"
        }, new JComponent[] {
                personagem,
                nome,
                vida,
                mana,
                ataque,
                defesa,
                movimentos,
                nivel,
                fraqueza,
                magia,
                equipamento
        }, 1);

        JButton atualizar = new JButton("Atualizar");
        atualizar.addActionListener(
                actionEvent -> {
                    boolean verificador = true;
                    if (personagem.estaVazio()) {
                        personagem.changeColor(Color.RED);
                        verificador = false;
                    }
                    for (Placeholder campo: new Placeholder[]{vida, mana, ataque, defesa, movimentos, nivel}) {
                        if (!campo.estaVazio() && campo.notNumeric()) {
                            campo.changeColor(Color.RED);
                            verificador = false;
                        }
                    }
                    if (verificador) {
                        try {
                            Personagem person = programa.procurarPersonagem(personagem.getText());

                            if (!nome.getText().isEmpty()) {
                                person.setNome(nome.getText());
                            }
                            if (!vida.estaVazio()) {
                                person.setVida(Integer.parseInt(vida.getText()));
                            }
                            if (!mana.estaVazio()) {
                                person.setMp(Integer.parseInt(mana.getText()));
                            }
                            if (!ataque.estaVazio()) {
                                person.setAtaque(Integer.parseInt(ataque.getText()));
                            }
                            if (!defesa.estaVazio()) {
                                person.setDefesa(Integer.parseInt(defesa.getText()));
                            }
                            if (!movimentos.estaVazio()) {
                                person.setMovimentos(Integer.parseInt(movimentos.getText()));
                            }
                            if (!nivel.estaVazio()) {
                                person.setNivel(Integer.parseInt(nivel.getText()));
                            }
                            if (!fraqueza.estaVazio()) {
                                person.setFraqueza(fraqueza.getText().split(" "));
                            }
                            if (!magia.estaVazio()) {
                                person.setPoderes(programa.procurarMagia(magia.getText()));
                            }
                            if (!equipamento.estaVazio()) {
                                person.setLoot(programa.procurarEquipamento(equipamento.getText()));
                            }
                            programa.atualizarPersonagem(person);
                            JOptionPane.showMessageDialog(null, "Personagem atualizado");
                            gerenciamento("personagens");
                        } catch (PersonagemNaoExisteException |
                                MagiaNaoEncontradoException |
                                EquipamentoNaoEncontradoException e) {
                            JOptionPane.showMessageDialog(null, e.getMessage());
                        }
                    }
                }
        );

        posicao.gridx = 0;
        posicao.gridy = 12;
        add(atualizar, posicao);
        posicao.gridx = 1;
        add(voltar, posicao);

        repaint();
        setVisible(true);
    }

    private void atualizarCidade() {
        GridBagConstraints posicao = limparTela();
        add(new JLabel("Atualizar cidade"), posicao);

        Placeholder cidade = new Placeholder("Obrigatório");
        JTextField nome = new JTextField();
        Placeholder populacao = new Placeholder("Número inteiro");
        Placeholder equipamento = new Placeholder("Nome do equipamento");
        JTextField missao = new JTextField();
        Placeholder monstro = new Placeholder("Nome do monstro");
        posicionar(new String[] {
                "Nome da cidade",
                "Alterar Nome",
                "Alterar Populacao",
                "Alterar Equipamento",
                "Alterar Missao",
                "Alterar Monstro"
        }, new JComponent[] {
                cidade,
                nome,
                populacao,
                equipamento,
                missao,
                monstro,
        }, 1);

        JButton atualizar = new JButton("Atualizar");
        atualizar.addActionListener(
                actionEvent -> {
                    boolean verificador = true;

                    if (cidade.estaVazio()) {
                        verificador = false;
                        cidade.changeColor(Color.RED);
                    }
                    if (!populacao.estaVazio() && populacao.notNumeric()) {
                        verificador = false;
                        populacao.changeColor(Color.RED);
                    }

                    if (verificador) {
                        try {
                            Cidade city = programa.procurarLocal(cidade.getText());

                            if (!nome.getText().isEmpty()) {
                                city.setCidade(nome.getText());
                            }
                            if (!populacao.estaVazio()) {
                                city.setPopulacao(Integer.parseInt(populacao.getText()));
                            }
                            if (!equipamento.estaVazio()) {
                                city.setVendedor(programa.procurarEquipamento(equipamento.getText()));
                            }
                            if (!missao.getText().isEmpty()) {
                                city.setMissao(missao.getText());
                            }
                            if (!monstro.estaVazio()) {
                                city.setMonstro((Monstro) programa.procurarPersonagem(monstro.getText()));
                            }
                            programa.atualizarCidade(city);
                            JOptionPane.showMessageDialog(null, "Cidade atualizada");
                            gerenciamento("cidades");
                        } catch (CidadeInvalidaException |
                                CidadeNaoExisteException |
                                EquipamentoNaoEncontradoException |
                                PersonagemNaoExisteException e) {
                            e.printStackTrace();
                        }
                    }
                }
        );

        repaint();
        setVisible(true);
    }

    private void procurarEquipamento() {
        GridBagConstraints posicao = limparTela();
        add(new JLabel("Procurar equipamento"), posicao);

        Placeholder equipamento = new Placeholder("Obrigatório");
        JLabel preco = new JLabel("");
        JLabel ataque = new JLabel("");
        JLabel defesa = new JLabel("");
        JLabel vida = new JLabel("");
        JLabel especial = new JLabel("");
        posicionar(new String[]{
                "Nome do equipamento",
                "Preço",
                "Ataque",
                "Defesa",
                "Vida",
                "Especial"
        }, new JComponent[]{
                equipamento,
                preco,
                ataque,
                defesa,
                vida,
                especial
        }, 1);

        JButton procurar = new JButton("Procurar");
        JButton remover = new JButton("Remover");

        procurar.addActionListener(
                actionEvent -> {
                    if (equipamento.estaVazio()) {
                        equipamento.changeColor(Color.RED);
                    } else {
                        try {
                            Equipamento equip = programa.procurarEquipamento(equipamento.getText());
                            preco.setText(Integer.toString(equip.getPreco()));
                            ataque.setText(Integer.toString(equip.getAtaque()));
                            defesa.setText(Integer.toString(equip.getDefesa()));
                            vida.setText(Integer.toString(equip.getVidaPlus()));
                            especial.setText(equip.getAtributosEsp());
                        } catch (Exception e) {
                            JOptionPane.showMessageDialog(null, e.getMessage());
                        }
                    }
                }
        );
        remover.addActionListener(
                actionEvent -> {
                    if (equipamento.estaVazio()) {
                        equipamento.changeColor(Color.RED);
                    } else {
                        try {
                            programa.removerEquipamento(equipamento.getText());
                            JOptionPane.showMessageDialog(null, "Equipamento removido");
                            gerenciamento("equipamentos");
                        } catch (EquipamentoNaoEncontradoException e) {
                            JOptionPane.showMessageDialog(null, e.getMessage());
                        }
                    }
                }
        );

        posicao.gridx = 0;
        posicao.gridy = 7;
        add(procurar, posicao);
        posicao.gridx = 1;
        add(remover, posicao);
        posicao.gridx = 2;
        add(voltar, posicao);

        repaint();
        setVisible(true);
    }

    private void procurarMagia() {
        GridBagConstraints posicao = limparTela();
        add(new JLabel("Procurar Magia"), posicao);

        Placeholder magia = new Placeholder("Obrigatório");
        JLabel dano = new JLabel("");
        JLabel gasto = new JLabel("");
        JLabel cura = new JLabel("");
        JLabel efeito = new JLabel("");
        JLabel tipo = new JLabel("");
        posicionar(new String[]{
                "Nome da magia",
                "Preço",
                "Ataque",
                "Defesa",
                "Vida",
                "Especial"
        }, new JComponent[]{
                magia,
                dano,
                gasto,
                cura,
                efeito,
                tipo
        }, 1);

        JButton procurar = new JButton("Procurar");
        JButton remover = new JButton("Remover");

        procurar.addActionListener(
                actionEvent -> {
                    if (magia.estaVazio()) {
                        magia.changeColor(Color.RED);
                    } else {
                        try {
                            Magia magic = programa.procurarMagia(magia.getText());
                            dano.setText(Integer.toString(magic.getDano()));
                            gasto.setText(Integer.toString(magic.getGasto()));
                            cura.setText(Integer.toString(magic.getCura()));
                            efeito.setText(magic.getEfeito());
                            tipo.setText(magic.getTipo());
                        } catch (MagiaNaoEncontradoException e) {
                            JOptionPane.showMessageDialog(null, e.getMessage());
                        }
                    }
                }
        );
        remover.addActionListener(
                actionEvent -> {
                    if (magia.estaVazio()) {
                        magia.changeColor(Color.RED);
                    } else {
                        try {
                            programa.removerMagia(magia.getText());
                            JOptionPane.showMessageDialog(null, "Magia removida");
                            gerenciamento("magias");
                        } catch (MagiaNaoEncontradoException e) {
                            JOptionPane.showMessageDialog(null, e.getMessage());
                        }
                    }
                }
        );

        posicao.gridx = 0;
        posicao.gridy = 7;
        add(procurar, posicao);
        posicao.gridx = 1;
        add(remover, posicao);
        posicao.gridx = 2;
        add(voltar, posicao);

        repaint();
        setVisible(true);
    }

    private void procurarPersonagem() {
        GridBagConstraints posicao = limparTela();
        add(new JLabel("Procurar personagem"));

        Placeholder personagem = new Placeholder("Obrigatório");
        JLabel vida = new JLabel("");
        JLabel mana = new JLabel("");
        JLabel ataque = new JLabel("");
        JLabel defesa = new JLabel("");
        JLabel movimentos = new JLabel("");
        JLabel nivel = new JLabel("");
        JLabel fraqueza = new JLabel("");
        JLabel magia = new JLabel("");
        JLabel equipamento = new JLabel("");
        posicionar(new String[] {
                "Nome do personagem",
                "Vida",
                "Mana",
                "Ataque",
                "Defesa",
                "Movimentos",
                "Nivel",
                "Fraqueza",
                "Magia",
                "Equipamento"
        }, new JComponent[] {
                personagem,
                vida,
                mana,
                ataque,
                defesa,
                movimentos,
                nivel,
                fraqueza,
                magia,
                equipamento
        }, 1);

        JButton procurar = new JButton("Procurar");
        JButton remover = new JButton("Remover");

        procurar.addActionListener(
                actionEvent -> {
                    if (personagem.estaVazio()) {
                        personagem.changeColor(Color.RED);
                    } else {
                        try {
                            Personagem person = programa.procurarPersonagem(personagem.getText());
                            vida.setText(person.getNome());
                            mana.setText(Integer.toString(person.getMp()));
                            ataque.setText(Integer.toString(person.getAtaque()));
                            defesa.setText(Integer.toString(person.getDefesa()));
                            movimentos.setText(Integer.toString(person.getMovimentos()));
                            nivel.setText(Integer.toString(person.getNivel()));
                            fraqueza.setText(String.join(", ", person.getFraqueza()));
                            magia.setText(person.getPoderes().getNome());
                            equipamento.setText(person.getLoot().getNome());
                        } catch (PersonagemNaoExisteException e) {
                            JOptionPane.showMessageDialog(null, e.getMessage());
                        }
                    }
                }
        );
        remover.addActionListener(
                actionEvent -> {
                    if (personagem.estaVazio()) {
                        personagem.changeColor(Color.RED);
                    } else {
                        try {
                            programa.removerPersonagem(personagem.getText());
                            JOptionPane.showMessageDialog(null, "Personagem removido");
                            gerenciamento("personagens");
                        } catch (PersonagemNaoExisteException e) {
                            JOptionPane.showMessageDialog(null, e.getMessage());
                        }
                    }
                }
        );

        posicao.gridx = 0;
        posicao.gridy = 11;
        add(procurar, posicao);
        posicao.gridx = 1;
        add(remover, posicao);
        posicao.gridx = 2;
        add(voltar, posicao);

        repaint();
        setVisible(true);
    }

    private void procurarCidade() {
        GridBagConstraints posicao = limparTela();
        add(new JLabel("Procurar cidade"), posicao);

        Placeholder cidade = new Placeholder("Obrigatório");
        JLabel nome = new JLabel("");
        JLabel populacao = new JLabel("");
        JLabel equipamento = new JLabel("");
        JLabel missao = new JLabel("");
        JLabel monstro = new JLabel("");
        posicionar(new String[] {
                "Nome da cidade",
                "Nome",
                "Populacao",
                "Equipamento",
                "Missao",
                "Monstro"
        }, new JComponent[] {
                cidade,
                nome,
                populacao,
                equipamento,
                missao,
                monstro,
        }, 1);

        JButton procurar = new JButton("Procurar");
        JButton remover = new JButton("Remover");

        procurar.addActionListener(
                actionEvent -> {
                    if (cidade.estaVazio()) {
                        cidade.changeColor(Color.RED);
                    } else {
                        try {
                            Cidade city = programa.procurarLocal(cidade.getText());
                            nome.setText(city.getCidade());
                            populacao.setText(Integer.toString(city.getPopulacao()));
                            equipamento.setText(city.getVendedor().getNome());
                            missao.setText(city.getMissao());
                            monstro.setText(city.getMonstro().getNome());
                        } catch (CidadeNaoExisteException | CidadeInvalidaException e) {
                            JOptionPane.showMessageDialog(null, e.getMessage());
                        }
                    }
                }
        );
        remover.addActionListener(
                actionEvent -> {
                    if (cidade.estaVazio()) {
                        cidade.changeColor(Color.RED);
                    } else {
                        try {
                            programa.removerCidade(cidade.getText());
                            JOptionPane.showMessageDialog(null, "Cidade removida");
                            gerenciamento("cidades");
                        } catch (CidadeNaoExisteException | CidadeInvalidaException e) {
                            JOptionPane.showMessageDialog(null, e.getMessage());
                        }
                    }
                }
        );

        posicao.gridx = 0;
        posicao.gridy = 7;
        add(procurar, posicao);
        posicao.gridx = 1;
        add(remover, posicao);
        posicao.gridx = 2;
        add(voltar, posicao);

        repaint();
        setVisible(true);
    }

    private GridBagConstraints limparTela() {
        getContentPane().removeAll();
        GridBagConstraints posicao = new GridBagConstraints();
        posicao.fill = GridBagConstraints.HORIZONTAL;
        return posicao;
    }

    private void posicionar(String[] titulos, JComponent[] widgets,  int start) {
        if (titulos.length == widgets.length) {
            GridBagConstraints posicao = new GridBagConstraints();
            posicao.fill = GridBagConstraints.HORIZONTAL;
            for (int i = 0; i < titulos.length; i++) {
                posicao.gridy = i + start;
                posicao.gridx = 0;
                add(new JLabel(titulos[i]), posicao);
                posicao.gridx = 1;
                add(widgets[i], posicao);
            }
        }
    }

    private static class Placeholder extends JTextField {
        private String reservado;

        public Placeholder(String reservado, int colunas) {
            super(reservado, colunas);
            init(reservado);
        }

        public Placeholder(String reservado) {
            super(reservado);
            init(reservado);
        }

        private void init(String reservado) {
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
