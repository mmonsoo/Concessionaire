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
public class AfficheEmpire extends JFrame {
	//Attributs de la classe
	private JPanel panneau;
	private JLabel labelIntro;
	private List<JButton> listeButtonConcession=new ArrayList<JButton>();
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
	public void afficheInfoEmpire(EmpireMotorise e) {
		this.panneau.setLayout(new GridLayout(e.getListe_concessions().size(), 1));
		//C'est l'intro
		String s="<html> L'empire "+e.getNom()+" a une trésorerie de "+e.getTresorerie()+" euros. Voici la liste de concessions ci-dessous(vous pouvez cliquer sur le bouton pour afficher les informations de chaque concession : <br><br> </html>";
		labelIntro.setText(s);
		//Pour chaque véhicule
		for(Concession c:e.getListe_concessions())
		{
			//On crée un Button
			JButton but=new JButton();
			//On modifie le texte du bouton
			but.setText("La concession"+c.getNom());
			but.setBounds(5, 20, 2, 2);
			//On ajoute un Listener
			but.addActionListener(
					new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent f) {
							// Le code à executer en cas de clique
							AfficheInformationsConcession fenetreInfoConcession=new AfficheInformationsConcession();
							fenetreInfoConcession.ajoutBoutonVehicule(c);
							//fenetreInfoConcession.getLabel().setText(c.formatterTexteAffichageVehicules());
							
						}
					}
					);
			this.panneau.add(but);
		}
		
	}
	
	public void afficheJeuEmpire(EmpireMotorise e) {
		
		
		
	}
	
}
