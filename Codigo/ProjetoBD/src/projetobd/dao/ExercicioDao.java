package projetobd.dao;

import projetobd.connection.GeradorConexao;
import projetobd.dao.mappers.ExercicioMapper;
import projetobd.modelo.Exercicio;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ExercicioDao {
    public void create(Exercicio e){
        Connection conn = GeradorConexao.getConnection();
        PreparedStatement stmt = null;

        try{
            stmt = conn.prepareStatement("INSERT INTO exercicio " +
                    "(Id,Series,Repeticoes,Nome,Modelo_equipamento_nome," +
                    "Treino_data,Treino_Professor_cref,Treino_Aluno_cpf)" +
                    " VALUES(?,?,?,?,?,?,?,?)");

            stmt.setInt(1,e.getId());
            stmt.setInt(2,e.getSeries());
            stmt.setInt(3,e.getRepeticoes());
            stmt.setString(4,e.getNome());
            stmt.setString(5,e.getModeloEquipamentoNome());
            stmt.setDate(6,Date.valueOf(e.getTreinoData()));
            stmt.setString(7,e.getProfessorCref());
            stmt.setString(8,e.getAlunoCpf());


            int rowsUpdated = stmt.executeUpdate();
            System.out.println("rowsUpdated = " + rowsUpdated);

        } catch (SQLException ex){
            throw new RuntimeException("Erro na inserção",ex);
        } finally {
            GeradorConexao.close(conn,stmt);
        }
    }

    public List<Exercicio> findAll(){
        Connection conn = GeradorConexao.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Exercicio> lista = new ArrayList<>();

        try{
            stmt = conn.prepareStatement("SELECT* FROM exercicio");
            rs = stmt.executeQuery();

            while(rs.next()){
                lista.add(ExercicioMapper.toExercicio(rs));
            }
            return lista;
        } catch (SQLException ex){
            throw new RuntimeException("Erro na leitura",ex);
        } finally {
            GeradorConexao.close(conn,stmt,rs);
        }
    }

    public Optional<Exercicio> findById(int id) {
        Connection conn = GeradorConexao.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            stmt = conn.prepareStatement("SELECT * FROM exercicio WHERE Id = ?");
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            return rs.next() ? Optional.of(ExercicioMapper.toExercicio(rs)) : Optional.empty();
        } catch (SQLException ex) {
            throw new RuntimeException("Erro na leitura", ex);
        } finally {
            GeradorConexao.close(conn, stmt, rs);
        }
    }

    public void update(Exercicio e){
        Connection conn = GeradorConexao.getConnection();
        PreparedStatement stmt = null;

        try{
            stmt = conn.prepareStatement("UPDATE exercicio SET " +
                                        "Series=?,Repeticoes=?,Nome=?,Modelo_equipamento_nome=?," +
                                        "Treino_data=?,Treino_Professor_cref=?,Treino_Aluno_cpf=? " +
                                        "WHERE Id = ?");

            stmt.setInt(1,e.getSeries());
            stmt.setInt(2,e.getRepeticoes());
            stmt.setString(3,e.getNome());
            stmt.setString(4,e.getModeloEquipamentoNome());
            stmt.setDate(5,Date.valueOf(e.getTreinoData()));
            stmt.setString(6,e.getProfessorCref());
            stmt.setString(7,e.getAlunoCpf());
            stmt.setInt(8,e.getId());

            int rowsUpdated = stmt.executeUpdate();
            System.out.println("rowsUpdated = " + rowsUpdated);

        } catch (SQLException ex){
            throw new RuntimeException("Erro no update",ex);
        } finally {
            GeradorConexao.close(conn,stmt);
        }
    }

    public void delete(Exercicio e){
        Connection conn = GeradorConexao.getConnection();
        PreparedStatement stmt = null;

        try{
            stmt = conn.prepareStatement("DELETE FROM exercicio WHERE Id = ?");
            stmt.setInt(1,e.getId());

            int rowsUpdated = stmt.executeUpdate();
            System.out.println("rowsUpdated = " + rowsUpdated);

        } catch (SQLException ex){
            throw new RuntimeException("Erro na remoção",ex);
        } finally {
            GeradorConexao.close(conn,stmt);
        }
    }
}
