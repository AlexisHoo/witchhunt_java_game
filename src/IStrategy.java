package model;

import java.util.*;

import javax.swing.JTextField;

public interface IStrategy{
	public int choixJoueur(List<Joueur> listJoueur, int tour, int nbrJoueur);
	public void choisirRole (int n,  int j, List<Joueur> listJoueur);//Permet de saisir le rôle du joueur en question
	public void MVCchoisirRoleWitcher (int joueur);
	public void MVCchoisirRoleHunter (int joueur);
	public int demandeChoixJoueur(List<Joueur> listJoueur, int nbrJoueur, int tourAffichage);
	public int demandeChoixCarte(List<Joueur> listJoueur, int numJoueur, int essai);//numJoueur est le joueur accusé --> accusation-1
	public int demandeChoixJoueurAccuse(List<Joueur> listJoueur, int accusation);
	public int selectPlayer(int nbrJoueur, int tour);
	public Carte selectCard(List<Joueur> listJoueur, List<Carte> From, List<Carte> Discard, boolean random, boolean multiSelect, int nbrJoueur, int packet, int tour);
}