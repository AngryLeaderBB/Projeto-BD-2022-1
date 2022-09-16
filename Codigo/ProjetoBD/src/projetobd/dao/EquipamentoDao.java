package projetobd.dao;

import projetobd.connection.GeradorConexao;
import projetobd.dao.mappers.EquipamentoMapper;
import projetobd.modelo.Equipamento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class EquipamentoDao {

    public void create(Equipamento e){
        Connection conn = GeradorConexao.getConnection();
        PreparedStatement stmt = null;

        try{
            stmt = conn.prepareStatement("INSERT INTO equipamento " +
                                        "(Id,Marca,Modelo_equipamento_nome,Fornecedor_cnpj)" +
                                        " VALUES(?,?,?,?)");

            stmt.setInt(1,e.getId());
            stmt.setString(2,e.getMarca());
            stmt.setString(3,e.getModeloEquipamentoNome());
            stmt.setString(4,e.getFornecedorCnpj());


            int rowsUpdated = stmt.executeUpdate();
            System.out.println("rowsUpdated = " + rowsUpdated);

        } catch (SQLException ex){
            throw new RuntimeException("Erro na inserção",ex);
        } finally {
            GeradorConexao.close(conn,stmt);
        }
    }

    public List<Equipamento> findAll(){
        Connection conn = GeradorConexao.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Equipamento> lista = new ArrayList<>();

        try{
            stmt = conn.prepareStatement("SELECT * FROM equipamento");
            rs = stmt.executeQuery();

            while(rs.next()){
                lista.add(EquipamentoMapper.toEquipamento(rs));
            }
            return lista;
        } catch (SQLException ex){
            throw new RuntimeException("Erro na leitura",ex);
        } finally {
            GeradorConexao.close(conn,stmt,rs);
        }
    }

    public Optional<Equipamento> findById(int id) {
        Connection conn = GeradorConexao.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            stmt = conn.prepareStatement("SELECT * FROM equipamento WHERE Id = ?");
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            return rs.next() ? Optional.of(EquipamentoMapper.toEquipamento(rs)) : Optional.empty();
        } catch (SQLException ex) {
            throw new RuntimeException("Erro na leitura", ex);
        } finally {
            GeradorConexao.close(conn, stmt, rs);
        }
    }

    public void update(Equipamento e){
        Connection conn = GeradorConexao.getConnection();
        PreparedStatement stmt = null;

        try{
            stmt = conn.prepareStatement("UPDATE equipamento SET " +
                                            "Marca = ?,Modelo_equipamento_nome = ?,Fornecedor_cnpj = ? " +
                                            "WHERE Id = ?");

            stmt.setString(1,e.getMarca());
            stmt.setString(2,e.getModeloEquipamentoNome());
            stmt.setString(3,e.getFornecedorCnpj());
            stmt.setInt(4,e.getId());

            int rowsUpdated = stmt.executeUpdate();
            System.out.println("rowsUpdated = " + rowsUpdated);

        } catch (SQLException ex){
            throw new RuntimeException("Erro no update",ex);
        } finally {
            GeradorConexao.close(conn,stmt);
        }
    }

    public void delete(Equipamento e){
        Connection conn = GeradorConexao.getConnection();
        PreparedStatement stmt = null;

        try{
            stmt = conn.prepareStatement("DELETE FROM equipamento WHERE Id = ?");
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
