package tela;

import paineis.PainelEmagrecimento;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaSpa extends JFrame {
    private JMenuBar jbBarra;
    private JMenu jmOpçoes;
    private JMenuItem jmiCadastrar,jmiPesquisar,jmiAlterar,jmiRemover,jmiP_emagrecimento,jmiP_estetica;
    private ImageIcon image;
    private JLabel jlimage;

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
        jmiCadastrar = new JMenu("Cadastrar");
        jmiPesquisar = new JMenuItem("Pesquisar");
        jmiAlterar = new JMenuItem("Alterar");
        jmiRemover = new JMenuItem("Remover");
        jmOpçoes = new JMenu("Opções");
        jmiP_emagrecimento = new JMenuItem("Paciente Emagrecimento");
        jmiP_estetica = new JMenuItem("Paciente Estética");
        jbBarra.add(jmOpçoes);
        jmOpçoes.add(jmiCadastrar);
        jmOpçoes.add(jmiPesquisar);
        jmOpçoes.add(jmiAlterar);
        jmOpçoes.add(jmiRemover);
        jmiCadastrar.add(jmiP_emagrecimento);
        jmiCadastrar.add(jmiP_estetica);



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
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            TelaSpa spa = new TelaSpa("SPA-LA-LA");
            spa.setVisible(true);
        });
    }
}
