package paineis;

import classes.CalculoPeso;
import classes.Emagrecimento;
import tela.TelaSpa;

import javax.swing.*;
import javax.swing.text.MaskFormatter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import static tela.TelaSpa.pacientes;

public class PainelEmagrecimento extends JPanel {
    private JLabel jlimage, jlNome, jlSexo, jlTelefone, jlPeso, jlAltura, jlAtividade;
    private ImageIcon image;
    private JTextField jtfNome;
    private JFormattedTextField jftTelefone, jtfPeso, jtfAltura;
    private JRadioButton rbMasculino, rbFeminino;
    private ButtonGroup bgGenero;
    private Button btCadastrar;
    private JComboBox<String> comboAtividade = new JComboBox<>();
    private Font font = new Font(Font.SANS_SERIF, Font.BOLD, 15);
    CalculoPeso calculoPeso = new CalculoPeso();

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

        jlTelefone = new JLabel("Telefone");
        jlTelefone.setFont(font);
        jlTelefone.setForeground(Color.WHITE);

        jlPeso = new JLabel("Peso");
        jlPeso.setFont(font);
        jlPeso.setForeground(Color.WHITE);

        jtfNome = new JTextField();

        jtfPeso = new JFormattedTextField();

        jftTelefone = new JFormattedTextField(mascara);

        jlAltura = new JLabel("Altura");
        jlAltura.setFont(font);
        jlAltura.setForeground(Color.WHITE);

        jtfAltura = new JFormattedTextField();

        jlAtividade = new JLabel("Atividades");
        jlAtividade.setFont(font);
        jlAtividade.setForeground(Color.WHITE);

        comboAtividade = new JComboBox<>();

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
        add(jlAtividade);
        add(comboAtividade);
        comboAtividade.addItem("Caminhada no Bosque");
        comboAtividade.addItem("Nadar na Piscina");
        comboAtividade.addItem("Academia");
        add(btCadastrar);


        jlNome.setBounds(60, 80, 100, 20);
        jtfNome.setBounds(60, 105, 150, 20);
        jlTelefone.setBounds(60, 140, 100, 20);
        jftTelefone.setBounds(60, 165, 150, 20);
        jlPeso.setBounds(60, 205, 100, 20);
        jtfPeso.setBounds(60, 225, 150, 20);
        jlAltura.setBounds(60, 265, 100, 20);
        jtfAltura.setBounds(60, 285, 150, 20);
        jlAtividade.setBounds(350, 180, 100, 20);
        comboAtividade.setBounds(350, 210, 170, 20);
        jlSexo.setBounds(350, 80, 100, 20);
        rbMasculino.setBounds(350, 110, 100, 20);
        rbFeminino.setBounds(350, 140, 100, 20);
        btCadastrar.setBounds(210, 370, 150, 30);

        //Colocando img
        image = new ImageIcon(getClass().getResource("/img/emagrecimento.png"));
        jlimage = new JLabel(image);
        add(jlimage);
        jlimage.setBounds(0, 0, 550, 550);

    }

    private void criarEventos() {
        btCadastrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (!(jtfAltura.getText().isEmpty() || jtfNome.getText().isEmpty() || jtfPeso.getText().isEmpty() || jftTelefone.getText().isEmpty() ||
                        !rbFeminino.isSelected() && !rbMasculino.isSelected())){
                    String nome = jtfNome.getText();
                    String telefone = jftTelefone.getText();
                    String sexo = null;
                    double peso = Double.parseDouble(jtfPeso.getText());
                    double altura = Double.parseDouble(jtfAltura.getText());
                    String tipoAtividade = (String) comboAtividade.getSelectedItem();

                    if (rbMasculino.isSelected()) {
                        sexo = "Masculino";
                    } else if (rbFeminino.isSelected()) {
                        sexo = "Feminino";
                    }
                    pacientes.add(new Emagrecimento(nome, sexo, telefone, tipoAtividade, peso, altura, calculoPeso));
                    JOptionPane.showMessageDialog(null,"CADASTRADO");
                    jtfNome.setText("");
                    jftTelefone.setText("");
                    jtfPeso.setText("");
                    jtfAltura.setText("");
                }else {
                    JOptionPane.showMessageDialog(null,"PREENCHA TODOS OS CAMPOS!","ERRO",JOptionPane.WARNING_MESSAGE);
                }

            }
        });

    }
}
