package projetobd.dao.mappers;

import projetobd.modelo.Fornecedor;

import java.sql.ResultSet;
import java.sql.SQLException;

public class FornecedorMapper {
    public static Fornecedor toFornecedor(ResultSet rs) throws SQLException {
        Fornecedor f = new Fornecedor();

        f.setCnpj(rs.getString("Cnpj"));
        f.setNomeEmpresa(rs.getString("Nome_empresa"));
        f.setTelefone(rs.getString("Telefone"));

        return f;
    }
}
