/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.gsb.rv.dr;
import fr.gsb.rv.dr.technique.Session;
import fr.gsb.rv.dr.entites.Visiteur;
import fr.gsb.rv.dr.modeles.ModeleGsbRv;
import fr.gsb.rv.dr.vues.VueConnexion;
import fr.gsb.rv.dr.technique.ConnexionBD;
import fr.gsb.rv.dr.technique.ConnexionException;
import fr.gsb.rv.dr.technique.DateFr;
import java.sql.Connection;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author developpeur
 */
public class GSBRVDR extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        
        BorderPane border = new BorderPane(); // Créer le conteneur de type BorderPane
        Scene scene = new Scene(border, 1000,1000); // Créer la scene et y associer le noeud racine du graphe de scene 
        primaryStage.setTitle("Fenetre TEST"); // permet de modifier le nom de notre fenetre
        primaryStage.setScene(scene); // associer a notre fenetre notre scene
        primaryStage.show(); // afficher 
        
        // Créer une barre de menu
        
        MenuBar barreMenus = new MenuBar();
        Menu menuFichier = new Menu("Fichier"); // permet de créer un objet de typee MENU ayant pour nom "FICHIER"
        MenuItem itemSeConnecter = new MenuItem("Se connecter"); // permet d'initialiser un objet de type menuItem permettant d'associer a notre menu un item 'Se Connecter'
        menuFichier.getItems().add(itemSeConnecter);
        barreMenus.getMenus().add(menuFichier);
        border.setTop(barreMenus);
        MenuItem itemSeDeconnecter = new MenuItem("Se Déconnecter");
        menuFichier.getItems().add(itemSeDeconnecter);
        MenuItem itemQuitter = new MenuItem("Quitter");
        menuFichier.getItems().add(itemQuitter);
        
        // add mnimoneic ctrl + x
        KeyCombination clavierQuitter = new KeyCodeCombination(KeyCode.X, KeyCombination.CONTROL_DOWN);
        itemQuitter.setAccelerator(clavierQuitter);
        
        Menu menuRapports = new Menu("Rapports");
        barreMenus.getMenus().add(menuRapports);
        MenuItem itemConsulter = new MenuItem("Consulter");
        menuRapports.getItems().add(itemConsulter);
        
        Menu menuPraticien = new Menu("Praticien");
        barreMenus.getMenus().add(menuPraticien);
        MenuItem itemHesitants = new MenuItem("Hesitants");
        menuPraticien.getItems().add(itemHesitants);
        
        Menu menuVisiteurConnecte = new Menu();
        barreMenus.getMenus().add(menuVisiteurConnecte);
        
        
        SeparatorMenuItem separateurQuitter = new SeparatorMenuItem();
        menuFichier.getItems().add(2, separateurQuitter);
        
        menuPraticien.setDisable(true);
        menuRapports.setDisable(true);
        itemSeDeconnecter.setDisable(true);
        
        
        itemQuitter.setOnAction(new EventHandler<ActionEvent>(){
            public void handle (ActionEvent event){
               
                Alert alertQuitter = new Alert(Alert.AlertType.CONFIRMATION);
                alertQuitter.setContentText("Voulez-vous quitter l'application ? ");
                alertQuitter.setHeaderText("Demande de confirmation ");
                alertQuitter.setTitle("Quitter");
                //Button btnOui = new Button();
                //Button btnNon = new Button();
                ButtonType btnOui = new ButtonType("Oui", ButtonData.YES);
                ButtonType btnNon = new ButtonType("Non", ButtonData.CANCEL_CLOSE);
                alertQuitter.getButtonTypes().setAll(btnOui, btnNon);
                
                
                
                Optional<ButtonType> result = alertQuitter.showAndWait();
                
                
                if(result.isPresent() && result.get().getText() == "Oui"){
                    Platform.exit();
                }
                //
               
            }
            
        }
        );
        
        itemSeConnecter.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle (ActionEvent event){
                System.out.println("Se connecter");
                
                
                VueConnexion vue = new VueConnexion();
                System.out.println(vue.getMatricule());
                System.out.println(vue.getMdp());
                try {
                    Visiteur visiteurCo = ModeleGsbRv.seConnecter(vue.getMatricule(), vue.getMdp());
                    if(visiteurCo != null){
                        Session.ouvrir(visiteurCo);
                        System.out.println(visiteurCo.toString());
                        itemSeConnecter.setDisable(true);
                        itemSeDeconnecter.setDisable(false);
                        menuPraticien.setDisable(false);
                        menuRapports.setDisable(false);
                        menuVisiteurConnecte.setText(Session.getSession().getVisiteur().getVis_nom() + " "+ Session.getSession().getVisiteur().getVis_prenom());
                        
                    } else{
                        
                        
                        Alert alertAuthentificationNok = new Alert(Alert.AlertType.CONFIRMATION); 
                        alertAuthentificationNok.setHeaderText("L'authentification à échouée ");
                        alertAuthentificationNok.setTitle("Echec authentification");
                        //Button btnOui = new Button();
                        //Button btnNon = new Button();
                        ButtonType btnOk = new ButtonType("Quitter", ButtonData.CANCEL_CLOSE);
                        alertAuthentificationNok.getButtonTypes().setAll(btnOk);
                        Optional<ButtonType> result = alertAuthentificationNok.showAndWait();


                       
                    }     
                   
                    
                    
        
                    
                    
                    //Visiteur visiteurCo = new Visiteur("0B001","BOUAICHI", "Oumayma", "1 bis", "91230", "montgeron", new DateFr(), "AZ", "ZEC", "azerty" );
                    // j'ouvre la session...
                    // if(Session.getSession() == null){ // Si la session est null...
                    //   Session.ouvrir(visiteurCo);
                    //}
                    //menuVisiteurConnecte.setText(Session.getSession().getVisiteur().getVis_nom() + " " + Session.getSession().getVisiteur().getVis_prenom());
                } catch (ConnexionException ex) {
                    Logger.getLogger(GSBRVDR.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                
               
            }
            
        }
        );
        
        itemSeDeconnecter.setOnAction(new EventHandler<ActionEvent>(){
            public void handle (ActionEvent event){
                System.out.println("Se deconnecter");
                itemSeConnecter.setDisable(false);
                itemSeDeconnecter.setDisable(true);
                menuPraticien.setDisable(true);
                menuRapports.setDisable(true);
                
                Session.fermer();
                menuVisiteurConnecte.setText("");
            }
        });
                
        
        itemConsulter.setOnAction(new EventHandler<ActionEvent>(){
            public void handle (ActionEvent event){
                System.out.println("Consulter");
                  
                   //System.out.println("[Rapports]"+ " "+Session.getSession().getVisiteur().getVis_prenom() +" "+ Session.getSession().getVisiteur().getVis_nom());
                   
            }
            
        }
        );
        
        itemHesitants.setOnAction(new EventHandler<ActionEvent>(){
            public void handle (ActionEvent event){
                System.out.println("Hesitants");
                   itemHesitants.setDisable(false);
                   itemConsulter.setDisable(false);
                  // System.out.println("[Praticiens]"+ " "+Session.getSession().getVisiteur().getVis_prenom() +" "+ Session.getSession().getVisiteur().getVis_nom());
            }
            
        }
        );  
        
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ConnexionException{
        launch(args);
        
        
        ConnexionBD.getConnexion();
       
        
        //Visiteur visiteurCo = ModeleGsbRv.seConnecter("a17", "azerty");
        /*if(visiteurCo != null){
            System.out.println(visiteurCo.toString());
        }
        */
        
        
        
    }
    
}
