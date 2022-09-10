package projetobd.dao.mappers;

import projetobd.modelo.Plano;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PlanoMapper {
    public static Plano toPlano(ResultSet rs) throws SQLException {
        Plano p = new Plano();

        p.setId(rs.getInt("Id"));
        p.setMultaRecisoria(rs.getDouble("Multa"));
        p.setDuracao(rs.getInt("Duracao"));
        p.setValor(rs.getDouble("Valor"));

        return p;
    }
}
