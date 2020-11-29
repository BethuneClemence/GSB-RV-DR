/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.gsb.rv.dr.technique;

import fr.gsb.rv.dr.entites.Visiteur;

/**
 *
 * @author developpeur
 */
public class Session {

	private static Session session = null ;
	private Visiteur visiteur ;
	
	private Session(Visiteur leVisiteur){
		super() ;
		this.visiteur = leVisiteur ;
	}
	
	public static boolean ouvrir(Visiteur visiteur){
            
		if( visiteur != null ){
			Session.session = new Session( visiteur ) ;
			return true ;
		}
		else {
			return false ;
		}
	}
	
	public static Session getSession(){
		return Session.session ;
	}
	
	public static void fermer(){
		Session.session = null ;
	}
	
	public Visiteur getVisiteur(){
		return this.visiteur ;
	}
}
