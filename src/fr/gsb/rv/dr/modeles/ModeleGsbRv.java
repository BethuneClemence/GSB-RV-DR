package fr.gsb.rv.dr.modeles;

import fr.gsb.rv.dr.entites.Visiteur;
import fr.gsb.rv.dr.technique.ConnexionBD;
import fr.gsb.rv.dr.technique.ConnexionException;
import fr.gsb.rv.dr.technique.DateFr;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ModeleGsbRv {
    
    public static Visiteur seConnecter( String matricule , String mdp ) throws ConnexionException{
        
        // Code de test à compléter
        
        Connection connexion = ConnexionBD.getConnexion() ;
        
        String requete = "select * "
                + "from Visiteur "
                + "where vis_matricule = ? "
                + "and vis_mdp = ?" ;
        
        try {
            PreparedStatement requetePreparee = (PreparedStatement) connexion.prepareStatement( requete ) ;
            requetePreparee.setString( 1 , matricule );
            requetePreparee.setString(2, mdp);
            ResultSet resultat = requetePreparee.executeQuery() ;
            if( resultat.next() ){
                
                Visiteur visiteur = new Visiteur() ;
                visiteur.setVis_matricule( matricule );
                visiteur.setVis_nom( resultat.getString( "vis_nom" ) ) ;
                visiteur.setVis_prenom(resultat.getString("vis_prenom"));
                visiteur.setVis_adresse(resultat.getString("vis_adresse"));
                visiteur.setVis_cp(resultat.getString("vis_cp"));
                visiteur.setVis_ville(resultat.getString("vis_ville"));
                visiteur.setSec_code(resultat.getString("sec_code"));
                visiteur.setLab_code(resultat.getString("lab_code"));
                visiteur.setVis_mdp(resultat.getString("vis_mdp"));
                requetePreparee.close() ;
                
                return visiteur ;
            }
            else {
                return null ;
            }
        }
        catch( Exception e ){
            return null ;
        } 
    }
}


