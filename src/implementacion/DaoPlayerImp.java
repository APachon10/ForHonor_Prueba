package implementacion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

import interfaces.IPlayer;
import modelos.Player;

public class DaoPlayerImp implements IPlayer{
	private static final String driver = "com.mysql.cj.jdbc.Driver";
    private static final String url = "jdbc:mysql://localhost:3306/ForHonor?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private static final String user = "User3";
    private static final String pass = "456";
	private Connection conn =null;
	
    @Override
	public void LogIn(String db_name, String url, String db_pass) {
    	System.out.println("Hola : "+ conn);
		try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, user, pass);
            System.out.println("Conexión OK");

        } catch (ClassNotFoundException e) {
            System.out.println("Error al cargar el controlador");
            e.printStackTrace();

        } catch (Exception e) {
            System.out.println("Error en la conexión");
            e.printStackTrace();
        }
		System.out.println("Adios : " +conn);
	}
	@Override
	public void getAllknights(String query) {
		LogIn(user, url, pass);
		ResultSet rs = null;
		
		try {
			Statement st = conn.createStatement();
			rs = st.executeQuery(query);			
			while(rs.next()) {
				System.out.println(rs.getInt(1) + " , "+ rs.getString(2) + ", "+ rs.getInt(3) + ", " + rs.getInt(4) + ", " + rs.getInt(5));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		logOut();
	}
	@Override
	public Player getSamuraiWithMoreAttack(String query,int faccion_id) {
		LogIn(user,url,pass);
		
		Player p = null;
		ResultSet rs= null;
		try {
			Statement st = conn.createStatement();
			rs = st.executeQuery(query);			
			while(rs.next()) {
				p.setPlayer_name(rs.getString(2));
				p.setAttack(rs.getInt(3));
				p.setDefense(rs.getInt(4));
				p.setFaction_id(rs.getInt(5));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		logOut();
		return p;
	}
	@Override
	public void logOut() {
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		DaoPlayerImp imp = new DaoPlayerImp();
		DaoFactionsImp imp2 = new DaoFactionsImp();
		
		/*int faccion_id=1;
		imp.getAllknights("Select * from Player where faccion_id = "+ faccion_id);
		
		System.out.println("============================================");*/
		
		int faccion_id2 = imp2.getFaction_id("Samurais");
		String query ="select * from Player where ataque = (select MAX(ataque) from Player where faccion_id = "+faccion_id2;
		System.out.println(imp.getSamuraiWithMoreAttack(query , faccion_id2));
	}
}
