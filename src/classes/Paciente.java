package classes;

public class Paciente {
    protected String nome;
    protected String sexo;
    protected String telefone;
    protected String tipoAtividade;

    public Paciente(String nome, String sexo, String telefone, String tipoAtividade) {
        this.nome = nome;
        this.sexo = sexo;
        this.telefone = telefone;
        this.tipoAtividade = tipoAtividade;
    }
    public String mostrarDados(){
        return null;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getTipoAtividade() {
        return tipoAtividade;
    }

    public void setTipoAtividade(String tipoAtividade) {
        this.tipoAtividade = tipoAtividade;
    }
}
