package controlleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import model.Jeu;
import vue.vue1;

public class controleurWitchInquisition {
	
	private vue1 window;

	public controleurWitchInquisition(vue1 window,JButton boutonWitchInquisitionOk, JButton boutonWitchInquisition, JButton boutonWitchInquisition2, JButton boutonWitchInquisition3, JButton boutonWitchInquisition4) {
		
		this.window=window;
		
		boutonWitchInquisitionOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				Jeu.getInstance().setTour(Jeu.getInstance().getDSPlayer());
				
				//On prend la taille du jeu pour afficher chaque carte en fonction
				int tourInqWitch=Jeu.getInstance().getAccusation()-1;
				int tailleJeuDS=Jeu.getInstance().getListJoueur().get(tourInqWitch).getEnMain().size();
				String cardInqWitch;
				
				
				if(tailleJeuDS>0) {
					
					boutonWitchInquisition.setVisible(true);
					
					boutonWitchInquisition2.setVisible(false);
					boutonWitchInquisition3.setVisible(false);
					boutonWitchInquisition4.setVisible(false);
					cardInqWitch = Jeu.getInstance().getListJoueur().get(tourInqWitch).getEnMain().get(0).getNom();
					boutonWitchInquisition.setIcon(new ImageIcon("C:\\Users\\enzos\\eclipse-workspace\\TP4\\src\\Vue\\"+cardInqWitch+".JPG"));
				}
				
				if(tailleJeuDS>1) {
					boutonWitchInquisition2.setVisible(true);
					cardInqWitch = Jeu.getInstance().getListJoueur().get(tourInqWitch).getEnMain().get(1).getNom();
					boutonWitchInquisition2.setIcon(new ImageIcon("C:\\Users\\enzos\\eclipse-workspace\\TP4\\src\\Vue\\"+cardInqWitch+".JPG"));
				}
				
				
				if(tailleJeuDS>2) {
					
					boutonWitchInquisition3.setVisible(true);
				
					cardInqWitch = Jeu.getInstance().getListJoueur().get(tourInqWitch).getEnMain().get(2).getNom();
					boutonWitchInquisition3.setIcon(new ImageIcon("C:\\Users\\enzos\\eclipse-workspace\\TP4\\src\\Vue\\"+cardInqWitch+".JPG"));
				}
				
				
				if(tailleJeuDS>3) {
					
					boutonWitchInquisition4.setVisible(true);
					cardInqWitch = Jeu.getInstance().getListJoueur().get(tourInqWitch).getEnMain().get(3).getNom();
					boutonWitchInquisition4.setIcon(new ImageIcon("C:\\Users\\enzos\\eclipse-workspace\\TP4\\src\\Vue\\"+cardInqWitch+".JPG"));
				}
				
			}
			
			
		});
		
		
		//Il a choisi ses cartes
		boutonWitchInquisition.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Jeu.getInstance().setChoixInqWitch(0);
				Jeu.getInstance().InqWitchMVC();
				
				Jeu.getInstance().setTour( Jeu.getInstance().getAccusation()-1);
				
				//On prépare le tour suivant
				window.invisiblePanel();
				window.setup();
				window.setPanelRecap(true);
				}
		});
		
		boutonWitchInquisition2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Jeu.getInstance().setChoixInqWitch(1);
				Jeu.getInstance().InqWitchMVC();
				
				Jeu.getInstance().setTour( Jeu.getInstance().getAccusation()-1);
				
				//On prépare le tour suivant
				window.invisiblePanel();
				window.setup();
				window.setPanelRecap(true);
				}
		});
		
		boutonWitchInquisition3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Jeu.getInstance().setChoixInqWitch(2);
				Jeu.getInstance().InqWitchMVC();
				
				Jeu.getInstance().setTour( Jeu.getInstance().getAccusation()-1);
				
				//On prépare le tour suivant
				window.invisiblePanel();
				window.setup();
				window.setPanelRecap(true);
				}
		});
		
		boutonWitchInquisition4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Jeu.getInstance().setChoixInqWitch(3);
				Jeu.getInstance().InqWitchMVC();
				
				Jeu.getInstance().setTour( Jeu.getInstance().getAccusation()-1);
				
				//On prépare le tour suivant
				window.invisiblePanel();
				window.setup();
				window.setPanelRecap(true);
				}
		});
	}
}