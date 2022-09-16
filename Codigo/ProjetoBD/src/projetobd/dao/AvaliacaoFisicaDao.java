package projetobd.dao;

import projetobd.connection.GeradorConexao;
import projetobd.dao.mappers.AvaliacaoFisicaMapper;
import projetobd.dao.validators.AvaliacaoFisicaValidator;
import projetobd.modelo.AvaliacaoFisica;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AvaliacaoFisicaDao {

    public void create(AvaliacaoFisica a){
        Connection conn = GeradorConexao.getConnection();
        PreparedStatement stmt = null;

        try{
            AvaliacaoFisicaValidator.valida(a);
            stmt = conn.prepareStatement("INSERT INTO Avaliacao_fisica " +
                    "(Data,Biceps,Panturrilha,Torax,Triceps,Cintura," +
                    "Perna,Imc,Altura,Peso,Peso_magro,Body_fat,Professor_cref," +
                    "Aluno_cpf)" +
                    " VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?)");

            stmt.setDate(1, Date.valueOf(a.getData()));
            stmt.setDouble(2,a.getBiceps());
            stmt.setDouble(3,a.getPanturilha());
            stmt.setDouble(4,a.getTorax());
            stmt.setDouble(5,a.getTriceps());
            stmt.setDouble(6,a.getCintura());
            stmt.setDouble(7,a.getPerna());
            stmt.setDouble(8,a.getImc());
            stmt.setDouble(9,a.getAltura());
            stmt.setDouble(10,a.getPeso());
            stmt.setDouble(11,a.getPesoMagro());
            stmt.setDouble(12,a.getBodyFat());
            stmt.setString(13,a.getProfessorCref());
            stmt.setString(14,a.getAlunoCpf());

            int rowsUpdated = stmt.executeUpdate();
            System.out.println("rowsUpdated = " + rowsUpdated);

        } catch (SQLException ex){
            throw new RuntimeException("Erro na inserção",ex);
        } finally {
            GeradorConexao.close(conn,stmt);
        }
    }


    public List<AvaliacaoFisica> findAll(){
        Connection conn = GeradorConexao.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<AvaliacaoFisica> lista = new ArrayList<>();

        try{
            stmt = conn.prepareStatement("SELECT* FROM avaliacao_fisica");
            rs = stmt.executeQuery();

            while(rs.next()){
                lista.add(AvaliacaoFisicaMapper.toAvaliacaoFisica(rs));
            }
            return lista;
        } catch (SQLException ex){
            throw new RuntimeException("Erro na leitura",ex);
        } finally {
            GeradorConexao.close(conn,stmt,rs);
        }
    }

    public Optional<AvaliacaoFisica> findByDataAndCrefAndCpf(LocalDate data, String professorCref, String alunoCpf){
        Connection conn = GeradorConexao.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            stmt = conn.prepareStatement("SELECT* FROM avaliacao_fisica WHERE Data = ? AND Professor_cref = ? AND Aluno_cpf = ?");
            stmt.setDate(1,Date.valueOf(data));
            stmt.setString(2,professorCref);
            stmt.setString(3,alunoCpf);

            rs = stmt.executeQuery();
            return rs.next() ? Optional.of(AvaliacaoFisicaMapper.toAvaliacaoFisica(rs)) : Optional.empty();
        } catch (SQLException ex) {
            throw new RuntimeException("Erro na leitura", ex);
        } finally {
            GeradorConexao.close(conn, stmt, rs);
        }
    }

    public void update(AvaliacaoFisica a) {
        Connection conn = GeradorConexao.getConnection();
        PreparedStatement stmt = null;

        try {
            AvaliacaoFisicaValidator.valida(a);

            stmt = conn.prepareStatement("UPDATE avaliacao_fisica SET " +
                    "Biceps = ?,Panturrilha = ?,Torax = ?,Triceps = ?," +
                    "Cintura = ?,Perna = ?,Imc = ?,Altura = ?,Peso = ?,Peso_magro = ?," +
                    "Body_fat = ?" +
                    "WHERE Data = ? AND Professor_cref = ? AND Aluno_cpf = ?");


            stmt.setDouble(1, a.getBiceps());
            stmt.setDouble(2, a.getPanturilha());
            stmt.setDouble(3, a.getTorax());
            stmt.setDouble(4, a.getTriceps());
            stmt.setDouble(5, a.getCintura());
            stmt.setDouble(6, a.getPerna());
            stmt.setDouble(7, a.getImc());
            stmt.setDouble(8, a.getAltura());
            stmt.setDouble(9, a.getPeso());
            stmt.setDouble(10, a.getPesoMagro());
            stmt.setDouble(11, a.getBodyFat());
            stmt.setDate(12, Date.valueOf(a.getData()));
            stmt.setString(13, a.getProfessorCref());
            stmt.setString(14, a.getAlunoCpf());

            int rowsUpdated = stmt.executeUpdate();
            System.out.println("rowsUpdated = " + rowsUpdated);

        } catch (SQLException ex) {
            throw new RuntimeException("Erro no update", ex);
        } finally {
            GeradorConexao.close(conn, stmt);
        }
    }

    public void delete(AvaliacaoFisica a){
        Connection conn = GeradorConexao.getConnection();
        PreparedStatement stmt = null;

        try{
            stmt = conn.prepareStatement("DELETE FROM avaliacao_fisica WHERE " +
                                            "Data = ? AND Professor_cref = ? AND " +
                                            "Aluno_cpf = ?");

            stmt.setDate(1,Date.valueOf(a.getData()));
            stmt.setString(2,a.getProfessorCref());
            stmt.setString(3,a.getAlunoCpf());

            int rowsUpdated = stmt.executeUpdate();
            System.out.println("rowsUpdated = " + rowsUpdated);

        } catch (SQLException ex){
            throw new RuntimeException("Erro na remoção",ex);
        } finally {
            GeradorConexao.close(conn, stmt);
        }
    }
}



