package model;

public class MVCDevenirVillageois {
	
	public static int DevenirVillageois() {
		
		int tour = Jeu.getInstance().getTour();
		Jeu.getInstance().getListJoueur().get(tour).setRole("Villageois");
		System.out.println("Le joueur "+tour+" sera "+Jeu.getInstance().getListJoueur().get(tour).getRole());
		return tour;
	}	

}
