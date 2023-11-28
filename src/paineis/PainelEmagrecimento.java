package paineis;

import classes.Emagrecimento;
import tela.TelaSpa;

import javax.swing.*;
import javax.swing.text.MaskFormatter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

public class PainelEmagrecimento extends JPanel {
    private JLabel jlNome, jlSexo, jlTelefone, jlPeso, jlAltura;
    private JTextField jtfNome;
    private JFormattedTextField jftTelefone,jtfPeso, jtfAltura;
    private JRadioButton rbMasculino, rbFeminino;
    private ButtonGroup bgGenero;
    private Button btCadastrar;
    private Font font = font = new Font(Font.SANS_SERIF, Font.BOLD, 15);

    public PainelEmagrecimento() {
        setSize(550, 550);
        setLayout(null);
        Color cor = new Color(0x91A8D0);
        setBackground(cor);
        iniciarComponentes();
        criarEventos();

    }

    private void iniciarComponentes() {

        MaskFormatter mascara = new MaskFormatter();
        MaskFormatter mascaraPeso = new MaskFormatter();
        MaskFormatter mascaraAltura = new MaskFormatter();
        try {
            mascara.setMask("(##)#####-####");
            mascaraPeso.setMask("##.## Kg");
            mascaraAltura.setMask("#.## m");
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }


        jlNome = new JLabel("Nome");
        jlNome.setFont(font);
        jlSexo = new JLabel("Sexo");
        jlSexo.setFont(font);
        rbMasculino = new JRadioButton("Masculino");
        rbMasculino.setOpaque(false);
        rbMasculino.setFont(font);
        rbFeminino = new JRadioButton("Feminino");
        rbFeminino.setFont(font);
        rbFeminino.setOpaque(false);
        bgGenero = new ButtonGroup();
        jlTelefone = new JLabel("Telefone");
        jlTelefone.setFont(font);
        jlPeso = new JLabel("Peso");
        jlPeso.setFont(font);
        jtfNome = new JTextField();
        jtfPeso = new JFormattedTextField();
        jftTelefone = new JFormattedTextField(mascara);
        jlAltura = new JLabel("Altura");
        jlAltura.setFont(font);
        jtfAltura = new JFormattedTextField();
        btCadastrar = new Button("Cadastrar");
        btCadastrar.setFont(font);


        add(jlNome);
        add(jtfNome);
        add(jlSexo);
        add(rbMasculino);
        add(rbFeminino);
        bgGenero.add(rbMasculino);
        bgGenero.add(rbFeminino);
        add(jlTelefone);
        add(jftTelefone);
        add(jlPeso);
        add(jtfPeso);
        add(jlAltura);
        add(jtfAltura);
        add(btCadastrar);


        jlNome.setBounds(60, 80, 100, 20);
        jtfNome.setBounds(60, 105, 150, 20);
        jlTelefone.setBounds(60, 140, 100, 20);
        jftTelefone.setBounds(60, 165, 150, 20);
        jlPeso.setBounds(60, 205, 100, 20);
        jtfPeso.setBounds(60, 225, 150, 20);
        jlAltura.setBounds(60, 265, 100, 20);
        jtfAltura.setBounds(60, 285, 150, 20);
        jlSexo.setBounds(380, 80, 100, 20);
        rbMasculino.setBounds(370, 110, 100, 20);
        rbFeminino.setBounds(370, 140, 100, 20);
        btCadastrar.setBounds(210,370,150,30);

    }

    private void criarEventos() {
        btCadastrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nome = jtfNome.getText();
                String telefone = jftTelefone.getText();
                String sexo = null;
                double peso = Double.parseDouble(jtfPeso.getText());
                double altura = Double.parseDouble(jtfAltura.getText());
                nome = jtfNome.getText();
                String tipoAtividade = "Caminhada Bosque";

                if (rbMasculino.isSelected()){
                    sexo = "Masculino";
                }else if (rbFeminino.isSelected()){
                    sexo = "Feminino";
                }


                    TelaSpa.pacientes.add(new Emagrecimento(nome,sexo,telefone,tipoAtividade,peso,altura));
                    TelaSpa.pacientes.forEach(emagrecimento-> System.out.println(emagrecimento.mostrarDados()));

                }
        });

    }
}
