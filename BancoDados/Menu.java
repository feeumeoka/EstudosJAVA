import java.util.Scanner;

public class Menu {
private Opcao op;
private ConexaoBanco con;

public enum Opcao{
INSERT,
UPDATE,
SELECT,
FIM,
INVALIDA
}

public void acessarMenu() {
    
    do {
        System.out.println("Seja bem vindo ao Menu.\n");

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
        
    } while (op == Opcao.FIM);

}

public Opcao escolherOpcao() {
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

    sc.close();
    return op;
}


public void insert() {
System.out.println("Inserindo...");
}

public void update() {
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
