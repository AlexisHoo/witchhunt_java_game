package model;
import java.util.*;

import javax.swing.JTextField;

public class DefaultStrategy implements IStrategy{
	
	private int action=3;//Pour la m�thode choixJoueur pour choisir si le joueur veut accuser ou jouer Hunt
	private int choixRole=7;//Pour la m�thode choisirrole
	private boolean stop=true;//Pour la m�thode demandeChoixJoueur
	private int accusation=7;//Pour la m�thode demandeChoixJoueur
	private int choixCarte=7;//Pour la m�thode demandechoixCarte
	private int choixJoueurAccuse=7;//Pour la m�thode demandeChoixJoueurAccuse
	private Carte selectCarte;//Pour la m�thode selectCard
	private int selection=7;//Pour la m�thode selectCard
	private int joueur;//Pour la m�thode selectCard
	private int selectPlayer=7;//Pour la m�thode selectPlayer
	
	public void MVCAccuse(int joueur) {
		Jeu.getInstance().getListJoueur().get(joueur-1).setAction(1);
	}
	
	public void MVCHunt(int joueur) {
		Jeu.getInstance().getListJoueur().get(joueur-1).setAction(2);
	}
	
	//Fonction pour demander le choix du joueur qui joue le tour 
	public int choixJoueur(List<Joueur> listJoueur, int tour, int nbrJoueur) {
		Scanner scan = new Scanner(System.in);
		System.out.print("Joueur numero "+ (tour+1));
		System.out.println(", veuillez choisir votre action:1(Accusez quelqu'un) 2(Jouer une carte Hunt!)");
		try {
			action=scan.nextInt();
		}
		catch(InputMismatchException e) {
		    System.out.println("Erreur c'est un string !");
		    scan.nextLine();
		}
		while(action<1 || action>2) {//Pour �viter les erreurs
			
			System.out.println("Veuillez s�lectionner 1 ou 2");
			System.out.println("Veuillez choisir votre action:1(Accusez quelqu'un) 2(Jouer une carte Hunt!)");
			try {
				action=scan.nextInt();
			}
			catch(InputMismatchException e) {
			    System.out.println("Erreur c'est un string !");
			    scan.nextLine();
			}
		}
		//scan.close();
		return action;
	}
	
	public void MVCchoisirRoleWitcher(int joueur) {
		Jeu.getInstance().getListJoueur().get(joueur-1).setRole("Sorci�re");
	}
	
	public void MVCchoisirRoleHunter(int joueur) {
		Jeu.getInstance().getListJoueur().get(joueur-1).setRole("Hunter");
	}
	
			
	//Choisis le r�le 
	public void choisirRole (int n,  int j, List<Joueur> listJoueur) {//Permet de saisir le r�le du joueur en question
		System.out.print("Joueur numero "+ j);//On demande son choix
		System.out.println(", veuillez choisir votre role! 1(Witch) 2(Villageaois)");
		Scanner scann= new Scanner(System.in);//On ouvre le scan car on est dans une classe
		try {
			choixRole=scann.nextInt();
		}
		catch(InputMismatchException e) {
		    System.out.println("Erreur c'est un string !");
		    scann.nextLine();
		}
		
		while(choixRole<1 || choixRole>2) {//S�curit� pour v�rifier que c'est bien 1 ou 2
			
			System.out.println("Veuillez saisir 1 ou 2");
			System.out.print("Joueur numero "+ j);
			System.out.println(", veuillez choisir votre role! 1(Witch) 2(Villageaois)");
			try {
				choixRole=scann.nextInt();
			}
			catch(InputMismatchException e) {
			    System.out.println("Erreur c'est un string !");
			    scann.nextLine();
			}
		}
		
		if (choixRole==1) {// Si le choix est sorci�re
			listJoueur.get(n).setRole("Sorci�re");
		}
		else {//Si le choix est Villageois
			listJoueur.get(n).setRole("Villageois");
		}
		
		System.out.println("Role du joueur numero "+ j);//Affichage du r�le pour v�rifier que � fonctionne bien
		System.out.println(listJoueur.get(n).getRole());
	}
		
	//Fonction pour demander quelle personne le joueur qui joue veut accuser
	public int demandeChoixJoueur(List<Joueur> listJoueur, int nbrJoueur, int tour) {
		Scanner scan = new Scanner(System.in);
		
		//On demande quel joueur il veut accuser
		System.out.println("Veuillez choisir la personne que vous accusez (indiquez le num�ro du joueur)");
		try {
			accusation=scan.nextInt();
		}
		catch(InputMismatchException e) {
		    System.out.println("Erreur c'est un string !");
		    scan.nextLine();
		}
		
		//On check si �a rempli les conditions
		if(accusation>0 && accusation<=nbrJoueur && accusation != tour+1) {
			
			//on check si l'identit� d'un jouer est d�j� r�v�l�e
			if(listJoueur.get(accusation-1).getIdentite()==true) {
				stop=false;
			}
		}
		
		//S�curit� qui r�it�re la demande jusqu'� ce que se soit valide
		while((accusation>nbrJoueur) || (accusation<1) || (accusation==tour+1) || (stop==false)) {//Check si le joueur n'accuse pas lui m�me ou un jour qui n'existe pas ou que le joueur qui est accus� n'a pas d�j� une identit� r�v�l�e d�j� 
			System.out.println("Veuillez saisir un joueur qui existe et qui n'a pas son identit� revelee(ni vous m�me !)");
			System.out.println("Veuillez choisir la personne que vous accusez (indiquez le num�ro du joueur)");
			try {
				accusation=scan.nextInt();
				
			}
			catch(InputMismatchException e) {
			    System.out.println("Erreur c'est un string !");
			    scan.nextLine();
			}
			
			if(accusation>0 && accusation<=nbrJoueur && accusation != tour+1) {
				
				if(listJoueur.get(accusation-1).getIdentite()==true) {
					stop=false;
				}
				else {
					stop=true;
				}
			}
		}
		return accusation--;
	}
	
	//Fonction pour demander le choix de la carte du joueur qui est accus� (joue une carte witch)
	public int demandeChoixCarte(List<Joueur> listJoueur, int numJoueur, int essai) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Quelle carte souhaitez vous jouer parmis celles-ci ?(votre main)");
		
		for(int i=0; i<listJoueur.get(numJoueur).getEnMain().size(); i++) {//Boucle qui parcourt la main du joueur
			System.out.print("Tapez "+ i);
			System.out.println(" pour: "+ listJoueur.get(numJoueur).getEnMain().get(i).getNom());
		}
		
		//L'utilisateur saisit son choix
		try {
			choixCarte=scan.nextInt();
		}
		catch(InputMismatchException e) {
		    System.out.println("Erreur c'est un string !");
		    scan.nextLine();
		}
		
		//Mise en place de la s�curit�
		while(choixCarte<0 || choixCarte>listJoueur.get(numJoueur).getEnMain().size()) {//V�rification, si le choix pointe vers un slot existant
			System.out.println("Quelle carte souhaitez vous jouer parmis celles-ci ?(votre main)");
				
			for(int i=0; i<listJoueur.get(numJoueur).getEnMain().size(); i++) {//Boucle qui parcourt la main du joueur
				System.out.print("Tapez"+ i);
				System.out.println("pour: "+ listJoueur.get(numJoueur).getEnMain().get(i));
			}//Prochain objectif:utiliser collection pour les cartes en main et en jeu car c'est dynamique (on peut faire enMain.add(''jkj'') pour ajouter un �l�ment trop bien)
		
			try {
				choixCarte=scan.nextInt();
			}
			catch(InputMismatchException e) {
			    System.out.println("Erreur c'est un string !");
			    scan.nextLine();
			}
		}
		//Fin s�curit�
		return choixCarte;
	}
	
	//Fonction pour demander le choix du joueur qui est accus�
	public int demandeChoixJoueurAccuse(List<Joueur> listJoueur, int numJoueur ) {
		Scanner scan = new Scanner(System.in);
		//Saisir l'action du joueur accus�
		System.out.println("Vous accusez le joueur "+ numJoueur);
		System.out.print("Joueur num�ro "+numJoueur);
		System.out.println(",que souhaitez vous faire ? 1(Reveler votre identite) 2(Jouer carte Witch?)");
		
		try {
			choixJoueurAccuse=scan.nextInt();
		}
		catch(InputMismatchException e) {
		    System.out.println("Erreur c'est un string !");
		    scan.nextLine();
		}
		
		while(choixJoueurAccuse<1 || choixJoueurAccuse>2) {//Check si le joueur accus� a saisi la bonne action
			
			System.out.println("Veuillez saisir 1 ou 2 ");
			System.out.println("Vous accusez le joueur "+numJoueur);
			System.out.print("Joueur num�ro "+numJoueur);
			System.out.println(", que souhaitez vous faire ? 1(Reveler votre idenitie) 2(Jouer carte Witch?)");
			try {
				choixJoueurAccuse=scan.nextInt();
			}
			catch(InputMismatchException e) {
			    System.out.println("Erreur c'est un string !");
			    scan.nextLine();
			}
		}
		//choixJoueurAccuse--;
		return choixJoueurAccuse--;
	}
	
	public int selectPlayer(int nbrJoueur, int tour) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Choisir un joueur entre 1 et "+nbrJoueur);
		try {
			selectPlayer=scanner.nextInt();
		}
		catch(InputMismatchException e) {
		    System.out.println("Erreur c'est un string !");
		    scanner.nextLine();
		}
		
		while((selectPlayer < 1) ||(selectPlayer > nbrJoueur) || (selectPlayer==(tour+1))) {
			System.out.println("Vous devez choisir un joueur entre 1 et "+nbrJoueur);
			try {
				selectPlayer=scanner.nextInt();
			}
			catch(InputMismatchException e) {
			    System.out.println("Erreur c'est un string !");
			    scanner.nextLine();
			}
		}
		return selectPlayer;
	}
	
	public Carte selectCard(List<Joueur> listJoueur, List<Carte> From, List<Carte> Discard, boolean random, boolean multiSelect, int nbrJoueur, int packet, int tour) {
		if(multiSelect==false) {
			if(random==false) {
				for(int i = 0; i < From.size(); i++) {
					System.out.println("Entrez "+i+" pour selectionner "+From.get(i).getNom());
				}
				
				selection=Jeu.getInstance().getPointedHat();

				selectCarte = From.get(selection);
				From.remove(selectCarte);
			}
			else {
				selection = (int)(Math.random() * From.size());
				selectCarte = From.get(selection);
				From.remove(selectCarte);
			}
		}
		else {
			if(packet == 1) {
				for(int i = 0 ; i < nbrJoueur; i++) {
					for(int j = 0 ; j < listJoueur.get(i).getEnMain().size(); j++) {
						System.out.println("Choisissez le Joueur "+(i+1)+" pour prendre "+listJoueur.get(i).getEnMain().get(j).getNom());
					}
				}
				joueur = listJoueur.get(tour).selectPlayer(nbrJoueur, tour);
				selectCarte = selectCard(listJoueur, listJoueur.get(joueur-1).getEnMain(), Discard, false, false, nbrJoueur, 0, tour);
			}
			if(packet == 2) {
				for(int i = 0 ; i < nbrJoueur; i++) {
					if((i==tour)&&(i!=nbrJoueur-1)) {
						i++;
					}
					for(int j = 0 ; j < listJoueur.get(i).getEnJeu().size(); j++) {
						System.out.println("Choisissez le Joueur "+(i+1)+" pour prendre "+listJoueur.get(i).getEnJeu().get(j).getNom());
					}
				}
				joueur = Jeu.getInstance().getPetNewt();
				selectCarte = selectCard(listJoueur, listJoueur.get(joueur).getEnJeu(), Discard, false, false, nbrJoueur, 0, tour);
			}
			else {
				selectCarte = selectCard(listJoueur, Discard, Discard, false, false, nbrJoueur, 0, tour);
			}
		}
		return selectCarte;
	}
}
