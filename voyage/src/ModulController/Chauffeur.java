package ModulController;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

public class Chauffeur {
	private String id=null;
	private String Matricule;
	private String Nom;
	private String conge;
	
	public Chauffeur(String matricule, String nom,boolean conge) {
		super();
		this.Matricule = matricule;
		this.Nom = nom;
		if(conge)
			this.conge = "1";
		if(!conge)
			this.conge = "0";
		
	}
	public Chauffeur(String matricule, String nom,String conge) {
		super();
		this.Matricule = matricule;
		this.Nom = nom;
		if(conge.equals("true") || conge.equals("1"))
			this.conge = "1";
		else if(!conge.equals("false") || !conge.equals("0"))
			this.conge = "0";
		
	}
	
	public Chauffeur(String matricule, String nom,boolean conge, Integer id) {
		super();
		this.id=String.valueOf(id);
		this.Matricule = matricule;
		this.Nom = nom;
		if(conge)
			this.conge = "1";
		if(!conge)
			this.conge = "0";
		
	}
	public static boolean ajouter( Connection C,Chauffeur ch) {
		Statement st;
		try {
			st = C.createStatement();
			
		  int i = st.executeUpdate
		("INSERT INTO `chauffeur` (`id_chauf`, `Matricule`, `nom`, `conge`)  "+
		  " VALUES (NULL, '"+ch.Matricule+"', '"+ch.Nom+"', '"+ch.conge+"')");
//INSERT INTO `chauffeur` (`id_chauf`, `Matricule`, `nom`, `conge`) VALUES (NULL, 'geg', 'zzdrgreg', '\"\"t\"\'yt\'\"r') 
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
	
	public static boolean modifier( Connection C,Chauffeur ch) {
		Statement st;
		try {
			st = C.createStatement();
			
		  int i = st.executeUpdate("UPDATE `chauffeur` SET `Matricule` = '"+ch.Matricule+"',"
		  		+ " `nom` = '"+ch.Nom+"', `conge` = '"+ch.conge+"' WHERE `chauffeur`.`id_chauf` = "+ch.id+" ");
			System.out.println("UPDATE `chauffeur` SET `Matricule` = '"+ch.Matricule+"',"
			  		+ " `nom` = '"+ch.Nom+"', `conge` = '"+ch.conge+"' WHERE `chauffeur`.`id_chauf` = "+ch.id+" ");	
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
	
	public static boolean supprimer( Connection C,Chauffeur ch) {
		Statement st;
		try {
			st = C.createStatement();
			String q="DELETE FROM `chauffeur` WHERE `Matricule`='"+ch.Matricule+"' AND `Nom`='"+ch.Nom+"'";
			System.out.println(q);
		  int i = st.executeUpdate(q);
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
	public static Chauffeur selectItem(int id) {
		return null;
	}
	
	public static ArrayList<HashMap<Integer, Chauffeur>> selectAll() {
		return null;	
	}
	
	public static ResultSet selectAll( Connection C,Statement st) throws SQLException {
		return st.executeQuery("select * from `chauffeur`");
	}
	public static boolean supprimer(Connection c, Integer integer) {
		Statement st;
		try {
			st = c.createStatement();
			String q="DELETE FROM `chauffeur` WHERE id_chauf='"+integer+"'";
			System.out.println(q);
		  int i = st.executeUpdate(q);
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
	
}
