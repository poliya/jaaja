package ModulController;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

public class AutoCar {
	private int id;
	private int nImmatriculation;
	//private String dureeImmobilisation;// l'utilite de l'attribut ?? on peut l'integrer dans l'etat
	private String etat;// statut de autocar
	public AutoCar(int id, String dureeImmobilisation,int nImmatriculation) {
		super();
		this.nImmatriculation=nImmatriculation;
		this.id = id;
		//this.dureeImmobilisation = dureeImmobilisation;
	}

	public static boolean ajouter(Connection C,AutoCar ac) {
		Statement st;
		try {
			st = C.createStatement();
			
		  int i = st.executeUpdate
		("INSERT INTO `autocar` (`id_car`, `nImmatriculation`, `etat`) "+
		  " VALUES (NULL, '"+ac.nImmatriculation+"', '"+ac.etat+"')");
//INSERT INTO `autocar` (`id_car`, `nImmatriculation`, `etat`) VALUES (NULL, 'ezfze5154', 'qsxqd')
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
	
	public static boolean miseJourEtat(String etat) {
		
		return false;
	}
	
	public static boolean modifier(Connection C,AutoCar ac) {
		Statement st;
		try {
			st = C.createStatement();
			
		  int i = st.executeUpdate("UPDATE `autocar` SET `nImmatriculation` = '"+ac.nImmatriculation+"',"
		  		+ " `etat` = '"+ac.etat+"' WHERE `ligne`.`id_car` = ? ");
				
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

	public static boolean supprimer(Connection C,AutoCar ac) {
		Statement st;
		try {
			st = C.createStatement();
			
		  int i = st.executeUpdate("DELETE FROM `autocar` WHERE `autocar`.`id_car` = ?");
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
	public static AutoCar selectItem(int id) {
		return null;
	}
	
	
	public static ArrayList<HashMap<Integer, AutoCar>> selectAll() {
		return null;
	}
	

}
