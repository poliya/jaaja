package ModulController;

import java.util.ArrayList;
import java.util.HashMap;

public class Voyage {
	private int id;
	private String Date_affectation;
	private String Date_voyage; 
 
	public Voyage(String Date_affectation,String Date_voyage) {
		this.Date_affectation=Date_affectation;
		this.Date_voyage=Date_voyage;
	}
	
	public static boolean ajouter() {
		return false;
	}
	
	public static boolean modifier() {
		return false;
	}
	
	public static boolean supprimer(int id) {
		return false;
	}
	public static Voyage selectItem(int id) {
		return null;
	}
	
	public static  ArrayList<HashMap<Integer, Voyage>> selectAll() {
		return null;
	}
}
