package projetobd.dao.mappers;

import projetobd.modelo.Contrato;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ContratoMapper {
    public static Contrato toContrato(ResultSet rs) throws SQLException {
        Contrato c = new Contrato();

        c.setNumero(rs.getInt("Numero"));
        c.setDataInicio(rs.getDate("Data_inicio").toLocalDate());
        c.setAlunoCpf(rs.getString("Aluno_cpf"));
        c.setGerenteCpf(rs.getString("Gerente_cpf"));
        c.setPlanoId(rs.getInt("Plano_id"));

        return c;
    }
}
