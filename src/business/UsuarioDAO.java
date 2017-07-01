package business;

import java.util.List;

import persistence.UsuarioDAOException;

public interface UsuarioDAO {
	boolean adicionar(Usuario u) throws UsuarioDAOException;
	Usuario getPorLogin(String email, String senha) throws UsuarioDAOException;
	List<Usuario> getTodos() throws UsuarioDAOException;
}