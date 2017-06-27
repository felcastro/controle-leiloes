package presentation;

import java.io.File;

import business.*;
import persistence.DBCreator;

public class App {

	public static void main(String[] args) {
		try {
			String DIRETORIO_BANCO = "../controle-leiloes/derbyDB";
			File db = new File(DIRETORIO_BANCO);
			if (!db.exists()) {
				DBCreator.createDB();
			} else {
				System.out.println("Utilizando banco ja existente...");
			}
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		} finally {
			
		}
	}

}
