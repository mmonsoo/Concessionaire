package com.mmonsoor;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class AfficheInformationsConcession extends JFrame {
	//Attributs de la classe
	//Attributs de la classe
	private JPanel panneau;
	private JLabel label;
	private JLabel labelListeVehicules;
	
	//Constructeur de la classe
	public AfficheInformationsConcession(){
		this.setTitle("Information de la concession");
		this.setSize(2000, 2000);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panneau=new JPanel();
		panneau.setLayout(null);
		this.setContentPane(panneau);
		//Création du JLabel Nom
		label=new JLabel();
		label.setBounds(5, 20, 500, 500);
		panneau.add(label);
		//Création du JLabel 
	}

	public JPanel getPanneau() {
		return panneau;
	}

	public void setPanneau(JPanel panneau) {
		this.panneau = panneau;
	}

	public JLabel getLabel() {
		return label;
	}

	public void setLabel(JLabel label) {
		this.label = label;
	}

}
