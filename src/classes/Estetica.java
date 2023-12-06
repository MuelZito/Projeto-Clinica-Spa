package classes;

public class Estetica extends Paciente{
    public Estetica(String nome, String sexo, String telefone, String tipoAtividade) {
        super(nome, sexo, telefone, tipoAtividade);
    }

    @Override
    public String mostrarDados() {
        return "Nome: " + this.nome + "\nSexo: " + this.sexo + "\nTelefone: " + this.telefone +
                "\nServico: " + this.tipoAtividade;
    }


}
