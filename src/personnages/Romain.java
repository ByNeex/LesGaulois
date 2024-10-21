package personnages;

public class Romain {
	private String nom;
	private int force;
	private Equipement[] equipements = new Equipement[2];
	private int nbEquipement = 0;
	private boolean vainqueur = true;

	public Romain(String nom, int force) {
		this.nom = nom;
		this.force = force;
		assert verifForce();
	}

	private boolean verifForce() {
		return force > 0;
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

	/*
	 * public void recevoirCoup(int forceCoup) { int forceAvantCoup = force; force
	 * -= forceCoup; assert verifForce(); if (force > 0) { parler("Aïe"); } else {
	 * parler("J'abandonne..."); } assert (force < forceAvantCoup);
	 * 
	 * }
	 */

	public Equipement[] recevoirCoup(int forceCoup) {
		Equipement[] equipementEjecte = null;
		// précondition
		assert force > 0;
		int oldForce = force;
		forceCoup = calculResistanceEquipement(forceCoup);
		force -= forceCoup;
		if (force == oldForce) {
			parler("Mon équipement m'a protégé, ma force n'a pas diminué !");
			vainqueur = false;
		} else if (force > 0){
			parler("Aïe");
		} else {
			equipementEjecte = ejecterEquipement();
			parler("J'abandonne...");
			//vainqueur = false; inutile
		}
		// post condition la force a diminuée
		assert force <= oldForce;
		return equipementEjecte;
	}
	
	public boolean isVainqueur() {
		return vainqueur;
	}

	private int calculResistanceEquipement(int forceCoup) {
		String texte = "Ma force est de " + this.force + ", et la force du coup est de " + forceCoup;
		int resistanceEquipement = 0;
		if (nbEquipement != 0) {
			texte += "\nMais heureusement, grace à mon équipement sa force est diminué de ";
			for (int i = 0; i < nbEquipement; i++) {
				if ((equipements[i] != null && equipements[i].equals(Equipement.BOUCLIER))) {
					resistanceEquipement += 8;
				} else {
					System.out.println("Equipement casque");
					resistanceEquipement += 5;
				}
			}
			texte += resistanceEquipement + "!";
		}
		parler(texte);
		if (resistanceEquipement > forceCoup) {
			forceCoup = 0;
		} else {
			forceCoup -= resistanceEquipement;
		}
		return forceCoup;
	}

	private Equipement[] ejecterEquipement() {
		Equipement[] equipementEjecte = new Equipement[nbEquipement];
		System.out.println("L'équipement de " + nom + "s'envole sous la force du coup.");
		int nbEquipementEjecte = 0;
		for (int i = 0; i < nbEquipement; i++) {
			if (equipements[i] != null) {
				equipementEjecte[nbEquipementEjecte] = equipements[i];
				nbEquipementEjecte++;
				equipements[i] = null;
			}
		}
		return equipementEjecte;
	}

	public int getForce() {
		return force;
	}

	private void ajouterEquipement(Equipement equipement) {
		equipements[nbEquipement] = equipement;
		nbEquipement++;
		System.out.println("Le soldat " + nom + " s'équipe avec un " + equipement.toString() + ".");
	}

	public void sEquiper(Equipement equip) {
		switch (nbEquipement) {
		case 2:
			System.out.println("Le soldat " + nom + " est déjà bien protégé !");
			break;
		case 1:
			if (equipements[0] == equip) {
				System.out.println("Le soldat " + nom + " possède déjà " + equip.toString() + " !");
			} else {
				ajouterEquipement(equip);
			}
			break;

		default:
			ajouterEquipement(equip);
		}
	}

	public static void main(String[] args) {
		Romain minus = new Romain("Minus", 6);
		minus.parler("Salut à toi jeune Gaulois !");
		minus.recevoirCoup(8);

		Equipement casque = Equipement.CASQUE;
		Equipement bouclier = Equipement.BOUCLIER;

		System.out.println("Equipement du Romain : " + casque);
		System.out.println("Equipement du Romain : " + bouclier);

		minus.sEquiper(casque);
		minus.sEquiper(casque);
		minus.sEquiper(bouclier);
		minus.sEquiper(casque);

	}

}
