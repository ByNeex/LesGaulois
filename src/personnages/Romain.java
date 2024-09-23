package personnages;

public class Romain {
	private String nom;
	private int force;

	public Romain(String nom, int force) {
		this.nom = nom;
		this.force = force;
	}

	public String getNom() {
		return nom;
	}

	public void parler(String texte) {
		System.out.println(prendreParole() + "« " + texte + "»");

	}

	private String prendreParole() {
		return "Le romain " + nom + " : ";

	}

	public void recevoirCoup(int forceCoup) {
		force -= forceCoup;
		if (force > 0) {
			parler("Aïe");
		} else {
			parler("J'abandonne...");
		}

	}
	
	public static void main(String[] args) {
		Romain cesar = new Romain("César", 7);
		cesar.parler("Salut à toi jeune Gaulois !");
		
		Gaulois asterix = new Gaulois("Astérix", 8);
		cesar.recevoirCoup(8);
	}

}
