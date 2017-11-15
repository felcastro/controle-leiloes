package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import business.Categoria;
import business.Item;
import business.Lance;
import business.Leilao;
import business.LeilaoDAO;
import business.Lote;
import business.Usuario;

public class LeilaoDAOJavaDb implements LeilaoDAO {

	private static LeilaoDAOJavaDb ref;

	public static LeilaoDAOJavaDb getInstance() throws LeilaoDAOException {
		if (ref == null)
			ref = new LeilaoDAOJavaDb();
		return ref;
	}

	private LeilaoDAOJavaDb() throws LeilaoDAOException {
		try {
			Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
		} catch (ClassNotFoundException ex) {
			throw new LeilaoDAOException("JdbcOdbDriver not found!!");
		}
	}

	public boolean adicionarLance(String idUsuario, String idLote, double valor) throws LeilaoDAOException {
		try {
			Connection con = DBCreator.getConnection();
			Timestamp dataAtual = new Timestamp(new Date().getTime());
			Statement stmt1 = con.createStatement();
			ResultSet resultadoLances = stmt1.executeQuery("SELECT * FROM Lances "
					+ "WHERE ID_USUARIO = " + idUsuario + " AND ID_LOTE = " + idLote);
			if (resultadoLances.next()) {
				throw new LeilaoDAOException("Usuario ja fez um lance!.");
			}
			Statement stmt2 = con.createStatement();
			ResultSet resultadoLeiloes = stmt2.executeQuery("SELECT * FROM Leiloes "
					+ "INNER JOIN Lotes ON Lotes.ID_LEILAO = Leiloes.ID "
					+ "WHERE Lotes.ID = ");
			if (!resultadoLances.next()) {
				throw new LeilaoDAOException("Nenhum lote com id " + idLote + " disponível!");
			}
			PreparedStatement stmt3 = con
					.prepareStatement("INSERT INTO Lances (ID_USUARIO, ID_LOTE, DATA, VALOR) "
							+ "VALUES (?,?,?,?,1)");
			stmt3.setString(1, idUsuario);
			stmt3.setString(2, idLote);
			stmt3.setTimestamp(3, dataAtual);
			stmt3.setDouble(4, valor);
			int ret = stmt3.executeUpdate();
			con.close();
			return (ret > 0);
		} catch (SQLException ex) {
			throw new LeilaoDAOException("Falha ao adicionar. " + ex.getMessage(), ex);
		}
	}
	
	public boolean adicionarLeilao(String idUsuario, String natureza, String formaLances, 
			Timestamp inicio, Timestamp termino, double valor) throws LeilaoDAOException {
		try {
			Connection con = DBCreator.getConnection();
			PreparedStatement stmt = con
					.prepareStatement("INSERT INTO Leiloes (ID_USUARIO, NATUREZA, FORMA_LANCES, INICIO, TERMINO, VALOR) "
							+ "VALUES (?,?,?,?,?,?)");
			stmt.setString(1, idUsuario);
			stmt.setString(2, natureza);
			stmt.setString(3, formaLances);
			stmt.setTimestamp(4, inicio);
			stmt.setTimestamp(5, termino);
			stmt.setDouble(6, valor);
			int ret = stmt.executeUpdate();
			con.close();
			return (ret > 0);
		} catch (SQLException ex) {
			throw new LeilaoDAOException("Falha ao adicionar. " + ex.getMessage(), ex);
		}
	}

	public List<Leilao> getTodos() throws LeilaoDAOException {
		try {
			Connection con = DBCreator.getConnection();
			Statement stmt = con.createStatement();

			List<Leilao> leiloes = new ArrayList<Leilao>();
			ResultSet resultadoLeiloes = stmt.executeQuery(
					"SELECT Leiloes.ID AS leilao_id, Leiloes.NATUREZA, Leiloes.FORMA_LANCES, Leiloes.INICIO, "
							+ "Leiloes.TERMINO, Leiloes.VALOR, Usuarios.NOME, Usuarios.ID AS usuario_id FROM Leiloes "
							+ "INNER JOIN Usuarios ON Usuarios.ID = Leiloes.ID_USUARIO");
			while (resultadoLeiloes.next()) {
				String idLeilao = resultadoLeiloes.getString("leilao_id");
				String natureza = resultadoLeiloes.getString("NATUREZA");
				String forma_lances = resultadoLeiloes.getString("FORMA_LANCES");
				Timestamp inicio = resultadoLeiloes.getTimestamp("INICIO");
				Timestamp termino = resultadoLeiloes.getTimestamp("TERMINO");
				double valor = resultadoLeiloes.getDouble("VALOR");
				String donoLeilao = resultadoLeiloes.getString("NOME");
				String idDonoLeilao = resultadoLeiloes.getString("usuario_id");

				List<Lote> lotes = new ArrayList<Lote>();
				Statement stmt2 = con.createStatement();
				ResultSet resultadoLotes = stmt2
						.executeQuery("SELECT * FROM Lotes WHERE Lotes.ID_LEILAO = " + idLeilao);
				while (resultadoLotes.next()) {
					String idLote = resultadoLotes.getString("ID");

					Statement stmt3 = con.createStatement();
					List<Item> itens = new ArrayList<Item>();
					ResultSet resultadoBens = stmt3.executeQuery(
							"SELECT Bens.DESCRICAO_SIMPLES, Bens.DESCRICAO_COMPLETA, Categorias.CATEGORIA FROM Bens "
									+ "INNER JOIN Categorias ON Categorias.ID = Bens.ID_CATEGORIA "
									+ "WHERE Bens.ID_LOTE = " + idLote);
					while (resultadoBens.next()) {
						String descricaoSimples = resultadoBens.getString("DESCRICAO_SIMPLES");
						String descricaoCompleta = resultadoBens.getString("DESCRICAO_COMPLETA");
						String categoria = resultadoBens.getString("CATEGORIA");
						Item item = new Item(descricaoSimples, descricaoCompleta, new Categoria(categoria));
						itens.add(item);
					}

					List<Lance> lances = new ArrayList<Lance>();
					if (forma_lances.equals("Aberto")) {
						ResultSet resultadoLances = stmt3.executeQuery(
								"SELECT Lances.DATA, Lances.VALOR, Lances.ATIVO, Usuarios.ID AS usuario_id, Usuarios.NOME FROM Lances "
										+ "INNER JOIN Usuarios ON Usuarios.ID = Lances.ID_USUARIO "
										+ "WHERE Lances.ID_LOTE = " + idLote + " AND Lances.ATIVO = true");
						while (resultadoLances.next()) {
							Timestamp dataLance = resultadoLances.getTimestamp("DATA");
							double valorLance = resultadoLances.getDouble("VALOR");
							String donoLance = resultadoLances.getString("NOME");
							boolean ativoLance = resultadoLances.getBoolean("ATIVO");
							String idDonolance = resultadoLances.getString("usuario_id");
							Lance lance = new Lance(valorLance, donoLance, idDonolance, dataLance);
							lances.add(lance);
						}
					}
					
					Lote lote = new Lote(itens, lances);
					lotes.add(lote);
				}

				Leilao leilao = new Leilao(idLeilao, donoLeilao, idDonoLeilao, natureza, forma_lances, inicio, termino,
						lotes, valor);

				leiloes.add(leilao);
			}

			return leiloes;
		} catch (SQLException ex) {
			throw new LeilaoDAOException("Falha ao buscar.", ex);
		}
	}

}
