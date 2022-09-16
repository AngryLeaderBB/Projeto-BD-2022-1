package projetobd.modelo;

public class ModeloEquipamento {
    private String Nome;

    public ModeloEquipamento(){

    }

    public ModeloEquipamento(String nome) {
        Nome = nome;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    @Override
    public String toString() {
        return "ModeloEquipamento{" +
                "Nome='" + Nome + '\'' +
                '}';
    }
}
