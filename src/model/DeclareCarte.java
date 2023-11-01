package model;

import java.util.ArrayList;
import java.util.List;

import model.*;
import model.Carte;

public abstract class DeclareCarte {
	
	private static List<Carte> Cartes = new ArrayList<Carte>();
	
	public static List<Carte> function() {
		Carte AngryMob= new Carte("Angry Mob");//Angry Mob
		AngryMob.setStrategy(new AngryMob());
		Cartes.add(AngryMob);
		
		Carte theInquisition= new Carte("The Inquisition");//The Inquisition
		theInquisition.setStrategy(new TheInquisition());
		Cartes.add(theInquisition);
		
		Carte pointedHat= new Carte("Pointed Hat");//pointed Hat
		pointedHat.setStrategy(new PointedHat());
		Cartes.add(pointedHat);
		
		Carte hookedNose= new Carte("Hooked Nose");//Hooked Nose
		hookedNose.setStrategy(new HookedNose());
		Cartes.add(hookedNose);
		
		Carte broomstick= new Carte("Broomstick");//Broomstick
		broomstick.setStrategy(new Broomstick());
		Cartes.add(broomstick);
		
		Carte Wart= new Carte("Wart");//Wart
		Wart.setStrategy(new Wart());
		Cartes.add(Wart);
		
		Carte duckingStool= new Carte("Ducking Stool");//Ducking Stool
		duckingStool.setStrategy(new DuckingStool());
		Cartes.add(duckingStool);
		
		Carte Cauldron= new Carte("Cauldron");//Pauldron
		Cauldron.setStrategy(new Cauldron());
		Cartes.add(Cauldron);
		
		Carte evilEye= new Carte("Evil Eye");//Evil Eye
		evilEye.setStrategy(new EvilEye());
		Cartes.add(evilEye);
		
		Carte Toad= new Carte("Toad");//Toad
		Toad.setStrategy(new Toad());
		Cartes.add(Toad);
		
		Carte blackCat= new Carte("Black Cat");//Black Cat
		blackCat.setStrategy(new BlackCat());
		Cartes.add(blackCat);
		
		Carte petNewt= new Carte("Pet Newt");//Pet Newt
		petNewt.setStrategy(new PetNewt());
		Cartes.add(petNewt);
		
		return(Cartes);
	}

}
