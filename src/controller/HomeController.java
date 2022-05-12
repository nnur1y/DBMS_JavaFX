/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import java.text.SimpleDateFormat;
import java.util.Date;
import javafx.application.Platform;

import database.DbConnection;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import model.Employees;
import model.EmployeesDAO;
import model.HomeDAO;

/**
 *
 * @author Nurly
 */


public class HomeController implements Initializable {
    
    private Connection con;
    
    
    
    @FXML
    private Label empNuber;
    @FXML
    private TableView birthdayTable;
    @FXML
    private TableColumn<Employees, String> empNameColumn;
    @FXML
    private TableColumn<Employees, String> empLastNameColumn;
    @FXML
    private TableColumn<Employees, Integer> empAgeColumn;
    @FXML
    private TableColumn<Employees, String> empPositionColumn;
    @FXML
    private Button load;
    
  
    public HomeController() {
        DbConnection dbc = DbConnection.getDatabaseConnection();
        con = dbc.getConnection();
        
    }
   
    
    
    
    @FXML
    private Label today;
    
    private volatile boolean stop = false;
    
     private void DayNow(){
        Thread thread = new Thread(() ->{
           SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
           while(!stop){
               try{
                   Thread.sleep(1000);
               }catch(Exception e){
                   System.out.println(e);
               }
               final String daynow = sdf.format(new Date());
               Platform.runLater(()->{
                   today.setText(daynow);
               });
           }
        });
        thread.start();
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        DayNow();
        empNameColumn.setCellValueFactory(cellData -> cellData.getValue().firstNameProperty());
        empLastNameColumn.setCellValueFactory(cellData -> cellData.getValue().lastNameProperty());
        empPositionColumn.setCellValueFactory(cellData -> cellData.getValue().PositionProperty());
        
    }
   
    
    
    @FXML
    private void searchBirthday(ActionEvent event) throws SQLException, ClassNotFoundException  {
        try {
            //Get all Employees information
            ObservableList<Employees> empData = HomeDAO.searchBirthday();
            
            //Populate Employees on TableView
            populateEmployees(empData);
            
        } catch (SQLException e){
            System.out.println("Error occurred while getting employees information from DB.\n" + e);
            throw e;
        }
    }
     private void populateEmployees (ObservableList<Employees> empData) throws ClassNotFoundException {
        //Set items to the employeeTable
        birthdayTable.setItems(empData);
        
        
    }
     
     
     public static int count (String count) throws SQLException, ClassNotFoundException {
        String selectStmt = "Select count(employee_id) from employees";
        int size = 0;
        try {
            ResultSet rsEmp = DbConnection.dbExecuteQuery(selectStmt);
             rsEmp.last();
            size = rsEmp.getRow();
            rsEmp.beforeFirst();
           return size;
        } catch (SQLException e) {
            System.out.println(e);
            throw e;
            
        }
        
    }
    
        
     @FXML
    private void countEmployee(ActionEvent event) throws SQLException, ClassNotFoundException  {
        //Get all Employees information
        ObservableList<Employees> empData = EmployeesDAO.getEmployeeList();
        //Populate Employees on TableView
        countEmp(empData);
    }
    private void countEmp (ObservableList<Employees> empData) throws ClassNotFoundException {
        //Set items to the employeeTable
        empNuber.setText(String.valueOf(empData));
    }
}