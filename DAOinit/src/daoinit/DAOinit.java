package daoinit;

import java.util.Scanner;

public class DAOinit {

    public static void main(String[] args) {
        //  instancia o Scanner para captar dados passados por um usuário ou pela própria aplicação.
        Scanner console = new Scanner (System.in);
        
        //  Obtem Valores de Entrada do usuário
        System.out.println("Email: ");
        String email = console.nextLine();
        System.out.println("Senha: ");
        String senha = console.nextLine();
        
        //  Instancia a Implementação de uma conexão DAO
        ClienteDao dao = new ClienteDaoImpl();
        boolean acesso = dao.validaLogin(email, senha);
        
        //  Validação do Booleano Retornado pelo Método validaLogin da classe ClienteDaoImpl.java
        if(acesso){
            System.out.println("Acesso Permitido");
        } else {
            System.out.println("Acesso Negado");
        }
        
    }
}
