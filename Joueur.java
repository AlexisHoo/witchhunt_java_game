package model;
import java.util.*; 

public class Joueur{
	
	//Variable pour initialiser un joueur
	private String nom;//Le nom du joueur en question
	private int points;//Les points du joueur en question
	private List<Carte> enMain = new ArrayList<Carte>();//Les cartes en Main (4 cartes au max)
	private List<Carte> enJeu = new ArrayList<Carte>();//Les cartes révélées (4 cartes au max)
	private String role;//String du rôle
	private boolean identite=false;//Identite n'est pas révélée, donc false
	private boolean elimine=false;//Si devoilée en tant que sorcière
	private int inciblable=0; //pour les joueurs qui devinennent inciblable comme avec la carte Evil Eye
	private List<Integer> listAccusation;
	private int action;
	
	//Variable pour définir la stratégie du joueur
	private IStrategy strategy;
	
	//Constructeur
	public Joueur(String nom, int points, int nbrJoueur) {
		this.nom=nom;
		this.points=points;
		listAccusation=new ArrayList<Integer>();
		for(int i = 1; i<=nbrJoueur; i++) {
			listAccusation.add(i);
		}
		Collections.shuffle(listAccusation);
	}
	
	//Setter
	
	//Strategy
	public void setStrategy(IStrategy strategy) {
		this.strategy=strategy;
	}
	//Points
	public void setPoints(int points) {
	    this.points = points;
	}
	//Inciblable
	public void setInciblable(int inciblable) {
	    this.inciblable=inciblable ;
	}
	//Role
	public void setRole(String role) {
		this.role=role ;
	}
	//enMain
	public void setEnMain(Carte carte) {
		this.enMain.add(carte);
	}
	//enMain
	public void setEnJeu(Carte carte) {
		this.enJeu.add(carte);
	}
	//Identite
	public void setIdentite(boolean identite) {
		this.identite=identite;
	}
	//Elimine
	public void setElimine(boolean elimine) {
		this.elimine=elimine;
	}
	//ListAccusationBot
	public void setListAccusation(List<Integer> ListAccusation) {
		this.listAccusation=ListAccusation;
	}
	
	public int getAction() {
		return action;
	}

	public void setAction(int action) {
		this.action = action;
	}
	
	//Getter
	
	//Points
	public int getPoints() {
		return points;
	}
	//Role
	public String getRole(){
		return role;
	}
	//Identite
	public boolean getIdentite() {
		return identite;
	}
	//Elimine
	public boolean getElimine() {
		return elimine;
	}
	//Inciblable
	public int getInciblable() {
		return inciblable;
	}
	//enMain
	public List<Carte> getEnMain() {
		return enMain;
	}
	//enJeu
	public List<Carte> getEnJeu(){
		return enJeu;
	}
	//Nom
	public String getNom() {
		return nom;
	}
	//ListAccusation
	public List<Integer> getListAccusation() {
		return listAccusation;
	}
	
	public String toString() {
		StringBuffer sb = new StringBuffer();
		//sb.append("Voici la main du joueur "+this.nom+": ");
		for(int i=0;i<this.enMain.size();i++) {
			sb.append(this.enMain.get(i).getNom()+", ");
		}
		return sb.toString();
	}
	
	public int choixJoueur(List<Joueur> listJoueur, int tour, int nbrJoueur) {
		action=strategy.choixJoueur(listJoueur, tour, nbrJoueur);
		return action;
	}
	
	public void choisirRole(int n,  int j, List<Joueur> listJoueur) {//Permet de saisir le rôle du joueur en question
		strategy.choisirRole(n,j,listJoueur);
	}
	
	public void MVCchoisirRoleWitcher(int joueur) {
		strategy.MVCchoisirRoleWitcher(joueur);
	}
	
	public void MVCchoisirRoleHunter(int joueur) {
		strategy.MVCchoisirRoleHunter(joueur);
	}
	
	

	//Fonction pour demander quelle personne le joueur qui joueur veut accuser
	public int demandeChoixJoueur(List<Joueur> listJoueur, int nbrJoueur, int tourAffichage) {
		int accusation;
		accusation=strategy.demandeChoixJoueur(listJoueur, nbrJoueur,tourAffichage);
		return accusation;
	}
	
	public void affichageJeu(List<Joueur> listJoueur, int joueur) {
		for(int i=0;i<listJoueur.get(joueur).enJeu.size();i++) {
			System.out.println(listJoueur.get(joueur).enJeu.get(i).getNom());
		}
	}
	
	public int demandeChoixCarte(List<Joueur> listJoueur, int numJoueur, int essai) {
		int choixcarte;
		choixcarte=strategy.demandeChoixCarte(listJoueur, numJoueur, essai);
		return choixcarte;
	}
	
	public int demandeChoixJoueurAccuse(List<Joueur> listJoueur, int accusation) {
		int choixJoueurAccuse=strategy.demandeChoixJoueurAccuse(listJoueur, accusation);
		return choixJoueurAccuse;
	}
	
	public int selectPlayer(int numJoueur, int tour) {
		int selectPlayer = strategy.selectPlayer(numJoueur, tour);
		return selectPlayer;
	}
	
	public Carte selectCard(List<Joueur> listJoueur, List<Carte> From, List<Carte> Discard, boolean random, boolean multiSelect, int nbrJoueur, int packet, int tour) {
		Carte Card=strategy.selectCard(listJoueur, From, Discard, random, multiSelect, nbrJoueur, packet, tour);
		return Card;
	}
}
