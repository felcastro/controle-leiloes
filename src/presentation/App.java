package presentation;

import java.io.File;

import business.*;
import persistence.CadastroLeilaoDAOJavaDb;
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
			try {
				System.out.println("Tentando buscar o primeiro valor da tabela Usuarios...");
				Usuario usuario = CadastroLeilaoDAOJavaDb.getUsuarioPorId();
				System.out.println(usuario.getNome() + " " + usuario.getCp() + " " + usuario.getEmail());
			} catch (Exception ex) {
				System.out.println(ex.getMessage());
			}
			
		}
	}

}
