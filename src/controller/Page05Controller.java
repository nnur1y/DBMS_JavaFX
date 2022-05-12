/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;


import model.Place;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import model.PlaceDAO;
import javafx.collections.ObservableList;

/**
 *
 * @author Nurly
 */
public class Page05Controller implements Initializable {
    
    @FXML
    private TableColumn<Place, Integer> place_idColumn;
    @FXML
    private TableColumn<Place, String> nameColumn;
    @FXML
    private TableColumn<Place, Integer> floorColumn;
    
   
    @FXML
    private Button SearchPlaceBtn;
    @FXML
    private TableView placeTable;

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        place_idColumn.setCellValueFactory(cellData -> cellData.getValue().PlaceIdProperty().asObject());
        nameColumn.setCellValueFactory(cellData -> cellData.getValue().NameProperty());
        floorColumn.setCellValueFactory(cellData -> cellData.getValue().FloorProperty().asObject());
    }
   @FXML
    private void searchPlace(ActionEvent event) throws SQLException, ClassNotFoundException  {
        try {
            
            ObservableList<Place> placeData = PlaceDAO.searchPlace();
            populatePlace(placeData);
        } catch (SQLException e){
            System.out.println("Error occurred while getting employees information from DB.\n" + e);
            throw e;
        }
    }
    private void populatePlace (ObservableList<Place> placeData) throws ClassNotFoundException {
        
       placeTable.setItems(placeData);
    }
    }
