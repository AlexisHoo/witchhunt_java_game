package model;

import java.util.List;

import model.IEffet;
import model.Joueur;
import model.Carte;
import model.MajCard;
import vue.vue1;

public class BlackCat implements IEffet {
	
	private boolean estJouable;
	private Carte card;
	
	public boolean testWitch(List<Joueur> listJoueur, int tour, int accusation, int nbrJoueur, int compteurIdentiteDevoilee) {
		estJouable = true;
		return estJouable;
	}
	
	public int effetWitch(vue1 window, List<Joueur> listJoueur, List<Carte> Discard, int tour, int nbrJoueur, int tourAffichage, int compteurIdentiteRevelee, boolean win, int accusation) {
		MajCard.majCarte("Black Cat", listJoueur, accusation);
		System.out.println("Effet Witch de Black Cat : Take Next Turn");
		Jeu.getInstance().setTour(Jeu.getInstance().getAccusation()-1);
		window.invisiblePanel();
		window.setPanelRecap(true);
		return accusation;
	}
	
	public boolean testHunt(List<Joueur> listJoueur, int tour, int nbrJoueur, int compteurIdentiteDevoilee, List<Carte> Discard) {
		estJouable = false;
		//Il faut au moins une carte dans Discard
		if(Discard.size() > 0) {
			estJouable = true;
		}
		return estJouable;
	}
	
	public int effetHunt(vue1 window,List<Joueur> listJoueur, List<Carte> Discard, int tour, int nbrJoueur, int tourAffichage, int compteurIdentiteRevelee, boolean win, int accusation) {
		MajCard.majCarte("Black Cat", listJoueur, (tour+1));
		System.out.println("Effet Hunt de Black Cat : Take in Discarded and discard Black Cat + Take Next turn");
		window.invisiblePanel();
		window.setPanelBlackCat(true);
		return tour;
	}
	
}
