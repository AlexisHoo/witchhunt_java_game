package model;

import java.util.ArrayList;

import javax.swing.JTextField;

public abstract class MVCDistribution {
	
	public static void Distribution(JTextField textJ1, JTextField textJ2, JTextField textJ3, JTextField textJ4, JTextField textJ5, JTextField textJ6) {
		
		Jeu.getInstance().setNom1(textJ1);
		Jeu.getInstance().setNom2(textJ2);
		Jeu.getInstance().setNom3(textJ3);
		Jeu.getInstance().setNom4(textJ4);
		Jeu.getInstance().setNom5(textJ5);
		Jeu.getInstance().setNom6(textJ6);
		
		//On déclare les joueurs dans la liste joueur
		Jeu.getInstance().setListJoueur(MVCDeclareJoueur.declarerJoueurMVC());
		
		//System.out.println("Prenom joueur 2 : "+Jeu.getInstance().getListJoueur().get(1).getNom());
		
		System.out.println("Debut du round");
		System.out.println("Le nombre d'identité devoilée est "+ Jeu.getInstance().getCompteurIdentiteRevelee());
		
		//Liste de carte dans laquelle on déclare les cartes du jeu 
		Jeu.getInstance().setCartes(DeclareCarte.function());
		Jeu.getInstance().setDiscard(new ArrayList<Carte>());
		Jeu.getInstance().setListJeux(new ArrayList<Carte>());
		
		//Declaration des liste pour PetNewt
		Jeu.getInstance().setListJeux(new ArrayList<Carte>());
		Jeu.getInstance().setListJoueurJeux(new ArrayList<Integer>());

		//On remets à zéro les cartes enMain et enJeu des joueurs s'ils viennent de jouer un round et on remets les identite à false
		for(int i=0;i<Jeu.getInstance().getNbrJoueur();i++) {
			Jeu.getInstance().getListJoueur().get(i).getEnMain().clear();
			Jeu.getInstance().getListJoueur().get(i).getEnJeu().clear();
			Jeu.getInstance().getListJoueur().get(i).setIdentite(false);
			Jeu.getInstance().getListJoueur().get(i).setElimine(false);
			
			//Pour les joueurs qui ont été inciblable on baisse leurs scores de 1
			//Comme ça il est inciblable le nombre de tour choisis
			//Si on fait listJoueur.get(i).incicblable=5; le joueur est inciblable 4 tours
			if(Jeu.getInstance().getListJoueur().get(i).getInciblable()!=0) {	
				Jeu.getInstance().getListJoueur().get(i).setInciblable(Jeu.getInstance().getListJoueur().get(i).getInciblable()-1);
			}
		}
		
		//Initialisation Game
		Jeu.getInstance().setTour(0);//Variable qui va servir à déterminer quel joueur va jouer (si tour==4) alors le joueur 5 va jouer (car tableau)
		Jeu.getInstance().setCompteurIdentiteRevelee(0);//Détermine le nbr d'identitée révelée
		Jeu.getInstance().setNbrCartes(12/Jeu.getInstance().getNbrJoueur());//Détermine le nbr de cartes par joueur
		Jeu.getInstance().setReset(false);
		
		System.out.println("Le nombre d'identité devoilée est maintenant "+Jeu.getInstance().getCompteurIdentiteRevelee());
		
		System.out.println("Nombre de cartes par joueur : "+Jeu.getInstance().getNbrCartes());
		
		//Distribution
		Distribution.function(Jeu.getInstance().getListJoueur(), Jeu.getInstance().getNbrJoueur(), Jeu.getInstance().getNbrCartes(), Jeu.getInstance().getCartes(), Jeu.getInstance().getDiscard());
		
		//Affichage des cartes des joueurs
		for(int i=0;i<Jeu.getInstance().getNbrJoueur();i++) {//Parcours le nombre de joueurs
			System.out.println("Main joueur "+ (i+1)); //On affiche leurs mains
			System.out.println(Jeu.getInstance().getListJoueur().get(i));
		}
	}

}
