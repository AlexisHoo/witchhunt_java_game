package model;
import java.util.*;

public class BotFacile implements IStrategy {

	private int accusation;
	private int choixCarte=0;
	private int choixJoueurAccuse=1;
	private Carte selectCarte;
	private int joueur;
	private int action = 1;
	
	public void MVCAccuse(int joueur) {
		System.out.println("LOL");
	}
	
	public void MVCHunt(int joueur) {
		System.out.println("LOL");
	}
	
	public void MVCchoisirRoleWitcher(int joueur) {
		System.out.println("LOL");
	}
	
	public void MVCchoisirRoleHunter(int joueur) {
		System.out.println("LOL");
	}
	
	@Override
	public int choixJoueur(List<Joueur> listJoueur, int tour, int nbrJoueur) {
		System.out.println("C'est un bot facile, il choisit d'accuser quelqu'un");
		return action;
	}
	
	public void choisirRole (int n,  int j, List<Joueur> listJoueur) {//Permet de saisir le rôle du joueur en question
		System.out.println("Bot facile "+ j);//On demande son choix
		
		//Le bot facile prend le rôle Villageois de base 
		listJoueur.get(n).setRole("Villageois");
		System.out.println("Role du bot numero "+ j+": "+listJoueur.get(n).getRole());//Affichage du rôle pour vérifier que ç fonctionne bien
	}

	//Fonction pour demander quelle personne le joueur qui joue veut accuser
	public int demandeChoixJoueur(List<Joueur> listJoueur, int nbrJoueur, int tour) {
		
		//Le bot facile révèle son identité direct
		System.out.println("C'est un bot facile, il choisit le joueur d'après, si c'est impossible le joueur d'après etc..");
		if (tour+1==6) {
			accusation = 1;
		}
		else {
			accusation = tour+2;//tourAffichage
		}
		
		//Sécurité
		while(listJoueur.get(accusation-1).getIdentite()==true || accusation==tour+1) {//Tant que accusation n'est pas dans les limites du tableu et le joeuru est déjà accusé
			accusation++;
			System.out.println("Accusation: "+accusation);
			System.out.println("tourAffichage: "+tour+1);
			
			if(accusation==nbrJoueur) {//On retourne accusation à 1 si on atteint le dernier joueur
				accusation=1;
			}
		}
		return accusation;
	}
	
	//Fonction pour demander le choix de la carte du joueur qui est accusé (joue une carte witch)
	public int demandeChoixCarte(List<Joueur> listJoueur, int numJoueur, int essai) {
		System.out.println("C'est un bot facile, il choisit la première carte qui est dans son jeu");
		choixCarte = 0+essai;
		return choixCarte;
	}
	
	//Fonction pour demander le choix du joueur qui est accusé
	public int demandeChoixJoueurAccuse(List<Joueur> listJoueur, int numJoueur ) {
		System.out.println("C'est un bot facile, il choisit de révéler son identité");
		return choixJoueurAccuse;
	}
	
	public int selectPlayer(int nbrJoueur, int tour) {
		System.out.println("Choisir un joueur entre 1 et "+nbrJoueur);
		int selectPlayer = (int)(Math.random() * nbrJoueur);
		while(selectPlayer==(tour+1)) {
			selectPlayer = (int)(Math.random() * nbrJoueur);
		}
		return selectPlayer;
	}
	
	public Carte selectCard(List<Joueur> listJoueur, List<Carte> From, List<Carte> Discard, boolean random, boolean multiSelect, int nbrJoueur, int packet, int tour) {
		if(multiSelect==false) {
			int selection = (int)(Math.random() * From.size());
			selectCarte = From.get(selection);
			From.remove(selectCarte);
		}
		else {
			if(packet == 1) {
				joueur = (int)(Math.random() * listJoueur.size());
				while(joueur == (tour+1)) {
					joueur = (int)(Math.random() * listJoueur.size());
				}
				selectCarte = selectCard(listJoueur, listJoueur.get(joueur-1).getEnMain(), Discard, false, false, nbrJoueur, 0, tour);
			}
			if(packet == 2) {
				joueur = (int)(Math.random() * listJoueur.size());
				while(joueur == (tour+1)) {
					joueur = (int)(Math.random() * listJoueur.size());
				}
				selectCarte = selectCard(listJoueur, listJoueur.get(joueur-1).getEnJeu(), Discard, false, false, nbrJoueur, 0, tour);
			}
			else {
				selectCarte = selectCard(listJoueur, Discard, Discard, false, false, nbrJoueur, 0, tour);
			}
		}
		return selectCarte;
	}
}



