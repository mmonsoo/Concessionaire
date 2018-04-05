package com.mmonsoor;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
public class AfficheEmpire extends JFrame {
	//Attributs de la classe
	private JPanel panneau;
	private JLabel labelIntro;
	private List<JButton> listeButtonVehicule=new ArrayList<JButton>();
	public AfficheEmpire() {
		this.setTitle("L'empire");
		this.setSize(500, 500);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panneau=new JPanel();
		panneau.setLayout(null);
		this.setContentPane(panneau);
		//Création du JLabel Nom
		labelIntro=new JLabel();
		labelIntro.setBounds(1, 1, 500, 500);
		panneau.add(labelIntro);
		//Création du JLabel 	
	}
	public void afficheInfoEmpire(EmpireMotorise empireMotorise) {
		
		
	}
}
