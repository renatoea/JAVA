package daoinit;

import java.util.Scanner;

public class DAOinit {

    public static void main(String[] args) {
        //  instancia o Scanner para captar dados passados por um usuário ou pela própria aplicação.
        Scanner console = new Scanner (System.in);
        
        ProdutoDao pdao = new ProdutoDaoImpl();
        pdao.listaCategorias();
        
        //  Obtem Valores de Entrada do usuário
              
        System.out.println("Escolha a categoria: ");
        String categoria = console.nextLine();
        pdao.listaProdutos(Integer.parseInt(categoria));
        
        System.out.println("Senha: ");
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
            
            dao.listaClientes();
            
             System.out.println("Deseja cadastrar um cliente? S para SIM ");
             
             String cadastrar = console.nextLine();
             System.out.println(cadastrar);
             
             if("s".equalsIgnoreCase(cadastrar)){
                 
                 System.out.println("Nome: ");
                 String nome = console.nextLine();
                 
                 System.out.println("Email: ");
                 String cliemail = console.nextLine();
                                  
                 System.out.println("Senha: ");
                 String clisenha = console.nextLine();
                 
                 System.out.println("CPF: ");
                 String cpf = console.nextLine();
                                  
                 Cliente cliente = new Cliente();
                 cliente.nome = nome;
                 cliente.email = cliemail;
                 cliente.senha = clisenha;
                 cliente.cpf = cpf;
                 
                 dao.cadastraClientes(cliente);
                 
             } else {
                 System.out.println("Nada feito... ");
             }
                          
        } else {
            System.out.println("Acesso Negado");
        }
    }
 
    
}