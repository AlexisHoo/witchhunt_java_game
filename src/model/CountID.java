package model;
import java.util.*;

import model.Joueur;

public abstract class CountID {
	
	

	public static int function(List<Joueur> listJoueur, int nbrJoueur){
		
		int count=0;
		
		//On parcourt les joueurs
		for(int i=0;i<nbrJoueur;i++) {
			//Si l'identté du joueur a été révélée
			if(listJoueur.get(i).getIdentite()==true) {
				
				//On incrémente le compteur
				count++;
			}
		}
		return count;
	}
}
