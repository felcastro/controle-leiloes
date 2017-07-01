package business;

import java.util.List;

import persistence.UsuarioDAOException;
import persistence.UsuarioDAOJavaDb;

public class UsuarioFachada {

	private UsuarioDAO dao;
    
    public UsuarioFachada() throws UsuarioException {
        try {
            dao = UsuarioDAOJavaDb.getInstance();
        } catch (UsuarioDAOException e) {
            throw new UsuarioException("Falha de criação da fachada!", e);
        }
    }
    
    public Usuario adicionarUsuario(String nome, String cp, String email, String senha) throws UsuarioException{
        if(!ValidadorUsuario.validaNome(nome)) {
            throw new UsuarioException("Nome de pessoa inválido! -> " + nome);
        }
        if(!ValidadorUsuario.validaCP(cp)) {
            throw new UsuarioException("Numero de cadastro de pessoa inválido! -> " + cp);
        }
        if(!ValidadorUsuario.validaEmail(email)) {
            throw new UsuarioException("E-mail inválido! -> " + email);
        }
        Usuario u = new Usuario(nome, cp, email, senha);
        try {
            boolean ok = dao.adicionar(u);
            if(ok) {
                return u;
            }
            return null;
        } catch (UsuarioDAOException e) {
            throw new UsuarioException("Falha ao adicionar pessoa!", e);
        }
    }
    
    public Usuario buscarLogin(String email, String senha) throws UsuarioException{
    	try {
            return dao.getPorLogin(email, senha);
        } catch (UsuarioDAOException e) {
            throw new UsuarioException("Falha ao buscar pessoas!", e);
        }
    }

    public List<Usuario> buscarTodos() throws UsuarioException{
        try {
            return dao.getTodos();
        } catch (UsuarioDAOException e) {
            throw new UsuarioException("Falha ao buscar pessoas!", e);
        }
    }
	
}
