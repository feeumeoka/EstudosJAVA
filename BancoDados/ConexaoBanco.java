import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class ConexaoBanco {
    final private String nomeBanco;
    final private String user;
    final private String senha;
    final private String porta;
    private String dataBase;
    private BancoDeDados banco;

    public ConexaoBanco(String nomeBanco, String user, String porta, String senha) {
        this.nomeBanco = nomeBanco;
        this.user = user;
        this.porta = porta;
        this.senha = senha;
    }

    public enum BancoDeDados {
        POSTGRESQL,
        MYSQL,
        MONGODB,
        ORACLE,
        SQLITE,
        MICROSOFTSQLSERVER,
        INVALIDO
    }

    private void escolherBanco(){
        
        Scanner sc = new Scanner(System.in);

        System.out.println("/nEscolha seu banco de dados./n");
        System.out.print (
            "1. PostgresSQL" +
            "2. MySQL" +
            "3. MongoDB" +
            "4. Oracle" +
            "5. SQLite"
        );

        do { 

            String bancoEscolhido = sc.next();
            
            switch(bancoEscolhido) {
                case "1" -> {
                    banco = BancoDeDados.POSTGRESQL;
                    dataBase = "postgres";
                }
                case "2" -> {
                    banco = BancoDeDados.MYSQL;
                    dataBase = "mysql";
                }
                case "3" -> {
                    banco = BancoDeDados.MONGODB;
                    dataBase = "mongodb";
                }
                case "4" -> {
                    banco = BancoDeDados.ORACLE;
                    dataBase = "oracle";
                }
                case "5" -> {
                    banco = BancoDeDados.SQLITE;
                    dataBase = "sqlite";
                }
                default -> banco = BancoDeDados.INVALIDO;
            }

        } while (banco == BancoDeDados.INVALIDO);

        sc.close();
    }

    private String ulr(){
        return "jdbc:" + dataBase +
                "://localHost:" + porta +
                "/" + nomeBanco;
    }

    public Connection conexao() {

    try {
        return DriverManager.getConnection(ulr(), "postgres", "postgres");

    } catch (SQLException erro) {
        System.out.println(erro.getMessage());
        return null;
    }
}
}
