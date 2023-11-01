package model;
import java.util.List;

import vue.vue1;

public class AngryMob implements IEffet {
	
	private boolean estJouable;
	private boolean hasBroomstick;
	public boolean testWitch(List<Joueur> listJoueur, int tour, int accusation, int nbrJoueur, int compteurIdentiteDevoilee) {
		estJouable = true;
		return estJouable;
	}
	
	public int effetWitch(vue1 window, List<Joueur> listJoueur, List<Carte> Discard, int tour, int nbrJoueur, int tourAffichage, int compteurIdentiteRevelee, boolean win, int accusation) {
		MajCard.majCarte("Angry Mob", listJoueur, accusation);
		System.out.println("Effet Witch de Angry Mob : Take Next Turn");
		Jeu.getInstance().setTour(Jeu.getInstance().getAccusation()-1);
		window.invisiblePanel();
		window.setup();
		window.setPanelRecap(true);
		return accusation;
	}
	
	public boolean testHunt(List<Joueur> listJoueur, int tour, int nbrJoueur, int compteurIdentiteDevoilee, List<Carte> Discard) {
		estJouable = false;
		//Il faut que le joueur soit dévoilé en tant que villageois
		if(listJoueur.get(tour).getIdentite()==true && listJoueur.get(tour).getRole()=="Villageois") {
			for(int i = 0; i<nbrJoueur; i++) {
				if(i==tour && i==nbrJoueur-1) {
					break;
				}
				else if(i==tour) {
					i++;
				}
				hasBroomstick = false;
				for(int j = 0; j<listJoueur.get(i).getEnJeu().size(); j++) {
					if(!listJoueur.get(i).getEnJeu().isEmpty()==false) {
						if(listJoueur.get(i).getEnJeu().get(j).getNom() != "Broomstick") {
							hasBroomstick = false;
						}
						else hasBroomstick = true;
					}
				}
				if(hasBroomstick == false) {
					estJouable = true;
				}
				else {
					System.out.println("Vous ne pouvez pas jouer l'effet Hunt de Angry Mob sur le joueur "+i+" car son jeu comporte Broomstick");
				}
			}
		}
		return estJouable;
	}
	
	public int effetHunt(vue1 window,List<Joueur> listJoueur, List<Carte> Discard, int tour, int nbrJoueur, int tourAffichage, int compteurIdentiteRevelee, boolean win, int accusation) {
		MajCard.majCarte("Angry Mob", listJoueur, (tour+1));
		System.out.println("Effet Hunt de Angry Mob : Reveal Another Identity");
		
		window.invisiblePanel();
		window.setPanelAngryMob(true);
		return tour;
	}

}
