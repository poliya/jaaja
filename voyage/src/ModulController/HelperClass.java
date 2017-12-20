package ModulController;

import java.sql.*;

public abstract class HelperClass {
	public static Connection c;

	private HelperClass() {}
	
	
	public static void createDBConnection() {
		try {
			Class.forName("org.gjt.mm.mysql.Driver");
			System.out.println("chargemet reussi !!");
			
			// Etablir la connection
			try {
				c = DriverManager.getConnection("jdbc:mysql://localhost:3306/voyage","root","");							
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void closeDBConnection() {
		try {
			c.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
