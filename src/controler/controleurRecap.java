package controlleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;

import model.Jeu;
import model.MVCReveler;
import vue.vue1;

public class controleurRecap {
	
private vue1 window;
	
	public controleurRecap(JButton AfficherPoints, JTextField nomJoueur1, JTextField nomJoueur2, JTextField nomJoueur3, JTextField nomJoueur4, JTextField nomJoueur5, JTextField nomJoueur6, JTextField pointsJoueur1, JTextField pointsJoueur2, JTextField pointsJoueur3, JTextField pointsJoueur4, JTextField pointsJoueur5, JTextField pointsJoueur6, JButton Suivant, vue1 window) {
		
		this.window=window;
		
		AfficherPoints.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nomJoueur1.setText(Jeu.getInstance().getNom1());
				nomJoueur2.setText(Jeu.getInstance().getNom2());
				nomJoueur3.setText(Jeu.getInstance().getNom3());
				nomJoueur4.setText(Jeu.getInstance().getNom4());
				nomJoueur5.setText(Jeu.getInstance().getNom5());
				nomJoueur6.setText(Jeu.getInstance().getNom6());
				
				int tailleJeu;
				tailleJeu=Jeu.getInstance().getListJoueur().size();
				
				if(tailleJeu>0) {
					
					pointsJoueur2.setVisible(false);
					pointsJoueur3.setVisible(false);
					pointsJoueur4.setVisible(false);
					pointsJoueur5.setVisible(false);
					pointsJoueur6.setVisible(false);
					int point = Jeu.getInstance().getListJoueur().get(0).getPoints();
					pointsJoueur1.setText(String.valueOf(point));
				}
				
				if(tailleJeu>1) {
					pointsJoueur2.setVisible(true);
					int point = Jeu.getInstance().getListJoueur().get(1).getPoints();
					pointsJoueur2.setText(String.valueOf(point));
				}
				
				
				if(tailleJeu>2) {
					pointsJoueur3.setVisible(true);
					int point = Jeu.getInstance().getListJoueur().get(2).getPoints();
					pointsJoueur3.setText(String.valueOf(point));
				}
				
				
				if(tailleJeu>3) {
					pointsJoueur4.setVisible(true);
					int point = Jeu.getInstance().getListJoueur().get(3).getPoints();
					pointsJoueur4.setText(String.valueOf(point));
				}
				
				if(tailleJeu>4) {
					pointsJoueur5.setVisible(true);
					int point = Jeu.getInstance().getListJoueur().get(4).getPoints();
					pointsJoueur5.setText(String.valueOf(point));
				}
				
				
				if(tailleJeu>5) {
					pointsJoueur6.setVisible(true);
					int point = Jeu.getInstance().getListJoueur().get(5).getPoints();
					pointsJoueur6.setText(String.valueOf(point));
				}
			}
		});

		
		
		Suivant.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Jeu.getInstance().aGagne();
				Jeu.getInstance().checkId();
				
				boolean winGame=Jeu.getInstance().getWin();
				System.out.println("Compteur ID: "+Jeu.getInstance().getCompteurIdentiteRevelee());
				
				if(winGame) {
					System.out.println("un joueur a gagné");
					window.invisiblePanel();
					window.setPanelVictoire(true);
				}
				else if(Jeu.getInstance().getReset()) {
					System.out.println("On recommence un round");
					window.invisiblePanel();
					window.setPanelTransition(true);
				}
				else {
					window.invisiblePanel();
					window.setPanelJoueurHunt(true);
				}
				
			}
		});
		
		
		
	}

}
