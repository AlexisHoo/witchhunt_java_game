package controlleur;

import javax.swing.JTextField;

import model.Jeu;
import vue.vue1;

public class controleurVictoire {
	
	private vue1 window;

	public controleurVictoire(vue1 window, JTextField textVictoire) {
		
		this.window=window;
		
		textVictoire.setText("Bravo joueur "+(Jeu.getInstance().getJoueurGagnant()+1)+", vous avez gagné !");
		
	}
}