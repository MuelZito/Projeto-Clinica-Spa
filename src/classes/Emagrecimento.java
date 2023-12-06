package classes;

import interfaces.Atividade;

import java.text.DecimalFormat;
import java.util.HashSet;
import java.util.Set;

public class Emagrecimento extends Paciente implements Atividade {
    private double peso;
    private double altura;
    private double pesoIdeal;
    private double porcentagemPesoIdeal;
    private String pesoIdealFormatado;
    private String porcentagemFormatada;
    private CalculoPeso calculoPeso;
    private Set<Paciente> emagrecimento = new HashSet<>();


    public Emagrecimento(String nome, String sexo, String telefone, String tipoAtividade, double peso, double altura, CalculoPeso calculoPeso) {
        super(nome, sexo, telefone, tipoAtividade);
        this.peso = peso;
        this.altura = altura;
        this.calculoPeso = calculoPeso;
        this.pesoIdeal = calculoPeso.pesoIdeal(this.sexo, this.altura);
        this.porcentagemPesoIdeal = calculoPeso.porcentagemDoPesoIdeal(this.pesoIdeal, this.peso);
        DecimalFormat formato = new DecimalFormat("##.##");
        pesoIdealFormatado = formato.format(pesoIdeal);
        porcentagemFormatada = formato.format(porcentagemPesoIdeal);

    }


    @Override
    public String mostrarDados() {
        return "Nome: " + this.nome + "\nSexo: " + this.sexo + "\nTelefone: " + this.telefone +
                "\nAtividade: " + this.tipoAtividade + "\nPeso: " + this.peso + " Kg" + "\nAltura: " + this.altura + " m"
                + "\nPeso ideal: " + this.pesoIdealFormatado + " Kg" + "\nPorcentagem Peso: " + this.porcentagemFormatada + "%";
    }

    @Override
    public String caminharBosque() {
        return null;
    }

    @Override
    public String nadarPiscina() {
        return null;
    }

    @Override
    public String exercitarAcademia() {
        return null;
    }
}
