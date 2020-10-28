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
    private static final String user = "User3";
    private static final String pass = "456";
	private Connection conn =null;
	
	
	@Override
	public void LogIn(String url, String user, String pass) {
		//System.out.println("Hello : " +conn);
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
		//System.out.println("Bye:" +conn);
	}

	@Override
	public int getFaction_id(String faction_name) {
		int id=0;
		LogIn(url, user, pass);
		ResultSet rs = null;
		try {
			Statement st= conn.createStatement();
			rs = st.executeQuery("select faccion_id from Factions where nombre_faccion = "+ "'" + faction_name + "'");
			
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
}
