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
import modele.base.dao.Matiere;
import modele.base.dao.Messagerie;
import modele.utils.ConnexionJDBC;

public class DAOMessagerie extends DAOFactory <Messagerie>{
    /**
     * Log4j logger
     */
    static org.apache.log4j.Logger log4j =  LogManager.getLogger(Connexion.class.getName());
    
	@Override
	public Messagerie find(int id) {
		
		return null;
	}

	@Override
	public Messagerie create(Messagerie msgEnvoye) {
        /* déclaration et init des variables nécessaires */
        Statement stmt = null;
        ConnexionJDBC instance = ConnexionJDBC.getInstance();
        Connection conn = (Connection) instance.getConnection();
        int envoiOuRecu;
        
        try {
            if(msgEnvoye.getEnvoiOuRecu() == 0){
                envoiOuRecu = 0;
            } else {
                envoiOuRecu = 1;
            }
            
            stmt = conn.createStatement();
            String req = "INSERT INTO `messagerie` (`ID_PERSONNE` ,`ID_MESSAGE` ,`ENVOI_RECU`)"
                    + " VALUES ("
                    + Integer.toString(msgEnvoye.getIdPersonne()) + ","
                    + Integer.toString(msgEnvoye.getIdMessage()) + ","
                    + Integer.toString(envoiOuRecu) + ");";
            stmt.executeUpdate(req);
            
        } catch (SQLException e) {
            log4j.info(e.getMessage(), e);
        }
		return null;
	}

	@Override
	public Messagerie update(Messagerie obj) {
		
		return null;
	}

	@Override
	public void delete(Messagerie msg) {
        /* déclaration et init des variables nécessaires */
        Statement stmt = null;
        ConnexionJDBC instance = ConnexionJDBC.getInstance();
        Connection conn = (Connection) instance.getConnection();
        
        try {
            stmt = conn.createStatement();
            stmt.executeUpdate("delete from messagerie where id_personne = " + msg.getIdPersonne()
                          + " and id_message = " + msg.getIdMessage()
                          + " and envoi_recu = " + msg.getEnvoiOuRecu());
        } catch (SQLException e) {
            log4j.info(e.getMessage(), e);
        }    
	}

	@Override
	public Messagerie find(String chaine) {
		
		return null;
	}

    @Override
    public List<Messagerie> findAll() {
        /* déclaration et init des variables nécessaires */
        List<Messagerie> listeCompose = new ArrayList<Messagerie>();
        Statement stmt = null;
        ResultSet res = null;
        ConnexionJDBC instance = ConnexionJDBC.getInstance();
        Connection conn = (Connection) instance.getConnection();
        
        try {
            stmt = conn.createStatement();
            res = stmt.executeQuery("select * from compose");

            while (res.next()){
                listeCompose.add(new Messagerie(res.getInt("id_personne"), res.getInt("id_message"), res.getInt("envoi_recu")));
            }
            
        } catch (SQLException e) {
            log4j.info(e.getMessage(), e);
        }        
        return listeCompose;
    }

    @Override
    public Messagerie map(java.sql.ResultSet resultSet) {
        
        return null;
    }
}
