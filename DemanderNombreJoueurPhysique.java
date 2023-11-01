package model;

import java.util.InputMismatchException;
import java.util.Scanner;

public abstract class DemanderNombreJoueurPhysique {
	
	private static int nbrJoueurPhysique=7;
	
	public static int function(int nbrJoueur) {
		Scanner scan = new Scanner(System.in);
		System.out.print("Combien y a t-il de joueurs physiques dans cette partie?");
		try {
			nbrJoueurPhysique=scan.nextInt();
		}
		catch(InputMismatchException e) {
		    System.out.println("Erreur c'est un string !");
		    scan.nextLine();
		}
		
		while(nbrJoueurPhysique<0 || nbrJoueurPhysique>nbrJoueur) {
			System.out.println("Veuillez sélectionner un chiffre entre 1 et"+ nbrJoueur);
			System.out.print("Combien y a t-il de joueurs physiques dans cette partie?");
			try {
				nbrJoueurPhysique=scan.nextInt();
			}
			catch(InputMismatchException e) {
			    System.out.println("Erreur c'est un string !");
			    scan.nextLine();
			}
		}
		return nbrJoueurPhysique;
	}

}
