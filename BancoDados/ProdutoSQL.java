import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ProdutoSQL{
    final private Connection con;

    public ProdutoSQL(Connection con){
        this.con = con;
    }

    public int insert(Produto produto) throws SQLException {

        String consultaSQL = """
                    INSERT INTO produtos(nome, preco, qtde, data_vencimento)
                    VALUES(?, ?, ?, ?);
                    """;
        PreparedStatement sql = con.prepareStatement(consultaSQL);
        
        sql.setString(1, produto.getNome());
        sql.setDouble(2, produto.getValor());
        sql.setInt(3, produto.getQtde());
        sql.setDate(4, produto.getData());

        return sql.executeUpdate();
    }
    
}
