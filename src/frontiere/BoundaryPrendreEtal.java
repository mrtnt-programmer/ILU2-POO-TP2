package frontiere;

import controleur.ControlPrendreEtal;

public class BoundaryPrendreEtal {
	private ControlPrendreEtal controlPrendreEtal;

	public BoundaryPrendreEtal(ControlPrendreEtal controlChercherEtal) {
		this.controlPrendreEtal = controlChercherEtal;
	}

	public void prendreEtal(String nomVendeur) {
		boolean nomVendeurConnu = this.controlPrendreEtal.verifierIdentite(nomVendeur);
		if(!nomVendeurConnu) {
			System.out.println("Je suis desolee "+nomVendeur+" mais il faut etre un habitant de notre village pour commercer ici");
		}
		else {
			System.out.println("Bonjour "+nomVendeur+" ,je vais regarder si je peux vous trouver un etals");
			boolean etalsDisponible = controlPrendreEtal.resteEtals();
			if (!etalsDisponible) {
				System.out.println("desolee"+nomVendeur+"je n'ai plus d'etals qui ne soit pas deja occuppe");
			}
			else {
				installerVendeur(nomVendeur);
				System.out.println("c'est parfait, il me reste un etals pour vous!");
				System.out.println("il me faudrait quelques renseignements.");
				String produit = Clavier.entrerChaine("produit");
				System.out.println("Combien souhaitez-vous en vendre?");
				int nbproduit = Clavier.entrerEntier("produit");
				int numeroEtals = controlPrendreEtal.prendreEtal(nomVendeur, produit, nbproduit);
				if (numeroEtals != -1) {
					System.out.println("Le vendeur"+nomVendeur+"s'est installe a l'etal n"+numeroEtals);
				}
			}
		}
	}

	private void installerVendeur(String nomVendeur) {
		//TODO a completer
	}
}
