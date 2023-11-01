package model;

import java.util.ArrayList;
import java.util.List;

public abstract class MVCDeclareJoueur extends Jeu{

	public static List<Joueur> declarerJoueurMVC() {
		
		int nbrJoueur=Jeu.getInstance().getNbrJoueur();
		List<Joueur> listJoueur=new ArrayList<Joueur>();
		List<String> nomJoueur=new ArrayList<String>();
		
		nomJoueur.add(Jeu.getInstance().getNom1());
		nomJoueur.add(Jeu.getInstance().getNom2());
		nomJoueur.add(Jeu.getInstance().getNom3());
		nomJoueur.add(Jeu.getInstance().getNom4());
		nomJoueur.add(Jeu.getInstance().getNom5());
		nomJoueur.add(Jeu.getInstance().getNom6());
		
		
		//On créée les joueurs
		for(int i=0;i<nbrJoueur;i++) {
			listJoueur.add(new Joueur(nomJoueur.get(i),0, nbrJoueur));
			listJoueur.get(i).setStrategy(new DefaultStrategy());
			//System.out.println("Joueur "+(i+1)+": "+Jeu.getInstance().getListJoueur().get(i).getNom());
		}
		return listJoueur;
	}
}
