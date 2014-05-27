package modele.base.actionsdao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.LogManager;

import controleur.connexion.Connexion;
import modele.base.dao.Categorie;
import modele.base.dao.Salle;
import modele.utils.ConnexionJDBC;

public class DAOSalle extends DAOFactory<Salle>{
    
    /**
     * Log4j logger
     */
    static org.apache.log4j.Logger log4j =  LogManager.getLogger(Connexion.class.getName());
    
	@Override
	public Salle find(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Salle create(Salle obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Salle update(Salle obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Salle obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Salle find(String chaine) {
		// TODO Auto-generated method stub
		return null;
	}

    @Override
    public List<Salle> findAll() {
        /* déclaration et init des variables nécessaires */
        List<Categorie> listeCateg = new ArrayList<Categorie>();
        Statement stmt = null;
        ResultSet res = null;
        ConnexionJDBC instance = ConnexionJDBC.getInstance();
        Connection conn = (Connection) instance.getConnection();
        
        try {
            stmt = conn.createStatement();
            res = stmt.executeQuery("select * from categorie");

            while (res.next()){
                listeCateg.add(new Categorie(res.getString("categorie")));
            }
            
        } catch (SQLException e) {
            log4j.info(e.getMessage(), e);
        }        
        return listeCateg;
    }

    @Override
    public Salle map(java.sql.ResultSet resultSet) {
        // TODO Auto-generated method stub
        return null;
    }

	
}
