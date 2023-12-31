package classes;

import paineis.PainelEstetica;

import java.text.DecimalFormat;

public class CalculoPeso {


    public double pesoIdeal(String sexo, double altura) {
        double pesoIdeal;
        if (sexo.equalsIgnoreCase("Masculino")) {
            pesoIdeal = (72.7 * altura - 58);
            return pesoIdeal;
        } else {
            pesoIdeal = (62.1 * altura - 44.7);
            return pesoIdeal;

        }

    }

    public double porcentagemDoPesoIdeal(double pesoIdeal, double peso) {
        double porcentagem;
        porcentagem = (1 - pesoIdeal / peso) * 100;
        return porcentagem;
    }
}
