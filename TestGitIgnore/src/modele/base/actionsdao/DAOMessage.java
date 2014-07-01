package modele.base.actionsdao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.LogManager;

import controleur.connexion.Connexion;
import modele.base.dao.Categorie;
import modele.base.dao.Matiere;
import modele.base.dao.Message;
import modele.base.dao.Messagerie;
import modele.utils.ConnexionJDBC;
import modele.vue.dao.DAOVueMessage;

public class DAOMessage extends DAOFactory<Message>{

    /**
     * Log4j logger
     */
    static org.apache.log4j.Logger log4j =  LogManager.getLogger(Connexion.class.getName());
    
	@Override
	public Message find(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Message create(Message msg) {
	    /* déclaration et init des variables nécessaires */
	    PreparedStatement preparedStatement = null;
	    ConnexionJDBC instance = ConnexionJDBC.getInstance();
        Connection conn = (Connection) instance.getConnection();
        
        try {
            if (conn == null){ System.out.println("test");}
            
            preparedStatement = 
                conn.prepareStatement("INSERT INTO `message` (`TITRE`, `DESTINATAIRES`, `CONTENU`, `LU`) VALUES (?, ?, ?, ?)", 
                Statement.RETURN_GENERATED_KEYS);

            preparedStatement.setString(1, msg.getObjet());
            preparedStatement.setString(2, msg.getDestinataires());
            preparedStatement.setString(3, msg.getContenu());
            preparedStatement.setInt(4, 1); /*1 ==> msg non lu*/
            preparedStatement.executeUpdate();
            
            /* on récupère l'id auto généré par la base */
            ResultSet tableKeys = preparedStatement.getGeneratedKeys();
            tableKeys.next();
            int autoGeneratedID = tableKeys.getInt(1);
            msg.setIdMessage(autoGeneratedID);
        } catch (SQLException e) {
            log4j.info(e.getMessage(), e);
        }
		return msg;
	}

	@Override
	public Message update(Message obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Message obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Message find(String chaine) {
		// TODO Auto-generated method stub
		return null;
	}

    @Override
    public List<Message> findAll() {
        /* déclaration et init des variables nécessaires */
        List<Message> listeMsg = new ArrayList<Message>();
        Statement stmt = null;
        ResultSet res = null;
        ConnexionJDBC instance = ConnexionJDBC.getInstance();
        Connection conn = (Connection) instance.getConnection();
        
        try {
            stmt = conn.createStatement();
            res = stmt.executeQuery("select * from message");

            while (res.next()){
                listeMsg.add(new Message(res.getInt("id_message"), res.getString("objet"), res.getString("destinataires"), res.getString("cotenu"), res.getBoolean("lu")));
            }
            
        } catch (SQLException e) {
            log4j.info(e.getMessage(), e);
        }        
        return listeMsg;
    }

    @Override
    public Message map(java.sql.ResultSet resultSet) {
        // TODO Auto-generated method stub
        return null;
    }
    
    public List<DAOVueMessage> getMsgEnvoyes (int idPersonne){
        /* déclaration et init des variables nécessaires */
        Statement stmt = null;
        ConnexionJDBC instance = ConnexionJDBC.getInstance();
        Connection conn = (Connection) instance.getConnection();
        List<DAOVueMessage> listMsg = new ArrayList<DAOVueMessage>();
        ResultSet res = null;
        
        try {            
            stmt = conn.createStatement();
            String req = "SELECT * from messagerie, message, personne where messagerie.id_personne = " + idPersonne + " and envoi_recu = 0 and messagerie.id_message = message.id_message and messagerie.id_personne = personne.id_personne;";
            res = stmt.executeQuery(req);
            
            while (res.next()){
                listMsg.add(new DAOVueMessage(res.getInt("message.id_message"), res.getInt("id_personne"), res.getString("email"), res.getString("titre"), res.getString("destinataires"), res.getString("contenu"), res.getInt("lu"), res.getInt("envoi_recu")));
            }
            
        } catch (SQLException e) {
            log4j.info(e.getMessage(), e);
        }
        return listMsg;
    }
    
    public List<DAOVueMessage> getMsgRecus (int idPersonne){
        /* déclaration et init des variables nécessaires */
        Statement stmt = null;
        Statement stmt2 = null;
        ConnexionJDBC instance = ConnexionJDBC.getInstance();
        Connection conn = (Connection) instance.getConnection();
        List<DAOVueMessage> listMsg = new ArrayList<DAOVueMessage>();
        ResultSet res = null;
        ResultSet res2 = null;
        
        try {            
            stmt = conn.createStatement();
            String req = "select * from messagerie, message, personne where messagerie.id_personne = " + idPersonne + " and envoi_recu = 1 and messagerie.id_message = message.id_message and messagerie.id_personne = personne.id_personne;";
            res = stmt.executeQuery(req);
            
            while (res.next()){
                String req2 = "select * "
                        + " from messagerie, personne"
                        + " where messagerie.id_personne = personne.id_personne"
                        + " and messagerie.id_message = " + res.getInt("message.id_message")
                        + " and messagerie.envoi_recu =0";
                stmt2 = conn.createStatement();
                res2 = stmt2.executeQuery(req2);
                String expediteur = null;
                while (res2.next()){
                    expediteur = res.getString("email");
                }
                listMsg.add(new DAOVueMessage(res.getInt("message.id_message"), res.getInt("id_personne"), expediteur, res.getString("titre"), res.getString("destinataires"), res.getString("contenu"), res.getInt("lu"), res.getInt("envoi_recu")));
            }
            
        } catch (SQLException e) {
            log4j.info(e.getMessage(), e);
        }
        return listMsg;
    }
}
