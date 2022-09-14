package projetobd.dao.mappers;

import projetobd.modelo.Aluno;
import projetobd.modelo.Professor;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProfessorMapper {
    public static Professor toProfessor(ResultSet rs) throws SQLException {
        Professor p = new Professor();

        p.setCref(rs.getString("Cref"));
        p.setEspecialidade(rs.getString("Especialidade"));
        p.setDataNascimento(rs.getDate("Data_nascimento").toLocalDate());
        p.setNome(rs.getString("Nome"));
        p.setCargaHoraria(rs.getInt("Carga_horaria"));
        p.setSalario(rs.getDouble("Salario"));
        p.setSexo(rs.getString("Sexo"));
        p.setTelefone(rs.getString("Telefone"));

        return p;
    }
}
