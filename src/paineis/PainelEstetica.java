package paineis;

import classes.Estetica;
import tela.TelaSpa;

import javax.swing.*;
import javax.swing.text.MaskFormatter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import static tela.TelaSpa.pacientes;

public class PainelEstetica extends JPanel {
    private JLabel jlimage,jlNome, jlTelefone, jlSexo, jlServicos;
    private ImageIcon image;
    private JTextField jtfNome;
    private JFormattedTextField jftTelefone;
    private JRadioButton rbMasculino, rbFeminino;
    private ButtonGroup bgGenero;
    private Button btCadastrar;
    private JComboBox<String> comboServicos = new JComboBox<>();
    private Font font = font = new Font(Font.SANS_SERIF, Font.BOLD, 15);

    public PainelEstetica() {
        setSize(550, 550);
        setLayout(null);
        Color cor = new Color(0x6495ED);
        setBackground(cor);
        iniciarComponentes();
        criarEventos();
    }

    private void iniciarComponentes() {
        MaskFormatter mascara = new MaskFormatter();
        try {
            mascara.setMask("(##)#####-####");
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        jlNome = new JLabel("Nome");
        jlNome.setFont(font);
        jlNome.setForeground(Color.WHITE);

        jlSexo = new JLabel("Sexo");
        jlSexo.setFont(font);
        jlSexo.setForeground(Color.WHITE);

        rbMasculino = new JRadioButton("Masculino");
        rbMasculino.setOpaque(false);
        rbMasculino.setFont(font);
        rbMasculino.setForeground(Color.WHITE);

        rbFeminino = new JRadioButton("Feminino");
        rbFeminino.setFont(font);
        rbFeminino.setOpaque(false);
        rbFeminino.setForeground(Color.WHITE);

        bgGenero = new ButtonGroup();
        jtfNome = new JTextField();

        jlTelefone = new JLabel("Telefone");
        jlTelefone.setFont(font);
        jlTelefone.setForeground(Color.WHITE);

        jftTelefone = new JFormattedTextField(mascara);

        jlServicos = new JLabel("Serviços");
        jlServicos.setFont(font);
        jlServicos.setForeground(Color.WHITE);

        comboServicos = new JComboBox<>();
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
        add(jlServicos);
        add(comboServicos);
        comboServicos.addItem("Hidratação de pés e mãos");
        comboServicos.addItem("Banho de lua");
        comboServicos.addItem("Limpeza de pele");
        comboServicos.addItem("Cuidados para cabelo");
        comboServicos.addItem("Massagem esfoliante");
        comboServicos.addItem("Peeling");
        comboServicos.addItem("Drenagem linfática");
        add(btCadastrar);


        jlNome.setBounds(60, 80, 100, 20);
        jtfNome.setBounds(60, 105, 150, 20);
        jlTelefone.setBounds(60, 140, 100, 20);
        jftTelefone.setBounds(60, 165, 150, 20);
        jlServicos.setBounds(60, 200, 100, 20);
        comboServicos.setBounds(60, 220, 170, 20);
        jlSexo.setBounds(350, 80, 100, 20);
        rbMasculino.setBounds(350, 110, 100, 20);
        rbFeminino.setBounds(350, 140, 100, 20);
        btCadastrar.setBounds(210, 370, 150, 30);


        //Colocando img
        image = new ImageIcon(getClass().getResource("/img/estetica.png"));
        jlimage = new JLabel(image);
        add(jlimage);
        jlimage.setBounds(0,0,550,550);

    }

    private void criarEventos() {
        btCadastrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (jtfNome.getText().isEmpty() || jftTelefone.getText().isEmpty() || (!rbMasculino.isSelected() && !rbFeminino.isSelected())){
                    String nome = jtfNome.getText();
                    String sexo = null;
                    String telefone = jftTelefone.getText();
                    String servico =  (String) comboServicos.getSelectedItem();

                    if (rbMasculino.isSelected()){
                        sexo = "Masculino";
                    }else {
                        sexo = "Feminio";
                    }
                    pacientes.add(new Estetica(nome,sexo,telefone,servico));
                }else{
                    JOptionPane.showMessageDialog(null,"PREENCHA TODOS OS CAMPOS","ERRO",JOptionPane.WARNING_MESSAGE);
                }



     }
        });

    }
}
