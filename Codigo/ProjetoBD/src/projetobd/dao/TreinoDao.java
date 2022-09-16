package projetobd.dao;

import projetobd.connection.GeradorConexao;
import projetobd.dao.mappers.TreinoMapper;
import projetobd.modelo.Treino;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TreinoDao {

    public void create(Treino t){
        Connection conn = GeradorConexao.getConnection();
        PreparedStatement stmt = null;

        try{
            stmt = conn.prepareStatement("INSERT INTO treino " +
                    "(Data,Duracao,Professor_cref,Aluno_cpf)" +
                    " VALUES(?,?,?,?)");

            stmt.setDate(1, Date.valueOf(t.getData()));
            stmt.setInt(2,t.getDuracao());
            stmt.setString(3,t.getProfessorCref());
            stmt.setString(4,t.getAlunoCpf());

            int rowsUpdated = stmt.executeUpdate();
            System.out.println("rowsUpdated = " + rowsUpdated);

        } catch (SQLException ex){
            throw new RuntimeException("Erro na inserção",ex);
        } finally {
            GeradorConexao.close(conn,stmt);
        }
    }

    public List<Treino> findAll(){
        Connection conn = GeradorConexao.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Treino> lista = new ArrayList<>();

        try{
            stmt = conn.prepareStatement("SELECT* FROM treino");
            rs = stmt.executeQuery();

            while(rs.next()){
                lista.add(TreinoMapper.toTreino(rs));
            }
            return lista;
        } catch (SQLException ex){
            throw new RuntimeException("Erro na leitura",ex);
        } finally {
            GeradorConexao.close(conn,stmt,rs);
        }
    }

    public Optional<Treino> findByDataAndCrefAndCpf(LocalDate data,String professorCref,String alunoCpf) {
        Connection conn = GeradorConexao.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            stmt = conn.prepareStatement("SELECT* FROM treino WHERE Data = ? AND Professor_cref = ? AND Aluno_cpf= ?");
            stmt.setDate(1, Date.valueOf(data));
            stmt.setString(2,professorCref);
            stmt.setString(3,alunoCpf);
            rs = stmt.executeQuery();
            return rs.next() ? Optional.of(TreinoMapper.toTreino(rs)) : Optional.empty();
        } catch (SQLException ex) {
            throw new RuntimeException("Erro na leitura", ex);
        } finally {
            GeradorConexao.close(conn, stmt, rs);
        }
    }

    public void update(Treino t){
        Connection conn = GeradorConexao.getConnection();
        PreparedStatement stmt = null;

        try{
            stmt = conn.prepareStatement("UPDATE treino SET " +
                                            "Duracao = ? " +
                                            "WHERE Data = ? AND Professor_cref = ? AND Aluno_cpf = ?");


            stmt.setInt(1,t.getDuracao());
            stmt.setDate(2, Date.valueOf(t.getData()));
            stmt.setString(3,t.getProfessorCref());
            stmt.setString(4,t.getAlunoCpf());

            int rowsUpdated = stmt.executeUpdate();
            System.out.println("rowsUpdated = " + rowsUpdated);

        } catch (SQLException ex){
            throw new RuntimeException("Erro no update",ex);
        } finally {
            GeradorConexao.close(conn,stmt);
        }
    }

    public void delete(Treino t){
        Connection conn = GeradorConexao.getConnection();
        PreparedStatement stmt = null;

        try{
            stmt = conn.prepareStatement("DELETE FROM treino WHERE Data = ? AND " +
                                            "Professor_cref = ? AND Aluno_cpf = ?");
            stmt.setDate(1, Date.valueOf(t.getData()));
            stmt.setString(2,t.getProfessorCref());
            stmt.setString(3,t.getAlunoCpf());

            int rowsUpdated = stmt.executeUpdate();
            System.out.println("rowsUpdated = " + rowsUpdated);

        } catch (SQLException ex){
            throw new RuntimeException("Erro na remoção",ex);
        } finally {
            GeradorConexao.close(conn,stmt);
        }
    }

}
