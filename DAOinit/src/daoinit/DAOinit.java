package daoinit;

import static java.lang.System.console;
import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DAOinit {

    public static void main(String[] args) {
        //  instancia o Scanner para captar dados passados por um usuário ou pela própria aplicação.
        Scanner console = new Scanner (System.in);
        
        //  Obtem Valores de Entrada
        System.out.println("Email: ");
        String email = console.nextLine();
        System.out.println("Senha: ");
        String senha = console.nextLine();
        
        //  Test application
        //  System.out.println(email + " " + senha);
        
        
    }
    
}
