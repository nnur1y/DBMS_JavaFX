/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
 */
package javafxproject;

import database.DbConnection;
import javafxproject.AlertHelper;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.Window;
import javafxproject.JavaFXProject;


/**
 *
 * @author Admin
 */
public class FXMLController implements Initializable {
    
    private final Connection con;
     
    @FXML
    private TextField username;
    
    @FXML
    private PasswordField password;
    
    @FXML
    private Button loginButton;
    
    Window window;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
     private void close_app(MouseEvent event) {
        System.exit(0);
    }
     
    public FXMLController() {
        DbConnection dbc = DbConnection.getDatabaseConnection();
        con = dbc.getConnection();
    }
    
    @FXML
    public void login() throws Exception {
            
        String sql = "Select * from admins where Username = ? and Password = ?";

                try{
                    PreparedStatement ps = con.prepareStatement(sql);
                    ps.setString(1,username.getText());
                    ps.setString(2, password.getText());
                    ResultSet rs = ps.executeQuery();
                    if(rs.next()){
                        Stage stage = (Stage) loginButton.getScene().getWindow();
                        stage.close();

                        Parent root = FXMLLoader.load(getClass().getResource("/enter/MainPanel.fxml"));

                        Scene scene = new Scene(root);

                        stage.setScene(scene);
                        stage.show();
                    }else{
                        AlertHelper.showAlert(Alert.AlertType.ERROR, window, "Error",
                            "Invalid username and password.");
                    username.requestFocus();
                    }

                }catch(SQLException ex) {
                    System.out.println(ex);
                }
            }

    
    
        }

