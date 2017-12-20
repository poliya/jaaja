package ModulController;

import java.util.ArrayList;
import java.util.HashMap;

public class Location {

	private int id;
	private String intitle;
	private String beneficiare;
	private String date_debut;
	private String date_fin;
	
	public Location(String intitle, String beneficiare, String date_debut, String date_fin) {
		super();
		this.intitle = intitle;
		this.beneficiare = beneficiare;
		this.date_debut = date_debut;
		this.date_fin = date_fin;
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
	public static Location selectItem(int id) {
		return null;
	}
	
	public static ArrayList<HashMap<Integer, Location>> selectAll() {
		return null;
	}
	
	
	
}
