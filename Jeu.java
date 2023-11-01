package model;


import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

import javax.swing.JTextField;

import vue.vue1;

public class Jeu extends Observable{
	
	//Variable du singleton
	private static Jeu instance;
	
	//Variables pour intialiser le jeu
	private int nbrJoueur=0;
	private int nbrJoueurPhysique;
	private boolean win=false;//Variable qui détermine quand un joueur a gagné, on check a chaque fin de round si un joueur a + ou 5 points, si c'est le cas on mets win=true
	
	//Variables pour intialiser le round
	private int tour;//Variable qui va servir à déterminer quel joueur va jouer (si tour==4) alors le joueur 5 va jouer (car tableau)
	private int compteurIdentiteRevelee;
	private int nbrCartes;//Détermine le nbr de cartes par joueur
	
	//Variables pour jouer le round
	private int action;//Pour le choix d'action d'un joueur (accuser ou jouer Hunt!)
	private int accusation;//En cas d'accusation, savoir quel joueur est accusé
	private int choixJoueurAccuse;//Choix du joueur accusé (réveler identité ou jouer carte Witch?)
	private int choixCarte;//Choix de la carte à jouer pour le mec accusé
	private boolean test;
	private int essai=0;
	private List<Joueur> listJoueur;
	private List<Carte> Cartes;
	private List<Carte> Discard;
	private List<Carte> ListJeux;
	private List<Integer> ListJoueurJeux;
	
	//Variable des noms des joueurs
	private String nom1;
	private String nom2;
	private String nom3;
	private String nom4;
	private String nom5;
	private String nom6;
	

	//Variable AngryMob
	private int angryMobPlayer;
	//Variable Hooked Nose
	private int hookedNosePlayer;
	//Variable DuckingStool
	private int DSPlayer;
	private int DSChoix;
	//Variable Inquisition
	private int choixInqWitch;
	private int PointedHat;
	private int BlackCat;
	private int PetNewt;
	private Carte card;

	//Victoire de fin
	private int joueurGagnant;
	
	//Transition
	private boolean reset;
	
	public boolean getReset() {
		return reset;
	}
	public void setReset(boolean reset) {
		this.reset=reset;
	}
	
	public int getJoueurGagnant(){
		return joueurGagnant;
	}
	
	public void setJoueurGagnant(int joueurGagnant) {
		this.joueurGagnant=joueurGagnant;
	}
	
	public boolean getWin() {
		return win;
	}
	
	public void setWin(boolean win) {
		this.win=win;
	}
	
	public int getChoixInqWitch() {
		return choixInqWitch;
	}
	
	public void setChoixInqWitch(int choixInqWitch) {
		this.choixInqWitch=choixInqWitch;
	}
	
	public int getAngryMobPlayer() {
		return angryMobPlayer;
	}
	
	public int getPointedHat() {
		return PointedHat;
	}
	
	public int getHookedNose() {
		return hookedNosePlayer;
	}
	
	public int getDSChoix() {
		return DSChoix;
	}
	public int getDSPlayer() {
		return DSPlayer;
	}
	
	public void setDSChoixBox(int DSChoix) {
		this.DSChoix=DSChoix;
	}
	public void setDSChoix(JTextField text) {
		this.DSChoix=Integer.parseInt(text.getText());
	}
	public void setDSPlayer(JTextField text) {
		this.DSPlayer=Integer.parseInt(text.getText());
	}
	
	public void setHookedNosePlayerMVC(JTextField text) {
		this.hookedNosePlayer=Integer.parseInt(text.getText());
	}
	
	public void setAngryMobPlayerMVC(JTextField text) {
		this.angryMobPlayer=Integer.parseInt(text.getText());
	}
	
	public void setPointedHat(int valeur) {
		this.PointedHat=valeur;
	}
	
	public int getBlackCat() {
		return PointedHat;
	}
	
	public void setBlackCat(int valeur) {
		this.BlackCat=valeur;
	}
	
	public int getPetNewt() {
		return PetNewt;
	}
	
	public void setPetNewt(int valeur) {
		this.PetNewt=valeur;
	}
	
	//Getter
	public int getNbrCartes(){
		return nbrCartes;
	}
	public int getTour() {
		return tour;
	}
	public int getAccusation() {
		return accusation;
	}
	public List<Carte> getCartes(){
		return Cartes;
	}
	public List<Carte> getDiscard(){
		return Discard;
	}
	public List<Carte> getListJeux(){
		return ListJeux;
	}
	public List<Integer> getListJoueurJeux(){
		return ListJoueurJeux;
	}
	public int getCompteurIdentiteRevelee() {
		return compteurIdentiteRevelee;
	}
	public String getNom1() {
		return nom1;
	}
	public String getNom2() {
		return nom2;
	}
	public String getNom3() {
		return nom3;
	}
	public String getNom4() {
		return nom4;
	}
	public String getNom5() {
		return nom5;
	}
	public String getNom6() {
		return nom6;
	}
	public static Jeu getInstance() {
		if (instance == null) {
            instance = new Jeu();
        }
        return instance;
    }
	
	public int getNbrJoueur() {
		return nbrJoueur;
	}
	
	public List<Joueur> getListJoueur(){
		return listJoueur;
	}
	
	
	//Setter
	public void setNbrCartes(int nbrCartes) {
		this.nbrCartes=nbrCartes;
	}
	public void setTour(int tour) {
		this.tour=tour;
	}
	public void setAccusation(int accusation) {
		this.accusation=accusation;
	}
	public void setTourMVC(JTextField text) {
		this.tour=Integer.parseInt(text.getText())-1;
	}
	public void setDiscard(List<Carte> Discard) {
		this.Discard=Discard;
	}
	public void addDiscard(Carte card) {
		this.Discard.add(card);
	}
	public void setListJeux(List<Carte> ListJeux) {
		this.ListJeux=ListJeux;
	}
	public void addListJeux(Carte card) {
		this.ListJeux.add(card);
	}
	public void setListJoueurJeux(List<Integer> ListJoueurJeux) {
		this.ListJoueurJeux=ListJoueurJeux;
	}
	public void addListJoueurJeux(int i) {
		this.ListJoueurJeux.add(i);
	}
	public void setCartes(List<Carte> Cartes) {
		this.Cartes=Cartes;
	}
	public void setCompteurIdentiteRevelee(int compteurIdentiteRevelee) {
		this.compteurIdentiteRevelee = compteurIdentiteRevelee;
	}
	public void setListJoueur(List<Joueur> listJoueur) {
		this.listJoueur=listJoueur;
	}
	public void setNom1(JTextField textField) {
		this.nom1=textField.getText();
	}
	public void setNom2(JTextField textField) {
		this.nom2=textField.getText();
	}
	public void setNom3(JTextField textField) {
		this.nom3=textField.getText();
	}
	public void setNom4(JTextField textField) {
		this.nom4=textField.getText();
	}
	public void setNom5(JTextField textField) {
		this.nom5=textField.getText();
	}
	public void setNom6(JTextField textField) {
		this.nom6=textField.getText();
	}
	
	
	public void setNbrJoueur(JTextField textField,JTextField textField2) {
	    this.nbrJoueur = Integer.parseInt(textField.getText());
	    this.nbrJoueurPhysique = Integer.parseInt(textField2.getText());
	    System.out.println("Nombre joueur:      "+nbrJoueur);
	    
	    if(nbrJoueur<3 || nbrJoueur>6 || nbrJoueurPhysique<0 || nbrJoueurPhysique>nbrJoueur) {
	    	
	    	System.out.println("Erreur");
	    }
	    else {
	    	
	    	String str=new String("joueur");
			//On change de scene
			this.setChanged();
	    	this.notifyObservers(str);
	    }
	}
	
	public void testEffetWitchMVC(JTextField text) {
		boolean estJouable=false;
		
		String nomCarte=text.getText();
		
		System.out.println("on est dans testWitch");
		System.out.println("Le nom de la carte est: "+nomCarte);
		System.out.println("La taille est: "+Jeu.getInstance().getListJoueur().get(getAccusation()-1).getEnMain().size());
		
		int taille=Jeu.getInstance().getListJoueur().get(getAccusation()-1).getEnMain().size();
		
		for(int i=0;i<taille;i++) {
			
			System.out.println("Nom de la carte dans la main: "+Jeu.getInstance().getListJoueur().get(getAccusation()-1).getEnMain().get(i).getNom());
			
			if(nomCarte.equals(Jeu.getInstance().getListJoueur().get(getAccusation()-1).getEnMain().get(i).getNom())) {
				
				//On lance le test
				System.out.println("on a trouvé la carte");
				estJouable=Jeu.getInstance().getListJoueur().get(getAccusation()-1).getEnMain().get(i).testWitch(listJoueur, tour, accusation, nbrJoueur, compteurIdentiteRevelee);			
			}
		}
		
		//Si c'est jouable
		if(estJouable==true) {
			
			String str=new String("jouable"+nomCarte);
			System.out.println("on est dans testWitchMVC");
			//On change de scene
			this.setChanged();
	    	this.notifyObservers(str);
		}
		else {
			System.out.println("Erreur, la carte n'est pas jouable");
		}
	}
	
	public void effetWitchMVC(String nomCarte, vue1 window) {
		
		int tourmaj=0;
		System.out.println("on est dans effetWitch");
		for(int i=0;i<Jeu.getInstance().getListJoueur().get(getAccusation()-1).getEnMain().size();i++) {
			
			if(nomCarte.equals(Jeu.getInstance().getListJoueur().get(getAccusation()-1).getEnMain().get(i).getNom())) {
				
				//On joue l'effet
				System.out.println("on a trouvé la carte effet witch "+nomCarte);
				tourmaj=Jeu.getInstance().getListJoueur().get(getAccusation()-1).getEnMain().get(i).effetWitch(window,listJoueur, Discard, tour, nbrJoueur, (tour+1), compteurIdentiteRevelee, win, getAccusation());			
			}
		}
		
	}
	
	public void effetHuntMVC(String nomCarte, vue1 window) {
		
		int tourmaj=0;
		for(int i=0;i<Jeu.getInstance().getListJoueur().get(getTour()).getEnMain().size();i++) {
			
			if(nomCarte.equals(Jeu.getInstance().getListJoueur().get(getTour()).getEnMain().get(i).getNom())) {
				
				//On joue l'effet
				System.out.println("on a trouvé "+nomCarte);
				tourmaj=Jeu.getInstance().getListJoueur().get(getTour()).getEnMain().get(i).effetHunt(window,listJoueur, Discard, tour, nbrJoueur, (tour+1), compteurIdentiteRevelee, win, 0);			
			}
		}
		
	}
	
	
	public void testEffetHuntMVC(JTextField text) {
		
		boolean estJouable=false;
		String nomCarte=text.getText();
		String nomCarteMain;
		int size=Jeu.getInstance().getListJoueur().get(getTour()).getEnMain().size();
		
		for(int i=0;i<size;i++) {
			
			nomCarteMain=Jeu.getInstance().getListJoueur().get(getTour()).getEnMain().get(i).getNom();
			
			if(nomCarte.equals(nomCarteMain)) {
				
				//On lance le test
				System.out.println("On a reperé la carte");
				estJouable=Jeu.getInstance().getListJoueur().get(getTour()).getEnMain().get(i).testHunt(listJoueur, tour, nbrJoueur, compteurIdentiteRevelee, Discard);			
				System.out.println("On est dans jeu et c'est estJouable: "+estJouable);
			}
		}
		
		//Si c'est jouable
		if(estJouable==true) {
			
			//On change de scene
			String str=new String(nomCarte);
			this.setChanged();
	    	this.notifyObservers(str);
		}
		else {
			System.out.println("Erreur, la carte n'est pas jouable");
		}
	}
	
	//Voir sir le joueur peut être accusé
	//while(listJoueur.get(accusation-1).getInciblable()==1 || (listJoueur.get(accusation-1).getElimine()==true)) {
	public void estAccusable(JTextField text) {
		
		 int joueurAccuse = Integer.parseInt(text.getText());
		 
		 if(listJoueur.get(joueurAccuse-1).getInciblable()==1 || listJoueur.get(joueurAccuse-1).getElimine()==true) {
			 System.out.println("Le joueur ne peux pas être accusé");
		 }
		 else {
			 
			//on met à jour le mec accusé
			accusation=joueurAccuse;
			//On change de scene
			this.setChanged();
		    this.notifyObservers("JoueurAccusable");
		 }
	}
	
	public void angryMobMVC() {
		if(listJoueur.get(getAngryMobPlayer()).getRole().equals("Sorciere")) {
			
			System.out.println("C'est une sorciere");
			listJoueur.get(getTour()).setPoints(listJoueur.get(getTour()).getPoints()+2);
			listJoueur.get(getAngryMobPlayer()).setElimine(true);
			setCompteurIdentiteRevelee(getCompteurIdentiteRevelee()+1);
			
			System.out.println("Tour: "+getTour());
			
		}
		else {
			
			System.out.println("C'est un villageois");
			listJoueur.get(getTour()).setPoints(listJoueur.get(getTour()).getPoints()-2);
			setTour(getAngryMobPlayer());
			System.out.println("Tour: "+getTour());
		}
	}
	
	public void InqWitchMVC() {
		
		//On ajoute dans discard
		Carte carte=listJoueur.get(getAccusation()-1).getEnMain().get(getChoixInqWitch());
		
		Jeu.getInstance().addDiscard(carte);
		
		//Doit discard une carte de sa main
		listJoueur.get(getAccusation()-1).getEnMain().remove(getChoixInqWitch());
		
		//Affichage des cartes des joueurs
		for(int i=0;i<Jeu.getInstance().getNbrJoueur();i++) {//Parcours le nombre de joueurs
			System.out.println("Main joueur "+ (i+1)); //On affiche leurs mains
			System.out.println(Jeu.getInstance().getListJoueur().get(i));
		}
	}
	
	//HookedNose Hunt
	public void hookedNoseMVC() {
		
		System.out.println("Le joueur qui est choisi est: "+getTour());
		
		card = listJoueur.get(getTour()).selectCard(listJoueur, listJoueur.get(getHookedNose()-1).getEnMain(), Discard, true, false, nbrJoueur, 0, tour);
		listJoueur.get(tour).setEnMain(card);
		
		setTour(getHookedNose());
	}
	
	public void HookedNoseWitchMVC() {
		card = listJoueur.get(tour).selectCard(listJoueur, listJoueur.get(tour).getEnMain(), Discard, false, false, nbrJoueur, 0, tour);
		listJoueur.get(accusation-1).setEnMain(card);
	}
	
	public void duckingStoolMVC() {
		System.out.println("Le joueur qui est choisi est: "+getDSPlayer());
		
		
		//On ajoute dans discard
		Carte carte=listJoueur.get(getDSPlayer()-1).getEnMain().get(getDSChoix());
		
		Jeu.getInstance().addDiscard(carte);
		
		//Doit discard une carte de sa main
		listJoueur.get(getDSPlayer()-1).getEnMain().remove(getDSChoix());
		
		//Affichage des cartes des joueurs
		for(int i=0;i<Jeu.getInstance().getNbrJoueur();i++) {//Parcours le nombre de joueurs
			System.out.println("Main joueur "+ (i+1)); //On affiche leurs mains
			System.out.println(Jeu.getInstance().getListJoueur().get(i));
		}
		
	}
	
	public void DSMVC2() {
		
		
		if(listJoueur.get(getDSPlayer()-1).getRole().equals("Sorciere")) {
			
			System.out.println("C'est une sorciere");
			listJoueur.get(getTour()).setPoints(listJoueur.get(getTour()).getPoints()+1);
			listJoueur.get(getAngryMobPlayer()).setElimine(true);
			setCompteurIdentiteRevelee(getCompteurIdentiteRevelee()+1);
			
			
			
			System.out.println("Tour: "+getTour());
			
		}
		else {
			
			System.out.println("C'est un villageois");
			listJoueur.get(getTour()).setPoints(listJoueur.get(getTour()).getPoints()-1);
			setTour(getDSPlayer());
			System.out.println("Tour: "+getTour());
			
			setTour(getDSPlayer());
		}
		
		//Affichage de spoints
		for(int i=0;i<Jeu.getInstance().getNbrJoueur();i++) {//Parcours le nombre de joueurs
			System.out.println("Joueur "+ (i+1)); //On affiche leurs mains
			System.out.println(Jeu.getInstance().getListJoueur().get(i).getPoints());
		}
	}
	
	
	public void setInciblable() {
		
		for(int i=0;i<nbrJoueur;i++) {
			if(listJoueur.get(i).getInciblable()!=0) {	
				listJoueur.get(i).setInciblable(listJoueur.get(i).getInciblable()-1);
			}
		}
	}
	
	public void PointedHatMVC() {
		card = listJoueur.get(tour).selectCard(listJoueur, listJoueur.get(tour).getEnJeu(), Discard, false, false, nbrJoueur, 0, tour);
		while(card.getNom()=="Pointed Hat") {
			listJoueur.get(tour).setEnJeu(card);
			card = listJoueur.get(tour).selectCard(listJoueur, listJoueur.get(tour).getEnJeu(), Discard, false, false, nbrJoueur, 0, tour);
		}
		listJoueur.get(tour).setEnMain(card);
	}
	
	public void BlackCatMVC() {
		card = listJoueur.get(tour).selectCard(listJoueur, Discard, Discard, false, false, nbrJoueur, 0, tour);
		listJoueur.get(tour).setEnMain(card);
		for(int i = 0; i<listJoueur.get(tour).getEnJeu().size(); i++) {
			if(listJoueur.get(tour).getEnJeu().get(i).getNom()=="Black Cat") {
				Carte suppr = listJoueur.get(tour).getEnJeu().get(i);
				Jeu.getInstance().addDiscard(suppr);
				listJoueur.get(tour).getEnJeu().remove(i);
			}
		}
	}
	
	public void PetNewtMVC() {
		card = listJoueur.get(tour).selectCard(listJoueur, Discard, Discard, false, true, nbrJoueur, 2, tour);
		listJoueur.get(tour).setEnMain(card);
	}
	
	public void remplirListJeux() {
		for(int i = 0; i<nbrJoueur; i++) {
			for(int j = 0; j<listJoueur.get(i).getEnJeu().size(); j++) {
				ListJeux.add(listJoueur.get(i).getEnJeu().get(j));
				ListJoueurJeux.add(i);
			}
		}
	}
	
	public void aGagne() {
		
		//On doit vérifier si quelqu'un a gagné
		for(int c=0;c<nbrJoueur;c++) {
			
			//Si le nombre de points d'un joueur est sup ou égal à 5
			if(listJoueur.get(c).getPoints()>=5) {

				//Alors on passe win à true pour arrêter la partie car ça va sortir des 2 boucles
				Jeu.getInstance().setWin(true); 
				Jeu.getInstance().setJoueurGagnant(c);
				
			}
		}
	}
	


	public void transition() {
		
		System.out.println("Debut du round");
		System.out.println("Le nombre d'identité devoilée est "+ Jeu.getInstance().getCompteurIdentiteRevelee());
		
		//Liste de carte dans laquelle on déclare les cartes du jeu 
		Jeu.getInstance().setCartes(DeclareCarte.function());
		Jeu.getInstance().setDiscard(new ArrayList<Carte>());
		
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
	
	public void checkId() {
		
		if(getCompteurIdentiteRevelee()==getNbrJoueur()-1) {
			Jeu.getInstance().setReset(true);
		}
	}


	public void Partie() {
		//--> tout le déroulé
		System.out.println("Le jeu commence");
		
		// Demande nbr de joueurs totaux
		//nbrJoueur=DemanderNombreJoueur.function();
		
		//Demande nbr de joueurs physiques
		//nbrJoueurPhysique=DemanderNombreJoueurPhysique.function(nbrJoueur);
		
		
		System.out.println("Le nombre de joueurs physique est "+ nbrJoueurPhysique);
		
		//Déclaration d'un tableau de type joueur (faudrait faire uune liste pour déclarer le nombre exacte de joueurs et modifier tout le code après
		listJoueur= DeclareJoueur.function(nbrJoueur, nbrJoueurPhysique);
		
		while (win==false){//Tant que win est faux
			
			System.out.println("Debut du round");
			System.out.println("Le nombre d'identité devoilée est "+compteurIdentiteRevelee);
			
			//Liste de carte dans laquelle on déclare les cartes du jeu 
			List<Carte> Cartes = DeclareCarte.function();
			
			//Liste pour les cartes discard
			List<Carte> Discard = new ArrayList<Carte>();

			//On remets à zéro les cartes enMain et enJeu des joueurs s'ils viennent de jouer un round et on remets les identite à false
			for(int i=0;i<nbrJoueur;i++) {
				listJoueur.get(i).getEnMain().clear();
				listJoueur.get(i).getEnJeu().clear();
				listJoueur.get(i).setIdentite(false);
				listJoueur.get(i).setElimine(false);
				
				//Pour les joueurs qui ont été inciblable on baisse leurs scores de 1
				//Comme ça il est inciblable le nombre de tour choisis
				//Si on fait listJoueur.get(i).incicblable=5; le joueur est inciblable 4 tours
				if(listJoueur.get(i).getInciblable()!=0) {	
					listJoueur.get(i).setInciblable(listJoueur.get(i).getInciblable()-1);
				}
			}
			
			//Initialisation Game
			tour=0;//Variable qui va servir à déterminer quel joueur va jouer (si tour==4) alors le joueur 5 va jouer (car tableau)
			compteurIdentiteRevelee=0;//Détermine le nbr d'identitée révelée
			nbrCartes=12/nbrJoueur;//Détermine le nbr de cartes par joueur
			
			System.out.println("Le nombre d'identité devoilée est maintenant "+compteurIdentiteRevelee);
			
			System.out.println("Nombre de cartes par joueur : "+nbrCartes);
			
			//Distribution
			Distribution.function(listJoueur, nbrJoueur, nbrCartes, Cartes, Discard);
			
			//Affichage des cartes des joueurs
			for(int i=0;i<nbrJoueur;i++) {//Parcours le nombre de joueurs
				System.out.println("Main joueur "+ (i+1)); //On affiche leurs mains
				System.out.println(listJoueur.get(i));
			}
			
			//Il faut établir le rôle des joueurs avant le round
			for(int i=0;i<nbrJoueur;i++) {//Chaque joueur choisit son rôle, on appelle la méthode choisirRole dans le classe joueur
				listJoueur.get(i).choisirRole(i, (i+1), listJoueur);
			}
			
	
			//Un round
			//Un tour de boucle équivaut à un temps d'action d'un joueur et on s'arrête quand nbrJoueur-1 identités sont révélées
			while((compteurIdentiteRevelee<nbrJoueur-1) && (win==false)){
				
				//Si le joueur qui va jouer est reveler en tant que Sorcière, ce sera le joueur d'après qui jouera
				while(listJoueur.get(tour).getElimine()==true) {
					System.out.println("Le joueur / bot "+(tour+1)+" est révellé en tant que Sorcière, il ne peut plus joeur pendant ce round");
					tour++;
				}
				
				if(compteurIdentiteRevelee==nbrJoueur-2) {
					for(int i=0; i<listJoueur.size(); i++) {
						listJoueur.get(i).setInciblable(0);
					}
				}
				
				//Saisir le choix du joueur
				action=listJoueur.get(tour).choixJoueur(listJoueur, tour, nbrJoueur);
				
				//Sécurité si le joueur n'a plus de carte
				while((listJoueur.get(tour).getEnMain().size()==0) && (action==2)) {
					System.out.println("Vous devez posséder des cartes pour jouer");
					action=listJoueur.get(tour).choixJoueur(listJoueur, tour, nbrJoueur);
				}
				
				//Si l'action est d'accuser une personne
				if(action==1) {
					
					//On demande quel joueur il veut accuser
					accusation=listJoueur.get(tour).demandeChoixJoueur(listJoueur, nbrJoueur,tour);
					
					//IL faut vérifier si le joueur peut être accusé
					while(listJoueur.get(accusation-1).getInciblable()==1 || (listJoueur.get(accusation-1).getElimine()==true)) {
						System.out.println("Ce joueur est inciblable, accusez quelqu'un d'autre");
						
						//On demande quel joueur il veut accuser
						accusation=listJoueur.get(tour).demandeChoixJoueur(listJoueur, nbrJoueur,tour);
					}
					
					//On demande ce que veut faire le joueur accusé
					choixJoueurAccuse=listJoueur.get(accusation-1).demandeChoixJoueurAccuse(listJoueur, accusation);
					
					//Sécurité si le jueor n'a plus de carte
					while((listJoueur.get(accusation-1).getEnMain().size()==0) && (choixJoueurAccuse!=1)) {
						System.out.println("Vous devez posséder des cartes pour jouer coucou");
						choixJoueurAccuse=listJoueur.get(accusation-1).demandeChoixJoueurAccuse(listJoueur, accusation);
					}
					
					//Si le choix du joueur accusé est de révélé son identité
					if(choixJoueurAccuse==1) {
						Reveler.function(listJoueur, accusation, false);
						compteurIdentiteRevelee++;
						if(listJoueur.get(accusation-1).getRole()=="Sorcière") {
							listJoueur.get(accusation-1).setPoints(listJoueur.get(accusation-1).getPoints()+1);
							listJoueur.get(accusation-1).setElimine(true);
						}
						else {
							tour = accusation-1;
						}
					}
					//Le joueur décide jouer une carte Witch
					else {
						essai=0;
						
						//On demande quelle carte il veut utiliser
						choixCarte=listJoueur.get(accusation-1).demandeChoixCarte(listJoueur, accusation-1, essai);

						//On vérifie si il peut jouer cette carte
						test=listJoueur.get(accusation-1).getEnMain().get(choixCarte).testWitch(listJoueur, tour, accusation, nbrJoueur, compteurIdentiteRevelee);

						//On test si la carte peut être jouée
						while(test==false) {
							System.out.println("Vous ne pouvez pas jouer cette carte, veuillez choisir une nouvelle carte");
							essai++;
							
							//On demande quelle carte il veut utiliser
							choixCarte=listJoueur.get(accusation-1).demandeChoixCarte(listJoueur, accusation-1, essai);
							
							if(choixCarte >= 0) {
								//On vérifie si il peut jouer cette carte
								test=listJoueur.get(accusation-1).getEnMain().get(choixCarte).testWitch(listJoueur, tour, accusation, nbrJoueur, compteurIdentiteRevelee);
							}
							else {
								test=true;
								System.out.println("Vous ne pouvez pas jouer de carte Witch, vous devez dévoiler votre identité");
								Reveler.function(listJoueur, accusation, false);
								compteurIdentiteRevelee++;
								if(listJoueur.get(accusation-1).getRole()=="Sorcière") {
									listJoueur.get(accusation-1).setPoints(listJoueur.get(accusation-1).getPoints()+1);
									listJoueur.get(accusation-1).setElimine(true);
								}
								else {
									tour = accusation-1;
								}
							}
							
						}
						
						//On applique l'effet Witch
						if(listJoueur.get(accusation-1).getIdentite()==false) {
							//tour = listJoueur.get(accusation-1).getEnMain().get(choixCarte).effetWitch(window, listJoueur, Discard, tour, nbrJoueur, (tour+1), compteurIdentiteRevelee, win, accusation);
						}
						System.out.println("Le touuuuur "+tour);
					}
				//Fin de l'action accuser une personne
				}
				//Si il veut jouer une carte Hunt!
				else {
					essai=0;
					System.out.println("Choisissez la carte que vous désirez jouer");
					
					//Le joueur choisit quelle carte il veut jouer
					choixCarte=listJoueur.get(tour).demandeChoixCarte(listJoueur, tour, essai);
					
					//On test si la carte peut être jouée
					test=listJoueur.get(tour).getEnMain().get(choixCarte).testHunt(listJoueur, tour, nbrJoueur, compteurIdentiteRevelee, Discard);
					
					while(test==false) {
						System.out.println("Vous ne pouvez pas jouer cette carte, veuillez choisir une nouvelle carte");
						essai++;
						
						//On demande quelle carte il veut utiliser
						choixCarte=listJoueur.get(tour).demandeChoixCarte(listJoueur, tour, essai);
						
						//On vérifie si il peut jouer cette carte
						test=listJoueur.get(tour).getEnMain().get(choixCarte).testHunt(listJoueur, tour, nbrJoueur, compteurIdentiteRevelee, Discard);
					}
					
					//On applique l'effet Hunt
					//tour = listJoueur.get(tour).getEnMain().get(choixCarte).effetHunt(listJoueur, Discard, tour, nbrJoueur, (tour+1), compteurIdentiteRevelee, win, 0);
				//Fin de l'action jouer une carte Hunt
				}
				
				System.out.println("Le tour suivant sera "+tour);
				
				//Condition pour pb de tour
				if(tour == nbrJoueur) {//tour=(tour+1)%nbrJoueur-1; doit marcher aussi
					tour=0;
				}
				if(tour < 0) {
					tour = tour+nbrJoueur;
				}
				//******
				//Affichage des nouvelles mains
				for(int i=0;i<nbrJoueur;i++) {//Parcours le nombre de joueurs
					System.out.println("Main joueur "+ (i+1)+" : "); //On affiche leurs mains
					System.out.println(listJoueur.get(i));
					System.out.print("\n");
					System.out.println("Jeu joueur "+ (i+1)+" : ");
					listJoueur.get(i).affichageJeu(listJoueur, i);
					System.out.print("\n");
				}
				//Affichage des cartes défaussées
				System.out.println("Défausse : ");
				for(int i=0; i<Discard.size(); i++) {
					System.out.println(Discard.get(i).getNom());
				}
				//On fait le compte des identitées révélées
				compteurIdentiteRevelee=CountID.function(listJoueur,nbrJoueur);
				System.out.println("Le nombre d'identité devoilée est "+compteurIdentiteRevelee);
			//Fin de la première boucle while
			}
			
			System.out.println("Le round est terminé");
			
			//On doit attribuer des points au dernier joueur qui a son identité cachée 
			//seulement si le round n'a pas été arrêté parce que qqn a atteint les 5 points!!!!!!!!!!!!!!!!!!!!
			
			//On vérifie cette condition, si le compteur identité est égale au nbr de joueurs -1
			//Ca veut dire que personne n'a atteint les 5 points et qu'on attribue donc les points de fin de round (pour éviter qu'on se retoruve avec 2 vainqueurs 
			
			ComptePoints.function(compteurIdentiteRevelee, nbrJoueur, listJoueur);
			
			//On doit vérifier si quelqu'un a gagné
			for(int c=0;c<nbrJoueur;c++) {
				
				//Si le nombre de points d'un joueur est sup ou égal à 5
				if(listJoueur.get(c).getPoints()>=5) {
	
					//Alors on passe win à true pour arrêter la partie car ça va sortir des 2 boucles
					win=true; 				
				}
			}
		//Fin de la deuxième boucle while
		}
		
		//La partie est terminée, on est sortis des 2 boucles (win==true)
		//Il faut déterminer le vainqueur
		for(int c=0;c<nbrJoueur;c++) {
			
			//Si le nombre de points d'un joueur est sup ou égal à 5
			if(listJoueur.get(c).getPoints()>=5) {
				c++;
				System.out.println("La partie est terminée"); 
				System.out.println("Le grand vainqueur est le joueur numéro "+ c);
			}
		}
	}
}