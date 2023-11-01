package model;

import java.util.List;

import model.Joueur;

public abstract class ComptePoints {

	public static void function(int compteurIdentiteRevelee, int nbrJoueur, List<Joueur> listJoueur) {
		if(compteurIdentiteRevelee==nbrJoueur-1) { 
			
			//On cherche d'abord qui c'est
			for(int b=0;b<nbrJoueur;b++) {
				
				//Le joueur qui a son identité cachée
				if(listJoueur.get(b).getIdentite()==false) {
					
					//On vérifie son rôle
					//Si c'est une sorcière
					if(listJoueur.get(b).getRole()=="Sorcière") {
						
						//Le joueur gagne 2 points
						listJoueur.get(b).setPoints(listJoueur.get(b).getPoints()+2);
					}
					
					else {//Si le joueur est un villageois, il ne gagne qu'un point
						
						listJoueur.get(b).setPoints(listJoueur.get(b).getPoints()+1);
					}
				}
			}
		}
		
		System.out.println("Voici le compte des points");
		
		//Boucle qui affice les points de tous les joueurs
		for(int i=0;i<nbrJoueur;i++) {
			System.out.print("Le joueur numéro "+ (i+1));
			System.out.print(" a "+ listJoueur.get(i).getPoints());
			System.out.println(" points");
		}
	}
}
