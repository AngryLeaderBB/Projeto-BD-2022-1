package projetobd.modelo;

import java.time.LocalDate;

public class Contrato {
    private int numero;
    private LocalDate dataInicio;
    private String alunoCpf;
    private String gerenteCpf;
    private int planoId;

   public Contrato(){
   }

    public Contrato(int numero, LocalDate dataInicio, String alunoCpf, String gerenteCpf, int planoId) {
        this.numero = numero;
        this.dataInicio = dataInicio;
        this.alunoCpf = alunoCpf;
        this.gerenteCpf = gerenteCpf;
        this.planoId = planoId;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public LocalDate getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
    }

    public String getAlunoCpf() {
        return alunoCpf;
    }

    public void setAlunoCpf(String alunoCpf) {
        this.alunoCpf = alunoCpf;
    }

    public String getGerenteCpf() {
        return gerenteCpf;
    }

    public void setGerenteCpf(String gerenteCpf) {
        this.gerenteCpf = gerenteCpf;
    }

    public int getPlanoId() {
        return planoId;
    }

    public void setPlanoId(int planoId) {
        this.planoId = planoId;
    }

    @Override
    public String toString() {
        return "Contrato{" +
                "numero=" + numero +
                ", dataInicio=" + dataInicio +
                ", alunoCpf='" + alunoCpf + '\'' +
                ", gerenteCpf='" + gerenteCpf + '\'' +
                ", planoId=" + planoId +
                '}';
    }
}
