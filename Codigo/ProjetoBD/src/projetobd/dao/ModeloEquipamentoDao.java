package projetobd.dao;

import projetobd.connection.GeradorConexao;
import projetobd.dao.mappers.ModeloEquipamentoMapper;
import projetobd.modelo.ModeloEquipamento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ModeloEquipamentoDao {

    public void create(ModeloEquipamento m){
        Connection conn = GeradorConexao.getConnection();
        PreparedStatement stmt = null;

        try{
            stmt = conn.prepareStatement("INSERT INTO modelo_equipamento " +
                                            "(Nome)" +
                                            " VALUES(?)");

            stmt.setString(1,m.getNome());

            int rowsUpdated = stmt.executeUpdate();
            System.out.println("rowsUpdated = " + rowsUpdated);

        } catch (SQLException ex){
            throw new RuntimeException("Erro na inserção",ex);
        } finally {
            GeradorConexao.close(conn,stmt);
        }
    }

    public List<ModeloEquipamento> findAll(){
        Connection conn = GeradorConexao.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<ModeloEquipamento> lista = new ArrayList<>();

        try{
            stmt = conn.prepareStatement("SELECT* FROM modelo_equipamento");
            rs = stmt.executeQuery();

            while(rs.next()){
                lista.add(ModeloEquipamentoMapper.toModeloEquipamento(rs));
            }
            return lista;
        } catch (SQLException ex){
            throw new RuntimeException("Erro na leitura",ex);
        } finally {
            GeradorConexao.close(conn,stmt,rs);
        }
    }

    public Optional<ModeloEquipamento> findByNome(String nome) {
        Connection conn = GeradorConexao.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            stmt = conn.prepareStatement("SELECT* FROM modelo_equipamento WHERE Nome = ?");
            stmt.setString(1, nome);
            rs = stmt.executeQuery();
            return rs.next() ? Optional.of(ModeloEquipamentoMapper.toModeloEquipamento(rs)) : Optional.empty();
        } catch (SQLException ex) {
            throw new RuntimeException("Erro na leitura", ex);
        } finally {
            GeradorConexao.close(conn, stmt, rs);
        }
    }
    
    public void delete(ModeloEquipamento m){
        Connection conn = GeradorConexao.getConnection();
        PreparedStatement stmt = null;

        try{
            stmt = conn.prepareStatement("DELETE FROM modelo_equipamento WHERE Nome = ?");
            stmt.setString(1,m.getNome());

            int rowsUpdated = stmt.executeUpdate();
            System.out.println("rowsUpdated = " + rowsUpdated);

        } catch (SQLException ex){
            throw new RuntimeException("Erro na remoção",ex);
        } finally {
            GeradorConexao.close(conn,stmt);
        }
    }
}
