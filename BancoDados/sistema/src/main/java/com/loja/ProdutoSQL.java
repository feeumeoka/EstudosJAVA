package com.loja;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProdutoSQL{
    final private Connection con;

    public ProdutoSQL(Connection con){
        this.con = con;
    }

    public int insert(Produto produto) throws SQLException {
        try{
            String consultaSQL = "INSERT INTO produto(nome, preco, qtde, data_vencimento) VALUES(?, ?, ?, ?);";
            PreparedStatement sql = con.prepareStatement(consultaSQL);
            
            sql.setString(1, produto.getNome());
            sql.setDouble(2, produto.getValor());
            sql.setInt(3, produto.getQtde());
            sql.setDate(4, produto.getData());

            System.out.println("Produto inserido com sucesso!");

            return sql.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
            return 0;
        }
        
    }

    public void select() throws SQLException {

        try {
            String consultaSQL = "SELECT * FROM produtos;";
        PreparedStatement sql = con.prepareStatement(consultaSQL);
        ResultSet resultado = sql.executeQuery();

        while(resultado.next()) {

            int id = resultado.getInt("id");
            String n = resultado.getString("nome");
            double p = resultado.getDouble("preco");
            int q = resultado.getInt("qtde");
            Date data = resultado.getDate("data_vencimento");

            String dataFormatada[] = data.toString().split("-");
            String dataBrasil = String.format("%s/%s/%s", dataFormatada[2],dataFormatada[1],dataFormatada[0]);

            System.out.println("Produto: " + n);
            System.out.println("ID: " + id);
            System.out.println("Preço: R$ " + String.format("%.2f", p));
            System.out.println("Quantidade: " + q);
            System.out.println("Data de vencimento: " + dataBrasil);
            System.out.println("-----------------------------------------------------");
        } 

    } catch(SQLException e) {
            System.out.println(e);
        }
    }
}
