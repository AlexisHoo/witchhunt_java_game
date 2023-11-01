package model;

import java.util.List;

import vue.vue1;

public class HookedNose implements IEffet {
	
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
		MajCard.majCarte("Hooked Nose", listJoueur, accusation);
		System.out.println("Effet Witch de Hooked Nose : Take in accuseur cartes + Take Next Turn");
		
		window.invisiblePanel();
		window.setPanelHookedNoseWitch(true);
		return accusation;
	}
	
	public boolean testHunt(List<Joueur> listJoueur, int tour, int nbrJoueur, int compteurIdentiteDevoilee, List<Carte> Discard) {
		estJouable = false;
		//Il faut que au moins une carte dans la main du joueur accusé
		for(int i=0; i<nbrJoueur; i++) {
			if(i==tour && i==nbrJoueur-1) {
				break;
			}
			else if(i==tour) {
				i++;
			}
			if(listJoueur.get(i).getEnMain().size() > 0) {
				estJouable = true;
			}
		}
		return estJouable;
	}
	
	public int effetHunt(vue1 window,List<Joueur> listJoueur, List<Carte> Discard, int tour, int nbrJoueur, int tourAffichage, int compteurIdentiteRevelee, boolean win, int accusation) {
		MajCard.majCarte("Hooked Nose", listJoueur, (tour+1));
		System.out.println("Effet Hunt de Hooked Nose : Choose Next Player + Take Random Card in Next Player Hand");
		
		window.invisiblePanel();
		window.setPanelHookedNose(true);
		
		return 1;
	}
	
}
