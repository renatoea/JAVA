package daoinit;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//  Classe de implementação da interface Criada no ClienteDAO.java
public class ClienteDaoImpl implements ClienteDao {

    private Connection conn;
    
    public ClienteDaoImpl (){
        this.conn = new Conexao().obtemConexao();
    }

    @Override
    public boolean validaLogin(String email, String senha) {
        
        //  Monta a Query a ser passada ao SQL
        String sql = " SELECT * FROM Cliente WHERE emailCliente = ? AND senhaCliente = ? ";

        try {
            //  Prepada o Statement da query a ser executada
            PreparedStatement stmt = conn.prepareStatement(sql);

            //  associação do Binding esperado pela consulta previamente declarada
            stmt.setString(1, email);
            stmt.setString(2, senha);

            //Executa o Statement preparado anteriormente e retorna um ResultSET
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()) {    //  Valida se em cada resultado obtido no ResultSET se consta mais de uma correspondência esperada da query
                String nome = rs.getString("nomeCompletoCliente");
                System.out.println(nome + " Autorizado");
                return true;    // Retorna verdadeiro no Booleano a quem chamou o Método validaLogin
            } else {
                System.out.println("Não encontrado");   //  Erro caso a informação foi inválida ou nao existe no banco.
            }

        } catch (SQLException ex) { //  Lança o Erro em caso de falha na execução da query ou na conexão
            System.out.println("Erro!");
        }

        return false;
    }

    @Override
    public void listaClientes() {
        //  Monta a Query a ser passada ao SQL
        String sql = " SELECT * FROM Cliente ORDER BY  nomeCompletoCliente";

        try {
            //  Prepada o Statement da query a ser executada
            PreparedStatement stmt = conn.prepareStatement(sql);

            //Executa o Statement preparado anteriormente e retorna um ResultSET
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()) {    //  Valida se em cada resultado obtido no ResultSET se consta mais de uma correspondência esperada da query
                String nome = rs.getString("nomeCompletoCliente");
                System.out.println(nome + "  ");
            } 

        } catch (SQLException ex) { //  Lança o Erro em caso de falha na execução da query ou na conexão
            System.out.println("Erro!");
        }

    }

    @Override
    public void cadastraClientes(Cliente cliente) {
        //  Monta a Query a ser passada ao SQL
        String sql = " INSERT INTO Kanino.dbo.Cliente (nomeCompletoCliente, emailCliente, senhaCliente, CPFCliente)" +
                            " VALUES (?, ?, ?, ?);" ;

        try {
            //  Prepara o Statement da query a ser executada
            PreparedStatement stmt = conn.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);
            //  Dados obtidos no Objeto para o cadastro de um novo cliente
            stmt.setString(1, cliente.nome);
            stmt.setString(2, cliente.email);
            stmt.setString(3, cliente.senha);
            stmt.setString(4, cliente.cpf);
            
            //Executa o Statement preparado anteriormente
            stmt.executeQuery();
            //  (tenta) Obtém o último ID cadastrado no banco
            ResultSet rs =stmt.getGeneratedKeys();
            
            if (rs.next()){
                int idregistered = rs.getInt(1);
                System.out.println( idregistered +" - "+ cliente.nome + " Inserido com sucesso!");
            }
            
        } catch (SQLException ex) { //  Lança o Erro em caso de falha na execução da query ou na conexão
            System.out.println("Erro! " + ex.getMessage());
        }
    }    
    
}