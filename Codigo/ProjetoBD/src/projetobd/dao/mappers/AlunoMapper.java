package projetobd.dao.mappers;

import projetobd.modelo.Aluno;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AlunoMapper {

    public static Aluno toAluno(ResultSet rs) throws SQLException {
        Aluno  aluno  = new Aluno();
        aluno.setCpf(rs.getString("Cpf"));
        aluno.setDataNascimento(rs.getDate("Data_nascimento").toLocalDate());
        aluno.setNome(rs.getString("Nome"));
        aluno.setSexo(rs.getString("Sexo"));
        aluno.setTelefone(rs.getString("Telefone"));
        aluno.setStatus(rs.getString("Status"));
        return aluno;
    }
}
