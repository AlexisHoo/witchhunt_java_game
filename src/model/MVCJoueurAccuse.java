package model;

import javax.swing.JTextField;

public class MVCJoueurAccuse {
	
	public static int JoueurAccuse(JTextField JoueurAccuse) {
		
		Jeu.getInstance().estAccusable(JoueurAccuse);
		int accusation = Jeu.getInstance().getAccusation();
		return accusation;
	}

}
