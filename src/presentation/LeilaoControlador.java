package presentation;

import java.sql.Timestamp;
import java.util.List;

import business.Leilao;
import business.LeilaoException;
import business.LeilaoFachada;
import business.UsuarioException;
import business.UsuarioFachada;

public class LeilaoControlador {
	
	private LeilaoFachada fachada;
	
	public LeilaoControlador() throws LeilaoException {
        fachada = new LeilaoFachada();
    }
	
	public boolean adicionarLance(String idUsuario, String idLote, double valor) throws LeilaoException {
		return fachada.adicionarLance(idUsuario, idLote, valor);
	}
	
	public List<Leilao> getTodos() throws LeilaoException {
		return fachada.buscarTodos();
	}

	public boolean adicionarLeilao(String idUsuario, String natureza, String formaLances, 
			Timestamp inicio, Timestamp termino, double valor) throws LeilaoException {
		return fachada.adicionarLeilao(idUsuario, natureza, formaLances, inicio, termino, valor);
	}
}
