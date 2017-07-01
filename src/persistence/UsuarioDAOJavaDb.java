package persistence;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import business.Usuario;
import business.UsuarioDAO;
import business.UsuarioException;

public class UsuarioDAOJavaDb implements UsuarioDAO {
	
	private static UsuarioDAOJavaDb ref;
	
	public static UsuarioDAOJavaDb getInstance() throws UsuarioDAOException {
        if (ref == null)
            ref = new UsuarioDAOJavaDb();
        return ref;
    }
    
    private UsuarioDAOJavaDb() throws UsuarioDAOException {
        try {
             Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
        } catch (ClassNotFoundException ex) {
            throw new UsuarioDAOException("JdbcOdbDriver not found!!");
        }
    }

	@Override
	public boolean adicionar(Usuario u) throws UsuarioDAOException {
		try {
            Connection con = DBCreator.getConnection();
            PreparedStatement stmt = con.prepareStatement(
                    "INSERT INTO Usuarios (NOME, CP, EMAIL, SENHA) VALUES (?,?,?,?)"
                    );
            stmt.setString(1, u.getNome());
            stmt.setString(2, u.getCp());
            stmt.setString(3, u.getEmail());
            stmt.setString(4, u.getSenha());
            int ret = stmt.executeUpdate();
            con.close();
            return (ret>0);
        } catch (SQLException ex) {
            throw new UsuarioDAOException("Falha ao adicionar.", ex);
        }
	}

	@Override
	public Usuario getPorLogin(String email, String senha) throws UsuarioDAOException {
		try {
            Connection con = DBCreator.getConnection();
            PreparedStatement stmt = con.prepareStatement(
                    "SELECT * FROM Usuarios WHERE EMAIL=? AND SENHA=?"
                    );
            stmt.setString(1, email);
            stmt.setString(2, senha);
            ResultSet resultado = stmt.executeQuery();
            Usuario u = null;
            if(resultado.next()) {
                String nome = resultado.getString("NOME");
                String cp = resultado.getString("CP");
                String emailResultado = resultado.getString("EMAIL");
                String senhaResultado = resultado.getString("SENHA");
                u = new Usuario(nome, cp, emailResultado, senhaResultado);
            }
            return u;
        } catch (SQLException ex) {
            throw new UsuarioDAOException("Falha ao buscar.", ex);
        }
	}

	@Override
	public List<Usuario> getTodos() throws UsuarioDAOException {
		try {
            Connection con = DBCreator.getConnection();
            Statement stmt = con.createStatement();
            ResultSet resultado = stmt.executeQuery("SELECT * FROM Usuarios");
            List<Usuario> lista = new ArrayList<Usuario>();
            while(resultado.next()) {
                String nome = resultado.getString("NOME");
                String cp = resultado.getString("CP");
                String email = resultado.getString("EMAIL");
                String senha = resultado.getString("SENHA");
                Usuario p = new Usuario(nome, cp, email, senha);
                lista.add(p);
            }
            return lista;
        } catch (SQLException ex) {
            throw new UsuarioDAOException("Falha ao buscar.", ex);
        }
	}

}
