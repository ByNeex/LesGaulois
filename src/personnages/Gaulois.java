package personnages;

import villagegaulois.Musee;

public class Gaulois {
	private String nom;
	private int force;
	private int nbTrophees;
	private int effetPotion = 1;
	private Equipement[] trophees = new Equipement[100];

	public Gaulois(String nom, int force) {
		this.nom = nom;
		this.force = force;
	}

	public String getNom() {
		return nom;
	}

	public void parler(String texte) {
		System.out.println(prendreParole() + "« " + texte + "»");
	}

	/*
	 * private String prendreParole() { return "Le gaulois " + nom + " : "; }
	 */

	private String prendreParole() {
		return "Le gaulois " + nom + " : ";
	}

	/*
	 * public void frapper(Romain romain) { System.out.println(nom +
	 * " envoie un grand coup dans la mâchoire de " + romain.getNom());
	 * romain.recevoirCoup((force / 3) * effetPotion);
	 * 
	 * }
	 */

	public void frapper(Romain romain) {
		System.out.println(nom + " envoie un grand coup dans la mâchoire de " + romain.getNom());
		Equipement[] trophee = romain.recevoirCoup((force / 3) * effetPotion);
		for (int i = 0; trophee != null && i < trophee.length; i++, nbTrophees++) {
			this.trophees[nbTrophees] = trophee[i];
		}
	}

	//@Override
	public String toString() {
		return "Gaulois [nom=" + nom + ", force=" + force + ", effetPotion=" + effetPotion + "]";
	}

	public void boirePotion(int forcePotion) {
		effetPotion = forcePotion;
		System.out.println(
				prendreParole() + "« Merci Druide, je sens que ma force est " + effetPotion + " fois décuplée. »");

	}
	
	public void faireUneDonnation(Musee musee) {
		if (nbTrophees > 0) {
			System.out.println(prendreParole()+ "« Je donne au musée tous mes trophées :");
			for (int i = 0; i < nbTrophees; i++) {
				musee.donnerTrophees(this, trophees[i]);
				System.out.println("- " + trophees[i].toString());
			}
			nbTrophees = 0;
		}
	}

	public static void main(String[] args) {
		Gaulois asterix = new Gaulois("Astérix", 8);
		System.out.println(asterix.getNom());
		asterix.parler("Salut !");

		Romain romain = new Romain("César", 10);
		asterix.frapper(romain);

		asterix.boirePotion(5);
		asterix.frapper(romain);

	}

}
