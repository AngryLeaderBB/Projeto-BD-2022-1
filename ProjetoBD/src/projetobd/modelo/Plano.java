package projetobd.modelo;

public class Plano {
    private int id;
    private double multaRecisoria;
    private int duracao;
    private double valor;

    public Plano(){

    }

    public Plano(int id, double multaRecisoria, int duracao, double valor) {
        this.id = id;
        this.multaRecisoria = multaRecisoria;
        this.duracao = duracao;
        this.valor = valor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getMultaRecisoria() {
        return multaRecisoria;
    }

    public void setMultaRecisoria(double multa_recisoria) {
        this.multaRecisoria = multa_recisoria;
    }

    public int getDuracao() {
        return duracao;
    }

    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "Plano{" +
                "id=" + id +
                ", multa_recisoria=" + multaRecisoria +
                ", duracao=" + duracao +
                ", valor=" + valor +
                '}';
    }
}
