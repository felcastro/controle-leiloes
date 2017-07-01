package presentation;

import java.io.File;

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
			JanelaLogin login = new JanelaLogin();
			login.setVisible(true);
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		} finally {
			
		}
	}

}
