package business;

import java.util.List;

import persistence.CadastroLeilaoDAOException;

public interface CadastroLeilaoDAO {

	boolean adicionar(Leilao p) throws CadastroLeilaoDAOException;
	
	Leilao getPorId(int id) throws CadastroLeilaoDAOException;

	List<Leilao> getPorUsuario(Usuario u) throws CadastroLeilaoDAOException;
	
	List<Leilao> getLanceAberto() throws CadastroLeilaoDAOException;
	
	List<Leilao> getLanceFechado() throws CadastroLeilaoDAOException;
	
	List<Leilao> getPorDemanda() throws CadastroLeilaoDAOException;

	List<Leilao> getPorOferta() throws CadastroLeilaoDAOException;

	List<Leilao> getTodos() throws CadastroLeilaoDAOException;
}
