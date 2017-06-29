package persistence;

import java.util.List;

import business.Leilao;
import business.Usuario;
import business.CadastroLeilaoDAO;
import java.sql.*;
import java.util.ArrayList;

public class CadastroLeilaoDAOJavaDb implements CadastroLeilaoDAO{
    private static CadastroLeilaoDAOJavaDb ref;
    
    public static CadastroLeilaoDAOJavaDb getInstance() throws CadastroLeilaoDAOException {
        if (ref == null)
            ref = new CadastroLeilaoDAOJavaDb();
        return ref;
    }
    
    private CadastroLeilaoDAOJavaDb() throws CadastroLeilaoDAOException {
        try {
             Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
        } catch (ClassNotFoundException ex) {
            throw new CadastroLeilaoDAOException("JdbcOdbDriver not found!!");
        }
        // Cria o banco de dados vazio
        // Retirar do comentário se necessário
        /*
        try {
            createDB();
        } catch (Exception ex) {
            System.out.println("Problemas para criar o banco: "+ex.getMessage());
            System.exit(0);
        }
        */
    }
    
    // METODO PARA SE BASEAR
//    @Override
//    public boolean adicionar(Leilao l) throws CadastroLeilaoDAOException {
//        try {
//            Connection con = ConnectionDAO.getConnection();
//            PreparedStatement stmt = con.prepareStatement(
//                    "INSERT INTO PESSOAS (NOME, TELEFONE, SEXO) VALUES (?,?,?)" //                             1        2         3            4          5             6
//                    );
//            stmt.setString(1, l.getNome());
//            stmt.setString(2, l.getTelefone());
//            stmt.setString(3, Character.toString(l.getSexo()));
//            int ret = stmt.executeUpdate();
//            con.close();
//            return (ret>0);
//        } catch (SQLException ex) {
//            throw new CadastroLeilaoDAOException("Falha ao adicionar.", ex);
//        }
//    }

    //METODO PARA SE BASEAR
//    @Override
//    public Leilao getLeilaoPorNome(String n) throws CadastroLeilaoDAOException {
//        try {
//            Connection con = ConnectionDAO.getConnection();
//            PreparedStatement stmt = con.prepareStatement(
//                    "SELECT * FROM LEILOES WHERE NOME=?"
//                    );
//            stmt.setString(1, n);
//            ResultSet resultado = stmt.executeQuery();
//            Leilao p = null;
//            if(resultado.next()) {
//                String nome = resultado.getString("NOME");
//                String telefone = resultado.getString("TELEFONE");
//                String sexo = resultado.getString("SEXO");
//                p = new Leilao(?);
//            }
//            return p;
//        } catch (SQLException ex) {
//            throw new CadastroLeilaoDAOException("Falha ao buscar.", ex);
//        }
//    }
    
    //METODO PARA SE BASEAR
//    @Override
//    public List<Leilao> getHomens() throws CadastroLeilaoDAOException {
//        try {
//            Connection con = ConnectionDAO.getConnection();
//            Statement stmt = con.createStatement();
//            ResultSet resultado = stmt.executeQuery("SELECT * FROM PESSOAS WHERE SEXO='M'");
//            List<Leilao> lista = new ArrayList<Leilao>();
//            while(resultado.next()) {
//                String nome = resultado.getString("NOME");
//                String telefone = resultado.getString("TELEFONE");
//                String sexo = resultado.getString("SEXO");
//                Leilao p = new Leilao(?);
//                lista.add(p);
//            }
//            return lista;
//        } catch (SQLException ex) {
//            throw new CadastroLeilaoDAOException("Falha ao buscar.", ex);
//        }
//    }

    //METODO PARA SE BASEAR
//    @Override
//    public List<Leilao> getMulheres() throws CadastroLeilaoDAOException {
//        try {
//            Connection con = ConnectionDAO.getConnection();
//            Statement stmt = con.createStatement();
//            ResultSet resultado = stmt.executeQuery("SELECT * FROM PESSOAS WHERE SEXO='F'");
//            List<Leilao> lista = new ArrayList<Leilao>();
//            while(resultado.next()) {
//                String nome = resultado.getString("NOME");
//                String telefone = resultado.getString("TELEFONE");
//                String sexo = resultado.getString("SEXO");
//                Leilao p = new Leilao(?);
//                lista.add(p);
//            }
//            return lista;
//        } catch (SQLException ex) {
//            throw new CadastroLeilaoDAOException("Falha ao buscar.", ex);
//        }   
//    }
    
    
    // Exemplo de metodo para buscar o primeiro usuario(Nao vai ficar nessa classe).
    public static Usuario getUsuarioPorId() throws CadastroLeilaoDAOException {
    	try {
    		Connection con = DBCreator.getConnection();
            Statement stmt = con.createStatement();
            ResultSet resultado = stmt.executeQuery("SELECT * FROM Usuarios");//Realiza a busca
            resultado.next();//Pega o proximo resultado do ResultSet (no caso o primeiro)
            Usuario usuario = new Usuario
            		(
            		resultado.getString("NOME"), //Atribui o valor de colunas aos parametros do usuario.
            		resultado.getString("CP"), 
            		resultado.getString("EMAIL")
            		);
            return usuario;
        } catch (SQLException ex) {
            throw new CadastroLeilaoDAOException("Falha ao buscar.", ex);
        }
    }

    //TODO Adaptar metodo para leilao
    @Override
    public List<Leilao> getTodos() throws CadastroLeilaoDAOException {
        try {
            Connection con = DBCreator.getConnection();
            Statement stmt = con.createStatement();
            ResultSet resultado = stmt.executeQuery("SELECT * FROM PESSOAS");
            List<Leilao> lista = new ArrayList<Leilao>();
            while(resultado.next()) {
                String nome = resultado.getString("NOME");
                String telefone = resultado.getString("TELEFONE");
                String sexo = resultado.getString("SEXO");
                //Leilao p = new Leilao();
                //lista.add(p);
            }
            return lista;
        } catch (SQLException ex) {
            throw new CadastroLeilaoDAOException("Falha ao buscar.", ex);
        }    
    }

	@Override
	public Leilao getPorId(int id) throws CadastroLeilaoDAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Leilao> getPorUsuario(Usuario u) throws CadastroLeilaoDAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Leilao> getLanceAberto() throws CadastroLeilaoDAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Leilao> getLanceFechado() throws CadastroLeilaoDAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Leilao> getPorDemanda() throws CadastroLeilaoDAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Leilao> getPorOferta() throws CadastroLeilaoDAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean adicionar(Leilao p) throws CadastroLeilaoDAOException {
		// TODO Auto-generated method stub
		return false;
	}
    
}
