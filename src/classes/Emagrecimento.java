package classes;

import com.sun.source.tree.NewArrayTree;
import interfaces.Atividade;

import java.util.function.DoublePredicate;

public class Emagrecimento extends Paciente implements Atividade {
    CalculoPeso pesoIdeal = new CalculoPeso();
    private double peso;

    public Emagrecimento(String nome, String sexo, String telefone, String tipoAtividade,double peso,CalculoPeso pesoIdeal) {
        super(nome, sexo, telefone, tipoAtividade);
        this.peso = peso;
        this.pesoIdeal = pesoIdeal;
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
