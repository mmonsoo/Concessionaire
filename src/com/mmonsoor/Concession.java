package com.mmonsoor;

import java.util.ArrayList;
import java.util.function.Predicate;

public class Concession {

	//Attributs de la classe Concession
	protected String nom;
	protected ArrayList<Vehicule> liste_vehicules;
	protected int trésorerie=0;
	/**
	 * Constructeur de la classe en mettant un nom de la concession que l'on veut créer
	 * @param tmpNom Nom de la concession à créer
	 */
	public Concession(String tmpNom) {
		// TODO Auto-generated constructor stub
		nom=tmpNom;
		liste_vehicules=new ArrayList<Vehicule>();
	}
	/**
	 * Méthode qui ajoute un véhicule dans la liste de véhicules du concesssionaire
	 * @param nouveauVehicule Un nouveau véhicule à ajouter dans la concession
	 */
	public void ajouterVehicule(Vehicule nouveauVehicule) {
		liste_vehicules.add(nouveauVehicule);
		System.out.println("On a ajouté dans notre concession un(e)"+nouveauVehicule.getClass().getSimpleName());
	}
	/**
	 * Une méthode qui retourne le nombre de véhicules dans la liste de la concession
	 */
	public void getNombreVehicules() {
		System.out.println("Le nombre de véhicules dans la concession est de "+liste_vehicules.size()+" véhicules.");
	}
	/**
	 * Une méthode qui fait l'inventaire des véhicules de la concession, et affiche pour chaque véhicule sa description.
	 */
	public String inventaire() {
		System.out.println("Nous allons faire l'inventaire des véhicules de notre concession:");
		int nombre=0;
		String s="";
		if(liste_vehicules.size()!=0) {
			for(Vehicule v:liste_vehicules)	{
				nombre++;
				//System.out.println("\t Numéro du véhicule["+(nombre-1)+"]"+v);
				s+="\t Numéro du véhicule["+(nombre-1)+"]"+v+"\n";
			}
		}
		else {
			//System.out.println("Il n'y a pas de véhicules dans la concession.");
			s="Il n'y a pas de véhicules dans la concession.";
		}
		return s;
	}
	@Override
	/**
	 * On affiche les informations de chaque concession et sa trésorerie
	 */
	public String toString() {
		return "Notre concession " + nom + " a la liste de véhicules suivante:" + liste_vehicules + ", trésorerie=" + trésorerie + "]";
	}
	/**
	 * Une méthode qui retourne la valeur des prix cumulés de tous les véhicules de la concession
	 */
	public int getValeurStock() {
		int somme_total=0;
		for(Vehicule v:liste_vehicules)	{
			somme_total=somme_total+v.getPrix();	
		}
		System.out.println("\tLa somme totale cumulée de tous les prix des véhicules de la concession "+nom+ " est de "+somme_total+" euros.");
		return somme_total;
	}
	/**
	 * Une méthode qui vend le ième véhicule
	 */
	public void vendre(int i) {
		//On teste si le i est dans la  liste
		if(i<=liste_vehicules.size()) {
			//On va rajouter le prix à la trésorie
			trésorerie=trésorerie+liste_vehicules.get(i).getPrix();
			//On va retirer le véhicule de la liste
			liste_vehicules.remove(i);
			System.out.println("On a supprimé le véhicule numéro ["+i+"]");
			System.out.println("La trésorerie est de :"+trésorerie+" euros.");
		}

		else {
			System.out.println("Attention, vous avez rentré un index qui ne se trouve pas dans la liste, revérifier la liste des véhicules ci-dessous: ");
			this.inventaire();
		}

	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public ArrayList<Vehicule> getListe_vehicules() {
		return liste_vehicules;
	}
	public void setListe_vehicules(ArrayList<Vehicule> liste_vehicules) {
		this.liste_vehicules = liste_vehicules;
	}
	public int getTrésorerie() {
		return trésorerie;
	}
	public void setTrésorerie(int trésorerie) {
		this.trésorerie = trésorerie;
	}
	/**
	 * Une méthode qui retourne le nombre de véhicules du type demandé
	 */
	public void nombreTypeVehicule(String type) {
		int nbVehicules=0;
		for(Vehicule v:liste_vehicules) {
			if(v.getClass().getSimpleName().equals(type)) {
				nbVehicules++;
			}
		}
		System.out.println("Le nombre de véhicules du type "+type+" est de "+nbVehicules+".");
	}
	
	/**
	 * Une méthode qui réduit en pourcentage indiqué les prix de tous les véhicules de la concession.
	 * @param pourcentage Pourcentage en entier
	 */
	public void reduction(int pourcentage) {
		// On crée la boucle pour accéder à chaque véhicule
		int nouveauPrix;
		for(Vehicule v:liste_vehicules) {
				//Appliquer la réduction de prix, donc modifier le prix des véhicules
				nouveauPrix=v.getPrix()-((v.getPrix()*pourcentage)/100);
				v.setPrix(nouveauPrix);
		}
	}
	/**
	 * Une méthode qui réduit en pourcentage les prix des véhicules, et on peut spécifier quel type de véhicules que l'on veut (Camion,Voiture,Moto)
	 * @param pourcentage Pourcentage en entier
	 * @param type Le type de véhicules sur lequel on veut appliquer l'augmentation de prix
	 */
	public void reduction(int pourcentage,String type) {
		// On crée la boucle pour accéder à chaque véhicule
		int nouveauPrix;
		for(Vehicule v:liste_vehicules) {
			if(v.getClass().getSimpleName().equals(type)) {
				//Appliquer la réduction de prix, donc modifier le prix des véhicules
				nouveauPrix=v.getPrix()-((v.getPrix()*pourcentage)/100);
				v.setPrix(nouveauPrix);
			}

		}
	}
	
	/**
	 * Une méthode qui augmente en pourcentage les prix de tous les véhicules.
	 * @param pourcentage Pourcentage en entier
	 */
	public void augmentation(int pourcentage) {
		// On crée la boucle pour accéder à chaque véhicule
		int nouveauPrix;
		for(Vehicule v:liste_vehicules) {
				//Appliquer la réduction de prix, donc modifier le prix des véhicules
				nouveauPrix=v.getPrix()+((v.getPrix()*pourcentage)/100);
				v.setPrix(nouveauPrix);
		}
	}
	
	/**
	 * Une méthode qui augmente en pourcentage les prix des véhicules, et on peut spécifier quel type de véhicules que l'on veut (Camion,Voiture,Moto)
	 * @param pourcentage Pourcentage en entier
	 * @param type Le type de véhicules sur lequel on veut appliquer l'augmentation de prix
	 */
	public void augmentation(int pourcentage,String type) {
		// On crée la boucle pour accéder à chaque véhicule
		int nouveauPrix;
		for(Vehicule v:liste_vehicules) {
			if(v.getClass().getSimpleName().equals(type)) {
				//Appliquer la réduction de prix, donc modifier le prix des véhicules
				nouveauPrix=v.getPrix()+((v.getPrix()*pourcentage)/100);
				v.setPrix(nouveauPrix);
			}	
		}
	}
	/**
	 * Une méthode qui vend toutes les voitures d'une certaine marque
	 * @param marque La marque d'une voiture
	 */
	public void liquidationMarque(String marque) {
		int index=0;
		while(index<liste_vehicules.size()) {
			Vehicule v=liste_vehicules.get(index);
			if(v.getMarque().equals(marque)) {
				vendre(index);
				System.out.println(index);
				//Sinon ça fait un out of bounds car index peut pas être égakl à -1
				if(index!=0) {
				index=index-1;
				}
			}
			else {
				System.out.println(index);
				index=index+1;
			}
		}
	
	}
	

	//
	 // Méthode qui retourne un String bien formatté pour l'affichage dans un JLabel
	 // @return
	 ///
	public String formatterTexteAffichageVehicules() {
		String s="<html> La concession "+this.getNom()+" a une trésorerie de "+this.getTrésorerie()+" euros. Voici sa liste de véhicules ci-dessous(vous pouvez cliquer sur le bouton pour afficher les informations de chaque véhicule : <br><br>";
		for(Vehicule v:this.getListe_vehicules()) {
			s+=v.getClass().getSimpleName()+" "+this.getListe_vehicules().indexOf(v)+"<br><br>";
		}
		s+="</html>";
		return s;
	}

	
}
