package persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionDAO {
	
	//TODO Criar SQL para criação de banco
	public static void createDB() throws CadastroLeilaoDAOException {
        try {
            Connection con = DriverManager.getConnection("jdbc:derby:derbyDB;create=true");
            Statement sta = con.createStatement();
            String sql = "CREATE TABLE Leiloes ("
                    + "ID INTEGER NOT NULL PRIMARY KEY GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),"
                    + "PROXIMA_COL INT NOT NULL,"
                    + ")";
            sta.executeUpdate(sql);
            sta.close();
            con.close();
        } catch (SQLException ex) {
            throw new CadastroLeilaoDAOException(ex.getMessage());
        }
    }
    
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:derby:derbyDB");
    }

}
