package com.loja;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoBanco {

    private BancoDeDados banco;
    private Connection con;

    public ConexaoBanco(BancoDeDados banco){
        this.banco = banco;
    }

    public Connection getCon() {
        return con;
    }

    private String url(){
        return "jdbc:" + banco.getDataBase() +
                "://localhost:" + banco.getPorta() +
                "/" + banco.getNomeBanco();
    }

    
    public void conexao(){

        try {
            con = DriverManager.getConnection(url(), banco.getUser(), banco.getSenha());
            System.out.println("Conexão Feita com sucesso!");
        } catch (SQLException erro) {
            System.out.println(erro.getMessage());
        }
    }

    
}
