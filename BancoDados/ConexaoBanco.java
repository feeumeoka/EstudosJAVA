import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoBanco {

    final private BancoDeDados banco;
    private Connection con;

    public ConexaoBanco(BancoDeDados banco){
        this.banco = banco;
    }

    public ConexaoBanco(){
        this.banco = new BancoDeDados();
    }

    public Connection getConnection() {
        return con;
    }

    private String ulr(){
        return "jdbc:" + banco.getDataBase() +
                "://localHost:" + banco.getPorta() +
                "/" + banco.getNomeBanco();
    }

    public void conexao(){

        try {
            con = DriverManager.getConnection(ulr(), banco.getUser(), banco.getSenha());
        } catch (SQLException erro) {
            System.out.println(erro.getMessage());
        }
    }

    
}
