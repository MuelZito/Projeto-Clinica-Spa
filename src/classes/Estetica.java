package classes;

public class Estetica extends Paciente{
    public Estetica(String nome, String sexo, String telefone, String tipoAtividade) {
        super(nome, sexo, telefone, tipoAtividade);
    }

    @Override
    public String mostrarDados() {
        return null;
    }
}
