package paineis;

import classes.Estetica;
import classes.Paciente;
import tela.TelaSpa;

import javax.swing.*;
import javax.swing.text.MaskFormatter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

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
        rbMasculino.setForeground(Color.WHITE); // Se aplicável, ajuste a cor do texto dos radio buttons

        rbFeminino = new JRadioButton("Feminino");
        rbFeminino.setFont(font);
        rbFeminino.setOpaque(false);
        rbFeminino.setForeground(Color.WHITE); // Se aplicável, ajuste a cor do texto dos radio buttons

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
        comboServicos.addItem("Limpeza de Pele");
        comboServicos.addItem("Cuidar do Cabelo");
        comboServicos.addItem("Massagem Esfoliante");
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
        image = new ImageIcon(getClass().getResource("/img/background2.png"));
        jlimage = new JLabel(image);
        add(jlimage);
        jlimage.setBounds(0,0,550,550);

    }

    private void criarEventos() {
        btCadastrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nome = jtfNome.getText();
                String sexo = null;
                String telefone = jftTelefone.getText();
                String servico =  (String) comboServicos.getSelectedItem();

                if (rbMasculino.isSelected()){
                    sexo = "Masculino";
                }else {
                    sexo = "Feminio";
                }

                TelaSpa.pacientes.add(new Estetica(nome,sexo,telefone,servico));
                //TelaSpa.pacientes.forEach(estetica -> System.out.println(estetica.mostrarDados()));
//
//                String nomeDigitado = JOptionPane.showInputDialog("DIGITE o nome para deletar");
//                Boolean achou = false;
//                for (Paciente paci:TelaSpa.pacientes) {
//                    if (paci.getNome().equals(nomeDigitado)){
//                        TelaSpa.pacientes.remove(paci);
//                        achou = true;
//                        JOptionPane.showMessageDialog(null,"REMOVIDO");
//                    }
//                }
//                if (!achou)JOptionPane.showMessageDialog(null,"NAO ACHOU");
     }
        });

    }
}
