package ModulController;

import java.util.ArrayList;
import java.util.HashMap;

public class CongeDate {
	private int id;
	private String dateDebut;
	private String dateFin;
	
	public CongeDate(int id, String dateDebut, String dateFin) {
		super();
		this.id = id;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
	}
	
	public static boolean ajouter() {
		return false;
	}
	
	public static boolean modifier() {
		return false;
	}
	
	public static boolean supprimer() {
		return false;
	}
	
	public static CongeDate selectItem() {
		return null;
	}
	
	public static  ArrayList<HashMap<Integer, CongeDate>> selectAll() {
		return null;
	}

}
