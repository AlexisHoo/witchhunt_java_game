package controlleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;

import model.Jeu;
import model.MVCJoueurAccuse;
import vue.vue1;

public class controleurAccuser {
	
	private vue1 window;
	
	public controleurAccuser(JButton AccuserJoueur, JTextField JoueurAccuse, JButton Carte1, JButton Carte2, JButton Carte3, JButton Carte4, JTextField nomJ1, JTextField roleJ1, JTextField CarteSelect, JButton Reveler, JButton JouerWitch, vue1 window) {
		
		this.window=window;
		
		AccuserJoueur.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int accusation = MVCJoueurAccuse.JoueurAccuse(JoueurAccuse)-1;
				
				nomJ1.setText(Jeu.getInstance().getListJoueur().get(accusation).getNom());
				
				int tailleJeu = Jeu.getInstance().getListJoueur().get(accusation).getEnMain().size();
				
				String card;
				
				if(tailleJeu>0) {
					
					Carte1.setVisible(true);
					Carte2.setVisible(false);
					Carte3.setVisible(false);
					Carte4.setVisible(false);
					card = Jeu.getInstance().getListJoueur().get(accusation).getEnMain().get(0).getNom();
					Carte1.setIcon(new ImageIcon("C:\\Users\\enzos\\eclipse-workspace\\TP4\\src\\Vue\\"+card+".JPG"));
				}
				
				if(tailleJeu>1) {
					Carte2.setVisible(true);
					card = Jeu.getInstance().getListJoueur().get(accusation).getEnMain().get(1).getNom();
					Carte2.setIcon(new ImageIcon("C:\\Users\\enzos\\eclipse-workspace\\TP4\\src\\Vue\\"+card+".JPG"));
				}
				
				
				if(tailleJeu>2) {
					
					Carte3.setVisible(true);
				
					card = Jeu.getInstance().getListJoueur().get(accusation).getEnMain().get(2).getNom();
					Carte3.setIcon(new ImageIcon("C:\\Users\\enzos\\eclipse-workspace\\TP4\\src\\Vue\\"+card+".JPG"));
				}
				
				
				if(tailleJeu>3) {
					
					Carte4.setVisible(true);
					card = Jeu.getInstance().getListJoueur().get(accusation).getEnMain().get(3).getNom();
					Carte4.setIcon(new ImageIcon("C:\\Users\\enzos\\eclipse-workspace\\TP4\\src\\Vue\\"+card+".JPG"));
				}
				
				nomJ1.setVisible(true);
				nomJ1.setText(Jeu.getInstance().getListJoueur().get(accusation).getNom());
				roleJ1.setVisible(true);
				roleJ1.setText(Jeu.getInstance().getListJoueur().get(accusation).getRole());
				CarteSelect.setVisible(true);
				Reveler.setVisible(true);
				JouerWitch.setVisible(true);
				
				window.invisiblePanel();
				window.setPanelJoueurWitch(true);
			}
		});
		
	}
	
}
