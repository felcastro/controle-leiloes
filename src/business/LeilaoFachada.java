package business;

import java.sql.Timestamp;
import java.util.List;

import persistence.LeilaoDAOException;
import persistence.LeilaoDAOJavaDb;

public class LeilaoFachada {

	private LeilaoDAO dao;
    
    public LeilaoFachada() throws LeilaoException {
        try {
            dao = LeilaoDAOJavaDb.getInstance();
        } catch (LeilaoDAOException e) {
            throw new LeilaoException("Falha de criação da fachada!", e);
        }
    }
    
    public boolean adicionarLeilao(String idUsuario, String natureza, String formaLances, 
			Timestamp inicio, Timestamp termino, double valor) throws LeilaoException{
    	try {
    		return dao.adicionarLeilao(idUsuario, natureza, formaLances, inicio, termino, valor);
    	} catch (LeilaoDAOException e) {
    		throw new LeilaoException("Falha ao adicionar leilao! " + e.getMessage(), e);
    	}
    }
	
    public boolean adicionarLance(String idUsuario, String idLote, double valor) throws LeilaoException{
    	try {
    		return dao.adicionarLance(idUsuario, idLote,  valor);
    	} catch (LeilaoDAOException e) {
    		throw new LeilaoException("Falha ao adicionar lance! " + e.getMessage(), e);
    	}
    }
    
    public List<Leilao> buscarTodos() throws LeilaoException{
        try {
            return dao.getTodos();
        } catch (LeilaoDAOException e) {
            throw new LeilaoException("Falha ao buscar leilao!", e);
        }
    }
}
