package com.mmonsoor;

public class Camion extends Vehicule {
	private int PTAC;
	public Camion(String tmpMarque, String tmpModele, String tmpCouleur, int tmpPrix,int tmpPTAC) {
		super(tmpMarque, tmpModele, tmpCouleur, tmpPrix);
		PTAC=tmpPTAC;
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String s=super.toString();
		s+=" et mon PTAC est "+PTAC+"kg.";
		return s;
	}

}
