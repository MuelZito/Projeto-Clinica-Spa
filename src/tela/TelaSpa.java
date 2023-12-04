package tela;

import classes.CalculoPeso;
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
    private CalculoPeso calculoPeso;
    public static Set<Paciente> pacientes = new HashSet<>();

    public TelaSpa(String title) throws HeadlessException {
        super(title);
        setSize(550, 550);
        setLayout(null);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setLocationRelativeTo(getContentPane());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        calculoPeso = new CalculoPeso();
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
        jbBarra
                .add(jmCadastrar);
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
                PainelEmagrecimento emagrecimento = new PainelEmagrecimento(calculoPeso);
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

                String nomeDeletado = JOptionPane.showInputDialog("DIGITE o nome para deletar");
                Boolean achou = false;
                for (Paciente paciente : pacientes) {
                    if (paciente.getNome().equals(nomeDeletado)) {
                        pacientes.remove(paciente);
                        achou = true;
                        JOptionPane.showMessageDialog(null, "REMOVIDO");
                    }
                }
                if (!achou) JOptionPane.showMessageDialog(null, "NAO ACHOU");
            }
        });
        jmiPesquisar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nomePesquisado = JOptionPane.showInputDialog("Digite o nome a ser pesquisado");
                for (Paciente paciente: pacientes){
                    if (paciente.getNome().equals(nomePesquisado)){
                        System.out.println("acho" + paciente.mostrarDados());
                    }
                }
            }
        });
        jmiAlterar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


            }
        });
    }

    public static void main(String[] args) {
        TelaSpa spa = new TelaSpa("SPA-LA-LA");
        spa.setVisible(true);

    }
}
