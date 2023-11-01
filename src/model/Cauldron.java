package model;

import java.util.List;

import model.Reveler;
import vue.vue1;
import model.IEffet;
import model.Joueur;
import model.Carte;
import model.MajCard;

public class Cauldron implements IEffet {
	
	private boolean estJouable;
	private Carte card;
	private int nextPlayer;
	
	public boolean testWitch(List<Joueur> listJoueur, int tour, int accusation, int nbrJoueur, int compteurIdentiteDevoilee) {
		estJouable = false;
		//Il faut au moins une carte dans la main du joueur accuseur
		if(listJoueur.get(tour).getEnMain().size() > 0) {
			estJouable = true;
		}
		return estJouable;
	}
	
	public int effetWitch(vue1 window, List<Joueur> listJoueur, List<Carte> Discard, int tour, int nbrJoueur, int tourAffichage, int compteurIdentiteRevelee, boolean win, int accusation) {
		MajCard.majCarte("Cauldron", listJoueur, accusation);
		System.out.println("Effet Witch de Cauldron : Random Discard pour l'accuseur + Take Next Turn");
		card = listJoueur.get(accusation-1).selectCard(listJoueur, listJoueur.get(tour).getEnMain(), Discard, true, false, nbrJoueur, 0, tour);
		Discard.add(card);
		Jeu.getInstance().setTour(Jeu.getInstance().getAccusation()-1);
		window.invisiblePanel();
		window.setup();
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
		MajCard.majCarte("Cauldron", listJoueur, (tour+1));
		System.out.println("Effet Hunt de Cauldron : Reveal Your Identity");
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
