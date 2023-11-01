package model;

import java.util.List;

public class MVCReveler {
	
	public static int Reveler() {
		
		List<Joueur> listJoueur = Jeu.getInstance().getListJoueur();
		int accusation = Jeu.getInstance().getAccusation();
		int compteurIdentiteRevelee = Jeu.getInstance().getCompteurIdentiteRevelee();
		int tour = Jeu.getInstance().getTour();
		
		
		Reveler.function(listJoueur, accusation, false);
		compteurIdentiteRevelee++;
		Jeu.getInstance().setCompteurIdentiteRevelee(Jeu.getInstance().getCompteurIdentiteRevelee()+1);
		if(listJoueur.get(accusation-1).getRole()=="Sorcière") {
			Jeu.getInstance().getListJoueur().get(tour).setPoints(Jeu.getInstance().getListJoueur().get(tour).getPoints()+1);
			Jeu.getInstance().getListJoueur().get(accusation-1).setElimine(true);
		}
		else {
			Jeu.getInstance().setTour(accusation-1);
			tour = Jeu.getInstance().getTour();
			System.out.println("Le prochain joueur sera "+tour);
		}
		
		for(int i = 0; i<listJoueur.size(); i++) {
			System.out.println("Le joueur "+listJoueur.get(i).getNom()+" a "+listJoueur.get(i).getPoints());
		}
		
		return tour;
		
	}

}
