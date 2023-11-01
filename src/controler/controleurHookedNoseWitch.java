package controlleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;

import model.Jeu;
import vue.vue1;

public class controleurHookedNoseWitch {
	

	
	private vue1 window;
	
	public controleurHookedNoseWitch(JButton AfficherJeuHookedNoseWitch, JButton HookedNoseC1Witch, JButton HookedNoseC2Witch, JButton HookedNoseC3Witch, JButton HookedNoseC4Witch, JButton Valider3HookedNoseWitch, JTextField HookedNoseTextWitch, vue1 window) {
		this.window=window;
		
		AfficherJeuHookedNoseWitch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int tour = Jeu.getInstance().getTour();
				Jeu.getInstance().setTour(tour);
				
				int tailleJeu = Jeu.getInstance().getListJoueur().get(tour).getEnMain().size();
				
				String card;
				
				if(tailleJeu>0) {
					
					HookedNoseC4Witch.setVisible(false);
					HookedNoseC3Witch.setVisible(false);
					HookedNoseC2Witch.setVisible(false);
					card = Jeu.getInstance().getListJoueur().get(tour).getEnMain().get(0).getNom();
					HookedNoseC1Witch.setIcon(new ImageIcon("C:\\Users\\enzos\\eclipse-workspace\\TP4\\src\\Vue\\"+card+".JPG"));
				}
				
				if(tailleJeu>1) {
					HookedNoseC2Witch.setVisible(true);
					card = Jeu.getInstance().getListJoueur().get(tour).getEnMain().get(1).getNom();
					HookedNoseC2Witch.setIcon(new ImageIcon("C:\\Users\\enzos\\eclipse-workspace\\TP4\\src\\Vue\\"+card+".JPG"));
				}
				
				
				if(tailleJeu>2) {
					
					HookedNoseC3Witch.setVisible(true);
				
					card = Jeu.getInstance().getListJoueur().get(tour).getEnMain().get(2).getNom();
					HookedNoseC3Witch.setIcon(new ImageIcon("C:\\Users\\enzos\\eclipse-workspace\\TP4\\src\\Vue\\"+card+".JPG"));
				}
				
				
				if(tailleJeu>3) {
					
					HookedNoseC4Witch.setVisible(true);
					card = Jeu.getInstance().getListJoueur().get(tour).getEnMain().get(3).getNom();
					HookedNoseC4Witch.setIcon(new ImageIcon("C:\\Users\\enzos\\eclipse-workspace\\TP4\\src\\Vue\\"+card+".JPG"));
				}
			}
		});
		
		
		
		HookedNoseC1Witch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int tour = Jeu.getInstance().getTour();
				HookedNoseTextWitch.setText(Jeu.getInstance().getListJoueur().get(tour).getEnMain().get(0).getNom());
				Jeu.getInstance().setPointedHat(0);
			}
		});
		
		HookedNoseC2Witch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int tour = Jeu.getInstance().getTour();
				HookedNoseTextWitch.setText(Jeu.getInstance().getListJoueur().get(tour).getEnMain().get(1).getNom());
				Jeu.getInstance().setPointedHat(1);
			}
		});
		
		HookedNoseC3Witch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int tour = Jeu.getInstance().getTour();
				HookedNoseTextWitch.setText(Jeu.getInstance().getListJoueur().get(tour).getEnMain().get(2).getNom());
				Jeu.getInstance().setPointedHat(2);
			}
		});
		
		HookedNoseC4Witch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int tour = Jeu.getInstance().getTour();
				HookedNoseTextWitch.setText(Jeu.getInstance().getListJoueur().get(tour).getEnMain().get(3).getNom());
				Jeu.getInstance().setPointedHat(3);
			}
		});
		
		Valider3HookedNoseWitch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Jeu.getInstance().HookedNoseWitchMVC();
				Jeu.getInstance().setTour(Jeu.getInstance().getAccusation()-1);
				window.invisiblePanel();
				window.setup();
				window.setPanelRecap(true);
			}
		});

	}

}
