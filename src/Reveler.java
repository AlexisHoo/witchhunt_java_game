package model;

import java.util.*;

public abstract class Reveler {
	
	public static void function(List<Joueur> listJoueur, int Joueur, boolean secret) {
		System.out.println("L'identité du joueur "+Joueur+" est "+listJoueur.get(Joueur-1).getRole());
		if(secret==false) {
			listJoueur.get(Joueur-1).setIdentite(true);
		}
	}

}
