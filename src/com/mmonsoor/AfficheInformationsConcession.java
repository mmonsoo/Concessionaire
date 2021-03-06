package com.mmonsoor;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class AfficheInformationsConcession extends JFrame {
	//Attributs de la classe
	//Attributs de la classe
	private JPanel panneau;
	private JLabel labelIntro;
	private List<JButton> listeButtonVehicule=new ArrayList<JButton>();

	//Constructeur de la classe
	public AfficheInformationsConcession(){
		this.setTitle("Information de la concession");
		this.setSize(500, 500);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		panneau=new JPanel();
		panneau.setLayout(null);
		this.setContentPane(panneau);
		//Cr�ation du JLabel Nom
		labelIntro=new JLabel();
		labelIntro.setBounds(1, 1, 500, 500);
		panneau.add(labelIntro);
		//Cr�ation du JLabel 
	}
	public void ajoutBoutonVehicule(Concession c) {
		this.panneau.setLayout(new GridLayout(c.getListe_vehicules().size(), 1));
		//C'est l'intro
		String s="<html> La concession "+c.getNom()+" a une tr�sorerie de "+c.getTr�sorerie()+" euros. Voici sa liste de v�hicules ci-dessous(vous pouvez cliquer sur le bouton pour afficher les informations de chaque v�hicule : <br><br> </html>";
		labelIntro.setText(s);
		//Pour chaque v�hicule
		for(Vehicule v:c.getListe_vehicules())
		{
			//On cr�e un Button
			JButton but=new JButton();
			//On modifie le texte du bouton
			but.setText(v.getClass().getSimpleName()+" "+c.getListe_vehicules().indexOf(v));
			but.setBounds(5, 20, 2, 2);
			//On ajoute un Listener
			but.addActionListener(
					new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							// Le code � executer en cas de clique
							AfficheInformationsVoiture fenetreInfoVoiture=new AfficheInformationsVoiture();
							fenetreInfoVoiture.getLabel().setText(v.toString());
						}
					}
					);
			this.panneau.add(but);
		}
	}
	public JPanel getPanneau() {
		return panneau;
	}

	public void setPanneau(JPanel panneau) {
		this.panneau = panneau;
	}

	public JLabel getLabel() {
		return labelIntro;
	}

	public void setLabel(JLabel label) {
		this.labelIntro = labelIntro;
	}

	public List<JButton> getListeButtonVehicule() {
		return listeButtonVehicule;
	}

	public void setListeButtonVehicule(List<JButton> listeButtonVehicule) {
		this.listeButtonVehicule = listeButtonVehicule;
	}
}
