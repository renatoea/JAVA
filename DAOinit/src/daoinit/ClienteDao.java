package daoinit;

//  Cria a interface da Classe para o DAO
public interface ClienteDao {
    
    //  Método retornado do tipo boolean (no caso da Autenticação)
    public boolean validaLogin(String email , String senha);

    public void listaClientes();

    public void cadastraClientes(Cliente cliente);
    
    // MODIFICADO
    
}