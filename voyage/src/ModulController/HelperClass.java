package ModulController;

import java.awt.Color;
import java.sql.*;

public abstract class HelperClass {
	public static Connection c;
	public static Color menuColorDefault=new Color(05, 05, 30);
	private HelperClass() {}
	
	public static boolean executeAjouterSupprimerModifier(Connection c,String query) {
		Statement st;
		try {
			st = c.createStatement();
			
		  int i = st.executeUpdate(query);
		  System.out.println(i);
		       if (i>0){
		    	   return true;
		       }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	public static ResultSet executeSelection(Connection c,String query) {
		Statement st;
		try {
			st = c.createStatement();
			return st.executeQuery(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
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
	public static int toTinyInt(boolean b) {
		if(b)
			return 1;
		else
			return 0;
	}
	public static int toTinyInt(String b) {
		if(b.equals("true") || b.equals("1"))
			return 1;
		else if(b.equals("false") || b.equals("0"))
			return 0;
		else 
			return 99999;
	}
	public static boolean toBoolean(int i) {
		if(i==0)
			return true;
		else if(i==1)
			return false;
		else 
			return false;
	}
}
