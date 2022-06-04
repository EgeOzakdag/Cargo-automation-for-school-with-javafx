package application;
import java.sql.*;
import java.sql.DriverManager;
import java.sql.SQLException;
public class DatabaseHelper {

	
	
	
	
	public static Connection Connection;
	private static String  DatabaseName= "cargoautomation";
	private static String DatabaseUsername = "root";
	private static String DatabasePassword = "";
	private static String url = "jdbc:mysql://localhost/"+DatabaseName;

	// Baðlantý Ýçin Gerekli Olan Mehtot.- This will be start a coonection Api between databese
public static Connection GetConnect() {
		
		try {
			Connection=DriverManager.getConnection(url,DatabaseUsername,DatabasePassword);
			
			return Connection;
			
		} catch (Exception e) {
			System.out.println(e.getMessage().toString());
			return null;
			// TODO: handle exception
		}
	}
	

	// Hata Alýndýðýnda Verilecek Error konsol çýktýýs.
	
	
	
	public static void CloseConnect() throws SQLException {
		Connection.close();
	}
	
	

}
	
	
	
	
	
	
	
	
	
	
	
	

