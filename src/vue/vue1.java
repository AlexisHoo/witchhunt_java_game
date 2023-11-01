package vue;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controlleur.controleurAccuser;
import controlleur.controleurAngryMob;
import controlleur.controleurBlackCat;
import controlleur.controleurChooseNextPlayer;
import controlleur.controleurDuckingStool;
import controlleur.controleurHookedNose;
import controlleur.controleurHookedNoseWitch;
import controlleur.controleurJoueurWitch;
import controlleur.controleurPetNewt;
import controlleur.controleurPointedHatHunt;
import controlleur.controleurPointedHatWitch;
import controlleur.controleurRecap;
import controlleur.controleurTheInquisition;
import controlleur.controleurTransition;
import controlleur.controleurVictoire;
import controlleur.controleurWitchInquisition;
import controlleur.controlleur;
import controlleur.controlleurJoueurHunt;
import controlleur.controlleurNomJoueur;
import model.Jeu;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;

import javax.swing.JLabel;

public class vue1 {
	
	public void setPanelNbrJoueur(boolean i) {
		panelNbrJoueur.setVisible(i);
	}
	
	public void setPanelNomJoueur(boolean i) {
		panelNomJoueur.setVisible(i);
	}
	
	public void setPanelJoueurHunt(boolean i) {
		panelJoueur.setVisible(i);
	}
	public void setPanelAccusation(boolean i) {
		panelAccusation.setVisible(i);
	}
	public void setPanelJoueurWitch(boolean i) {
		panelJoueurWitch.setVisible(i);
	}
	
	public void setPanelChooseNextPlayer(boolean i) {
		panelChooseNextPlayer.setVisible(i);
	}
	public void setPanelTheInquisition(boolean i) {
		panelTheInquisition.setVisible(i);
	}
	public void setPanelPointedHatHunt(boolean i) {
		panelPointedHatHunt.setVisible(i);
	}
	public void setPanelPointedHatWitch(boolean i) {
		panelPointedHatWitch.setVisible(i);
	}
	public void setPanelBlackCat(boolean i) {
		panelBlackCat.setVisible(i);
	}
	public void setPanelPetNewt(boolean i) {
		panelPetNewt.setVisible(i);
	}
	public void setPanelAngryMob(boolean i) {
		panelAngryMob.setVisible(i);
	}
	public void setPanelHookedNose(boolean i) {
		panelHookedNose.setVisible(i);
	}
	public void setPanelHookedNoseWitch(boolean i) {
		panelHookedNoseWitch.setVisible(i);
	}
	public void setPanelDuckingStool(boolean i) {
		panelDuckingStool.setVisible(i);
	}
	public void setPanelWitchInquisition(boolean i) {
		panelWitchInquisition.setVisible(i);
	}
	public void setPanelRecap(boolean i) {
		panelRecap.setVisible(i);
	}
	public void setPanelVictoire(boolean i) {
		panelVictoire.setVisible(i);
	}
	public void setPanelTransition(boolean i) {
		panelTransition.setVisible(i);
	}
	
	public void invisiblePanel() {
		panelNbrJoueur.setVisible(false);
		panelNomJoueur.setVisible(false);
		panelJoueur.setVisible(false);
		panelAccusation.setVisible(false);
		panelJoueurWitch.setVisible(false);
		panelChooseNextPlayer.setVisible(false);
		panelTheInquisition.setVisible(false);
		panelPointedHatHunt.setVisible(false);
		panelPointedHatWitch.setVisible(false);
		panelBlackCat.setVisible(false);
		panelPetNewt.setVisible(false);
		panelAngryMob.setVisible(false);
		panelHookedNose.setVisible(false);
		panelHookedNoseWitch.setVisible(false);
		panelDuckingStool.setVisible(false);
		panelRecap.setVisible(false);
		panelWitchInquisition.setVisible(false);
		panelVictoire.setVisible(false);
		panelTransition.setVisible(false);
	}
	
	public void setup() {
		int tour = Jeu.getInstance().getTour();
		Jeu.getInstance().setTour(tour);
		
		nomJ1.setText(Jeu.getInstance().getListJoueur().get(tour).getNom());
		
		int tailleJeu;
		tailleJeu=Jeu.getInstance().getListJoueur().get(tour).getEnMain().size();
		System.out.println("test");
		
		String card;
		
		if(tailleJeu>0) {
			
			Carte1.setVisible(true);
			Carte2.setVisible(false);
			Carte3.setVisible(false);
			Carte4.setVisible(false);
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
	}

	private JFrame frame;
	
	//Panel nombre joueur
	private JTextField textField;
	private JButton Valider;
	private JTextField textField_1;
	private JPanel panelNbrJoueur;
	
	//Panel Inquisition witch
	private JPanel panelWitchInquisition;
	private JLabel labelWitchInquisition;
	private JButton boutonWitchInquisition;
	private JButton boutonWitchInquisition2;
	private JButton boutonWitchInquisition3;
	private JButton boutonWitchInquisition4;
	private JButton boutonWitchInquisitionOk;
	
	//Panel Nom des joueurs
	private JPanel panelNomJoueur;
	private JTextField textJ1;
	private JTextField textJ2;
	private JTextField textJ3;
	private JTextField textJ4;
	private JTextField textJ5;
	private JTextField textJ6;
	private JButton Valider2;
	
	//Panel JoueurHunt
	private JPanel panelJoueur;
	private JButton Carte1;
	private JButton Carte2;
	private JButton Carte3;
	private JButton Carte4;
	private JTextField nomJ1;
	private JTextField roleJ1;
	private JTextField CarteSelect;
	private JButton Witcher;
	private JButton Hunter;
	private JButton Accuser;
	private JButton JouerHunt;
	
	//Panel Accusation
	private JPanel panelAccusation;
	private JLabel LabelAccusation;
	private JTextField JoueurAccuse;
	private JButton AccuserJoueur;
	
	//Panel JoueurWitch
	private JPanel panelJoueurWitch;
	private JButton Carte1Witch;
	private JButton Carte2Witch;
	private JButton Carte3Witch;
	private JButton Carte4Witch;
	private JTextField nomJ1Witch;
	private JTextField roleJ1Witch;
	private JTextField CarteSelectWitch;
	private JButton Reveler;
	private JButton JouerWitch;
		
	
	//PanelChooseNextPlayer
	private JPanel panelChooseNextPlayer;
	private JButton btnNewButtonChooseNextPlayer;
	private JTextField textFieldChooseNextPlayer;
	private JLabel labelChooseNextPlayer;
	
	//Panel TheInquisition
	private JPanel panelTheInquisition;
	private JButton btnNewButtonTheInquisition;
	private JTextField textFieldTheInquisition;
	private JLabel labelTheInquisition;
	
	//Panel PointedHat
	private JPanel panelPointedHatHunt;
	private JButton PointedHatC1;
	private JButton PointedHatC2;
	private JButton PointedHatC3;
	private JButton PointedHatC4;
	private JButton Valider3;
	private JTextField PointedHatText;
	private JButton AfficherJeu;
	
	private JPanel panelPointedHatWitch;
	private JButton PointedHatC1Witch;
	private JButton PointedHatC2Witch;
	private JButton PointedHatC3Witch;
	private JButton PointedHatC4Witch;
	private JButton Valider3Witch;
	private JTextField PointedHatTextWitch;
	private JButton AfficherJeuWitch;
	
	//Panel PointedHat
	private JPanel panelBlackCat;
	private JButton DiscardC1;
	private JButton DiscardC2;
	private JButton DiscardC3;
	private JButton DiscardC4;
	private JButton Valider4;
	private JTextField DiscardText;
	private JButton AfficherDiscard;
	
	//Panel PetNewt
	private JPanel panelPetNewt;
	private JButton Jeu1;
	private JButton Jeu2;
	private JButton Jeu3;
	private JButton Jeu4;
	private JButton Jeu5;
	private JButton Jeu6;
	private JButton Jeu7;
	private JButton Jeu8;
	private JButton AfficherJeux;
	
	//Panel AngryMob
	private JPanel panelAngryMob;
	private JTextField textAngryMob;
	private JButton boutonAngryMob;
	private JLabel labelAngryMob;
	
	//Panel hooked Nose
	private JPanel panelHookedNose;
	private JTextField textHookedNose;
	private JButton boutonHookedNose;
	private JLabel labelHookedNose;
	
	//Panel Hooked Nose Witch
	private JPanel panelHookedNoseWitch;
	private JButton HookedNoseC1Witch;
	private JButton HookedNoseC2Witch;
	private JButton HookedNoseC3Witch;
	private JButton HookedNoseC4Witch;
	private JTextField HookedNoseTextWitch;
	private JButton Valider3HookedNoseWitch;
	private JButton AfficherJeuHookedNoseWitch;
	
	
	//Panel Ducking stool
	private JCheckBox boxDuckingStool1;
	private JCheckBox boxDuckingStool2;
	private JPanel panelDuckingStool;
	private JLabel labelDuckingStool1;
	private JTextField textDuckingStool;
	private JButton boutonDuckingStool1;
	private JLabel labelDuckingStool2;
	private JButton boutonDuckingStool2;
	private JButton boutonDuckingStool3;
	private JButton boutonDuckingStool4;
	private JButton boutonDuckingStool5;
	private JButton boutonDuckingStool6;
	
	//Panel Recap
	private JPanel panelRecap;
	private JTextField nomJoueur1;
	private JTextField nomJoueur2;
	private JTextField nomJoueur3;
	private JTextField pointsJoueur1;
	private JTextField pointsJoueur2;
	private JTextField pointsJoueur3;
	private JTextField nomJoueur4;
	private JTextField nomJoueur5;
	private JTextField nomJoueur6;
	private JTextField pointsJoueur4;
	private JTextField pointsJoueur5;
	private JTextField pointsJoueur6;
	private JButton Suivant;
	private JButton AfficherPoints;
	
	//Panel Victoire
	private JPanel panelVictoire;
	private JTextField textVictoire;
	
	//Panel transition
	private JPanel panelTransition;
	private JLabel labelTransition;
	private JButton boutonTransition;
	
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_3_1;
	private JLabel lblNewLabel_3_2;
	private JLabel lblNewLabel_3_3;
	private JLabel lblNewLabel_3_4;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		Jeu.getInstance();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					vue1 window = new vue1();
					new controlleur(window.Valider,window.textField,window.textField_1,window);
					new controlleurNomJoueur(window.Valider2, window.textJ1, window.textJ2, window.textJ3, window.textJ4, window.textJ5, window.textJ6, window.Carte1, window.Carte2, window.Carte3, window.Carte4, window.Witcher, window.Hunter, window.nomJ1, window.roleJ1, window.CarteSelect, window.Accuser, window.JouerHunt, window);
					new controlleurJoueurHunt(window.Carte1, window.Carte2, window.Carte3, window.Carte4, window.Witcher, window.Hunter, window.nomJ1, window.roleJ1, window.CarteSelect, window.Accuser, window.JouerHunt, window);
					new controleurAccuser(window.AccuserJoueur, window.JoueurAccuse, window.Carte1Witch, window.Carte2Witch, window.Carte3Witch, window.Carte4Witch, window.nomJ1Witch, window.roleJ1Witch, window.CarteSelectWitch, window.Reveler, window.JouerWitch, window);
					new controleurJoueurWitch(window.Carte1, window.Carte2, window.Carte3, window.Carte4, window.Carte1Witch, window.Carte2Witch, window.Carte3Witch, window.Carte4Witch, window.nomJ1, window.roleJ1, window.CarteSelectWitch, window.Reveler, window.JouerWitch, window.Accuser, window.JouerHunt, window);
					new controleurChooseNextPlayer(window.btnNewButtonChooseNextPlayer, window, window.textFieldChooseNextPlayer,  window.nomJ1,  window.roleJ1, window.Carte1, window.Carte2, window.Carte3, window.Carte4, window.Accuser, window.CarteSelect, window.JouerHunt);
					new controleurTheInquisition(window.btnNewButtonTheInquisition, window, window.textFieldTheInquisition, window.nomJ1, window.roleJ1, window.Carte1, window.Carte2, window.Carte3, window.Carte4, window.Accuser, window.CarteSelect, window.JouerHunt);
					new controleurPointedHatHunt(window.AfficherJeu, window.PointedHatC1, window.PointedHatC2, window.PointedHatC3, window.PointedHatC4, window.Valider3, window.PointedHatText, window);
					new controleurPointedHatWitch(window.AfficherJeuWitch, window.PointedHatC1Witch, window.PointedHatC2Witch, window.PointedHatC3Witch, window.PointedHatC4Witch, window.Valider3Witch, window.PointedHatTextWitch, window);
					new controleurBlackCat(window.AfficherDiscard, window.DiscardC1, window.DiscardC2, window.DiscardC3, window.DiscardC4, window.Valider4, window.DiscardText, window);
					new controleurPetNewt(window.AfficherJeux, window.Jeu1, window.Jeu2, window.Jeu3, window.Jeu4,  window.Jeu5, window.Jeu6, window.Jeu7, window.Jeu8, window);
					new controleurAngryMob(window.boutonAngryMob, window.textAngryMob, window,window.nomJ1,  window.roleJ1, window.Carte1,window.Carte2, window.Carte3, window.Carte4, window.Accuser, window.CarteSelect, window.JouerHunt);
					new controleurHookedNose(window.textHookedNose, window.boutonHookedNose, window,window.nomJ1,  window.roleJ1, window.Carte1,window.Carte2, window.Carte3, window.Carte4, window.Accuser, window.CarteSelect, window.JouerHunt);
					new controleurHookedNoseWitch(window.AfficherJeuHookedNoseWitch, window.HookedNoseC1Witch, window.HookedNoseC2Witch, window.HookedNoseC3Witch, window.HookedNoseC4Witch, window.Valider3HookedNoseWitch, window.HookedNoseTextWitch, window);
					new controleurDuckingStool(window, window.boutonDuckingStool1,window.boutonDuckingStool2,window.boutonDuckingStool3,window.boutonDuckingStool4,window.boutonDuckingStool5,window.boutonDuckingStool6,window.boxDuckingStool1,window.boxDuckingStool2,window.labelDuckingStool2, window.labelDuckingStool2,window.textDuckingStool, window.nomJ1,  window.roleJ1, window.Carte1, window.Carte2, window.Carte3, window.Carte4, window.Accuser, window.CarteSelect, window.JouerHunt);
					new controleurRecap(window.AfficherPoints, window.nomJoueur1, window.nomJoueur2, window.nomJoueur3, window.nomJoueur4, window.nomJoueur5, window.nomJoueur6, window.pointsJoueur1, window.pointsJoueur2, window.pointsJoueur3, window.pointsJoueur4, window.pointsJoueur5, window.pointsJoueur6, window.Suivant, window);
					new controleurWitchInquisition(window,window.boutonWitchInquisitionOk, window.boutonWitchInquisition, window.boutonWitchInquisition2, window.boutonWitchInquisition3, window.boutonWitchInquisition4);
					new controleurVictoire(window, window.textVictoire);
					new controleurTransition(window, window.boutonTransition,  window.Carte1,  window.Carte2,  window.Carte3,  window.Carte4,  window.Witcher,  window.Hunter,  window.nomJ1,  window.roleJ1,  window.CarteSelect,  window.Accuser,  window.JouerHunt);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public vue1() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		//Panel TRansition
		panelTransition = new JPanel();
		panelTransition.setBounds(0, 0, 434, 261);
		frame.getContentPane().add(panelTransition);
		panelTransition.setLayout(null);
		
		labelTransition = new JLabel("Le round est termin�, redistribution des cartes !");
		labelTransition.setBounds(99, 53, 232, 23);
		panelTransition.add(labelTransition);
		
		boutonTransition = new JButton("Ok !");
		boutonTransition.setBounds(177, 147, 89, 23);
		panelTransition.add(boutonTransition);
		
		//Panel Victoire
		panelVictoire = new JPanel();
		panelVictoire.setBounds(0, 0, 434, 261);
		frame.getContentPane().add(panelVictoire);
		panelVictoire.setLayout(null);
		
		textVictoire = new JTextField();
		textVictoire.setBounds(92, 97, 239, 56);
		panelVictoire.add(textVictoire);
		textVictoire.setColumns(10);
		
		//Panel Inquisition Witch
		panelWitchInquisition = new JPanel();
		panelWitchInquisition.setBounds(0, 0, 434, 261);
		frame.getContentPane().add(panelWitchInquisition);
		panelWitchInquisition.setLayout(null);
		
		labelWitchInquisition = new JLabel("Dicscard une carte de votre main");
		labelWitchInquisition.setBounds(132, 39, 187, 21);
		panelWitchInquisition.add(labelWitchInquisition);
		
		boutonWitchInquisition = new JButton("New button");
		boutonWitchInquisition.setBounds(10, 100, 100, 139);
		panelWitchInquisition.add(boutonWitchInquisition);
		boutonWitchInquisition.setVisible(false);
		
		boutonWitchInquisition2 = new JButton("New button");
		boutonWitchInquisition2.setBounds(120, 100, 89, 139);
		panelWitchInquisition.add(boutonWitchInquisition2);
		boutonWitchInquisition2.setVisible(false);
		
		boutonWitchInquisition3 = new JButton("New button");
		boutonWitchInquisition3.setBounds(219, 100, 106, 139);
		panelWitchInquisition.add(boutonWitchInquisition3);
		boutonWitchInquisition3.setVisible(false);
		
		boutonWitchInquisition4 = new JButton("New button");
		boutonWitchInquisition4.setBounds(335, 100, 99, 139);
		panelWitchInquisition.add(boutonWitchInquisition4);
		boutonWitchInquisition4.setVisible(false);
		
		boutonWitchInquisitionOk = new JButton("Ok !");
		boutonWitchInquisitionOk.setBounds(166, 71, 89, 23);
		panelWitchInquisition.add(boutonWitchInquisitionOk);
		
		panelRecap = new JPanel();
		panelRecap.setBounds(0, 0, 434, 261);
		frame.getContentPane().add(panelRecap);
		panelRecap.setLayout(null);
		
		nomJoueur1 = new JTextField();
		nomJoueur1.setBounds(26, 34, 96, 19);
		panelRecap.add(nomJoueur1);
		nomJoueur1.setColumns(10);
		
		nomJoueur2 = new JTextField();
		nomJoueur2.setColumns(10);
		nomJoueur2.setBounds(164, 34, 96, 19);
		panelRecap.add(nomJoueur2);
		
		nomJoueur3 = new JTextField();
		nomJoueur3.setColumns(10);
		nomJoueur3.setBounds(299, 34, 96, 19);
		panelRecap.add(nomJoueur3);
		
		pointsJoueur1 = new JTextField();
		pointsJoueur1.setColumns(10);
		pointsJoueur1.setBounds(26, 82, 96, 19);
		panelRecap.add(pointsJoueur1);
		
		pointsJoueur2 = new JTextField();
		pointsJoueur2.setColumns(10);
		pointsJoueur2.setBounds(164, 82, 96, 19);
		panelRecap.add(pointsJoueur2);
		
		pointsJoueur3 = new JTextField();
		pointsJoueur3.setColumns(10);
		pointsJoueur3.setBounds(299, 82, 96, 19);
		panelRecap.add(pointsJoueur3);
		
		nomJoueur4 = new JTextField();
		nomJoueur4.setColumns(10);
		nomJoueur4.setBounds(26, 148, 96, 19);
		panelRecap.add(nomJoueur4);
		
		nomJoueur5 = new JTextField();
		nomJoueur5.setColumns(10);
		nomJoueur5.setBounds(164, 148, 96, 19);
		panelRecap.add(nomJoueur5);
		
		nomJoueur6 = new JTextField();
		nomJoueur6.setColumns(10);
		nomJoueur6.setBounds(299, 148, 96, 19);
		panelRecap.add(nomJoueur6);
		
		pointsJoueur4 = new JTextField();
		pointsJoueur4.setColumns(10);
		pointsJoueur4.setBounds(26, 196, 96, 19);
		panelRecap.add(pointsJoueur4);
		
		pointsJoueur5 = new JTextField();
		pointsJoueur5.setColumns(10);
		pointsJoueur5.setBounds(164, 196, 96, 19);
		panelRecap.add(pointsJoueur5);
		
		pointsJoueur6 = new JTextField();
		pointsJoueur6.setColumns(10);
		pointsJoueur6.setBounds(299, 196, 96, 19);
		panelRecap.add(pointsJoueur6);
		
		Suivant = new JButton("Suivant");
		Suivant.setBounds(164, 230, 85, 21);
		panelRecap.add(Suivant);
		
		AfficherPoints = new JButton("Afficher Points");
		AfficherPoints.setBounds(164, 10, 106, 21);
		panelRecap.add(AfficherPoints);
		
		//Panel DuckingStool
		panelDuckingStool = new JPanel();
		panelDuckingStool.setBounds(0, 0, 434, 261);
		frame.getContentPane().add(panelDuckingStool);
		panelDuckingStool.setLayout(null);
		
		labelDuckingStool1 = new JLabel("Choisssez un joueur");
		labelDuckingStool1.setBounds(254, 23, 112, 14);
		panelDuckingStool.add(labelDuckingStool1);
		
		
		textDuckingStool = new JTextField();
		textDuckingStool.setBounds(276, 48, 86, 20);
		panelDuckingStool.add(textDuckingStool);
		textDuckingStool.setColumns(10);
		
		boutonDuckingStool1 = new JButton("Valider");
		boutonDuckingStool1.setBounds(276, 79, 89, 23);
		panelDuckingStool.add(boutonDuckingStool1);
		
		//Invisible au d�but
		labelDuckingStool2 = new JLabel("Joueur cibl\u00E9, choisissez");
		labelDuckingStool2.setBounds(254, 124, 143, 14);
		panelDuckingStool.add(labelDuckingStool2);
		labelDuckingStool2.setVisible(false);
		
		boxDuckingStool1 = new JCheckBox("R\u00E9v\u00E9ler votre identit\u00E9");
		boxDuckingStool1.setBounds(231, 157, 145, 23);
		panelDuckingStool.add(boxDuckingStool1);
		boxDuckingStool1.setVisible(false);
		
		boxDuckingStool2 = new JCheckBox("Discard une carte de votre main");
		boxDuckingStool2.setBounds(231, 198, 197, 23);
		panelDuckingStool.add(boxDuckingStool2);
		boxDuckingStool2.setVisible(false);
		
		boutonDuckingStool2 = new JButton("New button");
		boutonDuckingStool2.setBounds(10, 11, 103, 91);
		panelDuckingStool.add(boutonDuckingStool2);
		boutonDuckingStool2.setVisible(false);
		
		boutonDuckingStool3 = new JButton("New button");
		boutonDuckingStool3.setBounds(123, 11, 97, 91);
		panelDuckingStool.add(boutonDuckingStool3);
		boutonDuckingStool3.setVisible(false);
		
		boutonDuckingStool4 = new JButton("New button");
		boutonDuckingStool4.setBounds(10, 136, 103, 96);
		panelDuckingStool.add(boutonDuckingStool4);
		boutonDuckingStool4.setVisible(false);
		
		boutonDuckingStool5 = new JButton("New button");
		boutonDuckingStool5.setBounds(123, 136, 97, 96);
		panelDuckingStool.add(boutonDuckingStool5);
		boutonDuckingStool5.setVisible(false);
		
		boutonDuckingStool6 = new JButton("Valider le choix");
		boutonDuckingStool6.setBounds(277, 228, 89, 23);
		panelDuckingStool.add(boutonDuckingStool6);
		boutonDuckingStool6.setVisible(false);
		
		//Panel Hooked Nose
		panelHookedNose = new JPanel();
		panelHookedNose.setBounds(0, 0, 434, 261);
		frame.getContentPane().add(panelHookedNose);
		panelHookedNose.setLayout(null);
		
		textHookedNose = new JTextField();
		textHookedNose.setBounds(171, 93, 86, 20);
		panelHookedNose.add(textHookedNose);
		textHookedNose.setColumns(10);
		
		boutonHookedNose = new JButton("New button");
		boutonHookedNose.setBounds(171, 166, 89, 23);
		panelHookedNose.add(boutonHookedNose);
		
		labelHookedNose = new JLabel("Choisissez le prochain joueur. Vous prendrez une carte de sa main au hasard");
		labelHookedNose.setBounds(35, 26, 389, 49);
		panelHookedNose.add(labelHookedNose);
		
		//Panel HookedNoseWitch
		
		panelHookedNoseWitch = new JPanel();
		panelHookedNoseWitch.setBounds(0, 0, 434, 261);
		frame.getContentPane().add(panelHookedNoseWitch);
		panelHookedNoseWitch.setLayout(null);
		
		HookedNoseC1Witch = new JButton("New button");
		HookedNoseC1Witch.setBounds(10, 34, 85, 124);
		panelHookedNoseWitch.add(HookedNoseC1Witch);
		
		HookedNoseC2Witch = new JButton("New button");
		HookedNoseC2Witch.setBounds(105, 34, 85, 124);
		panelHookedNoseWitch.add(HookedNoseC2Witch);
		
		HookedNoseC3Witch = new JButton("New button");
		HookedNoseC3Witch.setBounds(200, 34, 85, 124);
		panelHookedNoseWitch.add(HookedNoseC3Witch);
		
		HookedNoseC4Witch = new JButton("New button");
		HookedNoseC4Witch.setBounds(295, 34, 85, 124);
		panelHookedNoseWitch.add(HookedNoseC4Witch);
		
		HookedNoseTextWitch = new JTextField();
		HookedNoseTextWitch.setBounds(155, 191, 96, 19);
		panelHookedNoseWitch.add(HookedNoseTextWitch);
		HookedNoseTextWitch.setColumns(10);
		
		Valider3HookedNoseWitch = new JButton("New button");
		Valider3HookedNoseWitch.setBounds(151, 230, 85, 21);
		panelHookedNoseWitch.add(Valider3HookedNoseWitch);
		
		AfficherJeuHookedNoseWitch = new JButton("Afficher Jeu");
		AfficherJeuHookedNoseWitch.setBounds(155, 10, 112, 21);
		panelHookedNoseWitch.add(AfficherJeuHookedNoseWitch);
		
		//AngryMob
		panelAngryMob = new JPanel();
		panelAngryMob.setBounds(0, 0, 434, 261);
		frame.getContentPane().add(panelAngryMob);
		panelAngryMob.setLayout(null);
		
		textAngryMob = new JTextField();
		textAngryMob.setBounds(165, 94, 86, 20);
		panelAngryMob.add(textAngryMob);
		textAngryMob.setColumns(10);
		
		boutonAngryMob = new JButton("New button");
		boutonAngryMob.setBounds(165, 168, 89, 23);
		panelAngryMob.add(boutonAngryMob);
		
		labelAngryMob = new JLabel("Choisissez une personne");
		labelAngryMob.setBounds(118, 36, 210, 14);
		panelAngryMob.add(labelAngryMob);
		
		//Panel PetNewt
		
		panelPetNewt = new JPanel();
		panelPetNewt.setBounds(0, 0, 434, 261);
		frame.getContentPane().add(panelPetNewt);
		panelPetNewt.setLayout(null);
		
		Jeu1 = new JButton("New button");
		Jeu1.setBounds(339, 153, 85, 108);
		panelPetNewt.add(Jeu1);
		
		Jeu2 = new JButton("New button");
		Jeu2.setBounds(10, 39, 85, 108);
		panelPetNewt.add(Jeu2);
		
		Jeu3 = new JButton("New button");
		Jeu3.setBounds(10, 153, 85, 108);
		panelPetNewt.add(Jeu3);
		
		Jeu4 = new JButton("New button");
		Jeu4.setBounds(105, 39, 85, 108);
		panelPetNewt.add(Jeu4);
		
		Jeu5 = new JButton("New button");
		Jeu5.setBounds(105, 153, 85, 108);
		panelPetNewt.add(Jeu5);
		
		Jeu6 = new JButton("New button");
		Jeu6.setBounds(244, 39, 85, 108);
		panelPetNewt.add(Jeu6);
		
		Jeu7 = new JButton("New button");
		Jeu7.setBounds(339, 39, 85, 108);
		panelPetNewt.add(Jeu7);
		
		Jeu8 = new JButton("New button");
		Jeu8.setBounds(244, 153, 85, 108);
		panelPetNewt.add(Jeu8);
		
		AfficherJeux = new JButton("AfficherJeux");
		AfficherJeux.setBounds(175, 10, 85, 21);
		panelPetNewt.add(AfficherJeux);
		
		//Panel BlackCat
		
		panelBlackCat = new JPanel();
		panelBlackCat.setBounds(0, 0, 434, 261);
		frame.getContentPane().add(panelBlackCat);
		panelBlackCat.setLayout(null);
		
		DiscardC1 = new JButton("New button");
		DiscardC1.setBounds(10, 34, 85, 124);
		panelBlackCat.add(DiscardC1);
		
		DiscardC2 = new JButton("New button");
		DiscardC2.setBounds(105, 34, 85, 124);
		panelBlackCat.add(DiscardC2);
		
		DiscardC3 = new JButton("New button");
		DiscardC3.setBounds(200, 34, 85, 124);
		panelBlackCat.add(DiscardC3);
		
		DiscardC4 = new JButton("New button");
		DiscardC4.setBounds(295, 34, 85, 124);
		panelBlackCat.add(DiscardC4);
		
		DiscardText = new JTextField();
		DiscardText.setBounds(155, 191, 96, 19);
		panelBlackCat.add(DiscardText);
		DiscardText.setColumns(10);
		
		Valider4 = new JButton("New button");
		Valider4.setBounds(151, 230, 85, 21);
		panelBlackCat.add(Valider4);
		
		AfficherDiscard = new JButton("Afficher Discard");
		AfficherDiscard.setBounds(155, 10, 112, 21);
		panelBlackCat.add(AfficherDiscard);
				
		
		//Panel PointedHatWitch
		
		panelPointedHatWitch = new JPanel();
		panelPointedHatWitch.setBounds(0, 0, 434, 261);
		frame.getContentPane().add(panelPointedHatWitch);
		panelPointedHatWitch.setLayout(null);
		
		PointedHatC1Witch = new JButton("New button");
		PointedHatC1Witch.setBounds(10, 34, 85, 124);
		panelPointedHatWitch.add(PointedHatC1Witch);
		
		PointedHatC2Witch = new JButton("New button");
		PointedHatC2Witch.setBounds(105, 34, 85, 124);
		panelPointedHatWitch.add(PointedHatC2Witch);
		
		PointedHatC3Witch = new JButton("New button");
		PointedHatC3Witch.setBounds(200, 34, 85, 124);
		panelPointedHatWitch.add(PointedHatC3Witch);
		
		PointedHatC4Witch = new JButton("New button");
		PointedHatC4Witch.setBounds(295, 34, 85, 124);
		panelPointedHatWitch.add(PointedHatC4Witch);
		
		PointedHatTextWitch = new JTextField();
		PointedHatTextWitch.setBounds(155, 191, 96, 19);
		panelPointedHatWitch.add(PointedHatTextWitch);
		PointedHatTextWitch.setColumns(10);
		
		Valider3Witch = new JButton("New button");
		Valider3Witch.setBounds(151, 230, 85, 21);
		panelPointedHatWitch.add(Valider3Witch);
		
		AfficherJeuWitch = new JButton("Afficher Jeu");
		AfficherJeuWitch.setBounds(155, 10, 112, 21);
		panelPointedHatWitch.add(AfficherJeuWitch);
		
		//Panel PointedHatHunt
		
		panelPointedHatHunt = new JPanel();
		panelPointedHatHunt.setBounds(0, 0, 434, 261);
		frame.getContentPane().add(panelPointedHatHunt);
		panelPointedHatHunt.setLayout(null);
		
		PointedHatC1 = new JButton("New button");
		PointedHatC1.setBounds(10, 34, 85, 124);
		panelPointedHatHunt.add(PointedHatC1);
		
		PointedHatC2 = new JButton("New button");
		PointedHatC2.setBounds(105, 34, 85, 124);
		panelPointedHatHunt.add(PointedHatC2);
		
		PointedHatC3 = new JButton("New button");
		PointedHatC3.setBounds(200, 34, 85, 124);
		panelPointedHatHunt.add(PointedHatC3);
		
		PointedHatC4 = new JButton("New button");
		PointedHatC4.setBounds(295, 34, 85, 124);
		panelPointedHatHunt.add(PointedHatC4);
		
		PointedHatText = new JTextField();
		PointedHatText.setBounds(155, 191, 96, 19);
		panelPointedHatHunt.add(PointedHatText);
		PointedHatText.setColumns(10);
		
		Valider3 = new JButton("New button");
		Valider3.setBounds(151, 230, 85, 21);
		panelPointedHatHunt.add(Valider3);
		
		AfficherJeu = new JButton("Afficher Jeu");
		AfficherJeu.setBounds(155, 10, 112, 21);
		panelPointedHatHunt.add(AfficherJeu);
		
		
		//PanelJoueurWitch
		panelJoueurWitch = new JPanel();
		panelJoueurWitch.setBounds(0, 0, 434, 261);
		frame.getContentPane().add(panelJoueurWitch);
		panelJoueurWitch.setLayout(null);
		
		Carte1Witch = new JButton("New button");
		Carte1Witch.setBounds(0, 0, 104, 127);
		panelJoueurWitch.add(Carte1Witch);
		Carte1Witch.setVisible(false);
		
		Carte2Witch = new JButton("New button");
		Carte2Witch.setBounds(102, 0, 104, 127);
		panelJoueurWitch.add(Carte2Witch);
		Carte2Witch.setVisible(false);
		
		Carte3Witch = new JButton("New button");
		Carte3Witch.setBounds(0, 134, 104, 127);
		panelJoueurWitch.add(Carte3Witch);
		Carte3Witch.setVisible(false);
		
		Carte4Witch = new JButton("New button");
		Carte4Witch.setBounds(102, 134, 104, 127);
		panelJoueurWitch.add(Carte4Witch);
		Carte4Witch.setVisible(false);
		
		nomJ1Witch = new JTextField();
		nomJ1Witch.setBounds(282, 10, 96, 19);
		panelJoueurWitch.add(nomJ1Witch);
		nomJ1Witch.setColumns(10);
		
		roleJ1Witch = new JTextField();
		roleJ1Witch.setBounds(282, 54, 96, 19);
		panelJoueurWitch.add(roleJ1Witch);
		roleJ1Witch.setColumns(10);
		
		Reveler = new JButton("Reveler");
		Reveler.setBounds(280, 143, 85, 21);
		panelJoueurWitch.add(Reveler);
		Reveler.setVisible(false);
		
		CarteSelectWitch = new JTextField();
		CarteSelectWitch.setBounds(282, 188, 96, 19);
		panelJoueurWitch.add(CarteSelectWitch);
		CarteSelectWitch.setColumns(10);
		CarteSelectWitch.setVisible(false);
		
		JouerWitch = new JButton("Jouer Effet Witch");
		JouerWitch.setBounds(282, 230, 85, 21);
		panelJoueurWitch.add(JouerWitch);
		JouerWitch.setVisible(false);
		
		
		//Panel Accusation
		panelAccusation = new JPanel();
		panelAccusation.setBounds(0, 0, 436, 263);
		frame.getContentPane().add(panelAccusation);
		panelAccusation.setLayout(null);
		
		LabelAccusation = new JLabel("Quel joueur voulez vous accusez ?");
		LabelAccusation.setBounds(133, 10, 159, 13);
		panelAccusation.add(LabelAccusation);
		
		JoueurAccuse = new JTextField();
		JoueurAccuse.setBounds(160, 106, 96, 19);
		panelAccusation.add(JoueurAccuse);
		JoueurAccuse.setColumns(10);
		
		AccuserJoueur = new JButton("Accuser");
		AccuserJoueur.setBounds(160, 167, 85, 21);
		panelAccusation.add(AccuserJoueur);
		
		
		//Panel Jouer Hunt
		panelJoueur = new JPanel();
		panelJoueur.setBounds(0, 0, 434, 261);
		frame.getContentPane().add(panelJoueur);
		panelJoueur.setLayout(null);
		
		Carte1 = new JButton("New button");
		Carte1.setBounds(0, 0, 104, 127);
		panelJoueur.add(Carte1);
		Carte1.setVisible(false);
		
		Carte2 = new JButton("New button");
		Carte2.setBounds(102, 0, 104, 127);
		panelJoueur.add(Carte2);
		Carte2.setVisible(false);
		
		Carte3 = new JButton("New button");
		Carte3.setBounds(0, 134, 104, 127);
		panelJoueur.add(Carte3);
		Carte3.setVisible(false);
		
		Carte4 = new JButton("New button");
		Carte4.setBounds(102, 134, 104, 127);
		panelJoueur.add(Carte4);
		Carte4.setVisible(false);
		
		nomJ1 = new JTextField();
		nomJ1.setBounds(282, 10, 96, 19);
		panelJoueur.add(nomJ1);
		nomJ1.setColumns(10);
		
		roleJ1 = new JTextField();
		roleJ1.setBounds(282, 54, 96, 19);
		panelJoueur.add(roleJ1);
		roleJ1.setColumns(10);
		
		Witcher = new JButton("Sorci\u00E8re");
		Witcher.setBounds(216, 83, 96, 21);
		panelJoueur.add(Witcher);
		
		Hunter = new JButton("Villageois");
		Hunter.setBounds(328, 83, 96, 21);
		panelJoueur.add(Hunter);
		
		Accuser = new JButton("Accuser");
		Accuser.setBounds(280, 143, 85, 21);
		panelJoueur.add(Accuser);
		Accuser.setVisible(false);
		
		CarteSelect = new JTextField();
		CarteSelect.setBounds(282, 188, 96, 19);
		panelJoueur.add(CarteSelect);
		CarteSelect.setColumns(10);
		CarteSelect.setVisible(false);
		
		JouerHunt = new JButton("Jouer Effet Hunt");
		JouerHunt.setBounds(282, 230, 85, 21);
		panelJoueur.add(JouerHunt);
		JouerHunt.setVisible(false);
		
		//PanelChooseNextPlayer
		panelChooseNextPlayer = new JPanel();
		panelChooseNextPlayer.setBounds(0, 0, 434, 261);
		frame.getContentPane().add(panelChooseNextPlayer);
		panelChooseNextPlayer.setLayout(null);
		
		textFieldChooseNextPlayer = new JTextField();
		textFieldChooseNextPlayer.setBounds(176, 90, 86, 20);
		panelChooseNextPlayer.add(textFieldChooseNextPlayer);
		textFieldChooseNextPlayer.setColumns(10);
		
		btnNewButtonChooseNextPlayer = new JButton("Valider");
		
		btnNewButtonChooseNextPlayer.setBounds(176, 159, 89, 23);
		panelChooseNextPlayer.add(btnNewButtonChooseNextPlayer);
		
		labelChooseNextPlayer = new JLabel("choisir le prochain joueur");
		labelChooseNextPlayer.setBounds(160, 34, 209, 14);
		panelChooseNextPlayer.add(labelChooseNextPlayer);
		
		
		
		//Panel Nom des joueurs
		panelNomJoueur = new JPanel();
		panelNomJoueur.setBounds(0, 0, 434, 261);
		frame.getContentPane().add(panelNomJoueur);
		panelNomJoueur.setLayout(null);
		
		textJ1 = new JTextField();
		textJ1.setBounds(278, 8, 86, 20);
		panelNomJoueur.add(textJ1);
		textJ1.setColumns(10);
		
		lblNewLabel_2 = new JLabel("Joueur 1, choisissez votre nom.");
		lblNewLabel_2.setBounds(25, 11, 223, 14);
		panelNomJoueur.add(lblNewLabel_2);
		
		textJ2 = new JTextField();
		textJ2.setBounds(278, 39, 86, 20);
		panelNomJoueur.add(textJ2);
		textJ2.setColumns(10);
		
		textJ3 = new JTextField();
		textJ3.setBounds(278, 70, 86, 20);
		panelNomJoueur.add(textJ3);
		textJ3.setColumns(10);
		
		textJ4 = new JTextField();
		textJ4.setBounds(278, 106, 86, 20);
		panelNomJoueur.add(textJ4);
		textJ4.setColumns(10);
		
		textJ5 = new JTextField();
		textJ5.setBounds(278, 143, 86, 20);
		panelNomJoueur.add(textJ5);
		textJ5.setColumns(10);
		
		lblNewLabel_3 = new JLabel("Joueur 2, choisissez votre nom.");
		lblNewLabel_3.setBounds(25, 42, 176, 14);
		panelNomJoueur.add(lblNewLabel_3);
		
		lblNewLabel_3_1 = new JLabel("Joueur 3, choisissez votre nom.");
		lblNewLabel_3_1.setBounds(25, 73, 176, 14);
		panelNomJoueur.add(lblNewLabel_3_1);
		
		lblNewLabel_3_2 = new JLabel("Joueur 4, choisissez votre nom.");
		lblNewLabel_3_2.setBounds(25, 109, 176, 14);
		panelNomJoueur.add(lblNewLabel_3_2);
		
		lblNewLabel_3_3 = new JLabel("Joueur 5, choisissez votre nom.");
		lblNewLabel_3_3.setBounds(25, 146, 176, 14);
		panelNomJoueur.add(lblNewLabel_3_3);
		
		lblNewLabel_3_4 = new JLabel("Joueur 6, choisissez votre nom.");
		lblNewLabel_3_4.setBounds(25, 182, 176, 14);
		panelNomJoueur.add(lblNewLabel_3_4);
		
		textJ6 = new JTextField();
		textJ6.setColumns(10);
		textJ6.setBounds(278, 182, 86, 20);
		panelNomJoueur.add(textJ6);
		
		Valider2 = new JButton("Valider");
		Valider2.setBounds(163, 227, 89, 23);
		panelNomJoueur.add(Valider2);
		
		
		//PanelNbrJoueur
		panelNbrJoueur = new JPanel();
		panelNbrJoueur.setBounds(0, 0, 434, 261);
		frame.getContentPane().add(panelNbrJoueur);
		panelNbrJoueur.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(162, 48, 86, 20);
		panelNbrJoueur.add(textField);
		textField.setColumns(10);
		
		Valider = new JButton("Valider");
		Valider.setBounds(162, 227, 89, 23);
		panelNbrJoueur.add(Valider);
		
		textField_1 = new JTextField();
		textField_1.setBounds(162, 151, 86, 20);
		panelNbrJoueur.add(textField_1);
		textField_1.setColumns(10);
		
		lblNewLabel = new JLabel("Veuillez choisir le nombre de joueurs");
		lblNewLabel.setBounds(134, 11, 186, 26);
		panelNbrJoueur.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("Veuillez choisir le nombre de Bots");
		lblNewLabel_1.setBounds(141, 114, 179, 14);
		panelNbrJoueur.add(lblNewLabel_1);
		
		
		//Panel TheInquisition Hunt
		panelTheInquisition = new JPanel();
		panelTheInquisition.setBounds(0, 0, 434, 261);
		frame.getContentPane().add(panelTheInquisition);
		panelTheInquisition.setLayout(null);
		
		textFieldTheInquisition = new JTextField();
		textFieldTheInquisition.setBounds(176, 90, 86, 20);
		panelTheInquisition.add(textFieldTheInquisition);
		textFieldTheInquisition.setColumns(10);
		
		btnNewButtonTheInquisition = new JButton("Valider");
		btnNewButtonTheInquisition.setBounds(176, 159, 89, 23);
		panelTheInquisition.add(btnNewButtonTheInquisition);
		
		labelTheInquisition = new JLabel("choisir le prochain joueur");
		labelTheInquisition.setBounds(160, 34, 209, 14);
		panelTheInquisition.add(labelTheInquisition);
		
		
		
		//Panel J1
	}
}
