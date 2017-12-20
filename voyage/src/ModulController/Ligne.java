package ModulController;

import java.util.ArrayList;
import java.util.HashMap;

public class Ligne {
	
	private int id;
	private String heure_Allee;
	private String heure_Retoure;
	private String kilometrage;
	private String duree_ropos;
	private String duree_immobilisation;
	
	public Ligne(String heure_Allee, String heure_Retoure, String kilometrage, String duree_ropos, String duree_imm) {
		super();
		this.heure_Allee = heure_Allee;
		this.heure_Retoure = heure_Retoure;
		this.kilometrage = kilometrage;
		this.duree_ropos = duree_ropos;
		this.duree_immobilisation = duree_imm;
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
	public static Ligne selectItem(int id) {
		return null;
	}
	
	public static  ArrayList<HashMap<Integer, Ligne>> selectAll() {
		return null;
	}
	
	
	
	
	

}
