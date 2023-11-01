package controlleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;

import model.*;
import vue.vue1;


public class controlleurNomJoueur {
	
	private vue1 window;
	
	public controlleurNomJoueur(JButton Valider2, JTextField textJ1,JTextField textJ2,JTextField textJ3,JTextField textJ4,JTextField textJ5,JTextField textJ6, JButton Carte1, JButton Carte2, JButton Carte3, JButton Carte4, JButton Witcher, JButton Hunter, JTextField nomJ1, JTextField roleJ1, JTextField CarteSelect, JButton Accuser, JButton JouerHunt, vue1 window) {
		
		this.window=window;

		Valider2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				MVCDistribution.Distribution(textJ1, textJ2, textJ3, textJ4, textJ5, textJ6);
				
				int tour = 0;
				
				nomJ1.setText(Jeu.getInstance().getListJoueur().get(tour).getNom());
				Witcher.setVisible(true);
				Hunter.setVisible(true);
				window.setup();
				nomJ1.setVisible(true);
				roleJ1.setVisible(false);
				Accuser.setVisible(false);
				CarteSelect.setVisible(false);
				JouerHunt.setVisible(false);
				
				window.invisiblePanel();
				window.setPanelJoueurHunt(true);
			}
		});
				
	}

}