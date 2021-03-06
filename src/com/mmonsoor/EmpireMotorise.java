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
	 * Constructeur d'instance par d�faut
	 * 
	 */
	public EmpireMotorise() {
		// TODO Auto-generated constructor stub
		nom="";
		List <Concession> liste_concessions=new ArrayList<Concession> ();
	}
	/**
	 *  M�thode qui retourne la valeur cumul�e des Vehicules dans toutes les concessions, des tresoreries des concessions et de la tresorerie de l�Empire.
	 */
	public void valeurEmpire() {
		//La valeur cumul�e des prix des Vehicules dans toutes les concessions
		getValeurCumuleeVehicules();
		//La valeur cumul�e des tr�soreries de toutes les concessions
		getValeurCumuleeTresoreries();
		//On affiche la tr�sorerie de l'empire
		System.out.println("La tr�sorerie de l'empire est de :"+tresorerie+" euros.");
	}
	/**
	 * Affiche la valeur cumul�e des prix des Vehicules dans toutes les concessions
	 */
	public void getValeurCumuleeVehicules() {
		//Pour chaque concession de l'empire motoris�
		System.out.println("Nous pr�sentons les valeurs cumul�es pour chaque concession ci-dessous: ");
		int sommePrixvehicules=0;
		for(Concession c:liste_concessions) {
			sommePrixvehicules=sommePrixvehicules+c.getValeurStock();
		}
		System.out.println("La somme totale cumul�e de tous les prix des v�hicules de toutes les concessions est de "+sommePrixvehicules+" euros.");
	}
	/**
	 * Affiche la valeur cumul�e des tr�soreries de toutes les concessions
	 */
	public void getValeurCumuleeTresoreries() {
		System.out.println("Nous pr�sentons les valeurs cumul�es des tr�soreries des concessions: ");
		int tresoreriesTotalConcessions=0;
		for(Concession c:liste_concessions) {
			tresoreriesTotalConcessions=tresoreriesTotalConcessions+c.getTr�sorerie();
		}

		System.out.println("\tLa somme totale cumul�e des tr�soreries de toutes les concessions de l'empire est de "+tresoreriesTotalConcessions+" euros.");

	}
	/**
	 * Une m�thode qui ajoute une concession dans l'empire.
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
			//On va rajouter la tr�sorerie de la concession � la tr�sorie de l'empire
			tresorerie=tresorerie+liste_concessions.get(i).getTr�sorerie();
			//On va retirer la concession de la liste
			liste_concessions.remove(i);
			System.out.println("On a vendu la tr�sorerie num�ro ["+i+"]");
		}
		else {
			System.out.println("Attention, vous avez rentr� un index qui ne se trouve pas dans la liste, rev�rifier la liste des concessions ci-dessous: ");
		}	
	}
	/**
	 * La m�thode qui transf�re les v�hicules d'une concession � une autre.
	 * @param iConcessionVider L'index de la concession � vider
	 * @param iConcessionRemplir l'index de la concession � remplir
	 */
	public void deplacerStock(int iConcessionVider, int iConcessionRemplir) {
		//On obtient la liste des v�hicules de la concession � vider
		ArrayList<Vehicule> listeVehiculesAVider = liste_concessions.get(iConcessionVider).getListe_vehicules();
		for(Vehicule v:listeVehiculesAVider) {
			//On ajoute chaque v�hicule
			liste_concessions.get(iConcessionRemplir).ajouterVehicule(v);		
		}
		//On vide la liste des v�hicules de la concession � vider
		liste_concessions.get(iConcessionVider).getListe_vehicules().clear();
	}	
	/**
	 * Une m�thode qui fait l'inventaire des concessions de l'empire.
	 */
	public void inventaire() {
		System.out.println("Nous allons faire l'inventaire des concessions de notre empire:");
		int nombre=0;
		if(liste_concessions.size()!=0) {
			for(Concession c:liste_concessions)	{
				nombre++;
				System.out.println("\t Num�ro de la concession["+(nombre-1)+"]"+c);
			}
		}
		else {
			System.out.println("Il n'y a pas de concessions dans l'empire.");
		}
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public List<Concession> getListe_concessions() {
		return liste_concessions;
	}
	public void setListe_concessions(List<Concession> liste_concessions) {
		this.liste_concessions = liste_concessions;
	}
	public int getTresorerie() {
		return tresorerie;
	}
	public void setTresorerie(int tresorerie) {
		this.tresorerie = tresorerie;
	}
	
	
	
}
