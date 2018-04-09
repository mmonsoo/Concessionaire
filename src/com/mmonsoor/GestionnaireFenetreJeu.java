package com.mmonsoor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GestionnaireFenetreJeu implements ActionListener {
	private EmpireMotorise empiremotorise;
	
	public EmpireMotorise getEmpiremotorise() {
		return empiremotorise;
	}

	public void setEmpiremotorise(EmpireMotorise empiremotorise) {
		this.empiremotorise = empiremotorise;
	}

	public GestionnaireFenetreJeu(EmpireMotorise em) {
		this.empiremotorise=em;
		// TODO Auto-generated constructor stub
		//On va générer la première fenêtre principale du jeu
		FenetreJeu jeuconcession=new FenetreJeu(empiremotorise);
		//jeuconcession.getbutton().addActionListener(this);
		//for()
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getActionCommand().equals("vendre 0")) {
			//ACTION A FAIRE
		}
		

	}

}
