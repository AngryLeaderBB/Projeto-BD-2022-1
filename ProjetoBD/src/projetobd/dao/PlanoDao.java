package projetobd.dao;

import projetobd.connection.GeradorConexao;
import projetobd.dao.mappers.PlanoMapper;
import projetobd.modelo.Plano;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PlanoDao {

    public void create(Plano p){
        Connection conn = GeradorConexao.getConnection();
        PreparedStatement stmt = null;

        try{
            stmt = conn.prepareStatement("INSERT INTO plano " +
                    "(Id,Multa,Duracao,Valor)" +
                    " VALUES(?,?,?,?)");

            stmt.setInt(1,p.getId());
            stmt.setDouble(2,p.getMultaRecisoria());
            stmt.setInt(3,p.getDuracao());
            stmt.setDouble(4,p.getValor());

            int rowsUpdated = stmt.executeUpdate();
            System.out.println("rowsUpdated = " + rowsUpdated);

        } catch (SQLException ex){
            throw new RuntimeException("Erro na inserção",ex);
        } finally {
            GeradorConexao.close(conn,stmt);
        }
    }

    public List<Plano> findAll(){
        Connection conn = GeradorConexao.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Plano> lista = new ArrayList<>();

        try{
            stmt = conn.prepareStatement("SELECT* FROM plano");
            rs = stmt.executeQuery();

            while(rs.next()){
                lista.add(PlanoMapper.toPlano(rs));
            }
            return lista;
        } catch (SQLException ex){
            throw new RuntimeException("Erro na leitura",ex);
        } finally {
            GeradorConexao.close(conn,stmt,rs);
        }
    }

    public Optional<Plano> findById(int id) {
        Connection conn = GeradorConexao.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            stmt = conn.prepareStatement("SELECT * FROM plano WHERE Id = ?");
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            return rs.next() ? Optional.of(PlanoMapper.toPlano(rs)) : Optional.empty();
        } catch (SQLException ex) {
            throw new RuntimeException("Erro na leitura", ex);
        } finally {
            GeradorConexao.close(conn, stmt, rs);
        }
    }

    public void update(Plano p){
        Connection conn = GeradorConexao.getConnection();
        PreparedStatement stmt = null;

        try{
            stmt = conn.prepareStatement("UPDATE plano SET " +
                    "Multa = ?,Duracao= ?,Valor =?" +
                    "WHERE Id = ?");

            stmt.setDouble(1,p.getMultaRecisoria());
            stmt.setInt(2,p.getDuracao());
            stmt.setDouble(3,p.getValor());
            stmt.setInt(4,p.getId());

            int rowsUpdated = stmt.executeUpdate();
            System.out.println("rowsUpdated = " + rowsUpdated);

        } catch (SQLException ex){
            throw new RuntimeException("Erro no update",ex);
        } finally {
            GeradorConexao.close(conn,stmt);
        }
    }

    public void delete(Plano p){
        Connection conn = GeradorConexao.getConnection();
        PreparedStatement stmt = null;

        try{
            stmt = conn.prepareStatement("DELETE FROM plano WHERE Id = ?");
            stmt.setInt(1,p.getId());

            int rowsUpdated = stmt.executeUpdate();
            System.out.println("rowsUpdated = " + rowsUpdated);

        } catch (SQLException ex){
            throw new RuntimeException("Erro na remoção",ex);
        } finally {
            GeradorConexao.close(conn,stmt);
        }
    }
}
