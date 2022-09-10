package projetobd.modelo;

public class Equipamento {

    private int id;
    private String marca;
    private String modeloEquipamentoNome;
    private String fornecedorCnpj;

    public Equipamento(){
    }

    public Equipamento(int id, String marca, String modeloEquipamentoNome, String fornecedorCnpj) {
        this.id = id;
        this.marca = marca;
        this.modeloEquipamentoNome = modeloEquipamentoNome;
        this.fornecedorCnpj = fornecedorCnpj;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModeloEquipamentoNome() {
        return modeloEquipamentoNome;
    }

    public void setModeloEquipamentoNome(String modeloEquipamentoNome) {
        this.modeloEquipamentoNome = modeloEquipamentoNome;
    }

    public String getFornecedorCnpj() {
        return fornecedorCnpj;
    }

    public void setFornecedorCnpj(String fornecedorCnpj) {
        this.fornecedorCnpj = fornecedorCnpj;
    }

    @Override
    public String toString() {
        return "Equipamento{" +
                "id=" + id +
                ", marca='" + marca + '\'' +
                ", modeloEquipamentoNome='" + modeloEquipamentoNome + '\'' +
                ", fornecedorCnpj='" + fornecedorCnpj + '\'' +
                '}';
    }
}
