package com.mmonsoor;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class FenetreJeu extends JFrame {
	
	//Attributs de la classe
	private JPanel panneau;
	private JLabel labelIntro;
	private JButton buttonVehicule;
	private Dimension dim=this.getSize();
	private EmpireMotorise empiremotorise;
	private List<JButton> listeDeButtonVehiculesAVendre=new ArrayList<JButton>();
	/**
	 * Constructeur de la classe
	 */
	public FenetreJeu(EmpireMotorise em) {
		// TODO Auto-generated constructor stub
		this.empiremotorise=em;
		this.setTitle("Empire des concessions");
		this.setSize(700, 700);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panneau=new JPanel();
		panneau.setLayout(null);
		this.setContentPane(panneau);
		//Création du JLabel Intro du jeu
		labelIntro=new JLabel();
		labelIntro.setBounds(0, 1, 400, 400);
		labelIntro.setText("<html> <font size=\"7\" color=\"blue\"> <b>L'Empire des Concessions MOUAAAAAAHAHAHA</b> </font></html>");
		panneau.add(labelIntro);
		//On va mettre une image dans le jeu
	
		BufferedImage myPicture;
		try {
			myPicture = ImageIO.read(new File("C:\\Users\\ACI\\WorkSpaceS2\\Concessionnaire\\Logo_Jeu.jpg"));
			JLabel picLabel = new JLabel(new ImageIcon(myPicture.getScaledInstance(150, 150, myPicture.SCALE_FAST)));
			picLabel.setBounds(500, 90, 200, 200);
			panneau.add(picLabel);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//Appelle à la méthode VoitureàVendre
		vehiculesAVendre(0,0);
		//Pour ne pas avoir de bug d'affichage
		panneau.repaint();

		//Partie pour le button
		//buttonVehicule=new JButton();
		//buttonVehicule.setBounds(5, 20, 150, 20);
		//On ajoute le button au panneau
		//panneau.add(buttonVehicule);	
	}
	public JLabel getLabelIntro() {
		return labelIntro;
	}
	public void setLabelIntro(JLabel labelIntro) {
		this.labelIntro = labelIntro;
	}
	public Dimension getDim() {
		return dim;
	}
	public void setDim(Dimension dim) {
		this.dim = dim;
	}
	public EmpireMotorise getEmpiremotorise() {
		return empiremotorise;
	}
	public void setEmpiremotorise(EmpireMotorise empiremotorise) {
		this.empiremotorise = empiremotorise;
	}
	/**
	 * Qui crée des boutons de véhicules à vendre
	 * @param v
	 */
	public void vehiculesAVendre(int indexConcession,int indexVehicule) {
		//On stocke les informations de la concession et du véhicule
		Concession c=empiremotorise.getListe_concessions().get(indexConcession);
		Vehicule v=empiremotorise.getListe_concessions().get(indexConcession).getListe_vehicules().get(indexVehicule);
		//On crée un JLabel pour le véhicule
		JLabel vehiculelabel=new JLabel();
		String s="<html> Très belle occasion à saisir: "+v.getClass().getSimpleName()+" de marque "+v.getMarque()+" et de modèle "+v.getModele()+" de la concession "+c.getNom()+". <b> <font color=\"red\"> Avec un prix exceptionnel de "+v.getPrix()+" euros. </font></html>";
		vehiculelabel.setText(s);
		vehiculelabel.setBounds(10, 200, 300, 300);
		//On crée un Button
		JButton but=new JButton();
		//On modifie le texte du bouton
		but.setText("<html> <font color=\\\"blue\\\"> Acheter ce véhicule </font></html>");
		but.setBounds(400, 300, 150, 100);
		//On ajoute le bouton dans la liste de boutons de la classe
		listeDeButtonVehiculesAVendre.add(but);
	/*	
		//On ajoute un Listener
		but.addActionListener(
				new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						// Le code à executer en cas de clique
						AfficheInformationsVoiture fenetreInfoVoiture=new AfficheInformationsVoiture();
						fenetreInfoVoiture.getLabel().setText(v.toString());
					}
				}
				);
		
	*/
		this.panneau.add(vehiculelabel);
		this.panneau.add(but);
	}
	
	
	
	public void afficheJeu(EmpireMotorise e) {
		
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
		return labelIntro;
	}
	public void setLabel(JLabel label) {
		this.labelIntro = label;
	}
}
