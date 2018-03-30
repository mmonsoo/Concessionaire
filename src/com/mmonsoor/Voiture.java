package com.mmonsoor;

public class Voiture extends Vehicule {

	private String type;
	public Voiture(String tmpMarque, String tmpModele, String tmpCouleur, int tmpPrix,String tmpType) {
		super(tmpMarque, tmpModele, tmpCouleur, tmpPrix);
		type=tmpType;
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String s=super.toString();
		s+=" et mon type est "+type;
		return s;
	}

}
