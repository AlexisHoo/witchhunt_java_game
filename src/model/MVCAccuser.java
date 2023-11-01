package model;

public class MVCAccuser {
	
	public static void Accuser() {
		int tour = Jeu.getInstance().getTour();
		Jeu.getInstance().getListJoueur().get(tour).setAction(1);
		System.out.println(Jeu.getInstance().getListJoueur().get(tour).getAction());
	}

}
