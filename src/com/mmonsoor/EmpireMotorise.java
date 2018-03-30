package com.mmonsoor;

import java.util.ArrayList;
import java.util.List;

public class EmpireMotorise {
	//Attributs de la classe
	private String nom;
	private List <Concession> liste_concessions;
	private  int tresorerie=0;
	/**
	 * Constructeur d'instance
	 * @param tmpNom Le nom de l'empire 
	 */
	public EmpireMotorise(String tmpNom) {
		// TODO Auto-generated constructor stub
		nom=tmpNom;
		liste_concessions=new ArrayList<Concession> ();
	}
	/**
	 * Constructeur d'instance par défaut
	 * 
	 */
	public EmpireMotorise() {
		// TODO Auto-generated constructor stub
		nom="";
		List <Concession> liste_concessions=new ArrayList<Concession> ();
	}
	/**
	 *  Méthode qui retourne la valeur cumulée des Vehicules dans toutes les concessions, des tresoreries des concessions et de la tresorerie de l’Empire.
	 */
	public void valeurEmpire() {
		//La valeur cumulée des prix des Vehicules dans toutes les concessions
		getValeurCumuleeVehicules();
		//La valeur cumulée des trésoreries de toutes les concessions
		getValeurCumuleeTresoreries();
		//On affiche la trésorerie de l'empire
		System.out.println("La trésorerie de l'empire est de :"+tresorerie+" euros.");
	}
	/**
	 * Affiche la valeur cumulée des prix des Vehicules dans toutes les concessions
	 */
	public void getValeurCumuleeVehicules() {
		//Pour chaque concession de l'empire motorisé
		System.out.println("Nous présentons les valeurs cumulées pour chaque concession ci-dessous: ");
		int sommePrixvehicules=0;
		for(Concession c:liste_concessions) {
			sommePrixvehicules=sommePrixvehicules+c.getValeurStock();
		}
		System.out.println("La somme totale cumulée de tous les prix des véhicules de toutes les concessions est de "+sommePrixvehicules+" euros.");
	}
	/**
	 * Affiche la valeur cumulée des trésoreries de toutes les concessions
	 */
	public void getValeurCumuleeTresoreries() {
		System.out.println("Nous présentons les valeurs cumulées des trésoreries des concessions: ");
		int tresoreriesTotalConcessions=0;
		for(Concession c:liste_concessions) {
			tresoreriesTotalConcessions=tresoreriesTotalConcessions+c.getTrésorerie();
		}

		System.out.println("\tLa somme totale cumulée des trésoreries de toutes les concessions de l'empire est de "+tresoreriesTotalConcessions+" euros.");

	}
	/**
	 * Une méthode qui ajoute une concession dans l'empire.
	 * @param c Une concession
	 */
	public void ajouterConcession(Concession c) {
		liste_concessions.add(c);
	}
	/**
	 * Vendre une concession de l'empire
	 * @param c Une concession
	 */
	public void vendreConcession(int i) {
		if(i<=liste_concessions.size()) {
			//On va rajouter la trésorerie de la concession à la trésorie de l'empire
			tresorerie=tresorerie+liste_concessions.get(i).getTrésorerie();
			//On va retirer la concession de la liste
			liste_concessions.remove(i);
			System.out.println("On a vendu la trésorerie numéro ["+i+"]");
		}
		else {
			System.out.println("Attention, vous avez rentré un index qui ne se trouve pas dans la liste, revérifier la liste des concessions ci-dessous: ");
		}	
	}
	/**
	 * La méthode qui transfère les véhicules d'une concession à une autre.
	 * @param iConcessionVider L'index de la concession à vider
	 * @param iConcessionRemplir l'index de la concession à remplir
	 */
	public void deplacerStock(int iConcessionVider, int iConcessionRemplir) {
		//On obtient la liste des véhicules de la concession à vider
		ArrayList<Vehicule> listeVehiculesAVider = liste_concessions.get(iConcessionVider).getListe_vehicules();
		for(Vehicule v:listeVehiculesAVider) {
			//On ajoute chaque véhicule
			liste_concessions.get(iConcessionRemplir).ajouterVehicule(v);		
		}
		//On vide la liste des véhicules de la concession à vider
		liste_concessions.get(iConcessionVider).getListe_vehicules().clear();
	}	
	/**
	 * Une méthode qui fait l'inventaire des concessions de l'empire.
	 */
	public void inventaire() {
		System.out.println("Nous allons faire l'inventaire des concessions de notre empire:");
		int nombre=0;
		if(liste_concessions.size()!=0) {
			for(Concession c:liste_concessions)	{
				nombre++;
				System.out.println("\t Numéro de la concession["+(nombre-1)+"]"+c);
			}
		}
		else {
			System.out.println("Il n'y a pas de concessions dans l'empire.");
		}
	}
}
