package tela;

import javax.swing.*;
import java.awt.*;

public class TelaSpa extends JFrame {
    private JMenuBar jbBarra;
    private JMenu jmCadastrar;

    public TelaSpa(String title) throws HeadlessException {
        super(title);
        setSize(550, 550);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setLocationRelativeTo(getContentPane());
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        iniciarComponetes();
        criarEventos();
    }

    private void iniciarComponetes() {
        jbBarra = new JMenuBar();
        setJMenuBar(jbBarra);
        jmCadastrar = new JMenu("Cadastrar");
        jbBarra.add(jmCadastrar);


    }

    private void criarEventos() {

    }

    public static void main(String[] args) {
        TelaSpa spa = new TelaSpa("SPAntado");
        spa.setVisible(true);
    }
}
