package com.mmonsoor;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class FenetreJeu extends JFrame {
	
	//Attributs de la classe
	private JPanel panneau;
	private JLabel label;
	private JButton buttonVehicule;
	/**
	 * Constructeur de la classe
	 */
	public FenetreJeu() {
		// TODO Auto-generated constructor stub
		this.setTitle("Bienvenue dans le jeu de la concession");
		this.setSize(400, 400);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panneau=new JPanel();
		panneau.setLayout(null);
		this.setContentPane(panneau);
		//Création du JLabel
		label=new JLabel();
		label.setBounds(5, 20, 150, 20);
		panneau.add(label);
		//Partie pour le button
		buttonVehicule=new JButton();
		buttonVehicule.setBounds(5, 20, 150, 20);
		//On ajoute le button au panneau
		panneau.add(buttonVehicule);
		
	}
	public JButton getButtonVehicule() {
		return buttonVehicule;
	}
	public void setButtonVehicule(JButton buttonVehicule) {
		this.buttonVehicule = buttonVehicule;
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
