package presentation;

import java.util.ArrayList;
import java.util.List;

import javax.swing.ListModel;

import business.Usuario;
import business.UsuarioException;
import business.UsuarioFachada;

public class UsuarioControlador {
	
	private UsuarioFachada fachada;
    private ListaUsuariosModel modelSaidaTexto;

    public UsuarioControlador() throws UsuarioException {
        fachada = new UsuarioFachada();
        modelSaidaTexto = new ListaUsuariosModel(toListString(fachada.buscarTodos()));
    }

    public ListModel<String> getListaPessoasModel(){
        return modelSaidaTexto;
    }
    
    private List<String> toListString(List<Usuario> listaOrigem) {
        List<String> listaDestino = new ArrayList<String>(listaOrigem.size());
        for(Usuario u : listaOrigem) {
            listaDestino.add(u.toString());
        }
        return listaDestino;
    }
    
    public boolean adicionarUsuario(String nome, String cp, String email, String senha) throws UsuarioException {
    	Usuario u = fachada.adicionarUsuario(nome, cp, email, senha);
        if(u != null){
            modelSaidaTexto.add(u.toString());
            return true;
        }
        return false;
    }
    
    public Usuario getLogin(String email, String senha) throws UsuarioException {
        return fachada.buscarLogin(email, senha);
    }

    public List<String> getTodos() throws UsuarioException {
        return toListString(fachada.buscarTodos());
    }
}
