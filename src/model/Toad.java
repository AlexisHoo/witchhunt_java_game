package model;

import java.util.List;

import vue.vue1;


public class Toad implements IEffet {
	
	private boolean estJouable;
	private int nextPlayer;
	
	public boolean testWitch(List<Joueur> listJoueur, int tour, int accusation, int nbrJoueur, int compteurIdentiteDevoilee) {
		estJouable = true;
		return estJouable;
	}
	
	public int effetWitch(vue1 window, List<Joueur> listJoueur, List<Carte> Discard, int tour, int nbrJoueur, int tourAffichage, int compteurIdentiteRevelee, boolean win, int accusation) {
		MajCard.majCarte("Toad", listJoueur, accusation);
		System.out.println("Effet Witch de Toad : Take Next Turn");
		Jeu.getInstance().setTour(Jeu.getInstance().getAccusation()-1);
		window.invisiblePanel();
		window.setPanelRecap(true);
		return accusation;
	}
	
	public boolean testHunt(List<Joueur> listJoueur, int tour, int nbrJoueur, int compteurIdentiteDevoilee, List<Carte> Discard) {
		estJouable = false;
		//Il faut que le joueur ait son identité caché
		if(listJoueur.get(tour).getIdentite() == false) {
			estJouable = true;
		}
		return estJouable;
	}
	
	public int effetHunt(vue1 window,List<Joueur> listJoueur, List<Carte> Discard, int tour, int nbrJoueur, int tourAffichage, int compteurIdentiteRevelee, boolean win, int accusation) {
		MajCard.majCarte("Toad", listJoueur, (tour+1));
		System.out.println("Effet Hunt de Toad : Reveal Your Identity");
		Reveler.function(listJoueur, (tour+1), false);
		if(listJoueur.get(tour).getRole()=="Sorcière") {
			listJoueur.get(tour).setElimine(true);
			Jeu.getInstance().setTour(tour+1);
			window.invisiblePanel();
			window.setup();
			window.setPanelRecap(true);
			return tour;
		}
		else {
			window.invisiblePanel();
			window.setPanelChooseNextPlayer(true);
			return nextPlayer-1;
		}
	}
	
}
