package com.mmonsoor;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;

public class Program {

	public Program() {
		// TODO Auto-generated constructor stub
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Moto moto1=new Moto("Yamaha", "Mod�le 1", "Grise", 10000, 2);
		Moto moto2=new Moto("Yamaha", "Mod�le 2", "Grise", 10000, 2);
		Moto moto3=new Moto("Yamaha", "Mod�le 3", "Grise", 10000, 2);
		Voiture voiture1=new Voiture("Peugeot", "SW", "Rouge", 40000, "Break");
		Camion camion1=new Camion("BMW", "Mod�le2", "Rose", 100000, 1000);
		Camion camion2=new Camion("Yamaha", "Mod�le2", "Rose", 100000, 1000);
		//Nous allons cr�e une concession
		Concession concession1=new Concession("Monsoors Concession");
		concession1.ajouterVehicule(moto1);
		concession1.ajouterVehicule(moto2);
		concession1.ajouterVehicule(moto3);
		concession1.ajouterVehicule(voiture1);
		concession1.ajouterVehicule(camion1);
		concession1.ajouterVehicule(camion2);
		//concession1.getNombreVehicules();
		concession1.inventaire();
		concession1.getValeurStock();
		//concession1.vendre(0);
		//concession1.inventaire();
		//concession1.vendre(1);
		//concession1.inventaire();
		//concession1.vendre(0);
		//concession1.inventaire();
		//nombreTypeVehicule
		concession1.nombreTypeVehicule("Moto");
		concession1.nombreTypeVehicule("Camion");
		concession1.nombreTypeVehicule("Voiture");
		//concession1.reduction(20, "Moto");
		concession1.inventaire();
		//concession1.reduction(12, "Camion");
		//concession1.reduction(12,"Voiture");
		concession1.inventaire();
		//concession1.augmentation(12,"Voiture");
		concession1.inventaire();
		//concession1.vendre(0);
		//concession1.vendre(1);
		//concession1.vendre(2);
		//concession1.vendre(5);
		//concession1.liquidationMarque("Yamaha");
		concession1.liquidationMarque("Peugeot");
		concession1.inventaire();
		
//#### On commence l'empire
		//On cr�e une deuxi�me concession
		Concession concession2=new Concession("Gasniers Concession");
		//On cr�e des v�hicules
		Moto moto4=new Moto("Nissan", "Mod�le 1", "Bleue", 10000, 2);
		Moto moto5=new Moto("Nissan", "Mod�le 2", "Verte", 10000, 2);
		Moto moto6=new Moto("Nissan", "Mod�le 3", "Jaune", 10000, 2);
		Voiture voiture2=new Voiture("Peugeot", "SW", "Rouge", 40000, "Break");
		Voiture voiture3=new Voiture("Peugeot", "SW", "Rouge", 40000, "Break");
		Camion camion3=new Camion("BMW", "Mod�le2", "Rose", 100000, 1000);
		Camion camion4=new Camion("Yamaha", "Mod�le2", "Rose", 100000, 1000);
		//On ajoute les v�hicules dans la deuxi�me concession
		concession2.ajouterVehicule(moto4);
		concession2.ajouterVehicule(moto5);
		concession2.ajouterVehicule(moto6);
		concession2.ajouterVehicule(voiture2);
		concession2.ajouterVehicule(voiture3);
		concession2.ajouterVehicule(camion3);
		concession2.ajouterVehicule(camion4);
		concession2.vendre(0);
		//On cr�e un empire motoris�
		EmpireMotorise empireMotorise1=new EmpireMotorise("Monsoor Family");
		empireMotorise1.ajouterConcession(concession1);
		empireMotorise1.ajouterConcession(concession2);
		//System.out.println("RESULTAT AVANT VENTE");
		//empireMotorise1.valeurEmpire();
		//empireMotorise1.vendreConcession(0);
		//System.out.println("RESULTAT APRES VENTE");
		//empireMotorise1.valeurEmpire();
		//empireMotorise1.valeurEmpire();
		//empireMotorise1.inventaire();
		//On va tester d�placerStock
		//empireMotorise1.deplacerStock(0, 1);
		//empireMotorise1.inventaire();
		//On va cr�er la fen�tre principale du jeu
		//FenetreConcession maFenetrePrincipale=new FenetreConcession();
		//maFenetrePrincipale.setTitle("Bienvenue dans le jeu de la concession");
		//On cr�e l'affichage du button v�hicule1
		//maFenetrePrincipale.getButtonVehicule().setText(voiture1.getClass().getSimpleName()+" "+concession1.getListe_vehicules().indexOf(voiture1));
		//maFenetrePrincipale.getLabel().setText("Hello World");
		//AfficheInformationsVoiture fenetreInfoVoiture=new AfficheInformationsVoiture();
		//On affiche les informations d'un seul v�hicule
		//fenetreInfoVoiture.getLabel().setText(moto1.toString());
		//AfficheInformationsConcession afficheconcession=new AfficheInformationsConcession();
		//Pour une concession, on affiche le label associ�: informations de la concession.
		//afficheconcession.getLabel().setText(concession2.formatterTexteAffichageVehicules());
		//�a prend une concession et va ajouter des boutons dans le JPanel
		//afficheconcession.ajoutBoutonVehicule(concession2);
		//On va cr�er l'objet AfficheEmpire
		//AfficheEmpire afficheEmpire=new AfficheEmpire();
		//On va appeler la m�thode afficheInfoEmpire qui prend un empire cr�e.
		//afficheEmpire.afficheInfoEmpire(empireMotorise1);
		//On appelle la fen�tre jeu
		//FenetreJeu jeuconcession=new FenetreJeu();
		//jeuconcession.afficheJeu(empireMotorise1);
		//empireMotorise1.inventaire();
		//ArrayList d'index de voitures � vendre
		List <String> listeVehiculesAVendre= new ArrayList<String>();
		listeVehiculesAVendre.add("0,0");
		//listeVehiculesAVendre.add("0,1");
		//listeVehiculesAVendre.add("1,1");
		GestionnaireFenetreJeu Jeux=new GestionnaireFenetreJeu(empireMotorise1,listeVehiculesAVendre);
		
		
			
	}

}
