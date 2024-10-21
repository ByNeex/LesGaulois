package personnages;

import java.security.PublicKey;

public class Village {
	private String nom;
	private Gaulois[] villageois;
	private Chef chef;
	private int nbVillageois = 0;

	public Village(String nom, int nbVillageoisMaximum) {
		this.nom = nom;
		villageois = new Gaulois[nbVillageoisMaximum];
	}
	
	public void setChef(Chef chef) {
		this.chef = chef;
	}

	public String getNom() {
		return nom;
	}
	
	public void ajouterHabitant(Gaulois gaulois) {
		villageois[nbVillageois] = gaulois;
		nbVillageois++;
	}
	
	public Gaulois trouverHabitant(int numVillageois) {
		return villageois[numVillageois];
	}
	
	public void afficherVillageois() {
		System.out.println("Dans le village du chef " + chef.getNom() + " vivent les légendaires gaulois :");
		for (int i = 0; i < nbVillageois; i++) {
			System.out.println("- " + villageois[i].getNom());
		}
	}
	
	
	
	public static void main(String[] args) {
		Village village = new Village("Village des Irréductibles", 30);
		/* Gaulois gaulois = village.trouverHabitant(30)
		  
		  Cela ne fonctionne pas car on essaie d'accéder à l'habitant case 30 alors que le
		  tableau est vide.
		 */
		
		Chef abraracourcix = new Chef("Abraracourcix", 6, village);
		village.setChef(abraracourcix);
		Gaulois asterix = new Gaulois("Astérix", 8);
		village.ajouterHabitant(asterix);
		
		/* Gaulois gaulois = village.trouverHabitant(1);
		System.out.println(gaulois); 
		
		Gaulois [nom=Astérix, force=8, effetPotion=1] a été obtenu car a la case 1 donc indice 0
		on a le chef puis a l'indice 1 on a Astérix et il nous renvoie la construction de celui-ci.
		*/
		
		Gaulois obelix = new Gaulois("Obélix", 25);
		village.ajouterHabitant(obelix);
		village.afficherVillageois();
	}
	
}
