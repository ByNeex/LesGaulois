package villagegaulois;

import personnages.Equipement;
import personnages.Gaulois;

public class Musee {
	private Trophee[] trophees = new Trophee[200];
	private int nbTrophee = 0;

	public void donnerTrophees(Gaulois gaulois, Equipement equipement) {

		Trophee troph = new Trophee(gaulois, equipement);
		trophees[nbTrophee] = troph;
		nbTrophee++;
	}

	public String extraireInstructionsOCaml() {
		String exp = "let musee = [\n";
		for (int i = 0; i < nbTrophee; i++) {
			Trophee troph = trophees[i];
			exp = exp + "\t" + "\"" + troph.getGaulois().getNom() + "\", \"" + troph.getEquipement().toString() + "\"";

			if (i < nbTrophee - 1) {
				exp = exp + ";\n";
			}
		}
		exp = exp + "\n]";
		return exp;
	}

}