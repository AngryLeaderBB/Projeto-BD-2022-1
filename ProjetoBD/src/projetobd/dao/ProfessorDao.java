package projetobd.dao;

import projetobd.connection.GeradorConexao;
import projetobd.dao.mappers.ProfessorMapper;
import projetobd.modelo.Professor;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProfessorDao {

    public void create(Professor p){
        Connection conn = GeradorConexao.getConnection();
        PreparedStatement stmt = null;

        try{
            stmt = conn.prepareStatement("INSERT INTO professor " +
                    "(Cref,Cpf,Especialidade,Rg,Data_nascimento,Nome," +
                    "Carga_horaria,Salario,Sexo,Telefone)" +
                    " VALUES(?,?,?,?,?,?,?,?,?,?)");

            stmt.setString(1,p.getCref());
            stmt.setString(2,p.getCpf());
            stmt.setString(3,p.getEspecialidade());
            stmt.setString(4,p.getRg());
            stmt.setDate(5,Date.valueOf(p.getDataNascimento()));
            stmt.setString(6,p.getNome());
            stmt.setInt(7,p.getCargaHoraria());
            stmt.setDouble(8,p.getSalario());
            stmt.setString(9,p.getSexo());
            stmt.setString(10,p.getTelefone());

            int rowsUpdated = stmt.executeUpdate();
            System.out.println("rowsUpdated = " + rowsUpdated);

        } catch (SQLException ex){
            throw new RuntimeException("Erro na inserção",ex);
        } finally {
            GeradorConexao.close(conn,stmt);
        }
    }

    public List<Professor> findAll(){
        Connection conn = GeradorConexao.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Professor> lista = new ArrayList<>();

        try{
            stmt = conn.prepareStatement("SELECT* FROM professor");
            rs = stmt.executeQuery();

            while(rs.next()){
                Professor p = new Professor();
                lista.add(ProfessorMapper.toProfessor(rs));
            }

            return lista;
        } catch (SQLException ex){
            throw new RuntimeException("Erro na leitura",ex);
        } finally {
            GeradorConexao.close(conn,stmt,rs);
        }
    }

    public Optional<Professor> findByCref(String cref){
        Connection conn = GeradorConexao.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try{
            stmt = conn.prepareStatement("SELECT* FROM professor WHERE Cref = ?");
            stmt.setString(1,cref);
            rs = stmt.executeQuery();
            return rs.next() ? Optional.of(ProfessorMapper.toProfessor(rs)) : Optional.empty();
        } catch (SQLException ex){
            throw new RuntimeException("Erro na leitura",ex);
        } finally {
            GeradorConexao.close(conn,stmt,rs);
        }
    }


    public void update(Professor p){
        Connection conn = GeradorConexao.getConnection();
        PreparedStatement stmt = null;

        try{
            stmt = conn.prepareStatement("UPDATE professor SET " +
                    "Cpf = ?, Especialidade = ?, Rg = ?, Data_nascimento = ?," +
                    "Nome = ?, Carga_horaria = ?, Salario = ?, Sexo = ?, Telefone = ?" +
                    "WHERE Cref = ?");

            stmt.setString(1,p.getCpf());
            stmt.setString(2,p.getEspecialidade());
            stmt.setString(3,p.getRg());
            stmt.setDate(4,Date.valueOf(p.getDataNascimento()));
            stmt.setString(5,p.getNome());
            stmt.setInt(6,p.getCargaHoraria());
            stmt.setDouble(7,p.getSalario());
            stmt.setString(8,p.getSexo());
            stmt.setString(9,p.getTelefone());
            stmt.setString(10,p.getCref());

            int rowsUpdated = stmt.executeUpdate();
            System.out.println("rowsUpdated = " + rowsUpdated);

        } catch (SQLException ex){
            throw new RuntimeException("Erro no update",ex);
        } finally {
            GeradorConexao.close(conn,stmt);
        }
    }

    public void delete(Professor p){
        Connection conn = GeradorConexao.getConnection();
        PreparedStatement stmt = null;

        try{
            stmt = conn.prepareStatement("DELETE FROM professor WHERE Cref = ?");
            stmt.setString(1,p.getCref());

            int rowsUpdated = stmt.executeUpdate();
            System.out.println("rowsUpdated = " + rowsUpdated);

        } catch (SQLException ex){
            throw new RuntimeException("Erro na remoção",ex);
        } finally {
            GeradorConexao.close(conn,stmt);
        }
    }
}
