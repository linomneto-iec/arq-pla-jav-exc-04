package dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
    private String driver = "com.mysql.cj.jdbc.Driver";
    private String URL = "jdbc:mysql://puc-1336366.southcentralus.cloudapp.azure.com:3306/crud?useTimezone=true&serverTimezone=UTC";
    private String USER = "root";
    private String SENHA = "root";
    private Connection conn;

    public Conexao(){
        try{
            Class.forName(driver);
            conn = (Connection) DriverManager.getConnection(URL, USER, SENHA);
            System.out.println("Conectado.");
        }catch(Exception e){
            System.out.println("Classe não encontrada, adicione o driver nas bibliotecas.");
            e.printStackTrace();
        }
    }

    public Connection getConn(){
        return conn;
    }

    public void fecharConexao() {
        try{
            conn.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
}
