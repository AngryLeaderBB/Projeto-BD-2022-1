package projetobd.dao;

import java.io.InputStream;
import projetobd.connection.GeradorConexao;
import projetobd.dao.mappers.AlunoMapper;
import projetobd.modelo.Aluno;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AlunoDao {

    public void create(Aluno a){
        Connection conn = GeradorConexao.getConnection();
        PreparedStatement stmt = null;

        try{
            stmt = conn.prepareStatement("INSERT INTO aluno " +
                    "(Cpf,Data_nascimento,Nome,Sexo,Telefone,Status)" +
                    " VALUES(?,?,?,?,?,?)");

            stmt.setString(1,a.getCpf());
            stmt.setDate(2,Date.valueOf(a.getDataNascimento()));
            stmt.setString(3,a.getNome());
            stmt.setString(4,a.getSexo());
            stmt.setString(5,a.getTelefone());
            stmt.setString(6,a.getStatus());

            int rowsUpdated = stmt.executeUpdate();
            System.out.println("rowsUpdated = " + rowsUpdated);

        } catch (SQLException ex){
            throw new RuntimeException("Erro na inserção",ex);
        } finally {
            GeradorConexao.close(conn,stmt);
        }
    }

    public List<Aluno> findAll(){
        Connection conn = GeradorConexao.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Aluno> lista = new ArrayList<>();

        try{
            stmt = conn.prepareStatement("SELECT* FROM aluno");
            rs = stmt.executeQuery();
            while(rs.next()){ lista.add(AlunoMapper.toAluno(rs)); }
            return lista;
        } catch (SQLException ex){
            throw new RuntimeException("Erro na leitura",ex);
        } finally {
            GeradorConexao.close(conn,stmt,rs);
        }
    }

    public Optional<Aluno> findByCpf(String cpf){
        Connection conn = GeradorConexao.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try{
            stmt = conn.prepareStatement("SELECT* FROM aluno WHERE Cpf = ?");
            stmt.setString(1,cpf);
            rs = stmt.executeQuery();
            return rs.next() ? Optional.of(AlunoMapper.toAluno(rs)) : Optional.empty();
        } catch (SQLException ex){
            throw new RuntimeException("Erro na leitura",ex);
        } finally {
            GeradorConexao.close(conn,stmt,rs);
        }
    }

    public void update(Aluno a){
        Connection conn = GeradorConexao.getConnection();
        PreparedStatement stmt = null;

        try{
            stmt = conn.prepareStatement("UPDATE aluno SET " +
                    "Data_nascimento = ?,Nome = ?," +
                    "Sexo = ?,Telefone = ?,Status = ? " +
                    "WHERE Cpf = ?");

            stmt.setDate(1,Date.valueOf(a.getDataNascimento()));
            stmt.setString(2,a.getNome());
            stmt.setString(3,a.getSexo());
            stmt.setString(4,a.getTelefone());
            stmt.setString(5,a.getStatus());
            stmt.setString(6,a.getCpf());

            int rowsUpdated = stmt.executeUpdate();
            System.out.println("rowsUpdated = " + rowsUpdated);

        } catch (SQLException ex){
            throw new RuntimeException("Erro no update",ex);
        } finally {
            GeradorConexao.close(conn,stmt);
        }
    }

    public void delete(Aluno a){
        Connection conn = GeradorConexao.getConnection();
        PreparedStatement stmt = null;

        try{
            stmt = conn.prepareStatement("DELETE FROM aluno WHERE Cpf = ?");
            stmt.setString(1,a.getCpf());

            int rowsUpdated = stmt.executeUpdate();
            System.out.println("rowsUpdated = " + rowsUpdated);

        } catch (SQLException ex){
            throw new RuntimeException("Erro na remoção",ex);
        } finally {
            GeradorConexao.close(conn,stmt);
        }
    }

    public InputStream getFoto(String entrada){
        Connection conn = GeradorConexao.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        InputStream input;
        
        try{
            stmt = conn.prepareStatement("SELECT foto FROM aluno WHERE Cpf = ?");
            stmt.setString(1,entrada);

            rs = stmt.executeQuery();
            
            rs.next();
            input = rs.getBinaryStream(1);
            return input;

            
        } catch (SQLException ex){
            throw new RuntimeException("Erro na leitura",ex);
        } finally {
            GeradorConexao.close(conn,stmt,rs);

        }
             
    }
    
}
