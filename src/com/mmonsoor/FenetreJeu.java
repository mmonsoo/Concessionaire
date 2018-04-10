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
	private JLabel labelTresorerieEmpire=new JLabel();
	private JButton buttonVehicule;
	private Dimension dim=this.getSize();
	private EmpireMotorise empiremotorise;
	private List<JButton> listeDeButtonConcessionAVendre=new ArrayList<JButton>();
	private List<JButton> listeDeButtonVehiculesAVendre=new ArrayList<JButton>();
	private List <String> listeVehiculesAVendre= new ArrayList<String>();
	private JLabel labelListeConcession=new JLabel();
	
	
	
	/**
	 * Constructeur de la classe
	 */
	public FenetreJeu(EmpireMotorise em,List <String> tmpListeVehiculesAVendre) {
		// TODO Auto-generated constructor stub
		this.listeVehiculesAVendre=tmpListeVehiculesAVendre;
		this.empiremotorise=em;
		this.setTitle("Empire des concessions");
		this.setSize(1000, 1000);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//On appelle la fenetre
		afficherFenetreJeu();
		afficherConcessionVendre();
	}
	/**
	 * 
	 */
	public void afficherFenetreJeu() {
		panneau=new JPanel();
		panneau.setLayout(null);
		this.setContentPane(panneau);
		//Création du JLabel Intro du jeu
		labelIntro=new JLabel();
		labelIntro.setBounds(0, 1, 400, 400);
		labelIntro.setText("<html> <font size=\"7\" color=\"blue\"> <b>L'Empire des Concessions MOUAAAAAAHAHAHA</b> </font></html>");
		panneau.add(labelIntro);
		//On va mettre une image dans le jeu
/*
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
	*/	
		labelTresorerieEmpire.setBounds(0, 200, 500, 200);
		//labelTresorerieEmpire.setText("<html> <font size=\"4\" color=\"green\"> <b> Trésorerie de l'empire "+empiremotorise.getListe_concessions().get(0).getNom()+" est de: "+empiremotorise.getListe_concessions().get(0).getTrésorerie()+" euros."+"</b></font></html>");
		labelTresorerieEmpire.setText("<html> <font size=\"4\" color=\"red\"> <b> Trésorerie de l'empire est de: "+empiremotorise.getTresorerie()+" euros."+"</b></font></html>");
		panneau.add(labelTresorerieEmpire);
		labelListeConcession.setBounds(0, 300, 500, 200);
		labelListeConcession.setText("<html> <font size=\"4\" color=\"green\"> <b> La liste des concessions de l'empire ci-dessous : </b></font></html>");
		panneau.add(labelListeConcession);
		//vendreVehicules();
		//Pour ne pas avoir de bug d'affichage
		//Partie pour le button
		//buttonVehicule=new JButton();
		//buttonVehicule.setBounds(5, 20, 150, 20);
		//On ajoute le button au panneau
		//panneau.add(buttonVehicule);
		//Liste des concessions à vendre
		panneau.repaint();
	}
	public void afficherConcessionVendre() {
		//Pour chaque concession de l'empire
		int nbpixels=400;
		int nbpixelsbutton=500;
		for (int i=0;i<empiremotorise.getListe_concessions().size();i++) {
			//Partie label des noms de concessin
			JLabel concessionLabel=new JLabel();
			String s="<html> <font size=\\\"4\\\" color=\"red\">  Nom de concession: "+empiremotorise.getListe_concessions().get(i).getNom()+"</font></html>";
			concessionLabel.setText(s);
			concessionLabel.setBounds(10, nbpixels, 300, 300);
			panneau.add(concessionLabel);
			//Partie des boutons
			//On crée un Button
			JButton but=new JButton();
			//On modifie le texte du bouton
			but.setText("<html> <font color=\\\"blue\\\"> Acheter cette concession </font></html>");
			but.setBounds(300, nbpixelsbutton, 120, 80);
			but.setActionCommand("VendreConcession,"+i);
			panneau.add(but);
			nbpixels+=100;
			nbpixelsbutton+=100;
			listeDeButtonConcessionAVendre.add(but);
			
			//On ajoute le bouton dans la liste de boutons de la classe
		}
	}
	public List<JButton> getListeDeButtonVehiculesAVendre() {
		return listeDeButtonVehiculesAVendre;
	}
	public void setListeDeButtonVehiculesAVendre(List<JButton> listeDeButtonVehiculesAVendre) {
		this.listeDeButtonVehiculesAVendre = listeDeButtonVehiculesAVendre;
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
	public void vendreUnVehicule(int indexConcession,int indexVehicule,int nbpixelslabel,int nbpixelsButton) {
		//On stocke les informations de la concession et du véhicule
		Concession c=empiremotorise.getListe_concessions().get(indexConcession);
		Vehicule v=empiremotorise.getListe_concessions().get(indexConcession).getListe_vehicules().get(indexVehicule);
		//On crée un JLabel pour le véhicule
		JLabel vehiculelabel=new JLabel();
		String s="<html> Très belle occasion à saisir: "+v.getClass().getSimpleName()+" de marque "+v.getMarque()+" et de modèle "+v.getModele()+" de la concession "+c.getNom()+". <b> <font color=\"red\"> Avec un prix exceptionnel de "+v.getPrix()+" euros. </font></html>";
		vehiculelabel.setText(s);
		vehiculelabel.setBounds(10, nbpixelslabel, 300, 300);
		//On crée un Button
		JButton but=new JButton();
		//On modifie le texte du bouton
		but.setText("<html> <font color=\\\"blue\\\"> Acheter ce véhicule </font></html>");
		but.setBounds(400, nbpixelsButton, 150, 100);
		but.setActionCommand("Vendre,"+indexConcession+","+indexVehicule);
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
	public void vendreVehicules() {
		int nbpixelsLabel=200;
		int nbpixelsButton=300;	
		for(String s:listeVehiculesAVendre ) {
			System.out.println("VEHICULE A VENDRE"+s);
			String indexConcession=s.split(",")[0];
			String indexVehicule=s.split(",")[1];
			vendreUnVehicule(Integer.parseInt(indexConcession),Integer.parseInt(indexVehicule),nbpixelsLabel,nbpixelsButton);
			nbpixelsLabel+=130;
			nbpixelsButton+=130;
		}
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
	public List<String> getListeVehiculesAVendre() {
		return listeVehiculesAVendre;
	}
	public void setListeVehiculesAVendre(List<String> listeVehiculesAVendre) {
		this.listeVehiculesAVendre = listeVehiculesAVendre;
	}
	public List<JButton> getListeDeButtonConcessionAVendre() {
		return listeDeButtonConcessionAVendre;
	}
	public void setListeDeButtonConcessionAVendre(List<JButton> listeDeButtonConcessionAVendre) {
		this.listeDeButtonConcessionAVendre = listeDeButtonConcessionAVendre;
	}
}
