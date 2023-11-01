package controlleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;

import model.Jeu;
import vue.vue1;

public class controleurTransition {

	private vue1 window;
	
	public controleurTransition(vue1 window, JButton boutonTransition, JButton Carte1, JButton Carte2, JButton Carte3, JButton Carte4, JButton Witcher, JButton Hunter, JTextField nomJ1, JTextField roleJ1, JTextField CarteSelect, JButton Accuser, JButton JouerHunt){
		
		this.window=window;
		
		boutonTransition.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//on appelle la fonction qui reset toutes les listes de carte des joueurs à zéro, les joueurs inciblables et on re distribue
				Jeu.getInstance().transition();
				
				window.invisiblePanel();
				Jeu.getInstance().setTour(0);
				int tour = Jeu.getInstance().getTour();
				nomJ1.setText(Jeu.getInstance().getListJoueur().get(tour).getNom());
				Witcher.setVisible(true);
				Hunter.setVisible(true);
				window.setup();
				nomJ1.setVisible(true);
				roleJ1.setVisible(false);
				Accuser.setVisible(false);
				CarteSelect.setVisible(false);
				JouerHunt.setVisible(false);
				window.setup();
				window.setPanelJoueurHunt(true);
			}
		});
	}
}