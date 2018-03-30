package com.mmonsoor;

public abstract class  Vehicule {
	//Attributs de la classe
	protected String marque;
	protected String modele;
	protected String couleur;
	protected int prix;
	/**
	 * Constructeur de la classe
	 * @param tmpMarque La marque du véhicule à créer.
	 * @param tmpModele La modèle du véhicule à créer.
	 * @param tmpCouleur La couleur du véhicule à créer.
	 * @param tmpPrix Le prix du véhicule à créer.
	 */
	public Vehicule(String tmpMarque,String tmpModele,String tmpCouleur,int tmpPrix) {
		// TODO Auto-generated constructor stub
		marque=tmpMarque;
		modele=tmpModele;
		couleur=tmpCouleur;
		prix=tmpPrix;
	}

	@Override
	public String toString() {
		return "Je suis un(e) " + this.getClass().getSimpleName() +" de marque " + marque + ", mon modèle est " + modele + " et mon prix est " + prix;
	}

	public String getMarque() {
		return marque;
	}

	public void setMarque(String marque) {
		this.marque = marque;
	}

	public String getModele() {
		return modele;
	}

	public void setModele(String modele) {
		this.modele = modele;
	}

	public int getPrix() {
		return prix;
	}

	public void setPrix(int prix) {
		this.prix = prix;
	}
	
	

}
