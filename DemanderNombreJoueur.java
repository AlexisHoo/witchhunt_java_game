package model;

import java.util.InputMismatchException;
import java.util.Scanner;

import javax.swing.JTextField;

public abstract class DemanderNombreJoueur {
	
	private int nbrJoueur=7;
	
	
	public int avoirNbrJoueur(JTextField textField) {
		Scanner scan = new Scanner(System.in);
		System.out.print("Combien y a t-il de joueurs dans cette partie? max:6");
		try {
			nbrJoueur=Integer.parseInt(textField.getText());
		}
		catch(InputMismatchException e) {
		    System.out.println("Erreur c'est un string !");
		    scan.nextLine();
		}
		
		//Sécurité
		while(nbrJoueur<3 || nbrJoueur>6) {
			System.out.println("Veuillez sélectionner un chiffre entre 1 et 6");
			System.out.print("Combien y a t-il de joueurs dans cette partie?");
			try {
				nbrJoueur=scan.nextInt();
			}
			catch(InputMismatchException e) {
			    System.out.println("Erreur c'est un string !");
			    scan.nextLine();
			}
		}
		
		return nbrJoueur;
		
	}
	
	
	
}
