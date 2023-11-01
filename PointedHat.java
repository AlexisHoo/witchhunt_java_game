package model;

import java.util.List;

import vue.vue1;


public class PointedHat implements IEffet {
	
	private boolean estJouable;
	private Carte card;
	private int nextPlayer;
	
	public boolean testWitch(List<Joueur> listJoueur, int tour, int accusation, int nbrJoueur, int compteurIdentiteDevoilee) {
		estJouable = false;
		//Il faut au moins une carte dans le jeu du joueur
		if(listJoueur.get(accusation-1).getEnJeu().size() > 0) {
			estJouable = true;
		}
		return estJouable;
	}
	
	public int effetWitch(vue1 window, List<Joueur> listJoueur, List<Carte> Discard, int tour, int nbrJoueur, int tourAffichage, int compteurIdentiteRevelee, boolean win, int accusation) {
		MajCard.majCarte("Pointed Hat", listJoueur, accusation);
		System.out.println("Effet Witch de Pointed Hat : Take in revealed carte + Take Next Turn");
		window.invisiblePanel();
		window.setPanelPointedHatWitch(true);
		return accusation;
	}
	
	public boolean testHunt(List<Joueur> listJoueur, int tour, int nbrJoueur, int compteurIdentiteDevoilee, List<Carte> Discard) {
		estJouable = false;
		//Il faut au moins une carte dans le jeu du joueur
		for(int i = 0; i<listJoueur.get(tour).getEnJeu().size(); i++) {
			if(listJoueur.get(tour).getEnJeu().get(i).getNom()!="Pointed Hat") {
				estJouable = true;
			}
		}
		return estJouable;
	}
	
	public int effetHunt(vue1 window,List<Joueur> listJoueur, List<Carte> Discard, int tour, int nbrJoueur, int tourAffichage, int compteurIdentiteRevelee, boolean win, int accusation) {
		MajCard.majCarte("Pointed Hat", listJoueur, (tour+1));
		System.out.println("Effet Hunt de Pointed Hat : Take in revealed carte + Choose Next Player");
		window.invisiblePanel();
		window.setPanelPointedHatHunt(true);
		return nextPlayer-1;
	}

}
