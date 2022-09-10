package projetobd.dao;

import projetobd.connection.GeradorConexao;
import projetobd.dao.mappers.GerenteMapper;
import projetobd.modelo.Gerente;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class GerenteDao{

    public void create(Gerente g){
        Connection conn = GeradorConexao.getConnection();
        PreparedStatement stmt = null;

        try{
            stmt = conn.prepareStatement("INSERT INTO gerente " +
                                            "(Cpf,Nome,Salario,Sexo,Telefone,Data_nascimento)" +
                                            " VALUES(?,?,?,?,?,?)");

            stmt.setString(1,g.getCpf());
            stmt.setString(2,g.getNome());
            stmt.setDouble(3,g.getSalario());
            stmt.setString(4,g.getSexo());
            stmt.setString(5,g.getTelefone());
            stmt.setDate(6, Date.valueOf(g.getDataNascimento()));

            int rowsUpdated = stmt.executeUpdate();
            System.out.println("rowsUpdated = " + rowsUpdated);

        } catch (SQLException ex){
            throw new RuntimeException("Erro na inserção",ex);
        } finally {
            GeradorConexao.close(conn,stmt);
        }
    }

    public List<Gerente> findAll(){
        Connection conn = GeradorConexao.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Gerente> lista = new ArrayList<>();

        try{
            stmt = conn.prepareStatement("SELECT* FROM gerente");
            rs = stmt.executeQuery();

            while(rs.next()){
                lista.add(GerenteMapper.toGerente(rs));
            }
        } catch (SQLException ex){
            throw new RuntimeException("Erro na leitura",ex);
        } finally {
            GeradorConexao.close(conn,stmt,rs);
        }

        return lista;

    }

    public Optional<Gerente> findByCpf(String cpf){
        Connection conn = GeradorConexao.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try{
            stmt = conn.prepareStatement("SELECT* FROM gerente WHERE Cpf = ?");
            stmt.setString(1,cpf);
            rs = stmt.executeQuery();
            return rs.next() ? Optional.of(GerenteMapper.toGerente(rs)) : Optional.empty();
        } catch (SQLException ex){
            throw new RuntimeException("Erro na leitura",ex);
        } finally {
            GeradorConexao.close(conn,stmt,rs);
        }
    }

    public void update(Gerente g){
        Connection conn = GeradorConexao.getConnection();
        PreparedStatement stmt = null;

        try{
            stmt = conn.prepareStatement("UPDATE gerente SET " +
                                            "Nome = ?, Salario = ?, Sexo = ?, " +
                                            "Telefone = ?, Data_nascimento = ? " +
                                            "WHERE Cpf = ?");

            stmt.setString(1,g.getNome());
            stmt.setDouble(2,g.getSalario());
            stmt.setString(3,g.getSexo());
            stmt.setString(4,g.getTelefone());
            stmt.setDate(5,Date.valueOf(g.getDataNascimento()));
            stmt.setString(6,g.getCpf());

            int rowsUpdated = stmt.executeUpdate();
            System.out.println("rowsUpdated = " + rowsUpdated);

        } catch (SQLException ex){
            throw new RuntimeException("Erro no update",ex);
        } finally {
            GeradorConexao.close(conn,stmt);
        }
    }

    public void delete(Gerente g){
        Connection conn = GeradorConexao.getConnection();
        PreparedStatement stmt = null;

        try{
            stmt = conn.prepareStatement("DELETE FROM gerente WHERE Cpf = ?");
            stmt.setString(1,g.getCpf());

            int rowsUpdated = stmt.executeUpdate();
            System.out.println("rowsUpdated = " + rowsUpdated);

        } catch (SQLException ex){
            throw new RuntimeException("Erro na remoção",ex);
        } finally {
            GeradorConexao.close(conn,stmt);
        }
    }
}
