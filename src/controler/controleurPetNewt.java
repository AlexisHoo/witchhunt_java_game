package controlleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;

import model.Jeu;
import vue.vue1;

public class controleurPetNewt {
	
	private vue1 window;
	
	public controleurPetNewt(JButton AfficherJeux, JButton Jeu1, JButton Jeu2, JButton Jeu3, JButton Jeu4, JButton Jeu5, JButton Jeu6, JButton Jeu7, JButton Jeu8, vue1 window) {
		this.window=window;
		
		AfficherJeux.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int tour = Jeu.getInstance().getTour();
				Jeu.getInstance().setTour(tour);
				
				int tailleJeu;
				tailleJeu=Jeu.getInstance().getListJeux().size();
				System.out.println("test");
				
				String card;
				
				if(tailleJeu>0) {
					
					Jeu2.setVisible(false);
					Jeu3.setVisible(false);
					Jeu4.setVisible(false);
					Jeu5.setVisible(false);
					Jeu6.setVisible(false);
					Jeu7.setVisible(false);
					Jeu8.setVisible(false);
					card = Jeu.getInstance().getListJeux().get(0).getNom();
					Jeu1.setIcon(new ImageIcon("C:\\Users\\enzos\\eclipse-workspace\\TP4\\src\\Vue\\"+card+".JPG"));
				}
				
				if(tailleJeu>1) {
					Jeu2.setVisible(true);
					card = Jeu.getInstance().getListJeux().get(1).getNom();
					Jeu2.setIcon(new ImageIcon("C:\\Users\\enzos\\eclipse-workspace\\TP4\\src\\Vue\\"+card+".JPG"));
				}
				
				
				if(tailleJeu>2) {
					
					Jeu3.setVisible(true);
				
					card = Jeu.getInstance().getListJeux().get(2).getNom();
					Jeu3.setIcon(new ImageIcon("C:\\Users\\enzos\\eclipse-workspace\\TP4\\src\\Vue\\"+card+".JPG"));
				}
				
				
				if(tailleJeu>3) {
					
					Jeu4.setVisible(true);
					card = Jeu.getInstance().getListJeux().get(3).getNom();
					Jeu4.setIcon(new ImageIcon("C:\\Users\\enzos\\eclipse-workspace\\TP4\\src\\Vue\\"+card+".JPG"));
				}
				
				if(tailleJeu>4) {
					Jeu5.setVisible(true);
					card = Jeu.getInstance().getListJeux().get(4).getNom();
					Jeu5.setIcon(new ImageIcon("C:\\Users\\enzos\\eclipse-workspace\\TP4\\src\\Vue\\"+card+".JPG"));
				}
				
				
				if(tailleJeu>5) {
					
					Jeu6.setVisible(true);
				
					card = Jeu.getInstance().getListJeux().get(5).getNom();
					Jeu6.setIcon(new ImageIcon("C:\\Users\\enzos\\eclipse-workspace\\TP4\\src\\Vue\\"+card+".JPG"));
				}
				
				
				if(tailleJeu>6) {
					
					Jeu7.setVisible(true);
					card = Jeu.getInstance().getListJeux().get(6).getNom();
					Jeu7.setIcon(new ImageIcon("C:\\Users\\enzos\\eclipse-workspace\\TP4\\src\\Vue\\"+card+".JPG"));
				}
				
				if(tailleJeu>7) {
					
					Jeu8.setVisible(true);
					card = Jeu.getInstance().getListJeux().get(7).getNom();
					Jeu8.setIcon(new ImageIcon("C:\\Users\\enzos\\eclipse-workspace\\TP4\\src\\Vue\\"+card+".JPG"));
				}
			}
		});
		
		
		
		Jeu1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Jeu.getInstance().setPointedHat(0);
				Jeu.getInstance().setPetNewt(Jeu.getInstance().getListJoueurJeux().get(0));
				Jeu.getInstance().PetNewtMVC();
				window.invisiblePanel();
				window.setPanelChooseNextPlayer(true);
			}
		});
		
		Jeu2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Jeu.getInstance().setPointedHat(1);
				Jeu.getInstance().setPetNewt(Jeu.getInstance().getListJoueurJeux().get(1));
				Jeu.getInstance().PetNewtMVC();
				window.invisiblePanel();
				window.setPanelChooseNextPlayer(true);
			}
		});
		
		Jeu3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Jeu.getInstance().setPointedHat(2);
				Jeu.getInstance().setPetNewt(Jeu.getInstance().getListJoueurJeux().get(2));
				Jeu.getInstance().PetNewtMVC();
				window.invisiblePanel();
				window.setPanelChooseNextPlayer(true);
			}
		});
		
		Jeu4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Jeu.getInstance().setPointedHat(3);
				Jeu.getInstance().setPetNewt(Jeu.getInstance().getListJoueurJeux().get(3));
				Jeu.getInstance().PetNewtMVC();
				window.invisiblePanel();
				window.setPanelChooseNextPlayer(true);
			}
		});
		
		Jeu5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Jeu.getInstance().setPointedHat(4);
				Jeu.getInstance().setPetNewt(Jeu.getInstance().getListJoueurJeux().get(4));
				Jeu.getInstance().PetNewtMVC();
				window.invisiblePanel();
				window.setPanelChooseNextPlayer(true);
			}
		});
		
		Jeu6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Jeu.getInstance().setPointedHat(5);
				Jeu.getInstance().setPetNewt(Jeu.getInstance().getListJoueurJeux().get(5));
				Jeu.getInstance().PetNewtMVC();
				window.invisiblePanel();
				window.setPanelChooseNextPlayer(true);
			}
		});
		
		Jeu7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Jeu.getInstance().setPointedHat(6);
				Jeu.getInstance().setPetNewt(Jeu.getInstance().getListJoueurJeux().get(6));
				Jeu.getInstance().PetNewtMVC();
				window.invisiblePanel();
				window.setPanelChooseNextPlayer(true);
			}
		});
		
		Jeu8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Jeu.getInstance().setPointedHat(7);
				Jeu.getInstance().setPetNewt(Jeu.getInstance().getListJoueurJeux().get(7));
				Jeu.getInstance().PetNewtMVC();
				window.invisiblePanel();
				window.setPanelChooseNextPlayer(true);
			}
		});
		

	}
	

}
