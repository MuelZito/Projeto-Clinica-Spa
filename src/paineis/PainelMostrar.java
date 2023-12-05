package paineis;

import classes.Emagrecimento;
import classes.Estetica;
import classes.Paciente;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Set;

import static tela.TelaSpa.pacientes;

public class PainelMostrar extends JPanel {
    private JTextArea jtaCampo;
    private JButton btMostraEstetica, btMostrarEmagrecimento;
    private ImageIcon image;
    private JLabel jlimage;

    public PainelMostrar() {
        setSize(550, 550);
        setLayout(null);
        //Color cor = new Color(0x556B2F);
        //setBackground(cor);
        iniciarComponentes();
        criarEventos();
    }

    private void iniciarComponentes() {
        jtaCampo = new JTextArea();
        btMostraEstetica = new JButton("Estética");
        btMostrarEmagrecimento = new JButton("Emagrecimento");

        add(jtaCampo);
        add(btMostraEstetica);
        add(btMostrarEmagrecimento);

        jtaCampo.setBounds(90, 40, 350, 300);
        btMostraEstetica.setBounds(150, 350, 100, 25);
        btMostrarEmagrecimento.setBounds(270,350,125,25);

        //Colocando img
        image = new ImageIcon(getClass().getResource("/img/background2.png"));
        jlimage = new JLabel(image);
        add(jlimage);
        jlimage.setBounds(0,0,550,550);
    }

    private void criarEventos() {
        btMostraEstetica.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jtaCampo.setText("*****************************ESTÉTICA*****************************" + "\n");

                for (Paciente paciente : pacientes) {
                    if (paciente instanceof Estetica) {
                        jtaCampo.append(paciente.mostrarDados());
                    }
                }
            }
        });
        btMostrarEmagrecimento.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                jtaCampo.setText("************************EMAGRECIMENTO**************************" + "\n");
                for (Paciente paciente: pacientes) {
                    if (paciente instanceof Emagrecimento){
                        jtaCampo.append(paciente.mostrarDados());
                    }
                }
            }
        });
    }
}
