package projetobd.dao;

import projetobd.connection.GeradorConexao;
import projetobd.dao.mappers.ContratoMapper;
import projetobd.modelo.Contrato;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ContratoDao {

    public void create(Contrato c){
        Connection conn = GeradorConexao.getConnection();
        PreparedStatement stmt = null;

        try{
            stmt = conn.prepareStatement("INSERT INTO contrato " +
                                        "(Numero,Data_inicio,Aluno_cpf,Gerente_cpf,Plano_id)" +
                                        "VALUES(?,?,?,?,?)");

            stmt.setInt(1,c.getNumero());
            stmt.setDate(2, Date.valueOf(c.getDataInicio()));
            stmt.setString(3,c.getAlunoCpf());
            stmt.setString(4,c.getGerenteCpf());
            stmt.setInt(5,c.getPlanoId());

            int rowsUpdated = stmt.executeUpdate();
            System.out.println("rowsUpdated = " + rowsUpdated);

        } catch (SQLException ex){
            throw new RuntimeException("Erro na inserção",ex);
        } finally {
            GeradorConexao.close(conn,stmt);
        }
    }

    public List<Contrato> findAll(){
        Connection conn = GeradorConexao.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Contrato> lista = new ArrayList<>();

        try{
            stmt = conn.prepareStatement("SELECT* FROM contrato");
            rs = stmt.executeQuery();

            while(rs.next()){
                lista.add(ContratoMapper.toContrato(rs));
            }
            return lista;
        } catch (SQLException ex){
            throw new RuntimeException("Erro na leitura",ex);
        } finally {
            GeradorConexao.close(conn,stmt,rs);
        }
    }

    public Optional<Contrato> findByNumero(int numero) {
        Connection conn = GeradorConexao.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            stmt = conn.prepareStatement("SELECT* FROM contrato WHERE Numero = ?");
            stmt.setInt(1, numero);
            rs = stmt.executeQuery();
            return rs.next() ? Optional.of(ContratoMapper.toContrato(rs)) : Optional.empty();
        } catch (SQLException ex) {
            throw new RuntimeException("Erro na leitura", ex);
        } finally {
            GeradorConexao.close(conn, stmt, rs);
        }
    }

    public void update(Contrato c){
        Connection conn = GeradorConexao.getConnection();
        PreparedStatement stmt = null;

        try{
            stmt = conn.prepareStatement("UPDATE contrato SET " +
                                "Data_inicio = ?,Aluno_cpf = ?,Gerente_cpf = ?,Plano_id = ? " +
                                "WHERE Numero = ?");


            stmt.setDate(1, Date.valueOf(c.getDataInicio()));
            stmt.setString(2,c.getAlunoCpf());
            stmt.setString(3,c.getGerenteCpf());
            stmt.setInt(4,c.getPlanoId());
            stmt.setInt(5,c.getNumero());

            int rowsUpdated = stmt.executeUpdate();
            System.out.println("rowsUpdated = " + rowsUpdated);

        } catch (SQLException ex){
            throw new RuntimeException("Erro no update",ex);
        } finally {
            GeradorConexao.close(conn,stmt);
        }
    }

    public void delete(Contrato c){
        Connection conn = GeradorConexao.getConnection();
        PreparedStatement stmt = null;

        try{
            stmt = conn.prepareStatement("DELETE FROM contrato WHERE Numero = ?");
            stmt.setInt(1,c.getNumero());

            int rowsUpdated = stmt.executeUpdate();
            System.out.println("rowsUpdated = " + rowsUpdated);

        } catch (SQLException ex){
            throw new RuntimeException("Erro na remoção",ex);
        } finally {
            GeradorConexao.close(conn,stmt);
        }
    }

}
