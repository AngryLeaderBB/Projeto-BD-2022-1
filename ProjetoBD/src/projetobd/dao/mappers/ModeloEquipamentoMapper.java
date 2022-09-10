package projetobd.dao.mappers;

import projetobd.modelo.ModeloEquipamento;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ModeloEquipamentoMapper {

    public static ModeloEquipamento toModeloEquipamento(ResultSet rs) throws SQLException {
        ModeloEquipamento m = new ModeloEquipamento();

        m.setNome(rs.getString("Nome"));

        return m;
    }
}
