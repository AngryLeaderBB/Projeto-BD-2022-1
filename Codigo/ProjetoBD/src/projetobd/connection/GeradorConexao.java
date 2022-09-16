package projetobd.connection;

import java.sql.*;


public class GeradorConexao {
    private static final String URL = "jdbc:mysql://localhost:3306/academia";
    private static final String USER = "root";
    private static String senha = "";

    public static void setSenha(String s){
        senha = s;
    }
    
    public static boolean testConnection(String senha){
        Connection conn;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(URL,USER,senha);
            conn.close();
            setSenha(senha);
            return true;
        } catch (SQLException |ClassNotFoundException e) {
            
            return false;
        }
    
    }
    
    public static Connection getConnection(){
        Connection conn = null;

        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(URL,USER,senha);

        } catch (SQLException |ClassNotFoundException e) {
            throw new RuntimeException("Falha na conexao");
        }

        return conn;
    }

    public static void close(Connection conn){
        if(conn != null){
            try {
                conn.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void close(Connection conn, PreparedStatement stmt){
        close(conn);

        if(stmt != null){
            try {
                stmt.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

    }

    public static void close(Connection conn, PreparedStatement stmt,ResultSet set){
        close(conn,stmt);

        if(set != null){
            try {
                set.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

    }
    
}
