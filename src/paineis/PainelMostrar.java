package paineis;

import javax.swing.*;
import java.awt.*;

public class PainelMostrar extends JPanel {
    private JTextArea jtaCampo;
    private JButton btMostra;
    public PainelMostrar() {
        setSize(550, 550);
        setLayout(null);
        Color cor = new Color(0x6495ED);
        setBackground(cor);
        iniciarComponentes();
        criarEventos();
    }

    private void iniciarComponentes() {
        jtaCampo = new JTextArea();
        btMostra = new JButton("Mostrar");

        add(jtaCampo);
        add(btMostra);

        jtaCampo.setBounds(90,40,350,300);
        btMostra.setBounds(215,330,100,25);


    }

    private void criarEventos() {

    }
}
