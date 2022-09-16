package projetobd.dao.mappers;

import projetobd.modelo.Exercicio;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ExercicioMapper {
    public static Exercicio toExercicio(ResultSet rs) throws SQLException {
        Exercicio e = new Exercicio();

        e.setId(rs.getInt("Id"));
        e.setSeries(rs.getInt("Series"));
        e.setRepeticoes(rs.getInt("Repeticoes"));
        e.setNome(rs.getString("Nome"));
        e.setModeloEquipamentoNome(rs.getString("Modelo_equipamento_nome"));
        e.setTreinoData(rs.getDate("Treino_data").toLocalDate());
        e.setProfessorCref(rs.getString("Treino_Professor_cref"));
        e.setAlunoCpf(rs.getString("Treino_Aluno_cpf"));

        return e;
    }
}
