package com.mmonsoor;

public class Moto extends Vehicule {
	//Attributs de la classe
	private int cylindree;
	public Moto(String tmpMarque, String tmpModele, String tmpCouleur, int tmpPrix,int tmpCylindree) {
		super(tmpMarque, tmpModele, tmpCouleur, tmpPrix);
		cylindree=tmpCylindree;
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String s=super.toString();
		s+=" et ma cylindree est "+cylindree;
		return s;
	}
	
	

}
