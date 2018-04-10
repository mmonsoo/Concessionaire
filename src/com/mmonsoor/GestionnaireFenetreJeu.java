package com.mmonsoor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;

public class GestionnaireFenetreJeu implements ActionListener {
	private EmpireMotorise empiremotorise;
	private FenetreJeu jeuconcession;
	private List <String> listeVehiculesAVendre= new ArrayList<String>();
	
	public EmpireMotorise getEmpiremotorise() {
		return empiremotorise;
	}

	public void setEmpiremotorise(EmpireMotorise empiremotorise) {
		this.empiremotorise = empiremotorise;
	}

	public GestionnaireFenetreJeu(EmpireMotorise em,List <String> tmpListeVehiculesAVendre) {
		this.listeVehiculesAVendre=tmpListeVehiculesAVendre;
		this.empiremotorise=em;
		// TODO Auto-generated constructor stub
		//On va générer la première fenêtre principale du jeu
		this.jeuconcession=new FenetreJeu(empiremotorise,listeVehiculesAVendre);
		//jeuconcession.getbutton().addActionListener(this);
		for(JButton jb:this.jeuconcession.getListeDeButtonConcessionAVendre()) {
			jb.addActionListener(this);
		}
		
	}
	public FenetreJeu getJeuconcession() {
		return jeuconcession;
	}

	public void setJeuconcession(FenetreJeu jeuconcession) {
		this.jeuconcession = jeuconcession;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		//Pour vendre un véhicule
		if (e.getActionCommand().startsWith("VendreConcession")) {
			//jeuconcession.afficherConcessionVendre();
			System.out.println("Cliqué sur Acheter concession");
			String[] actionVendre=e.getActionCommand().split(",");
			System.out.println(Integer.parseInt(actionVendre[1]));
			empiremotorise.vendreConcession(Integer.parseInt(actionVendre[1]));
			System.out.println(empiremotorise.getTresorerie());
			jeuconcession.afficherFenetreJeu();
			jeuconcession.afficherConcessionVendre();
			//jeuconcession.repaint();
		}
		
	/*	
		if (e.getActionCommand().startsWith("Vendre")) {
			System.out.println("Cliqué sur Acheter");
			String[] actionVendre=e.getActionCommand().split(",");
			System.out.println(e.getActionCommand());
			System.out.println(empiremotorise.getListe_concessions().get(Integer.parseInt(actionVendre[1])).getNom());
			empiremotorise.getListe_concessions().get(Integer.parseInt(actionVendre[1])).vendre(Integer.parseInt(actionVendre[2]));
			System.out.println(empiremotorise.getTresorerie());
			jeuconcession.afficherFenetreJeu();	
			jeuconcession.repaint();
		}
	*/
		
	}
}
