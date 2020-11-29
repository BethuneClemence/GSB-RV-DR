/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.gsb.rv.dr.entites;

import fr.gsb.rv.dr.technique.DateFr;

/**
 *
 * @author developpeur
 */
public class Visiteur {
    
    
    /*| Field            | Type         | Null | Key | Default | Extra |
    +------------------+--------------+------+-----+---------+-------+
    | vis_matricule    | varchar(20)  | NO   | PRI |         |       |
    | vis_nom          | varchar(50)  | YES  |     | NULL    |       |
    | vis_prenom       | varchar(100) | YES  |     | NULL    |       |
    | vis_adresse      | varchar(100) | YES  |     | NULL    |       |
    | vis_cp           | varchar(10)  | YES  |     | NULL    |       |
    | vis_ville        | varchar(60)  | YES  |     | NULL    |       |
    | vis_dateembauche | date         | YES  |     | NULL    |       |
    | sec_code         | varchar(2)   | YES  | MUL | NULL    |       |
    | lab_code         | varchar(4)   | YES  | MUL | NULL    |       |
    | vis_mdp          | varchar(30)  | YES  |     | azerty  |       |
    +------------------+--------------+------+-----+---------+-------+*/

    private String vis_matricule;
    private String vis_nom;
    private String vis_prenom;
    private String vis_adresse;
    private String vis_cp;
    private String vis_ville;
    private DateFr vis_dateEmbauche;
    private String sec_code;
    private String lab_code;
    private String vis_mdp;

    public Visiteur(String vis_matricule, String vis_nom, String vis_prenom, String vis_adresse, String vis_cp, String vis_ville, DateFr vis_dateEmbauche, String sec_code, String lab_code, String vis_mdp) {
        this.vis_matricule = vis_matricule;
        this.vis_nom = vis_nom;
        this.vis_prenom = vis_prenom;
        this.vis_adresse = vis_adresse;
        this.vis_cp = vis_cp;
        this.vis_ville = vis_ville;
        this.vis_dateEmbauche = vis_dateEmbauche;
        this.sec_code = sec_code;
        this.lab_code = lab_code;
        this.vis_mdp = vis_mdp;
    }
    
    
    

    public String getVis_matricule() {
        return vis_matricule;
    }

    public void setVis_matricule(String vis_matricule) {
        this.vis_matricule = vis_matricule;
    }

    public String getVis_nom() {
        return vis_nom;
    }

    public void setVis_nom(String vis_nom) {
        this.vis_nom = vis_nom;
    }

    public String getVis_prenom() {
        return vis_prenom;
    }

    public void setVis_prenom(String vis_prenom) {
        this.vis_prenom = vis_prenom;
    }

    public String getVis_adresse() {
        return vis_adresse;
    }

    public void setVis_adresse(String vis_adresse) {
        this.vis_adresse = vis_adresse;
    }

    public String getVis_cp() {
        return vis_cp;
    }

    public void setVis_cp(String vis_cp) {
        this.vis_cp = vis_cp;
    }

    public String getVis_ville() {
        return vis_ville;
    }

    public void setVis_ville(String vis_ville) {
        this.vis_ville = vis_ville;
    }

    public DateFr getVis_dateEmbauche() {
        return vis_dateEmbauche;
    }

    public void setVis_dateEmbauche(DateFr vis_dateEmbauche) {
        this.vis_dateEmbauche = vis_dateEmbauche;
    }

    public String getSec_code() {
        return sec_code;
    }

    public void setSec_code(String sec_code) {
        this.sec_code = sec_code;
    }

    public String getLab_code() {
        return lab_code;
    }

    public void setLab_code(String lab_code) {
        this.lab_code = lab_code;
    }

    public String getVis_mdp() {
        return vis_mdp;
    }

    public void setVis_mdp(String vis_mdp) {
        this.vis_mdp = vis_mdp;
    }

    @Override
    public String toString() {
        return "Visiteur{" + "vis_matricule=" + vis_matricule + ", vis_nom=" + vis_nom + ", vis_prenom=" + vis_prenom + ", vis_adresse=" + vis_adresse + ", vis_cp=" + vis_cp + ", vis_ville=" + vis_ville + ", vis_dateEmbauche=" + vis_dateEmbauche + ", sec_code=" + sec_code + ", lab_code=" + lab_code + ", vis_mdp=" + vis_mdp + '}';
    }
    
    
    
    

    
}
