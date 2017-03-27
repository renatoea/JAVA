package daoinit;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProdutoDaoImpl implements ProdutoDao {
    
  private Connection conn;
    
    public ProdutoDaoImpl(){
        this.conn = new Conexao().obtemConexao();
    }
            
    
        @Override
    public void listaProdutos(int id) {
        //  Monta a Query a ser passada ao SQL
        String sql = " SELECT * FROM Kanino.dbo.Produto WHERE idCategoria = ?;";

        try {
              //  Prepada o Statement da query a ser executada
            PreparedStatement stmt = conn.prepareStatement(sql);

            //  associação do Binding esperado pela consulta previamente declarada
            stmt.setInt(1, id);

            //Executa o Statement preparado anteriormente e retorna um ResultSET
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()) {    //  Valida se em cada resultado obtido no ResultSET se consta mais de uma correspondência esperada da query
                String produtoexistente = rs.getString("nomeProduto");
                System.out.println(produtoexistente + "  ");
            } 

        } catch (SQLException ex) { //  Lança o Erro em caso de falha na execução da query ou na conexão
            System.out.println("Erro!" + ex.getMessage());
        }

    }

    
       @Override
    public void listaCategorias() {
        //  Monta a Query a ser passada ao SQL
        String sql = " SELECT * FROM Kanino.dbo.Categoria ORDER BY nomeCategoria ASC;";

        try {
            //  Prepada o Statement da query a ser executada
            PreparedStatement stmt = conn.prepareStatement(sql);

            //Executa o Statement preparado anteriormente e retorna um ResultSET
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()) {    //  Valida se em cada resultado obtido no ResultSET se consta mais de uma correspondência esperada da query
                String idcateg = rs.getString("idCategoria");
                String categ = rs.getString("nomeCategoria");
                System.out.println(idcateg  + "  " + categ);
            } 

        } catch (SQLException ex) { //  Lança o Erro em caso de falha na execução da query ou na conexão
            System.out.println("Erro!" + ex.getMessage());
        }

    }
    
    
}
