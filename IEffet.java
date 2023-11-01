package model;

import java.util.List;

import vue.vue1;

public interface IEffet {
	public int effetWitch(vue1 window, List<Joueur> listJoueur, List<Carte> Discard, int tour, int nbrJoueur, int tourAffichage, int compteurIdentiteRevelee, boolean win, int accusation);
	public int effetHunt(vue1 window, List<Joueur> listJoueur, List<Carte> Discard, int tour, int nbrJoueur, int tourAffichage, int compteurIdentiteRevelee, boolean win, int accusation);
	public boolean testWitch(List<Joueur> listJoueur, int tour, int accusation, int nbrJoueur, int compteurIdentiteDevoilee);
	public boolean testHunt(List<Joueur> listJoueur, int tour, int nbrJoueur, int compteurIdentiteDevoilee, List<Carte> Discard);
}
