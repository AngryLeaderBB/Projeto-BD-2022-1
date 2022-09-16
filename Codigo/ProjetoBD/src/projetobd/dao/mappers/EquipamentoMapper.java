package projetobd.dao.mappers;

import projetobd.modelo.Equipamento;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EquipamentoMapper {
    public static Equipamento toEquipamento(ResultSet rs) throws SQLException {
        Equipamento e = new Equipamento();

        e.setId(rs.getInt("Id"));
        e.setMarca(rs.getString("Marca"));
        e.setModeloEquipamentoNome(rs.getString("Modelo_equipamento_nome"));
        e.setFornecedorCnpj(rs.getString("Fornecedor_cnpj"));

        return e;
    }
}
