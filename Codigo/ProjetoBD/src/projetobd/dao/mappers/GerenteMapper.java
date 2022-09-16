package projetobd.dao.mappers;

import projetobd.modelo.Gerente;

import java.sql.ResultSet;
import java.sql.SQLException;

public class GerenteMapper {

    public static Gerente toGerente(ResultSet rs) throws SQLException {
        Gerente g = new Gerente();

        g.setCpf(rs.getString("Cpf"));
        g.setNome(rs.getString("Nome"));
        g.setSalario(rs.getDouble("Salario"));
        g.setSexo(rs.getString("Sexo"));
        g.setTelefone(rs.getString("Telefone"));
        g.setDataNascimento(rs.getDate("Data_nascimento").toLocalDate());

        return g;
    }

}
