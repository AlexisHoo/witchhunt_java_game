package controlleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;

import model.Carte;
import model.Jeu;
import vue.vue1;

public class controleurPointedHatHunt {
	
	private vue1 window;
	
	public controleurPointedHatHunt(JButton AfficherJeu, JButton PointedHatC1, JButton PointedHatC2, JButton PointedHatC3, JButton PointedHatC4, JButton Valider3, JTextField CarteSelect, vue1 window) {
		this.window=window;
		
		AfficherJeu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int tour = Jeu.getInstance().getTour();
				Jeu.getInstance().setTour(tour);
				
				int tailleJeu;
				tailleJeu=Jeu.getInstance().getListJoueur().get(tour).getEnJeu().size();
				
				String card;
				
				if(tailleJeu>0) {
					
					PointedHatC4.setVisible(false);
					PointedHatC3.setVisible(false);
					PointedHatC2.setVisible(false);
					card = Jeu.getInstance().getListJoueur().get(tour).getEnJeu().get(0).getNom();
					PointedHatC1.setIcon(new ImageIcon("C:\\Users\\enzos\\eclipse-workspace\\TP4\\src\\Vue\\"+card+".JPG"));
				}
				
				if(tailleJeu>1) {
					PointedHatC2.setVisible(true);
					card = Jeu.getInstance().getListJoueur().get(tour).getEnJeu().get(1).getNom();
					PointedHatC2.setIcon(new ImageIcon("C:\\Users\\enzos\\eclipse-workspace\\TP4\\src\\Vue\\"+card+".JPG"));
				}
				
				
				if(tailleJeu>2) {
					
					PointedHatC3.setVisible(true);
				
					card = Jeu.getInstance().getListJoueur().get(tour).getEnJeu().get(2).getNom();
					PointedHatC3.setIcon(new ImageIcon("C:\\Users\\enzos\\eclipse-workspace\\TP4\\src\\Vue\\"+card+".JPG"));
				}
				
				
				if(tailleJeu>3) {
					
					PointedHatC4.setVisible(true);
					card = Jeu.getInstance().getListJoueur().get(tour).getEnJeu().get(3).getNom();
					PointedHatC4.setIcon(new ImageIcon("C:\\Users\\enzos\\eclipse-workspace\\TP4\\src\\Vue\\"+card+".JPG"));
				}
			}
		});
		
		
		
		PointedHatC1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int tour = Jeu.getInstance().getTour();
				CarteSelect.setText(Jeu.getInstance().getListJoueur().get(tour).getEnJeu().get(0).getNom());
				Jeu.getInstance().setPointedHat(0);
			}
		});
		
		PointedHatC2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int tour = Jeu.getInstance().getTour();
				CarteSelect.setText(Jeu.getInstance().getListJoueur().get(tour).getEnJeu().get(1).getNom());
				Jeu.getInstance().setPointedHat(1);
			}
		});
		
		PointedHatC3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int tour = Jeu.getInstance().getTour();
				CarteSelect.setText(Jeu.getInstance().getListJoueur().get(tour).getEnJeu().get(2).getNom());
				Jeu.getInstance().setPointedHat(2);
			}
		});
		
		PointedHatC4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int tour = Jeu.getInstance().getTour();
				CarteSelect.setText(Jeu.getInstance().getListJoueur().get(tour).getEnJeu().get(3).getNom());
				Jeu.getInstance().setPointedHat(3);
			}
		});
		
		Valider3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Jeu.getInstance().PointedHatMVC();
				System.out.println("villageois");
				window.invisiblePanel();
				window.setPanelChooseNextPlayer(true);
			}
		});

	}

}
