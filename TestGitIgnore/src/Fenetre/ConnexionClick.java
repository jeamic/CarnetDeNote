package Fenetre;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;
import com.mysql.jdbc.Statement;

public class ConnexionClick {
	
	public static Connection connexion() {
		try
		{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			
		}
		
		Connection conn = null;
		try
		{
			conn = DriverManager.getConnection("jdbc:mysql://localhost/Onlinote", "root", "");
			
		}
		catch(SQLException e)
		{
			System.out.println("sql exception");
			while (e!=null)
			{
				System.out.println(e.getErrorCode());
				System.out.println(e.getMessage());
				System.out.println(e.getSQLState());
				e.printStackTrace();
				e=e.getNextException();
			}
			
			//return null;
		}
		catch (Exception e)
		{
			e.printStackTrace();
			
			//return null;
		}
		
		return conn;
	}
	
	public static void clicked() {
		Connection conn = connexion();
		
		if(conn != null)
			try {
				
				java.sql.Statement stat = conn.createStatement();
				java.sql.ResultSet res = stat.executeQuery("Select ID, Password from utilisateur");
				while (res.next())
				{
					System.out.println(res.getInt(1));
					System.out.println(res.getString(2));
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		else
			System.out.println("null !");
		
	}
	
}
