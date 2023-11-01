package model;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import vue.vue1;

public class DuckingStool implements IEffet {
	
	private boolean estJouable;
	private boolean hasWart;
	private Carte card;
	private int nextPlayer;
	private int player;
	private int choice;
	
	public boolean testWitch(List<Joueur> listJoueur, int tour, int accusation, int nbrJoueur, int compteurIdentiteDevoilee) {
		estJouable = true;
		return estJouable;
	}
	
	public int effetWitch(vue1 window, List<Joueur> listJoueur, List<Carte> Discard, int tour, int nbrJoueur, int tourAffichage, int compteurIdentiteRevelee, boolean win, int accusation) {
		MajCard.majCarte("Ducking Stool", listJoueur, accusation);
		System.out.println("Effet Witch de Ducking Stool : Choose Next Player");
		window.invisiblePanel();
		window.setPanelChooseNextPlayer(true);
		return 1;
	}
	
	public boolean testHunt(List<Joueur> listJoueur, int tour, int nbrJoueur, int compteurIdentiteDevoilee, List<Carte> Discard) {
		estJouable = false;
		//Il faut soit que l'identité du joueur accusé soit caché
        //soit qu'il y ait une carte dans la main du joueur accusé
		for(int i=0; i<nbrJoueur; i++) {
			if(i==tour && i==nbrJoueur-1) {
				break;
			}
			else if(i==tour) {
				i++;
			}
			hasWart = false;
			for(int j = 0; j<listJoueur.get(i).getEnJeu().size(); j++) {
				if(!listJoueur.get(i).getEnJeu().isEmpty()==false) {
					if(listJoueur.get(i).getEnJeu().get(j).getNom() != "Wart") {
						hasWart = false;
					}
					else hasWart = true;
				}
			}
			if(hasWart == false) {
				if(listJoueur.get(i).getIdentite() == false || listJoueur.get(i).getEnMain().size() > 0) {
					estJouable = true;
				}
			}
			else {
				System.out.println("Vous ne pouvez pas jouer l'effet Hunt de Angry Mob sur le joueur "+i+" car son jeu comporte Wart");
			}
		}
		return estJouable;
	}
	
	public int effetHunt(vue1 window,List<Joueur> listJoueur, List<Carte> Discard, int tour, int nbrJoueur, int tourAffichage, int compteurIdentiteRevelee, boolean win, int accusation) {
		MajCard.majCarte("Ducking Stool", listJoueur, (tour+1));
		System.out.println("Effet Hunt de Ducking Stool : Choose Player -> choice between Reveal identity or Discard");
		
		//On ouvre le bon panel
		window.invisiblePanel();
		window.setPanelDuckingStool(true);
		
		
		return 1;
	}

}
