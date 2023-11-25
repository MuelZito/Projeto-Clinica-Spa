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


    public Emagrecimento(String nome, String sexo, String telefone, String tipoAtividade, double peso, double altura, CalculoPeso calculoPeso) {
        super(nome, sexo, telefone, tipoAtividade);
        this.peso = peso;
        this.altura = altura;
        this.calculoPeso = calculoPeso;
        this.pesoIdeal = calculoPeso.pesoIdeal(sexo, altura);
    }

    @Override
    public String mostrarDados() {
      return null;
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
