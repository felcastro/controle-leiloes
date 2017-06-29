package persistence;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;

public class DBCreator {
	
	//TODO Criar SQL para criação de banco
	public static void createDB() throws SQLException {
        try {
        	System.out.println("Iniciando criação do banco...");
        	long startTime = System.nanoTime();
        	String SCRIPT_BANCO = "../controle-leiloes/src/persistence/SqlScript";
        	BufferedReader in = new BufferedReader(new FileReader(SCRIPT_BANCO));
            String sql = "";
            String line;
            while((line = in.readLine()) != null)
            {
            	if (!line.isEmpty()) {
            		sql += line + "\n";
            	}
            }
            String[] sqlArray = sql.split(";");
            in.close();
            System.out.println("Script obtido com sucesso...");
            Connection con = DriverManager.getConnection("jdbc:derby:derbyDB;create=true");
            System.out.println("Conexão criada com sucesso...");
            Statement sta = con.createStatement();
            System.out.println("Statement criado com sucesso...");
            for (int i = 0; i < sqlArray.length; i++) {
            	System.out.println("Executando comando abaixo...");
            	System.out.println(sqlArray[i]);
            	sta.executeUpdate(sqlArray[i]);
            }
            long endTime = System.nanoTime();
            sta.close();
            con.close();
            System.out.println("Banco criado com sucesso em " + ((double) endTime - startTime)/1000000000  + " segundos.");
        } catch (Exception ex) {
        	System.out.println("Erro! Por favor delete a pasta \"derbyDB\" e tente novamente.");
            throw new SQLException(ex.getMessage());
        }
    }
    
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:derby:derbyDB");
    }

}
