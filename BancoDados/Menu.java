import java.util.Scanner;

public class Menu {
    private Opcao op;
    static private BancoDeDados banco;

    public enum Opcao{
        INSERT,
        UPDATE,
        SELECT,
        FIM,
        INVALIDA
    }

    private void menuAcoes(){
        
        do {
            System.out.println("1. Insert");
            System.out.println("2. Update");
            System.out.println("3. Select");
            System.out.println("4. Fim");

            op = escolherOpcao();

            switch(op) {
                case Opcao.INSERT -> insert();
                case Opcao.UPDATE -> update();
                case Opcao.SELECT -> select();
                case Opcao.FIM -> System.out.println("Finalizando...");
                default -> System.out.println("Opção inválida.");
            } 
               
        } while (op != Opcao.FIM);
    }

    private String escolherBanco(){
        
        Scanner sc = new Scanner(System.in);

        System.out.println("\nEscolha seu banco de dados.\n");
        System.out.print("""
            1. PostgresSQL 
            2. MySQL
            """);

        String dataBase;

        do { 
            String bancoEscolhido = sc.next();
            
            if(bancoEscolhido.equals("1")) {
                return dataBase = "postgres";
            } else if (bancoEscolhido.equals("2")) {
                return dataBase = "mysql";
            }

        } while (true);
        
    }

    public void acessarMenu() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Seja bem vindo ao Menu.\n");

        if(banco == null){
            do { 
                String dataBase = escolherBanco();
                System.out.println("Informe o nome do Banco de Dados: ");
                String nomeBanco = sc.next();

                System.out.println("Informe o user: ");
                String user = sc.next();

                System.out.println("Informe a senha: ");
                String senha = sc.next();

                System.out.println("Informe a porta: ");
                String porta = sc.next();
                
                banco = new BancoDeDados(nomeBanco, user, senha, porta, dataBase);
            
            } while (banco == null);
        }

        

    }

    private Opcao escolherOpcao() {
        Scanner sc = new Scanner(System.in);
        Opcao op = Opcao.INVALIDA;
        
        do {
            String opcao = sc.next();
            
            switch (opcao) {
                case "1" -> {op = Opcao.INSERT;}
                case "2" -> {op = Opcao.UPDATE;}
                case "3" -> {op = Opcao.SELECT;}
                case "4" -> {op = Opcao.FIM;}
                default -> { op = Opcao.INVALIDA;}
            }

        } while (op == Opcao.INVALIDA);

        return op;
    }


    private void insert() {
        System.out.println("Inserindo...");
    }

    private void update() {
        System.out.println("update...");
    }

    public void select() {
        System.out.println("select...");
    }

    

    public static void main(String args[]) {
        Menu menu = new Menu();
        menu.acessarMenu();

        }

    }
