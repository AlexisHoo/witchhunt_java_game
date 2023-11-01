package model;
import java.util.*;

public class MajCard {

	public static void majCarte(String nom, List<Joueur> listJoueur, int numJoueur) {
		
		//Reherche carte dans la main du joueur
		for(int i=0;i<listJoueur.get(numJoueur-1).getEnMain().size();i++) {
			if(listJoueur.get(numJoueur-1).getEnMain().get(i).getNom()==nom) {//Quand la carte correspond 
				listJoueur.get(numJoueur-1).setEnJeu(listJoueur.get(numJoueur-1).getEnMain().get(i));//On place la carte dans le tableau enJeu pour montrer que la carte est utilisée
				listJoueur.get(numJoueur-1).getEnMain().remove(i);//On supprime la carte de la main du joueur
			}
		}
	}
}
