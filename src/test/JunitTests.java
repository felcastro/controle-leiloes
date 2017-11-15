package test;
import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import business.UsuarioException;
import presentation.UsuarioControlador;

public class JunitTests {
	static UsuarioControlador uc;
	
	@BeforeClass
	public static void setUp() throws UsuarioException{
		uc = new UsuarioControlador();
	}
	
	@Test
	public void adicionarUsuarioTest() throws UsuarioException{
		assertTrue(uc.adicionarUsuario("Teste", "11111111111", "teste@gmail.com", "12345"));
	}
	
	@Test
	public void getTodosTest() throws UsuarioException{
		assertNotNull(uc.getTodos());
	}
	
	@Test
	public void getLoginTest() throws UsuarioException{
		assertNotNull(uc.getLogin("teste@gmail.com", "12345"));
	}
	
	@Test
	public void getListaPessoasModelTest() throws UsuarioException{
		assertNotNull(uc.getListaPessoasModel());
	}
}
