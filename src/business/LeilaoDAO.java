package business;

import java.sql.Timestamp;
import java.util.List;

import persistence.LeilaoDAOException;

public interface LeilaoDAO {
	List<Leilao> getTodos() throws LeilaoDAOException;
	boolean adicionarLance(String idUsuario, String idLote, double valor) throws LeilaoDAOException;
	boolean adicionarLeilao(String idUsuario, String natureza, String formaLances, 
			Timestamp inicio, Timestamp termino, double valor) throws LeilaoDAOException;
}
