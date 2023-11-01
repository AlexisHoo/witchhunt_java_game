package controlleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;

import model.Jeu;
import model.MVCAccuser;
import model.MVCDevenirSorciere;
import model.MVCDevenirVillageois;
import model.MajCard;
import vue.vue1;

public class controlleurJoueurHunt implements Observer{
	
	private vue1 window;
	
	public controlleurJoueurHunt(JButton Carte1, JButton Carte2, JButton Carte3, JButton Carte4, JButton Witcher, JButton Hunter, JTextField nomJ1, JTextField roleJ1, JTextField CarteSelect, JButton Accuser, JButton JouerHunt, vue1 window) {
		
		this.window=window;
		Jeu.getInstance().addObserver(this);
				
		Witcher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int tour = MVCDevenirSorciere.DevenirSorciere();
				
				roleJ1.setText(Jeu.getInstance().getListJoueur().get(tour).getRole());
				if(tour!=Jeu.getInstance().getNbrJoueur()-1) {
					
					Jeu.getInstance().setTour(tour+1);
					tour = Jeu.getInstance().getTour();
					
					nomJ1.setText(Jeu.getInstance().getListJoueur().get(tour).getNom());

					window.setup();
				}
				else {
					Witcher.setVisible(false);
					Hunter.setVisible(false);
					
					Jeu.getInstance().setTour(0);
					tour = Jeu.getInstance().getTour();
					
					nomJ1.setText(Jeu.getInstance().getListJoueur().get(tour).getNom());
					roleJ1.setText(Jeu.getInstance().getListJoueur().get(tour).getRole());

					window.setup();
					
					roleJ1.setVisible(true);
					CarteSelect.setVisible(true);
					Accuser.setVisible(true);
					JouerHunt.setVisible(true);
					
					window.invisiblePanel();
					window.setPanelRecap(true);
				}
			}
		});
		
		Hunter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int tour = MVCDevenirVillageois.DevenirVillageois();
				
				
				roleJ1.setText(Jeu.getInstance().getListJoueur().get(tour).getRole());
				if(tour!=Jeu.getInstance().getNbrJoueur()-1) {
					
					Jeu.getInstance().setTour(tour+1);
					tour = Jeu.getInstance().getTour();
					
					nomJ1.setText(Jeu.getInstance().getListJoueur().get(tour).getNom());

					window.setup();

				}
				else {
					Witcher.setVisible(false);
					Hunter.setVisible(false);
					
					Jeu.getInstance().setTour(0);
					tour = Jeu.getInstance().getTour();
					
					nomJ1.setText(Jeu.getInstance().getListJoueur().get(tour).getNom());
					roleJ1.setText(Jeu.getInstance().getListJoueur().get(tour).getRole());

					window.setup();
					
					roleJ1.setVisible(true);
					CarteSelect.setVisible(true);
					Accuser.setVisible(true);
					JouerHunt.setVisible(true);
					
					window.invisiblePanel();
					window.setPanelRecap(true);
				}
			}
		});
		
		Carte1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int tour = Jeu.getInstance().getTour();
				CarteSelect.setText(Jeu.getInstance().getListJoueur().get(tour).getEnMain().get(0).getNom());
			}
		});
		
		Carte2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int tour = Jeu.getInstance().getTour();
				CarteSelect.setText(Jeu.getInstance().getListJoueur().get(tour).getEnMain().get(1).getNom());
			}
		});
		
		Carte3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int tour = Jeu.getInstance().getTour();
				CarteSelect.setText(Jeu.getInstance().getListJoueur().get(tour).getEnMain().get(2).getNom());
			}
		});
		
		Carte4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int tour = Jeu.getInstance().getTour();
				CarteSelect.setText(Jeu.getInstance().getListJoueur().get(tour).getEnMain().get(3).getNom());
			}
		});
		
		Accuser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				MVCAccuser.Accuser();
				
				window.invisiblePanel();
				window.setPanelAccusation(true);
			}
		});
		
		JouerHunt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int tour = Jeu.getInstance().getTour();
				//Sécurité si la carte est jouable
				System.out.println("On teste la carte");
				Jeu.getInstance().testEffetHuntMVC(CarteSelect);
			}
		});
		
	}
	
	public void update(Observable o, Object arg) {
		
		String nomCarte;
		
		if (!arg.equals("joueur") && !arg.toString().contains("jouable")) {
			
			System.out.println("On va faire l'effet "+arg);
			
			 nomCarte=arg.toString();
			 
			Jeu.getInstance().effetHuntMVC(nomCarte, window);
			
		}
		
	}

}
