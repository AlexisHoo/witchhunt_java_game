package controlleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JTextField;

import model.Jeu;
import vue.vue1;

public class controleurChooseNextPlayer {

	private vue1 window;
	
	public controleurChooseNextPlayer(JButton btnNewButtonChooseNextPlayer, vue1 window,JTextField textChooseNextPlayer,  JTextField nomJ1,  JTextField roleJ1, JButton Carte1, JButton Carte2, JButton Carte3, JButton Carte4, JButton Accuser, JTextField CarteSelect, JButton JouerHunt) {
		this.window=window;
		
		
		btnNewButtonChooseNextPlayer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Jeu.getInstance().setTourMVC(textChooseNextPlayer);
				System.out.println("tour YYYYYYYYY "+Jeu.getInstance().getTour());
				
				//Changement de joueur
				
				window.setup();
				
				
				roleJ1.setVisible(true);
				CarteSelect.setVisible(true);
				Accuser.setVisible(true);
				JouerHunt.setVisible(true);

				
				window.invisiblePanel();
				window.setPanelRecap(true);
			}
		});
	}
	
}
