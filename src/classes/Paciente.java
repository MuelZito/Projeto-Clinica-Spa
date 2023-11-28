package classes;

public class Paciente {
    protected String nome;
    protected String sexo;
    protected String telefone;
    protected String TipoAtividade;

    public Paciente(String nome, String sexo, String telefone, String tipoAtividade) {
        this.nome = nome;
        this.sexo = sexo;
        this.telefone = telefone;
        TipoAtividade = tipoAtividade;
    }
    public String mostrarDados(){
        return null;
    }
}
