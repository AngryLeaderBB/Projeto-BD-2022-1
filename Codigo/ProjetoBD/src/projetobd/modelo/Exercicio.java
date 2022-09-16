package projetobd.modelo;

import java.time.LocalDate;

public class Exercicio {

    private int id;
    private int series;
    private int repeticoes;
    private String nome;
    private String modeloEquipamentoNome;
    private LocalDate treinoData;
    private String professorCref;
    private String alunoCpf;

    public Exercicio(){
    }

    public Exercicio(int id, int series, int repeticoes, String nome,
                     String modeloEquipamentoNome, LocalDate treinoData,
                     String professorCref, String alunoCpf) {
        this.id = id;
        this.series = series;
        this.repeticoes = repeticoes;
        this.nome = nome;
        this.modeloEquipamentoNome = modeloEquipamentoNome;
        this.treinoData = treinoData;
        this.professorCref = professorCref;
        this.alunoCpf = alunoCpf;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSeries() {
        return series;
    }

    public void setSeries(int series) {
        this.series = series;
    }

    public int getRepeticoes() {
        return repeticoes;
    }

    public void setRepeticoes(int repeticoes) {
        this.repeticoes = repeticoes;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getModeloEquipamentoNome() {
        return modeloEquipamentoNome;
    }

    public void setModeloEquipamentoNome(String modeloEquipamentoNome) {
        this.modeloEquipamentoNome = modeloEquipamentoNome;
    }

    public LocalDate getTreinoData() {
        return treinoData;
    }

    public void setTreinoData(LocalDate treinoData) {
        this.treinoData = treinoData;
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
        return "Exercicio{" +
                "id=" + id +
                ", series=" + series +
                ", repeticoes=" + repeticoes +
                ", nome='" + nome + '\'' +
                ", modeloEquipamentoNome='" + modeloEquipamentoNome + '\'' +
                ", treinoData=" + treinoData +
                ", professorCref='" + professorCref + '\'' +
                ", alunoCpf='" + alunoCpf + '\'' +
                '}';
    }
}
