package controlleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;

import model.Jeu;
import model.MVCReveler;
import vue.vue1;

public class controleurJoueurWitch implements Observer{
	
	private vue1 window;
	
	public controleurJoueurWitch(JButton Carte1Hunt, JButton Carte2Hunt, JButton Carte3Hunt, JButton Carte4Hunt, JButton Carte1, JButton Carte2, JButton Carte3, JButton Carte4, JTextField nomJ1, JTextField roleJ1, JTextField CarteSelect, JButton Reveler, JButton JouerWitch, JButton Accuser, JButton JouerHunt, vue1 window) {
		
		this.window=window;
		Jeu.getInstance().addObserver(this);
				
		Carte1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int accusation = Jeu.getInstance().getAccusation()-1;
				CarteSelect.setText(Jeu.getInstance().getListJoueur().get(accusation).getEnMain().get(0).getNom());
			}
		});
		
		Carte2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int accusation = Jeu.getInstance().getAccusation()-1;
				CarteSelect.setText(Jeu.getInstance().getListJoueur().get(accusation).getEnMain().get(1).getNom());
			}
		});
		
		Carte3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int accusation = Jeu.getInstance().getAccusation()-1;
				CarteSelect.setText(Jeu.getInstance().getListJoueur().get(accusation).getEnMain().get(2).getNom());
			}
		});
		
		Carte4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int accusation = Jeu.getInstance().getAccusation()-1;
				CarteSelect.setText(Jeu.getInstance().getListJoueur().get(accusation).getEnMain().get(3).getNom());
			}
		});
		
		Reveler.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int tour = MVCReveler.Reveler();
				System.out.println("Le prochain jouer sera "+tour);
				
				nomJ1.setText(Jeu.getInstance().getListJoueur().get(tour).getNom());
				System.out.println(Jeu.getInstance().getListJoueur().get(tour).getRole());
				roleJ1.setText(Jeu.getInstance().getListJoueur().get(tour).getRole());
				window.setup();
				roleJ1.setVisible(true);
				CarteSelect.setVisible(true);
				Accuser.setVisible(true);
				JouerHunt.setVisible(true);
				
				window.invisiblePanel();
				window.setPanelRecap(true);
				
			}
		});
		
		JouerWitch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Sécurité si la carte est jouable
				System.out.println("On teste la carte Witch");
				Jeu.getInstance().testEffetWitchMVC(CarteSelect);
			}
		});
	}
	
	public void update(Observable o, Object arg) {
		String nomCarte;
		
		//Ne contient pas joueur et contient jouable
		if (!arg.equals("joueur") && arg.toString().contains("jouable")) {
			
			System.out.println("On va faire l'effet "+arg);
			System.out.println("On est dans le update de Witch ");
			
			nomCarte=arg.toString();
			nomCarte=nomCarte.replace("jouable", "");
			System.out.println("nomCarte:  "+nomCarte);
			 
			Jeu.getInstance().effetWitchMVC(nomCarte, window);
			
		}
		
	}
}
