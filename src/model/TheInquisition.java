package model;

import java.util.List;

import vue.vue1;


public class TheInquisition  implements IEffet {
	
	private boolean estJouable;
	private Carte card;
	private int nextPlayer;
	
	public boolean testWitch(List<Joueur> listJoueur, int tour, int accusation, int nbrJoueur, int compteurIdentiteDevoilee) {
		estJouable = false;
		//Il faut au moins une carte dans la main du joueur
		if(listJoueur.get(accusation-1).getEnMain().size() > 1) {
			estJouable = true;
		}
		return estJouable;
	}
	
	public int effetWitch(vue1 window, List<Joueur> listJoueur, List<Carte> Discard, int tour, int nbrJoueur, int tourAffichage, int compteurIdentiteRevelee, boolean win, int accusation) {
		MajCard.majCarte("The Inquisition", listJoueur, accusation);
		System.out.println("Effet Witch de The Inquisition : Discard + Take Next Turn");
		
		window.invisiblePanel();
		window.setPanelWitchInquisition(true);
		return accusation;
	}
	
	public boolean testHunt(List<Joueur> listJoueur, int tour, int nbrJoueur, int compteurIdentiteDevoilee, List<Carte> Discard) {
		estJouable = false;
		//Il faut que le joueur soit devoilé en tant que villageois
		//Il faut que le joueur accusé n'ait pas dévoilé son identité
		if(listJoueur.get(tour).getIdentite() == true && listJoueur.get(tour).getRole() == "Villageois") {
			for(int i = 0; i<nbrJoueur; i++) {
				if((i==tour)&&(i!=nbrJoueur-1)) {
					i++;
				}
				if(listJoueur.get(i).getIdentite() == false) {
					estJouable = true;
				}
			}
		}
		return estJouable;
	}
	
	public int effetHunt(vue1 window,List<Joueur> listJoueur, List<Carte> Discard, int tour, int nbrJoueur, int tourAffichage, int compteurIdentiteRevelee, boolean win, int accusation) {
		MajCard.majCarte("The Inquisition", listJoueur, (tour+1));
		System.out.println("Effet Hunt de The Inquisition : Choose Next Player + Look secretely Identity of the Next Player");
		/*
		nextPlayer = listJoueur.get(tour).selectPlayer(nbrJoueur, tour);
		Reveler.function(listJoueur, nextPlayer, true);
		*/
		
		window.invisiblePanel();
		window.setPanelTheInquisition(true);
		
		return nextPlayer-1;
	}
	
}
