package ModulController;

import java.util.ArrayList;
import java.util.HashMap;

public class EtatPanne {
	private int id;
	private String dateNonDispo;
	
	public EtatPanne(int id, String dateNonDispo) {
		super();
		this.id = id;
		this.dateNonDispo = dateNonDispo;
	}
	
	public static boolean ajouter() {
		return false;
	}
	
	public static void ajouterPanne() {
		
	}
	
	public static boolean modifier() {
		return false;
	}
	
	public static boolean supprimer(int id) {
		return false;
	}
	public static EtatPanne selectItem(int id) {
		return null;
	}
	
	public static ArrayList<HashMap<Integer, EtatPanne>> selectAll() {
		return null;
	}
	
}
