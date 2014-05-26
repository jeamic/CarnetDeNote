package modele.base.actionsdao;
import java.sql.SQLException;
import java.util.List;

import modele.base.dao.Personne;

import org.apache.log4j.LogManager;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;


public class DAOPersonne extends DAOFactory<Personne>{

	/**
	 * Log4j logger
	 */
	static org.apache.log4j.Logger log4j =  LogManager.getLogger(DAOPersonne.class.getName());
	
	@Override
	public Personne find(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public Personne find (String email) {
		/* déclaration et init des variables nécessaires */
		Personne pers = null;
		PreparedStatement stmt = null;
		ResultSet res = null;
		
		/* requête pour rechercher la personne */
		try {
			stmt = (PreparedStatement) instance.getConnection().prepareStatement("Select * from personne where email = ?");
			stmt.setString(1, email);
			res = (ResultSet) stmt.executeQuery();
            if (res.first()){
                /* création de l'objet correspondant à la personne recherchée */
                pers = new Personne( res.getInt("id_personne"),
                                     res.getString("nom"),
                                     res.getString("prenom"),
                                     res.getString("adresse"),
                                     res.getString("mot_de_passe"),
                                     res.getString("email"),
                                     res.getString("type_p"));
            }
		} catch (SQLException e) {
			log4j.info(e.getMessage(), e);
		}

		return pers;
	}

	@Override
	public Personne create(Personne obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Personne update(Personne obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Personne obj) {
		// TODO Auto-generated method stub
		
	}

    @Override
    public List<Personne> findAll() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Personne map(java.sql.ResultSet resultSet) {
        // TODO Auto-generated method stub
        return null;
    }

}