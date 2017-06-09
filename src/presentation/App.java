package presentation;

import business.*;

public class App {

	public static void main(String[] args) {
		Usuario u1 = new Usuario("John Doe", "02463942002", "john@doe.com");
		Lance lance = new Lance(1000, u1);
		
		System.out.println(lance.getData());
	}

}
