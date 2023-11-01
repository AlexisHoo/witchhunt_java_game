package controlleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;

import model.Jeu;
import model.Reveler;
import vue.vue1;

public class controleurTheInquisition {
	
private vue1 window;
	
	public controleurTheInquisition(JButton btnNewButtonTheInquisition, vue1 window,JTextField textFieldTheInquisition, JTextField nomJ1,  JTextField roleJ1, JButton Carte1, JButton Carte2, JButton Carte3, JButton Carte4, JButton Accuser, JTextField CarteSelect, JButton JouerHunt) {
		this.window=window;
		
		
		btnNewButtonTheInquisition.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Jeu.getInstance().setTourMVC(textFieldTheInquisition);
				System.out.println("tour YYYYYYYYY "+Jeu.getInstance().getTour());
				
				Reveler.function(Jeu.getInstance().getListJoueur(), Jeu.getInstance().getTour()+1, true);
				
				//Changement de joueur
				
				int tour = Jeu.getInstance().getTour()-1;
				Jeu.getInstance().setTour(tour);
				
				nomJ1.setText(Jeu.getInstance().getListJoueur().get(tour).getNom());
				roleJ1.setText(Jeu.getInstance().getListJoueur().get(tour).getRole());

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
