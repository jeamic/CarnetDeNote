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
import modele.base.dao.Specialite;
import modele.utils.ConnexionJDBC;

public class DAOSpecialite extends DAOFactory<Specialite>{

    /**
     * Log4j logger
     */
    static org.apache.log4j.Logger log4j =  LogManager.getLogger(Connexion.class.getName());
    
	@Override
	public Specialite find(int id) {
		
		return null;
	}

	@Override
	public Specialite create(Specialite obj) {
		
		return null;
	}

	@Override
	public Specialite update(Specialite obj) {
		
		return null;
	}

	@Override
	public void delete(Specialite obj) {
	    return;
	}

	@Override
	public Specialite find(String chaine) {
		
		return null;
	}

    @Override
    public List<Specialite> findAll() {
        /* déclaration et init des variables nécessaires */
        List<Specialite> listeSpe = new ArrayList<Specialite>();
        Statement stmt = null;
        ResultSet res = null;
        ConnexionJDBC instance = ConnexionJDBC.getInstance();
        Connection conn = (Connection) instance.getConnection();
        
        try {
            stmt = conn.createStatement();
            res = stmt.executeQuery("select * from specialite");

            while (res.next()){
                listeSpe.add(new Specialite(res.getString("specialite")));
            }
            
        } catch (SQLException e) {
            log4j.info(e.getMessage(), e);
        }        
        return listeSpe;
    }

    @Override
    public Specialite map(java.sql.ResultSet resultSet) {
        
        return null;
    }

	
}
