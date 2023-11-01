package controlleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;

import model.Jeu;
import model.Reveler;
import vue.vue1;

public class controleurAngryMob {
	private vue1 window;

	public controleurAngryMob(JButton boutonAngryMob,JTextField textAngryMob, vue1 window, JTextField nomJ1,  JTextField roleJ1, JButton Carte1, JButton Carte2, JButton Carte3, JButton Carte4, JButton Accuser, JTextField CarteSelect, JButton JouerHunt) {
		this.window=window;
		
		boutonAngryMob.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Jeu.getInstance().setAngryMobPlayerMVC(textAngryMob);
				
				//ON révèle son identité
				Reveler.function(Jeu.getInstance().getListJoueur(), Jeu.getInstance().getAngryMobPlayer(), false);
				
				Jeu.getInstance().angryMobMVC();
				
				
				int tour = Jeu.getInstance().getTour()-1;
				Jeu.getInstance().setTour(tour);
				
				int tailleJeu;
				tailleJeu=Jeu.getInstance().getListJoueur().get(tour).getEnMain().size();
				
				nomJ1.setText(Jeu.getInstance().getListJoueur().get(tour).getNom());
				roleJ1.setText(Jeu.getInstance().getListJoueur().get(tour).getRole());
				String card;
				
				if(tailleJeu>0) {
					
					Carte4.setVisible(false);
					Carte3.setVisible(false);
					Carte2.setVisible(false);
					card = Jeu.getInstance().getListJoueur().get(tour).getEnMain().get(0).getNom();
					Carte1.setIcon(new ImageIcon("C:\\Users\\enzos\\eclipse-workspace\\TP4\\src\\Vue\\"+card+".JPG"));
				}
				
				if(tailleJeu>1) {
					Carte2.setVisible(true);
					card = Jeu.getInstance().getListJoueur().get(tour).getEnMain().get(1).getNom();
					Carte2.setIcon(new ImageIcon("C:\\Users\\enzos\\eclipse-workspace\\TP4\\src\\Vue\\"+card+".JPG"));
				}
				
				
				if(tailleJeu>2) {
					
					Carte3.setVisible(true);
				
					card = Jeu.getInstance().getListJoueur().get(tour).getEnMain().get(2).getNom();
					Carte3.setIcon(new ImageIcon("C:\\Users\\enzos\\eclipse-workspace\\TP4\\src\\Vue\\"+card+".JPG"));
				}
				
				
				if(tailleJeu>3) {
					
					Carte4.setVisible(true);
					card = Jeu.getInstance().getListJoueur().get(tour).getEnMain().get(3).getNom();
					Carte4.setIcon(new ImageIcon("C:\\Users\\enzos\\eclipse-workspace\\TP4\\src\\Vue\\"+card+".JPG"));
				}
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