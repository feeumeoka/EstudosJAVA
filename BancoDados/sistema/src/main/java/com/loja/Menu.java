package com.loja;
import java.util.Scanner;

public class Menu {
    private Opcao op;
    private boolean conexao;
    private ProdutoSQL operacao;

    public enum Opcao{
        INSERT,
        UPDATE,
        SELECT,
        FIM,
        INVALIDA
    }

    public void acessarMenu(Produto produto) throws Exception{
        Scanner sc = new Scanner(System.in);
        System.out.println("Seja bem vindo ao Menu.\n");
        ConexaoBanco con;
        String user;
        String senha;
        String porta;

        if(conexao == false){
            do { 
                String dataBase = escolherBanco();
                System.out.println("Informe o nome do Banco de Dados: ");
                String nomeBanco = sc.next();

                if(dataBase.equals("postgres")) {
                    user = "postgres";
                    senha = "postgres";
                    porta = "5432";
                    
                     
                } else {
                    user = "root";
                    senha = "";
                    porta = "3306";
                    
                }
                BancoDeDados banco = new BancoDeDados(nomeBanco, user, senha, porta, dataBase);
                
                con = new ConexaoBanco(banco);
                con.conexao();
                operacao = new ProdutoSQL(con.getCon());

            } while (con.getCon() == null);
        }
        do{
            menuAcoes(produto);    
        } while (op != Opcao.FIM);
        

        

    }

    private void menuAcoes(Produto produto) throws Exception{
        
        System.out.println("1. Insert");
        System.out.println("2. Update");
        System.out.println("3. Select");
        System.out.println("4. Fim");

        do {

            op = escolherOpcao();

            switch(op) {
                case INSERT: {
                    operacao.insert(produto);
                    break;
                }
                case UPDATE: {
                    System.out.println("Update...");
                    break;
                }
                case SELECT: {
                    System.out.println("Selecionando");
                    break;
                }
                case FIM: {
                    System.out.println("Finalizando...");
                    break;
                }
                default: System.out.println("Opção inválida.");
            } 
               
        } while (op != Opcao.FIM);
    }

    private String escolherBanco(){
        
        Scanner sc = new Scanner(System.in);

        System.out.println("\nEscolha seu banco de dados.\n");
        System.out.print("1. PostgresSQL." + "\n2. MySQL.\n");

        String dataBase;

        do { 
            String bancoEscolhido = sc.next();
            
            if(bancoEscolhido.equals("1")) {
                return dataBase = "postgresql";
            } else if (bancoEscolhido.equals("2")) {
                return dataBase = "mysql";
            }

        } while (true);
        
    }

    private Opcao escolherOpcao() {
        Scanner sc = new Scanner(System.in);
        Opcao op = Opcao.INVALIDA;
        
        do {
            String opcao = sc.next();
            
            switch (opcao) {
                case "1": {
                    op = Opcao.INSERT;
                    break;
                }
                case "2": {
                    op = Opcao.UPDATE;
                    break;
                }
                case "3": {
                    op = Opcao.SELECT;
                    break;
                }
                case "4": {
                    op = Opcao.FIM;
                    break;    
                }
                default: { 
                    op = Opcao.INVALIDA;
                    System.out.println("Opção inválida! Informe novalmente o número.");
                }
            }

        } while (op == Opcao.INVALIDA);

        return op;
    }
}
