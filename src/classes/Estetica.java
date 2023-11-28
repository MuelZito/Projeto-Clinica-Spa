package classes;

import java.util.HashSet;
import java.util.Set;

public class Estetica extends Paciente{
    Set<Servicos> servicos = new HashSet<>();
    public Estetica(String nome, String sexo, String telefone, String tipoAtividade) {
        super(nome, sexo, telefone, tipoAtividade);
    }

    @Override
    public String mostrarDados() {
        return null;
    }
}
