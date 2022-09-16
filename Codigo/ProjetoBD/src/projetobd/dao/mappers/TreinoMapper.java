package projetobd.dao.mappers;

import projetobd.modelo.Treino;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TreinoMapper {
    public static Treino toTreino(ResultSet rs) throws SQLException {
        Treino t = new Treino();

        t.setData(rs.getDate("Data").toLocalDate());
        t.setDuracao(rs.getInt("Duracao"));
        t.setProfessorCref(rs.getString("Professor_cref"));
        t.setAlunoCpf(rs.getString("Aluno_cpf"));

        return t;
    }
}
