package controlleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;

import model.Jeu;
import vue.vue1;

public class controleurBlackCat {
	
	private vue1 window;
	
	public controleurBlackCat(JButton AfficherDiscard, JButton DiscardC1, JButton DiscardC2, JButton DiscardC3, JButton DiscardC4, JButton Valider4, JTextField CarteSelect, vue1 window) {
		this.window=window;
		
		AfficherDiscard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int tour = Jeu.getInstance().getTour();
				Jeu.getInstance().setTour(tour);
				
				int tailleJeu;
				tailleJeu=Jeu.getInstance().getDiscard().size();
				
				String card;
				
				if(tailleJeu>0) {
					
					DiscardC2.setVisible(false);
					DiscardC3.setVisible(false);
					DiscardC4.setVisible(false);
					card = Jeu.getInstance().getDiscard().get(0).getNom();
					DiscardC1.setIcon(new ImageIcon("C:\\Users\\enzos\\eclipse-workspace\\TP4\\src\\Vue\\"+card+".JPG"));
				}
				
				if(tailleJeu>1) {
					DiscardC2.setVisible(true);
					card = Jeu.getInstance().getDiscard().get(1).getNom();
					DiscardC2.setIcon(new ImageIcon("C:\\Users\\enzos\\eclipse-workspace\\TP4\\src\\Vue\\"+card+".JPG"));
				}
				
				
				if(tailleJeu>2) {
					
					DiscardC3.setVisible(true);
				
					card = Jeu.getInstance().getDiscard().get(2).getNom();
					DiscardC3.setIcon(new ImageIcon("C:\\Users\\enzos\\eclipse-workspace\\TP4\\src\\Vue\\"+card+".JPG"));
				}
				
				
				if(tailleJeu>3) {
					
					DiscardC4.setVisible(true);
					card = Jeu.getInstance().getDiscard().get(4).getNom();
					DiscardC4.setIcon(new ImageIcon("C:\\Users\\enzos\\eclipse-workspace\\TP4\\src\\Vue\\"+card+".JPG"));
				}
			}
		});
		
		
		
		DiscardC1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CarteSelect.setText(Jeu.getInstance().getDiscard().get(0).getNom());
				Jeu.getInstance().setBlackCat(0);
			}
		});
		
		DiscardC2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CarteSelect.setText(Jeu.getInstance().getDiscard().get(1).getNom());
				Jeu.getInstance().setBlackCat(1);
			}
		});
		
		DiscardC3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CarteSelect.setText(Jeu.getInstance().getDiscard().get(2).getNom());
				Jeu.getInstance().setBlackCat(2);
			}
		});
		
		DiscardC4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CarteSelect.setText(Jeu.getInstance().getDiscard().get(3).getNom());
				Jeu.getInstance().setBlackCat(3);
			}
		});
		
		Valider4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Jeu.getInstance().BlackCatMVC();

				window.invisiblePanel();
				window.setup();
				window.setPanelRecap(true);
			}
		});

	}

}
