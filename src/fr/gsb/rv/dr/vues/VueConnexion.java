/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.gsb.rv.dr.vues;
import java.util.Optional;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Pair;

/**
 *
 * @author developpeur
 */
public class VueConnexion extends Dialog<Pair<String, String>>{
    
   private String matricule;
   private String mdp;
   private Optional<Pair<String, String>> valeurs;
   
   
   public VueConnexion(){
       
        super();
        
        this.setTitle("Connexion");

        ButtonType loginButtonType = new ButtonType("Valider", ButtonData.OK_DONE);
        this.getDialogPane().getButtonTypes().addAll(loginButtonType, ButtonType.CANCEL);

        GridPane gridPane = new GridPane();
        gridPane.setHgap(30);
        gridPane.setVgap(30);
        gridPane.setPadding(new Insets(20, 150, 10, 10));

        TextField matriculeInput = new TextField();
        matriculeInput.setPromptText("Entrer votre matricule");
        TextField mdpInput = new TextField();
        mdpInput.setPromptText("Entrer votre mot de passe ");
        
        gridPane.add(new Label("Matricule :"), 0, 0);
        gridPane.add(matriculeInput, 1, 0);
        gridPane.add(new Label("Mot de passe :"), 0, 1);
        gridPane.add(mdpInput, 1, 1);

        this.getDialogPane().setContent(gridPane);
        //this.showAndWait();
        Platform.runLater(() -> matriculeInput.requestFocus());

    // Convert the result to a username-password-pair when the login button is clicked.
        this.setResultConverter(dialogButton -> {
            if (dialogButton == loginButtonType) {
                return new Pair<>(matriculeInput.getText(), mdpInput.getText());
            }
            return null;
        });
        valeurs = this.showAndWait();

        valeurs.ifPresent(pair -> {
            //System.out.println("From=" + pair.getKey() + ", To=" + pair.getValue());
            this.matricule = pair.getKey();
            this.mdp = pair.getValue();
            
        });
        
       
        
        
        
        
   }

    public String getMatricule() {
        return matricule;
    }

    public String getMdp() {
        return mdp;
    }
   
   
 
}
    