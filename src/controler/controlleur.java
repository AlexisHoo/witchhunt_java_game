package controlleur;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observer;
import java.util.Observable;

import javax.swing.JButton;
import javax.swing.JTextField;

import model.Jeu;
import vue.vue1;

//this.window marche pas window tout seul marche des fois 

public class controlleur implements Observer{
	
	private vue1 window;
	
	public controlleur (JButton btnNewButton,JTextField textField,JTextField textField_1, vue1 window) {
		
		this.window=window;
		window.invisiblePanel();
		window.setPanelNbrJoueur(true);

		Jeu.getInstance().addObserver(this);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Jeu.getInstance().setNbrJoueur(textField,textField_1);
			}
		});
	}
	
	public void update(Observable o, Object arg) {
		
		if(arg.equals("joueur")) {
			
			System.out.println("on change de panel pour aller dans nomJoueur");
			window.invisiblePanel();
			window.setPanelNomJoueur(true);
		}
	}
	
	

	
}
