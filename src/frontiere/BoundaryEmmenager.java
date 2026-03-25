package frontiere;

import controleur.ControlEmmenager;

public class BoundaryEmmenager {
	private ControlEmmenager controlEmmenager;

	public BoundaryEmmenager(ControlEmmenager controlEmmenager) {
		this.controlEmmenager = controlEmmenager;
	}

	public void emmenager(String nomVisiteur) {
		if (controlEmmenager.isHabitant(nomVisiteur)) {
			System.out.println("Mais vous êtes déjà un habitant du village !");
		} else {
			StringBuilder question = new StringBuilder();
			question.append("Êtes-vous :\n");
			question.append("1 - un druide.\n");
			question.append("2 - un gaulois.\n");
			int choixUtilisateur = -1;
			do {
				choixUtilisateur = Clavier.entrerEntier(question.toString());
				switch (choixUtilisateur) {
				case 1:
					emmenagerDruide(nomVisiteur);
					break;

				case 2:
					emmenagerGaulois(nomVisiteur);
					break;

				default:
					System.out
							.println("Vous devez choisir le chiffre 1 ou 2 !");
					break;
				}
			} while (choixUtilisateur != 1 && choixUtilisateur != 2);
		}
	}

	private void emmenagerDruide(String nomVisiteur) {
		StringBuilder question = new StringBuilder();
		question.append("bienvenu druide "+nomVisiteur+"\n");
		question.append("Quelle est votre force ?\n");
		int choixUtilisateur = -1;
		do {
			choixUtilisateur = Clavier.entrerEntier(question.toString());
			
		}while (choixUtilisateur<0);
		int force = choixUtilisateur;
		
		question = new StringBuilder();
		question.append("Quelle est la force de potion la plus faible que vous produisez ?\n");
		choixUtilisateur = -1;
		StringBuilder questionMax = new StringBuilder();
		questionMax.append("Quelle est la force de potion la plus forte que vous produisez ?\n");
		int choixUtilisateurMax = -1;

		do {
			choixUtilisateur = Clavier.entrerEntier(question.toString());
			choixUtilisateurMax = Clavier.entrerEntier(question.toString());
			
		}while (choixUtilisateur<0 && choixUtilisateurMax<0 && choixUtilisateur<choixUtilisateurMax);
		int min = choixUtilisateur;
		int max = choixUtilisateurMax;
		
		controlEmmenager.ajouterDruide(nomVisiteur, force, min, max);
	}
	
	private void emmenagerGaulois(String nomVisiteur) {
		StringBuilder question = new StringBuilder();
		question.append("bienvenu villageois "+nomVisiteur+"\n");
		question.append("Quelle est votre force ?\n");
		int choixUtilisateur = -1;
		do {
			choixUtilisateur = Clavier.entrerEntier(question.toString());
			
		}while (choixUtilisateur<0);
		int force = choixUtilisateur;
		controlEmmenager.ajouterGaulois(nomVisiteur, force);

	}
}