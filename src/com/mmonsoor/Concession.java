package com.mmonsoor;

import java.util.ArrayList;
import java.util.function.Predicate;

public class Concession {

	//Attributs de la classe Concession
	protected String nom;
	protected ArrayList<Vehicule> liste_vehicules;
	protected int tr�sorerie=0;
	/**
	 * Constructeur de la classe en mettant un nom de la concession que l'on veut cr�er
	 * @param tmpNom Nom de la concession � cr�er
	 */
	public Concession(String tmpNom) {
		// TODO Auto-generated constructor stub
		nom=tmpNom;
		liste_vehicules=new ArrayList<Vehicule>();
	}
	/**
	 * M�thode qui ajoute un v�hicule dans la liste de v�hicules du concesssionaire
	 * @param nouveauVehicule Un nouveau v�hicule � ajouter dans la concession
	 */
	public void ajouterVehicule(Vehicule nouveauVehicule) {
		liste_vehicules.add(nouveauVehicule);
		System.out.println("On a ajout� dans notre concession un(e)"+nouveauVehicule.getClass().getSimpleName());
	}
	/**
	 * Une m�thode qui retourne le nombre de v�hicules dans la liste de la concession
	 */
	public void getNombreVehicules() {
		System.out.println("Le nombre de v�hicules dans la concession est de "+liste_vehicules.size()+" v�hicules.");
	}
	/**
	 * Une m�thode qui fait l'inventaire des v�hicules de la concession, et affiche pour chaque v�hicule sa description.
	 */
	public String inventaire() {
		System.out.println("Nous allons faire l'inventaire des v�hicules de notre concession:");
		int nombre=0;
		String s="";
		if(liste_vehicules.size()!=0) {
			for(Vehicule v:liste_vehicules)	{
				nombre++;
				//System.out.println("\t Num�ro du v�hicule["+(nombre-1)+"]"+v);
				s+="\t Num�ro du v�hicule["+(nombre-1)+"]"+v+"\n";
			}
		}
		else {
			//System.out.println("Il n'y a pas de v�hicules dans la concession.");
			s="Il n'y a pas de v�hicules dans la concession.";
		}
		return s;
	}
	@Override
	/**
	 * On affiche les informations de chaque concession et sa tr�sorerie
	 */
	public String toString() {
		return "Notre concession " + nom + " a la liste de v�hicules suivante:" + liste_vehicules + ", tr�sorerie=" + tr�sorerie + "]";
	}
	/**
	 * Une m�thode qui retourne la valeur des prix cumul�s de tous les v�hicules de la concession
	 */
	public int getValeurStock() {
		int somme_total=0;
		for(Vehicule v:liste_vehicules)	{
			somme_total=somme_total+v.getPrix();	
		}
		System.out.println("\tLa somme totale cumul�e de tous les prix des v�hicules de la concession "+nom+ " est de "+somme_total+" euros.");
		return somme_total;
	}
	/**
	 * Une m�thode qui vend le i�me v�hicule
	 */
	public void vendre(int i) {
		//On teste si le i est dans la  liste
		if(i<=liste_vehicules.size()) {
			//On va rajouter le prix � la tr�sorie
			tr�sorerie=tr�sorerie+liste_vehicules.get(i).getPrix();
			//On va retirer le v�hicule de la liste
			liste_vehicules.remove(i);
			System.out.println("On a supprim� le v�hicule num�ro ["+i+"]");
			System.out.println("La tr�sorerie est de :"+tr�sorerie+" euros.");
		}

		else {
			System.out.println("Attention, vous avez rentr� un index qui ne se trouve pas dans la liste, rev�rifier la liste des v�hicules ci-dessous: ");
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
	public int getTr�sorerie() {
		return tr�sorerie;
	}
	public void setTr�sorerie(int tr�sorerie) {
		this.tr�sorerie = tr�sorerie;
	}
	/**
	 * Une m�thode qui retourne le nombre de v�hicules du type demand�
	 */
	public void nombreTypeVehicule(String type) {
		int nbVehicules=0;
		for(Vehicule v:liste_vehicules) {
			if(v.getClass().getSimpleName().equals(type)) {
				nbVehicules++;
			}
		}
		System.out.println("Le nombre de v�hicules du type "+type+" est de "+nbVehicules+".");
	}
	
	/**
	 * Une m�thode qui r�duit en pourcentage indiqu� les prix de tous les v�hicules de la concession.
	 * @param pourcentage Pourcentage en entier
	 */
	public void reduction(int pourcentage) {
		// On cr�e la boucle pour acc�der � chaque v�hicule
		int nouveauPrix;
		for(Vehicule v:liste_vehicules) {
				//Appliquer la r�duction de prix, donc modifier le prix des v�hicules
				nouveauPrix=v.getPrix()-((v.getPrix()*pourcentage)/100);
				v.setPrix(nouveauPrix);
		}
	}
	/**
	 * Une m�thode qui r�duit en pourcentage les prix des v�hicules, et on peut sp�cifier quel type de v�hicules que l'on veut (Camion,Voiture,Moto)
	 * @param pourcentage Pourcentage en entier
	 * @param type Le type de v�hicules sur lequel on veut appliquer l'augmentation de prix
	 */
	public void reduction(int pourcentage,String type) {
		// On cr�e la boucle pour acc�der � chaque v�hicule
		int nouveauPrix;
		for(Vehicule v:liste_vehicules) {
			if(v.getClass().getSimpleName().equals(type)) {
				//Appliquer la r�duction de prix, donc modifier le prix des v�hicules
				nouveauPrix=v.getPrix()-((v.getPrix()*pourcentage)/100);
				v.setPrix(nouveauPrix);
			}

		}
	}
	
	/**
	 * Une m�thode qui augmente en pourcentage les prix de tous les v�hicules.
	 * @param pourcentage Pourcentage en entier
	 */
	public void augmentation(int pourcentage) {
		// On cr�e la boucle pour acc�der � chaque v�hicule
		int nouveauPrix;
		for(Vehicule v:liste_vehicules) {
				//Appliquer la r�duction de prix, donc modifier le prix des v�hicules
				nouveauPrix=v.getPrix()+((v.getPrix()*pourcentage)/100);
				v.setPrix(nouveauPrix);
		}
	}
	
	/**
	 * Une m�thode qui augmente en pourcentage les prix des v�hicules, et on peut sp�cifier quel type de v�hicules que l'on veut (Camion,Voiture,Moto)
	 * @param pourcentage Pourcentage en entier
	 * @param type Le type de v�hicules sur lequel on veut appliquer l'augmentation de prix
	 */
	public void augmentation(int pourcentage,String type) {
		// On cr�e la boucle pour acc�der � chaque v�hicule
		int nouveauPrix;
		for(Vehicule v:liste_vehicules) {
			if(v.getClass().getSimpleName().equals(type)) {
				//Appliquer la r�duction de prix, donc modifier le prix des v�hicules
				nouveauPrix=v.getPrix()+((v.getPrix()*pourcentage)/100);
				v.setPrix(nouveauPrix);
			}	
		}
	}
	/**
	 * Une m�thode qui vend toutes les voitures d'une certaine marque
	 * @param marque La marque d'une voiture
	 */
	public void liquidationMarque(String marque) {
		int index=0;
		while(index<liste_vehicules.size()) {
			Vehicule v=liste_vehicules.get(index);
			if(v.getMarque().equals(marque)) {
				vendre(index);
				System.out.println(index);
				//Sinon �a fait un out of bounds car index peut pas �tre �gakl � -1
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
	 // M�thode qui retourne un String bien formatt� pour l'affichage dans un JLabel
	 // @return
	 ///
	public String formatterTexteAffichageVehicules() {
		String s="<html> La concession "+this.getNom()+" a une tr�sorerie de "+this.getTr�sorerie()+" euros. Voici sa liste de v�hicules ci-dessous(vous pouvez cliquer sur le bouton pour afficher les informations de chaque v�hicule : <br><br>";
		for(Vehicule v:this.getListe_vehicules()) {
			s+=v.getClass().getSimpleName()+" "+this.getListe_vehicules().indexOf(v)+"<br><br>";
		}
		s+="</html>";
		return s;
	}

	
}
