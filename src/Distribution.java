package model;

import java.util.Collections;
import java.util.List;


public abstract class Distribution {

	public static void function(List<Joueur> listJoueur, int nbrJoueur, int nbrCartes, List<Carte> Cartes, List<Carte> Discard) {
		Collections.shuffle(Cartes);
		for(int n=0;n<nbrJoueur;n++) {//Distribution des cartes
			for(int m=1;m<=nbrCartes;m++) {//m le nombre de carte par joueur, si le nbr de carte est égale à 5, on laisse les 2  cartes dans le tableau oklm			
				listJoueur.get(n).setEnMain(Cartes.get(0)); //On place dans la main du joueur le nom de la carte tirée au hasard
				Cartes.remove(0); //On retire la carte du tableau pour pas qu'il y ai de double
			}	
		}
		if(Cartes.isEmpty()==false) {
			for(int i = 0; i<Cartes.size(); i++) {
				Discard.add(Cartes.get(i));
			}
		}
	}
}
