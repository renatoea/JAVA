package daoinit;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexao {
    //  Parâmetros necessários para a conexão no Banco SQL
    String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    String url = "jdbc:sqlserver://prof-ramon.database.windows.net:1433;database=Kanino;";
    String user = "TSI";
    String pass = "SistemasInternet123";

    public Connection obtemConexao() {
        
        // Cria a variável do Tipo Connection
        Connection conn = null;
        
        try {
           /// Carrega o Driver
            Class.forName(driver);
            //  Obtém a conexão usando os parametros exigidos pelo método getConnection
            conn = DriverManager.getConnection(url, user, pass);
        
        } catch (Exception ex) {    //  Lança a exceção no caso de Erro
            System.out.println("Falha! " + ex.getMessage());                    
        }
        
        return conn;    //  retorna a conexão a quem chamou o obtemConexao
    }
    
}