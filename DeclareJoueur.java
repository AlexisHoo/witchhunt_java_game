package model;

import model.BotDifficile;
import model.BotFacile;
import model.Joueur;
import model.DefaultStrategy;

import java.util.*;

public abstract class DeclareJoueur {
	
	private static List<Joueur> listJoueur=new ArrayList<Joueur>();
	private static List<String> nomJoueur=new ArrayList<String>();
	private static String nom;
	private static int choixDifficulte=1;
	
	public static List<Joueur> function(int nbrJoueur, int nbrJoueurPhysique) {
		
		Scanner scan = new Scanner(System.in);
		
		//On demande le nom des joueurs
		for(int i=1;i<=nbrJoueurPhysique;i++) {
			System.out.println("Joueur "+i+", quel nom souhaitez-vous avoir?");
			nom=scan.next();
			nomJoueur.add(nom);
		}
		
		//On créée les joueurs
		for(int i=0;i<nbrJoueurPhysique;i++) {
			listJoueur.add(new Joueur(nomJoueur.get(i),0, nbrJoueur));
			listJoueur.get(i).setStrategy(new DefaultStrategy());
			System.out.println("Joueur "+(i+1)+": "+listJoueur.get(i).getNom());
		}
		
		//on créée les bots
		for(int i=nbrJoueurPhysique;i<nbrJoueur;i++) {
			
			//On initialise à 1--> bot facile par défaut
			if(nbrJoueur!=nbrJoueurPhysique) {
				//On demande la difficulté des bots
				System.out.println("Choisissez la difficulté:");
				System.out.println("Facile(1), Difficile(2)");
				choixDifficulte=2;
				/*
				try {
					choixDifficulte=scan.nextInt();
				}
				catch(InputMismatchException e) {
				    System.out.println("Erreur c'est un string !");
				    scan.nextLine();
				}
				*/
				
				//Sécurité
				while((choixDifficulte!=1) && (choixDifficulte!=2)) {
					System.out.println("Choisissez la difficulté:");
					System.out.println("Facile(1), Difficile(2)");
					try {
						choixDifficulte=scan.nextInt();
					}
					catch(InputMismatchException e) {
					    System.out.println("Erreur c'est un string !");
					    scan.nextLine();
					}
				}
			}
			
			//Le bot est soit en mode facile ou difficile
			if(choixDifficulte==1) {
				nomJoueur.add("Bot Facile");
				listJoueur.add(new Joueur(nomJoueur.get(i),0,nbrJoueur));
				listJoueur.get(i).setStrategy(new BotFacile());
			}
			else {
				nomJoueur.add("Bot Difficile");
				listJoueur.add(new Joueur(nomJoueur.get(i),0,nbrJoueur));
				listJoueur.get(i).setStrategy(new BotDifficile());
			}
			System.out.println("Joueur / Bot "+(i+1)+": "+listJoueur.get(i).getNom());
		}
		
		return listJoueur;
	}
	
	
	
}
