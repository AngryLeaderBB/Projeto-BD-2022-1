package projetobd.modelo;


public class Fornecedor {
    private String cnpj;
    private String nomeEmpresa;
    private String telefone;

    public Fornecedor(){

    }

    public Fornecedor(String cnpj, String nomeEmpresa, String telefone) {
        this.cnpj = cnpj;
        this.nomeEmpresa = nomeEmpresa;
        this.telefone = telefone;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getNomeEmpresa() {
        return nomeEmpresa;
    }

    public void setNomeEmpresa(String nomeEmpresa) {
        this.nomeEmpresa = nomeEmpresa;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    @Override
    public String toString() {
        return "Fornecedor{" +
                "cnpj='" + cnpj + '\'' +
                ", nomeEmpresa='" + nomeEmpresa + '\'' +
                ", telefone='" + telefone + '\'' +
                '}';
    }
}
