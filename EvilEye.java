package model;

import java.util.List;

import vue.vue1;


public class EvilEye implements IEffet {
	
	private boolean estJouable;
	private int nextPlayer;
	
	public boolean testWitch(List<Joueur> listJoueur, int tour, int accusation, int nbrJoueur, int compteurIdentiteDevoilee) {
		estJouable = true;
		return estJouable;
	}
	
	public int effetWitch(vue1 window, List<Joueur> listJoueur, List<Carte> Discard, int tour, int nbrJoueur, int tourAffichage, int compteurIdentiteRevelee, boolean win, int accusation) {
		MajCard.majCarte("Evil Eye", listJoueur, accusation);
		System.out.println("Effet Witch de Evil Eye : Choose Next Player + Accuse Other Player");
		window.invisiblePanel();
		window.setPanelChooseNextPlayer(true);
		return nextPlayer-1;
	}
	
	public boolean testHunt(List<Joueur> listJoueur, int tour, int nbrJoueur, int compteurIdentiteDevoilee, List<Carte> Discard) {
		estJouable = true;
		return estJouable;
	}
	
	public int effetHunt(vue1 window,List<Joueur> listJoueur, List<Carte> Discard, int tour, int nbrJoueur, int tourAffichage, int compteurIdentiteRevelee, boolean win, int accusation) {
		MajCard.majCarte("Evil Eye", listJoueur, (tour+1));
		System.out.println("Effet Hunt de Evil Eye : Choose Next Player + Accuse Other Player");
		window.invisiblePanel();
		window.setPanelChooseNextPlayer(true);
		return nextPlayer-1;
	}

}
