package projetobd.modelo;

import java.time.LocalDate;

public class Treino {
    private LocalDate data;
    private int duracao;
    private String professorCref;
    private String alunoCpf;

    public Treino(){
    }

    public Treino(LocalDate data, int duracao, String professorCref, String alunoCpf) {
        this.data = data;
        this.duracao = duracao;
        this.professorCref = professorCref;
        this.alunoCpf = alunoCpf;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public int getDuracao() {
        return duracao;
    }

    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }

    public String getProfessorCref() {
        return professorCref;
    }

    public void setProfessorCref(String professorCref) {
        this.professorCref = professorCref;
    }

    public String getAlunoCpf() {
        return alunoCpf;
    }

    public void setAlunoCpf(String alunoCpf) {
        this.alunoCpf = alunoCpf;
    }

    @Override
    public String toString() {
        return "Treino{" +
                "data=" + data +
                ", duracao=" + duracao +
                ", professorCref='" + professorCref + '\'' +
                ", alunoCpf='" + alunoCpf + '\'' +
                '}';
    }
}
