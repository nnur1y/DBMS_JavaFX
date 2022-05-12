 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import model.Menu;
import model.MenuDAO;
import java.sql.Date;
import java.sql.SQLException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.MenuButton;
/**
 *
 * @author Nurly
 */
public class Page04Controller implements Initializable {

    
    @FXML
    private Button searchEmpBtn;
    @FXML
    private TextArea resultArea;
    
    
    
    @FXML
    private TextField idText;
    @FXML
    private Button updateMailBtn;
    
    @FXML
    private TextField newPriceText;
    @FXML
    private Button searchMenuBtn;
    @FXML
    private TextField titleText;
    @FXML
    private TextField positionText;
    @FXML
    private TextField priceText;
    @FXML
    private TextField amountText;
    
    @FXML
    private TextField foodIdText;
    @FXML
    private Button addMenuBtn;
    
    @FXML
    private TableColumn<Menu, String> TitleColumn;
    @FXML
    private TableColumn<Menu, String> PositionColumn;
    @FXML
    private TableColumn<Menu, Integer> amountColumn;
    
    @FXML
    private TableView menuTable;
    @FXML
    private TableColumn<Menu, Integer> priceColumn;
    @FXML
    private TableColumn<Menu, Integer> placeIdColumn;
    private MenuButton placeMenu;
    @FXML
    private TextField placeIdText;
    @FXML
    private TableColumn<Menu, Integer> foodIdColumn;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        foodIdColumn.setCellValueFactory(cellData -> cellData.getValue().FoodIdProperty().asObject());
        TitleColumn.setCellValueFactory(cellData -> cellData.getValue().TitleProperty());
        PositionColumn.setCellValueFactory(cellData -> cellData.getValue().PositionProperty());
        priceColumn.setCellValueFactory(cellData -> cellData.getValue().PriceProperty().asObject());
        placeIdColumn.setCellValueFactory(cellData -> cellData.getValue().PlaceIdProperty().asObject());
        amountColumn.setCellValueFactory(cellData -> cellData.getValue().AmountProperty().asObject());

        
    }
    @FXML
    private void searchMenu(ActionEvent event) throws ClassNotFoundException, SQLException {
        try {
            
            Menu menu = MenuDAO.searchMenu(foodIdText.getText());
            
            populateAndShowMenu(menu);
        } catch (SQLException e) {
            e.printStackTrace();
            resultArea.setText("Error occurred while getting employee information from DB.\n" + e);
            throw e;
        }
    }

    @FXML
    private void updateMenuPrice (ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        try {
            MenuDAO.updateMenuPrice(foodIdText.getText(),newPriceText.getText());
            resultArea.setText("Price has been updated for, food id: " + foodIdText.getText() + "\n");
        } catch (SQLException e) {
            resultArea.setText("Problem occurred while updating price: " + e);
        }
    }

    @FXML
    private void insertMenu(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        try {
            MenuDAO.insertMenu(idText.getText(),titleText.getText(),positionText.getText(),priceText.getText(),placeIdText.getText(),amountText.getText());
            resultArea.setText("Menu inserted! \n");
        } catch (SQLException e) {
            resultArea.setText("Problem occurred while inserting Menu " + e);
            throw e;
        }
    }
    
    @FXML
    private void searchMenus(ActionEvent event) throws SQLException, ClassNotFoundException  {
        try {
            
            ObservableList<Menu> menuData = MenuDAO.searchMenus();
            populateMenus(menuData);
        } catch (SQLException e){
            System.out.println("Error occurred while getting employees information from DB.\n" + e);
            throw e;
        }
    }

    private void populateMenu (Menu menu) throws ClassNotFoundException {
        //Declare and ObservableList for table view
        ObservableList<Menu> menuData = FXCollections.observableArrayList();
        //Add employee to the ObservableList
        menuData.add(menu);
        menuTable.setItems(menuData);
    }
    private void setMenuInfoToTextArea ( Menu menu) {
        resultArea.setText("Title: " + menu.getTitle() + "\n" +
                "Position: " + menu.getPosition());
    }

    //Populate Employee for TableView and Display Employee on TextArea
    private void populateAndShowMenu(Menu menu) throws ClassNotFoundException {
        if (menu != null) {
            populateMenu(menu);
            setMenuInfoToTextArea(menu);
        } else {
            resultArea.setText("This employee does not exist!\n");
        }
    }
    
    
    
    private void populateMenus (ObservableList<Menu> menuData) throws ClassNotFoundException {
        
        menuTable.setItems(menuData);
    }

   

    
}