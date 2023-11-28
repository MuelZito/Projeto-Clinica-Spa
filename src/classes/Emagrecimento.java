package classes;

import interfaces.Atividade;

import java.util.HashSet;
import java.util.Set;

public class Emagrecimento extends Paciente implements Atividade {
    private double peso;
    private double altura;
    private double pesoIdeal;
    private double porcentagemPesoIdeal;
    private CalculoPeso calculoPeso;
    private Set<Paciente> emagrecimento = new HashSet<>();


    public Emagrecimento(String nome, String sexo, String telefone, String tipoAtividade, double peso, double altura) {
        super(nome, sexo, telefone, tipoAtividade);
        this.peso = peso;
        this.altura = altura;
//        this.calculoPeso = calculoPeso;
//        this.pesoIdeal = calculoPeso.pesoIdeal(sexo, altura);
    }

    @Override
    public String mostrarDados() {

        return "Nome " + this.nome + "\nSexo " + this.sexo + "\nTelefone " + this.telefone +
                "\nAtividade " + this.TipoAtividade + "\nPeso " + this.peso + " Kg" + "\nAltura" + this.altura + " m" ;
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
