package projetobd.modelo;

import java.time.LocalDate;

public class AvaliacaoFisica {

    private LocalDate data;
    private double biceps;
    private double panturilha;
    private double torax;
    private double triceps;
    private double cintura;
    private double perna;
    private double imc;
    private double altura;
    private double peso;
    private double pesoMagro;
    private double bodyFat;
    private String professorCref;
    private String alunoCpf;

    public AvaliacaoFisica(){

    }

    public AvaliacaoFisica(LocalDate data, double biceps, double panturilha,
                           double torax, double triceps, double cintura,
                           double perna, double imc, double altura, double peso,
                           double pesoMagro, double bodyFat, String professorCref,
                           String alunoCpf) {
        this.data = data;
        this.biceps = biceps;
        this.panturilha = panturilha;
        this.torax = torax;
        this.triceps = triceps;
        this.cintura = cintura;
        this.perna = perna;
        this.imc = imc;
        this.altura = altura;
        this.peso = peso;
        this.pesoMagro = pesoMagro;
        this.bodyFat = bodyFat;
        this.professorCref = professorCref;
        this.alunoCpf = alunoCpf;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public double getBiceps() {
        return biceps;
    }

    public void setBiceps(double biceps) {
        this.biceps = biceps;
    }

    public double getPanturilha() {
        return panturilha;
    }

    public void setPanturilha(double panturilha) {
        this.panturilha = panturilha;
    }

    public double getTorax() {
        return torax;
    }

    public void setTorax(double torax) {
        this.torax = torax;
    }

    public double getTriceps() {
        return triceps;
    }

    public void setTriceps(double triceps) {
        this.triceps = triceps;
    }

    public double getCintura() {
        return cintura;
    }

    public void setCintura(double cintura) {
        this.cintura = cintura;
    }

    public double getPerna() {
        return perna;
    }

    public void setPerna(double perna) {
        this.perna = perna;
    }

    public double getImc() {
        return imc;
    }

    public void setImc(double imc) {
        this.imc = imc;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getPesoMagro() {
        return pesoMagro;
    }

    public void setPesoMagro(double pesoMagro) {
        this.pesoMagro = pesoMagro;
    }

    public double getBodyFat() {
        return bodyFat;
    }

    public void setBodyFat(double bodyFat) {
        this.bodyFat = bodyFat;
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
        return "AvaliacaoFisica{" +
                "data=" + data +
                ", biceps=" + biceps +
                ", panturilha=" + panturilha +
                ", torax=" + torax +
                ", triceps=" + triceps +
                ", cintura=" + cintura +
                ", perna=" + perna +
                ", imc=" + imc +
                ", altura=" + altura +
                ", peso=" + peso +
                ", pesoMagro=" + pesoMagro +
                ", bodyFat=" + bodyFat +
                ", professorCref='" + professorCref + '\'' +
                ", alunoCpf='" + alunoCpf + '\'' +
                '}';
    }
}
