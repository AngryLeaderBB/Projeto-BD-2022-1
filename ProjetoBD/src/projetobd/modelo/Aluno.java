package projetobd.modelo;

import java.time.LocalDate;

public class Aluno {
    private String cpf;
    private String rg;
    private LocalDate dataNascimento;
    private String nome;
    private String sexo;
    private String telefone;
    private String status;

    public Aluno(){

    }

    public Aluno(String cpf, String rg, LocalDate dataNascimento,
                 String nome, String sexo, String telefone,
                 String status) {
        this.cpf = cpf;
        this.rg = rg;
        this.dataNascimento = dataNascimento;
        this.nome = nome;
        this.sexo = sexo;
        this.telefone = telefone;
        this.status = status;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


    @Override
    public String toString() {
        return "Aluno{" +
                "cpf='" + cpf + '\'' +
                ", rg='" + rg + '\'' +
                ", dataNascimento=" + dataNascimento +
                ", nome='" + nome + '\'' +
                ", sexo='" + sexo + '\'' +
                ", telefone='" + telefone + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
