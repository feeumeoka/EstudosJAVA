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

    public void acessarMenu() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Seja bem vindo ao Menu.\n");

        if(banco == null){
            do { 
                banco = new BancoDeDados()
            } while (banco != null);
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
