package tela;

import classes.CalculoPeso;
import classes.Emagrecimento;
import classes.Paciente;
import paineis.PainelEmagrecimento;
import paineis.PainelEstetica;
import paineis.PainelMostrar;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;
import java.util.Set;

public class TelaSpa extends JFrame {
    private JMenuBar jbBarra;
    private JMenu jmOpçoes, jmCadastrar;
    private JMenuItem jmiPesquisar, jmiMostrar, jmiAlterar, jmiRemover, jmiP_emagrecimento, jmiP_estetica;
    private ImageIcon image;
    private JLabel jlimage;
    public static Set<Paciente> pacientes = new HashSet<>();

    public TelaSpa(String title) throws HeadlessException {
        super(title);
        setSize(550, 550);
        setLayout(null);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setLocationRelativeTo(getContentPane());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        iniciarComponentes();
        criarEventos();
    }

    private void iniciarComponentes() {
        jbBarra = new JMenuBar();
        setJMenuBar(jbBarra);
        jmCadastrar = new JMenu("Cadastrar");
        jmiPesquisar = new JMenuItem("Pesquisar");
        jmiMostrar = new JMenuItem("Mostrar");
        jmiAlterar = new JMenuItem("Alterar");
        jmiRemover = new JMenuItem("Remover");
        jmOpçoes = new JMenu("Opções");
        jmiP_emagrecimento = new JMenuItem("Paciente Emagrecimento");
        jmiP_estetica = new JMenuItem("Paciente Estética");
        jbBarra.add(jmOpçoes);
        jbBarra.add(jmCadastrar);
        jmOpçoes.add(jmiPesquisar);
        jmOpçoes.add(jmiMostrar);
        jmOpçoes.add(jmiAlterar);
        jmOpçoes.add(jmiRemover);
        jmCadastrar.add(jmiP_emagrecimento);
        jmCadastrar.add(jmiP_estetica);


        //Colocar Background
        image = new ImageIcon(getClass().getResource("/img/background.png"));
        jlimage = new JLabel(image);
        jlimage.setLayout(null);
        setContentPane(jlimage);

    }

    private void criarEventos() {
        jmiP_emagrecimento.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PainelEmagrecimento emagrecimento = new PainelEmagrecimento();
                getContentPane().removeAll();
                getContentPane().add(emagrecimento);
                getContentPane().validate();
                getContentPane().repaint();

            }
        });
        jmiP_estetica.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PainelEstetica estetica = new PainelEstetica();
                getContentPane().removeAll();
                getContentPane().add(estetica);
                getContentPane().validate();
                getContentPane().repaint();
            }
        });
        jmiMostrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PainelMostrar mostrar = new PainelMostrar();
                getContentPane().removeAll();
                getContentPane().add(mostrar);
                getContentPane().validate();
                getContentPane().repaint();
            }
        });
        jmiRemover.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String nomeDeletado = JOptionPane.showInputDialog(null, "DIGITE o nome do paciente para DELETAR",
                        "Deletar Paciente", JOptionPane.INFORMATION_MESSAGE);
                Boolean achou = false;
                for (Paciente paciente : pacientes) {
                    if (paciente.getNome().equals(nomeDeletado)) {
                        pacientes.remove(paciente);
                        achou = true;
                        JOptionPane.showMessageDialog(null, "Pacente Removido :)");
                    }
                }
                if (!achou) {
                    JOptionPane.showMessageDialog(null, "Não foi possivel Deletar :(", "ERRO", JOptionPane.WARNING_MESSAGE);
                }
            }
        });
        jmiPesquisar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nomePesquisado = JOptionPane.showInputDialog(null, "Digite o nome do paciente para pesquisar",
                        "Pesquisar Paciente", JOptionPane.INFORMATION_MESSAGE);
                Boolean achou = false;
                for (Paciente paciente : pacientes) {
                    if (paciente.getNome().equals(nomePesquisado)) {
                        JOptionPane.showMessageDialog(null, paciente.mostrarDados(), "Pesquisar Paciente", JOptionPane.INFORMATION_MESSAGE);
                        achou = true;
                    }

                }
                if (!achou) {
                    JOptionPane.showMessageDialog(null, "PACIENTE NÃO ENCONTRADO :(", "ERRO", JOptionPane.WARNING_MESSAGE);
                }

            }
        });
        jmiAlterar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nomeAlterar = JOptionPane.showInputDialog(null, "DIGITE o nome do paciente para ALTERAR a atividade",
                        "Alterar Paciente", JOptionPane.INFORMATION_MESSAGE);

                boolean achou = false;

                for (Paciente paciente : pacientes) {
                    if (paciente instanceof Emagrecimento) {
                        if (paciente.getNome().equals(nomeAlterar)) {
                            String atividade[] = {"Caminhada Bosque", "Nadar na Piscina", "Academia"};
                            String opcaoEscolhida = (String) JOptionPane.showInputDialog(null, "Escolha uma Atividade:",
                                    "Caminhada", JOptionPane.QUESTION_MESSAGE, null, atividade, "Caminhada Bosque");
                            paciente.setTipoAtividade(opcaoEscolhida);
                            achou = true;
                            break;
                        }
                    }
                }
                if (!achou) {
                    JOptionPane.showMessageDialog(null, "PACIENTE NÃO ENCONTRADO OU NÃO FAZ ATIVIDADE :(", "ERRO", JOptionPane.WARNING_MESSAGE);
                }

            }
        });
    }


}
