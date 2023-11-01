package model;

import java.util.List;

import vue.vue1;


public class PetNewt implements IEffet {
	
	private boolean estJouable;
	private Carte card;
	private int nextPlayer;
	
	public boolean testWitch(List<Joueur> listJoueur, int tour, int accusation, int nbrJoueur, int compteurIdentiteDevoilee) {
		estJouable = true;
		return estJouable;
	}
	
	public int effetWitch(vue1 window, List<Joueur> listJoueur, List<Carte> Discard, int tour, int nbrJoueur, int tourAffichage, int compteurIdentiteRevelee, boolean win,  int accusation) {
		MajCard.majCarte("Pet Newt", listJoueur, accusation);
		System.out.println("Effet Witch de Pet Newt : Take Next Turn");
		Jeu.getInstance().setTour(Jeu.getInstance().getAccusation()-1);
		window.invisiblePanel();
		window.setPanelRecap(true);
		return accusation;
	}
	
	public boolean testHunt(List<Joueur> listJoueur, int tour, int nbrJoueur, int compteurIdentiteDevoilee, List<Carte> Discard) {
		estJouable = false;
		//Il faut au moins une carte dans le jeu d'un joueur
		for(int i=0; i<nbrJoueur; i++) {
			if((i==tour)&&(i!=nbrJoueur-1)) {
				i++;
			}
			if(listJoueur.get(i).getEnJeu().size() > 0) {
				estJouable = true;
			}
		}
		return estJouable;
	}
	
	public int effetHunt(vue1 window,List<Joueur> listJoueur, List<Carte> Discard, int tour, int nbrJoueur, int tourAffichage, int compteurIdentiteRevelee, boolean win, int accusation) {
		MajCard.majCarte("Pet Newt", listJoueur, (tour+1));
		System.out.println("Effet Hunt de Pet Newt : Take Reveal Card from any other Player + Choose Next Player");
		Jeu.getInstance().remplirListJeux();
		
		window.invisiblePanel();
		window.setPanelPetNewt(true);
		return nextPlayer-1;
	}
	
}
