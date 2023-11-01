package model;

public class MVCDevenirSorciere {
	
	public static int DevenirSorciere() {
		
		int tour = Jeu.getInstance().getTour();
		Jeu.getInstance().getListJoueur().get(tour).setRole("Sorcière");
		System.out.println("Le joueur "+tour+" sera "+Jeu.getInstance().getListJoueur().get(tour).getRole());
		return tour;
	}

}
