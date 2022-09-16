package projetobd.modelo;


import java.time.LocalDate;

public class Gerente {
    private String cpf;
    private String nome;
    private double salario;
    private String sexo;
    private String telefone;
    private LocalDate dataNascimento;

    public Gerente(){
    }
    public Gerente(String cpf, String nome, double salario,
                   String sexo, String telefone, LocalDate dataNascimento) {
        this.cpf = cpf;
        this.nome = nome;
        this.salario = salario;
        this.sexo = sexo;
        this.telefone = telefone;
        this.dataNascimento = dataNascimento;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate data_nascimento) {
        this.dataNascimento = data_nascimento;
    }

    @Override
    public String toString() {
        return "Gerente{" +
                "cpf='" + cpf + '\'' +
                ", nome='" + nome + '\'' +
                ", salario=" + salario +
                ", sexo='" + sexo + '\'' +
                ", telefone='" + telefone + '\'' +
                ", data_nascimento=" + dataNascimento +
                '}';
    }
}
