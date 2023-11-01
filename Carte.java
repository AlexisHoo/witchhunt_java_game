package model;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import vue.vue1;

public class Carte{
	
	private String nom;
	private IEffet strategy;
	private boolean estJouable;
	private boolean test;
	private int choixCarteARetirer=7;//Pour la méthode choisircarte
	
	//Getter
	public String getNom() {
		return nom;
	}
	
	//Constructeur
	public Carte(String nom) {
		this.nom = nom;
	}
	
	//Interface
	public void setStrategy(IEffet strategy) {
		this.strategy=strategy;
	}
	
	public boolean testWitch(List<Joueur> listJoueur, int tour, int accusation, int nbrJoueur, int compteurIdentiteDevoilee) {
		estJouable = strategy.testWitch(listJoueur, tour, accusation, nbrJoueur, compteurIdentiteDevoilee);
		return estJouable;
	}
	
	public int effetWitch(vue1 window, List<Joueur> listJoueur, List<Carte> Discard, int tour, int nbrJoueur, int tourAffichage, int compteurIdentiteRevelee, boolean win, int accusation) {
		tour = strategy.effetWitch(window, listJoueur, Discard, tour, nbrJoueur, tourAffichage, compteurIdentiteRevelee, win, accusation);
		return tour;
	}
	
	public boolean testHunt(List<Joueur> listJoueur, int tour, int nbrJoueur, int compteurIdentiteDevoilee, List<Carte> Discard) {
		estJouable = strategy.testHunt(listJoueur, tour, nbrJoueur, compteurIdentiteDevoilee, Discard);
		return estJouable;
	}
	
	public int effetHunt(vue1 window,List<Joueur> listJoueur, List<Carte> Discard, int tour, int nbrJoueur, int tourAffichage, int compteurIdentiteRevelee, boolean win, int accusation) {
		tour = strategy.effetHunt(window, listJoueur, Discard, tour, nbrJoueur, tourAffichage, compteurIdentiteRevelee, win, accusation);
		return tour;
	}
	
	//Pour vérifier si la carte peut être jouée
	public boolean test(List<Joueur> listJoueur, int numJoueur) {
				
		//Si la carte jouée est ANgry Mob
		if(this.nom=="Pointed Hat") {
			
			//Si le joueur a au mins une carte dans enJeu
			if(listJoueur.get(numJoueur).getEnJeu().size()>=1) {
				
				//Alors il peut jouer la carte
				test=true;
			}
			//Sinon il ne peut pas jouer la carte
			else {
				test=false;
			}
		}
		else {
			test=true;
		}
		return test;
	}
	
	//Sert à retirer la carte de enMain pour la mettre dans enJeu
	public void majCarte(String nom, List<Joueur> listJoueur, int numJoueur) {
		
		//Reherche carte dans la main du joueur
		for(int i=0;i<listJoueur.get(numJoueur).getEnMain().size();i++) {
			if(listJoueur.get(numJoueur).getEnMain().get(i).nom==nom) {//Quand la carte correspond 
				listJoueur.get(numJoueur).setEnJeu(listJoueur.get(numJoueur).getEnMain().get(i));//On place la carte dans le tableau enJeu pour montrer que la carte est utilisée
				listJoueur.get(numJoueur).getEnMain().remove(i);//On supprime la carte de la main du joueur
			}
		}
	}
	
	public int choisirCarte(List<Joueur> listJoueur, int tour) {
		System.out.println("Choisissez une carte à retirer");
		
		Scanner scanner= new Scanner(System.in);//On ouvre le scan car on est dans une classe
		
		for(int i=0; i<listJoueur.get(tour).getEnMain().size(); i++) {//Boucle qui parcourt la main du joueur
			System.out.print("Tapez "+ i);
			System.out.println(" pour: "+ listJoueur.get(tour).getEnMain().get(i).nom);
		}
		
		try {
			choixCarteARetirer=scanner.nextInt();
		}
		catch(InputMismatchException e) {
		    System.out.println("Erreur c'est un string !");
		    scanner.nextLine();
		}
		
		//Mise en place de la sécurité
		while(choixCarteARetirer<0 || choixCarteARetirer>listJoueur.get(tour).getEnMain().size()) {//Vérification, si le choix pointe vers un slot existant
			System.out.println("Quelle carte souhaitez vous jouer parmis celles-ci ?(votre main)");
				
			for(int i=0; i<listJoueur.get(tour).getEnMain().size(); i++) {//Boucle qui parcourt la main du joueur	
				System.out.print("Tapez"+ i);
				System.out.println("pour: "+ listJoueur.get(tour).getEnMain().get(i));
			}//Prochain objectif:utiliser collection pour les cartes en main et en jeu car c'est dynamique (on peut faire enMain.add(''jkj'') pour ajouter un élément trop bien)
		
			try {
				choixCarteARetirer=scanner.nextInt();
			}
			catch(InputMismatchException e) {
			    System.out.println("Erreur c'est un string !");
			    scanner.nextLine();
			}
		}
		
		//Fin sécurité
		return choixCarteARetirer;
	}
	
	public void revelerIdentite(int compteurIdentiteRevelee, List<Joueur> listJoueur, int joueur) {
		compteurIdentiteRevelee++; //On incrémente le le compteur qui permet d'arrêter le round
		listJoueur.get(joueur-1).setIdentite(true); //On spécifie que son identité est révélée
		System.out.print("L'identite du joueur numero "+joueur);//On affiche à tout le monde son identité
		System.out.println(" est: "+ listJoueur.get(joueur-1).getRole());
		System.out.println("Le nbr d'identités révélées est: "+ compteurIdentiteRevelee);
	}
}

//Pour les effets Hunt! faut utiliser le même système de test par exemple avec les carte Broomstick et Wart 
//Si on joue carte Angry Mob en Hunt et que le joueur accusé a dans enJeu la carte Broomstick, on renvoie test==false
