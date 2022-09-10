package projetobd.dao;

import projetobd.connection.GeradorConexao;
import projetobd.dao.mappers.FornecedorMapper;
import projetobd.modelo.Fornecedor;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class FornecedorDao {
    public void create(Fornecedor f){
        Connection conn = GeradorConexao.getConnection();
        PreparedStatement stmt = null;

            try{
            stmt = conn.prepareStatement("INSERT INTO fornecedor " +
                    "(Cnpj,Nome_empresa,Telefone)" +
                    " VALUES(?,?,?)");

            stmt.setString(1,f.getCnpj());
            stmt.setString(2,f.getNomeEmpresa());
            stmt.setString(3,f.getTelefone());


            int rowsUpdated = stmt.executeUpdate();
            System.out.println("rowsUpdated = " + rowsUpdated);

        } catch (
        SQLException ex){
            throw new RuntimeException("Erro na inserção",ex);
        } finally {
            GeradorConexao.close(conn,stmt);
        }
    }

    public List<Fornecedor> findAll(){
        Connection conn = GeradorConexao.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Fornecedor> lista = new ArrayList<>();

        try{
            stmt = conn.prepareStatement("SELECT* FROM fornecedor");
            rs = stmt.executeQuery();

            while(rs.next()) {
                lista.add(FornecedorMapper.toFornecedor(rs));
            }
            return lista;
        } catch (SQLException ex){
            throw new RuntimeException("Erro na leitura",ex);
        } finally {
            GeradorConexao.close(conn,stmt,rs);
        }
    }

    public Optional<Fornecedor> findByCnpj(String cnpj){
        Connection conn = GeradorConexao.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try{
            stmt = conn.prepareStatement("SELECT* FROM fornecedor WHERE Cnpj = ?");
            stmt.setString(1,cnpj);
            rs = stmt.executeQuery();
            return rs.next() ? Optional.of(FornecedorMapper.toFornecedor(rs)) : Optional.empty();
        } catch (SQLException ex){
            throw new RuntimeException("Erro na leitura",ex);
        } finally {
            GeradorConexao.close(conn,stmt,rs);
        }
    }

    public void update(Fornecedor f){
        Connection conn = GeradorConexao.getConnection();
        PreparedStatement stmt = null;

        try{
            stmt = conn.prepareStatement("UPDATE fornecedor SET " +
                    "Nome_empresa = ?, Telefone = ?" +
                    "WHERE Cnpj = ?");


            stmt.setString(1,f.getNomeEmpresa());
            stmt.setString(2,f.getTelefone());
            stmt.setString(3,f.getCnpj());

            int rowsUpdated = stmt.executeUpdate();
            System.out.println("rowsUpdated = " + rowsUpdated);

        } catch (SQLException ex){
            throw new RuntimeException("Erro no update",ex);
        } finally {
            GeradorConexao.close(conn,stmt);
        }
    }

    public void delete(Fornecedor f){
        Connection conn = GeradorConexao.getConnection();
        PreparedStatement stmt = null;

        try{
            stmt = conn.prepareStatement("DELETE FROM fornecedor WHERE Cnpj = ?");
            stmt.setString(1,f.getCnpj());

            int rowsUpdated = stmt.executeUpdate();
            System.out.println("rowsUpdated = " + rowsUpdated);

        } catch (SQLException ex){
            throw new RuntimeException("Erro na remoção",ex);
        } finally {
            GeradorConexao.close(conn,stmt);
        }
    }
}
