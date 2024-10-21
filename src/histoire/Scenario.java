/*
 * package histoire;
 * 
 * import personnages.Gaulois; import personnages.Romain; import
 * personnages.Druide;
 * 
 * public class Scenario {
 * 
 * public static void main(String[] args) {
 * 
 * Gaulois asterix = new Gaulois("Astérix", 8); Romain minus = new
 * Romain("Minus", 6);
 * 
 * // Premier scénario /*asterix.parler("Bonjour à tous");
 * minus.parler("UN GAU... UN GAUGAU..."); for (int i = 0; i < 3; i++) {
 * asterix.frapper(minus); }
 * 
 * // Deuxième scénario Gaulois obelix = new Gaulois("Obélix", 25); Druide
 * panoramix = new Druide("Panoramix", 5, 10);
 * 
 * panoramix.parler("Je vais aller préparer une petite potion...");
 * panoramix.preparerPotion(); panoramix.booster(obelix);
 * obelix.parler("Par Bénelos, ce n'est pas juste !");
 * panoramix.booster(asterix); asterix.parler("Bonjour");
 * minus.parler("UN GAU... UN GAUGAU..."); asterix.frapper(minus);
 * 
 * 
 * }
 * 
 * }
 */

package histoire;

import personnages.Druide;
import personnages.Equipement;
import personnages.Gaulois;
import personnages.Romain;
import villagegaulois.Musee;

public class Scenario {

	public static void main(String[] args) {
		Druide druide = new Druide("Panoramix", 5, 10);
		druide.parler("Je vais aller préparer une petite potion...");
		druide.preparerPotion();
		Gaulois obelix = new Gaulois("Obélix", 25);
		Gaulois asterix = new Gaulois("Astérix", 8);
		druide.booster(obelix);
		obelix.parler("Par Bélénos, ce n'est pas juste !");
		druide.booster(asterix);
		asterix.parler("Bonjour");
		Romain minus = new Romain("Minus", 6);
		Romain milexcus = new Romain("Milexcus", 8);
		minus.sEquiper(Equipement.BOUCLIER);
		minus.sEquiper(Equipement.CASQUE);
		milexcus.sEquiper(Equipement.CASQUE);
		minus.parler("UN GAU... UN GAUGAU...");
		do {
			asterix.frapper(minus);
		} while (minus.isVainqueur() && minus.getForce() > 0);
		milexcus.parler("UN GAU... UN GAUGAU...");
		do {
			asterix.frapper(milexcus);
		} while (milexcus.isVainqueur() && milexcus.getForce() > 0);
		
		Musee musee = new Musee();
		asterix.faireUneDonnation(musee);
		System.out.println(musee.extraireInstructionsOCaml());

	}

}