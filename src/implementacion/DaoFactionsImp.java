package implementacion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import interfaces.IFaction;

public class DaoFactionsImp implements IFaction{
	private static final String driver = "com.mysql.cj.jdbc.Driver";
    private static final String url = "jdbc:mysql://localhost:3306/ForHonor?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private static final String user = "root";
    private static final String pass = "";
	private Connection conn =null;
	
	
	@Override
	public void LogIn(String db_name, String url, String db_pass) {
		System.out.println("Hello : " +conn);
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
		System.out.println("Bye:" +conn);
	}

	@Override
	public int getFaction_id(String faction_name) {
		int id=0;
		LogIn(url, user, pass);
		ResultSet rs = null;
		try {
			Statement st= conn.createStatement();
			rs = st.executeQuery("select faccion_id from Factions where nombre_faccion = "+faction_name);
			
			while(rs.next()) {
				id = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		logOut();
		return id;		
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
		DaoPlayerImp imp =  new DaoPlayerImp();
		DaoFactionsImp imp2 = new DaoFactionsImp();
		
		int faccion_id2 = imp2.getFaction_id("Samurais");
		System.out.println(imp.getSamuraiWithMoreAttack("select * from Player where ataque = (select MAX(ataque) from Player where faccion_id = "+faccion_id2,faccion_id2));
	}
}
