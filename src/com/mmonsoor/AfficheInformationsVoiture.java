package com.mmonsoor;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class AfficheInformationsVoiture extends JFrame {
	//Attributs de la classe
	private JPanel panneau;
	private JLabel label;
	public AfficheInformationsVoiture() {
		// TODO Auto-generated constructor stub
		this.setTitle("On affiche les informations d'un véhicule donné");
		this.setSize(900, 900);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		panneau=new JPanel();
		panneau.setLayout(null);
		this.setContentPane(panneau);
		//Création du JLabel
		label=new JLabel();
		label.setBounds(5, 5, 700, 700);
		panneau.add(label);
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
