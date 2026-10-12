import java.util.Scanner;

public class BancoDeDados {
    private String nomeBanco;
    private String user;
    private String senha;
    private String porta;
    private String dataBase;

    public BancoDeDados(String nomeBanco, String user, String senha, String porta, String dataBase) {
        this.nomeBanco = nomeBanco;
        this.user = user;
        this.senha = senha;
        this.porta = porta;
        this.dataBase = dataBase;
    }

    public String getNomeBanco() {
        return nomeBanco;
    }

    public String getUser() {
        return user;
    }

    public String getSenha() {
        return senha;
    }

    public String getPorta() {
        return porta;
    }

    public String getDataBase() {
        return dataBase;
    }

    public enum Banco {
        POSTGRESQL,
        MYSQL
    }

    private void escolherBanco(){
        
        Scanner sc = new Scanner(System.in);

        System.out.println("/nEscolha seu banco de dados./n");
        System.out.print (
            "1. PostgresSQL" +
            "2. MySQL"
        );

        do { 
            String bancoEscolhido = sc.next();
            
            if(bancoEscolhido.equals("1")) {
                dataBase = "postgres";
                break;
            } else if (bancoEscolhido.equals("2")) {
                dataBase = "mysql";
                break;
            } 
        } while (true);
        
    }

    
}
