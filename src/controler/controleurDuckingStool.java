package controlleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JTextField;

import model.Jeu;
import model.Reveler;
import vue.vue1;

public class controleurDuckingStool {
	
	private vue1 window;

	public controleurDuckingStool(vue1 window,JButton boutonDS1,JButton boutonDS2,JButton boutonDS3,JButton boutonDS4,JButton boutonDS5,JButton boutonDS6,JCheckBox boxDS1,JCheckBox boxDS2,JLabel labelDS1, JLabel labelDS2,JTextField textDS, JTextField nomJ1,  JTextField roleJ1, JButton Carte1, JButton Carte2, JButton Carte3, JButton Carte4, JButton Accuser, JTextField CarteSelect, JButton JouerHunt) {
		
		this.window=window;
		
		boutonDS1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//On regarde son choix
				Jeu.getInstance().setDSPlayer(textDS);
				
				//On affiche les autres boutons
				boutonDS6.setVisible(true);
				boxDS1.setVisible(true);
				boxDS2.setVisible(true);
				labelDS2.setVisible(true);
				
			}
		});
		
		boutonDS6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int tailleJeuDS;
				String cardDS;
				
				
				
				//On prends le choix des box
				if(boxDS1.isSelected()) {
					//Le joueur révèle son identité
					Reveler.function(Jeu.getInstance().getListJoueur(), Jeu.getInstance().getDSPlayer(), false);
					
					Jeu.getInstance().DSMVC2();
	
					
					//Prochain tour
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
				
				
				
				else if(boxDS2.isSelected()) {
					
					//On rend visible les cartes du jouer ciblé
					boutonDS2.setVisible(true);
					boutonDS3.setVisible(true);
					boutonDS4.setVisible(true);
					boutonDS5.setVisible(true);
					
					Jeu.getInstance().setTour(Jeu.getInstance().getDSPlayer());
					
					//On prend la taille du jeu pour afficher chaque carte en fonction
					int tourDS=Jeu.getInstance().getDSPlayer()-1;
					tailleJeuDS=Jeu.getInstance().getListJoueur().get(tourDS).getEnMain().size();
					
					
					if(tailleJeuDS>0) {
						
						boutonDS3.setVisible(false);
						boutonDS4.setVisible(false);
						boutonDS5.setVisible(false);
						cardDS = Jeu.getInstance().getListJoueur().get(tourDS).getEnMain().get(0).getNom();
						boutonDS2.setIcon(new ImageIcon("C:\\Users\\enzos\\eclipse-workspace\\TP4\\src\\Vue\\"+cardDS+".JPG"));
					}
					
					if(tailleJeuDS>1) {
						boutonDS3.setVisible(true);
						cardDS = Jeu.getInstance().getListJoueur().get(tourDS).getEnMain().get(1).getNom();
						boutonDS3.setIcon(new ImageIcon("C:\\Users\\enzos\\eclipse-workspace\\TP4\\src\\Vue\\"+cardDS+".JPG"));
					}
					
					
					if(tailleJeuDS>2) {
						
						boutonDS4.setVisible(true);
					
						cardDS = Jeu.getInstance().getListJoueur().get(tourDS).getEnMain().get(2).getNom();
						boutonDS4.setIcon(new ImageIcon("C:\\Users\\enzos\\eclipse-workspace\\TP4\\src\\Vue\\"+cardDS+".JPG"));
					}
					
					
					if(tailleJeuDS>3) {
						
						boutonDS5.setVisible(true);
						cardDS = Jeu.getInstance().getListJoueur().get(tourDS).getEnMain().get(3).getNom();
						boutonDS5.setIcon(new ImageIcon("C:\\Users\\enzos\\eclipse-workspace\\TP4\\src\\Vue\\"+cardDS+".JPG"));
					}
					
					
					
					
					
					
				}
				else {
					System.out.println("Vous devez choisir!");
				}
				
			}
		});
		
		
		//Bouton carte première
		boutonDS2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Jeu.getInstance().setDSChoixBox(0);
				Jeu.getInstance().duckingStoolMVC();
				
				//Pour le tour suivant
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
		
		boutonDS3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Jeu.getInstance().setDSChoixBox(1);
				Jeu.getInstance().duckingStoolMVC();
				
				//Pour le tour suivant
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
		
		boutonDS4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Jeu.getInstance().setDSChoixBox(2);
				Jeu.getInstance().duckingStoolMVC();
				
				//Pour le tour suivant
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
		
		boutonDS5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Jeu.getInstance().setDSChoixBox(3);
				Jeu.getInstance().duckingStoolMVC();
				
				//Pour le tour suivant
				int tour = Jeu.getInstance().getTour()-1;
				Jeu.getInstance().setTour(tour);
				
				int tailleJeu = Jeu.getInstance().getListJoueur().get(tour).getEnMain().size();
				
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