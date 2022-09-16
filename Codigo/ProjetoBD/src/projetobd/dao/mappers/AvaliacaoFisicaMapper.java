package projetobd.dao.mappers;

import projetobd.modelo.AvaliacaoFisica;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AvaliacaoFisicaMapper {
    public static AvaliacaoFisica toAvaliacaoFisica(ResultSet rs) throws SQLException {
        AvaliacaoFisica f = new AvaliacaoFisica();

        f.setData(rs.getDate("Data").toLocalDate());
        f.setBiceps(rs.getDouble("Biceps"));
        f.setPanturilha(rs.getDouble("Panturrilha"));
        f.setTorax(rs.getDouble("Torax"));
        f.setTriceps(rs.getDouble("Triceps"));
        f.setCintura(rs.getDouble("Cintura"));
        f.setPerna(rs.getDouble("Perna"));
        f.setImc(rs.getDouble("Imc"));
        f.setAltura(rs.getDouble("Altura"));
        f.setPeso(rs.getDouble("Peso"));
        f.setPesoMagro(rs.getDouble("Peso_magro"));
        f.setBodyFat(rs.getDouble("Body_fat"));
        f.setProfessorCref(rs.getString("Professor_cref"));
        f.setAlunoCpf(rs.getString("Aluno_cpf"));

        return f;
    }
}
