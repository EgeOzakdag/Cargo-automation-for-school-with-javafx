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

	// Ba�lant� ��in Gerekli Olan Mehtot.- This will be start a coonection Api between databese
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
	

	// Hata Al�nd���nda Verilecek Error konsol ��kt��s.
	
	
	
	public static void CloseConnect() throws SQLException {
		Connection.close();
	}
	
	

}
	
	
	
	
	
	
	
	
	
	
	
	

