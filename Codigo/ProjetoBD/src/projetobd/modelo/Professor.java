package projetobd.modelo;

import java.time.LocalDate;

public class Professor {
    private String cref;
    private String especialidade;
    private LocalDate dataNascimento;
    private String nome;
    private int cargaHoraria;
    private double salario;
    private String sexo;
    private String telefone;

    public Professor(){

    }

    public Professor(String cref, String especialidade,
                 LocalDate dataNascimento, String nome, int cargaHoraria,
                 double salario, String sexo, String telefone) {
        this.cref = cref;
        this.especialidade = especialidade;
        this.dataNascimento = dataNascimento;
        this.nome = nome;
        this.cargaHoraria = cargaHoraria;
        this.salario = salario;
        this.sexo = sexo;
        this.telefone = telefone;
    }

    public String getCref() {
        return cref;
    }

    public void setCref(String cref) {
        this.cref = cref;
    }


    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
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

    public int getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
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

    @Override
    public String toString() {
        return "Professor{" +
                "cref='" + cref + '\'' +
                ", especialidade='" + especialidade + '\'' +
                ", dataNascimento=" + dataNascimento +
                ", nome='" + nome + '\'' +
                ", cargaHoraria=" + cargaHoraria +
                ", salario=" + salario +
                ", sexo='" + sexo + '\'' +
                ", telefone='" + telefone + '\'' +
                '}';
    }
}
