package daoinit;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//  Classe de implementação da interface Criada no ClienteDAO.java
public class ClienteDaoImpl implements ClienteDao {

    private Connection conn;

    @Override
    public boolean validaLogin(String email, String senha) {
        //  Busca na classe o 
        conn = new Conexao().obtemConexao();

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
}