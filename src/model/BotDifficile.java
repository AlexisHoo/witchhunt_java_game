package model;

import java.util.ArrayList;
import java.util.List;

public class BotDifficile implements IStrategy{
	
	private List<Integer> listAccusation = new ArrayList<Integer>();
	private int i;
	private int accusation;
	private int choixCarte;
	private int choixJoueurAccuse = 2;
	private Carte selectCarte;
	private int selection;
	private int joueur;
	private int action;
	private boolean sortie;
	
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

	public int choixJoueur(List<Joueur> listJoueur, int tour, int nbrJoueur) {
		System.out.println("C'est un bot difficile, il choisit d'accuser quelqu'un");
		listAccusation = listJoueur.get(tour).getListAccusation();
		i=0;
		action=0;
	
		//Sécurité
		while(action==0) {//Tant que accusation n'est pas dans les limites du tableu et le joeuru est déjà accusé
			accusation = listAccusation.get(i);
			if((listJoueur.get(accusation-1).getIdentite()==true) || (accusation==(tour+1)) || (listJoueur.get(accusation-1).getInciblable()==1)) {
				System.out.println("Le bot "+(tour+1)+" ne peut pas accuser le joueur / bot "+accusation);
				i++;
			}
			else {
				action=1;
				System.out.println("Le bot "+(tour+1)+" va accuser");
			}
			if(i==nbrJoueur) {
				action=2;
				System.out.println("Le bot "+(tour+1)+" va jouer une carte hunt");
			}
		}
		return action;
	}

	public void choisirRole(int n,  int j, List<Joueur> listJoueur) {//Permet de saisir le rôle du joueur en question
		System.out.println("Bot difficile "+ j);//On demande son choix
		
		//Le bot difficile prend le rôle Sorcière de base 
		listJoueur.get(n).setRole("Villageois");
		System.out.println("Role du bot numero "+j+" "+listJoueur.get(n).getRole());//Affichage du rôle pour vérifier que ç fonctionne bien
		System.out.println("List d'accusation du bot"+ listJoueur.get(n).getListAccusation());
	}
	
	//Fonction pour demander quelle personne le joueur qui joue veut accuser
	public int demandeChoixJoueur(List<Joueur> listJoueur, int nbrJoueur, int tour) {
		listAccusation = listJoueur.get(tour).getListAccusation();
		i=0;
		sortie=false;
		
		while(sortie==false) {//Tant que accusation n'est pas dans les limites du tableu et le joeuru est déjà accusé
			accusation = listAccusation.get(i);
			if((listJoueur.get(accusation-1).getIdentite()==true) || (accusation==(tour+1)) || (listJoueur.get(accusation-1).getInciblable()==1)) {
				System.out.println("Le bot "+(tour+1)+" ne peut pas accuser le joueur / bot "+accusation);
				i++;
			}
			else {
				sortie=true;
			}
		}
		System.out.println("Le bot "+(tour+1)+" accuse le joueur / bot "+accusation);
		return accusation;
	}
				
	//Fonction pour demander le choix de la carte du joueur qui est accusé (joue une carte witch)
	public int demandeChoixCarte(List<Joueur> listJoueur, int numJoueur, int essai) {
		System.out.println("C'est un bot difficile, il choisit la dernière carte qui est dans son jeu");
		choixCarte = listJoueur.get(numJoueur).getEnMain().size()-1-essai;
		return choixCarte;
	}
	
	//Fonction pour demander le choix du joueur qui est accusé
	public int demandeChoixJoueurAccuse(List<Joueur> listJoueur, int numJoueur) {
		//Le bot difficile choisit toujours de jouercarte witch
		System.out.println("C'est un bot difficile, il choisit de jouer une carte Witch");
		if(listJoueur.get(numJoueur-1).getEnMain().size()==0) {
			choixJoueurAccuse=1;
		}
		else {
			choixJoueurAccuse=2;
		}
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
			selection = (int)(Math.random() * From.size());
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
