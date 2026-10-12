package com.loja;
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

    

    
}
