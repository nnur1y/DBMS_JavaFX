 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controller;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Admin
 */
public class MainPanelController implements Initializable {

    @FXML
    private BorderPane borderPane;
    @FXML
    private Button logout;
    @FXML
    private Button home;
    @FXML
    private Button page01;
    @FXML
    private Button page04;
    @FXML
    private Button page05;
    @FXML
    private Button page06;
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void close() throws IOException {
        Stage stage = (Stage) borderPane.getScene().getWindow();
        stage.close();

        Parent root = FXMLLoader.load(getClass().getResource("/javafxproject/FXML.fxml"));

        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.show();
    }

    private void loadFXML(String fileName) {
        Parent parent;
        try {
            parent = FXMLLoader.load(getClass().getResource("/enter/" + fileName + ".fxml"));
            borderPane.setCenter(parent);

        } catch (IOException ex) {
            Logger.getLogger(MainPanelController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void loadPage01View(ActionEvent event) {
     loadFXML("Page01View");
    }

    @FXML
    private void loadPage04View(ActionEvent event) {
         loadFXML("Page04View");
    }

    @FXML
    private void loadPage05View(ActionEvent event) {
         loadFXML("Page05View");
    }

    @FXML
    private void loadPage06View(ActionEvent event) {
            loadFXML("Page06View");
    }

    

   @FXML
    private void loadHomeView(ActionEvent event) {
        loadFXML("HomeView");
    }

    @FXML
     private void close_app(MouseEvent event) {
        System.exit(0);
    }
    
}

