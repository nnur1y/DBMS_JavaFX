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
import model.Employees;
import model.EmployeesDAO;
import java.sql.Date;
import java.sql.SQLException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
/**
 *
 * @author Nurly
 */
public class Page01Controller implements Initializable {

    @FXML
    private TextField empIdText;
    @FXML
    private Button searchEmpBtn;
    @FXML
    private Button deleteEmpBtn;
    @FXML
    private Button addEmpBtn;
    @FXML
    private TextArea resultArea;
    @FXML
    private TextField newEmailText;
    @FXML
    private TextField nameText;
    @FXML
    private TextField surnameText;
    @FXML
    private TextField emailText;
    @FXML
    private TableView employeeTable;
    @FXML
    private TableColumn<Employees, Integer> empIdColumn;
    @FXML
    private TableColumn<Employees, String> empNameColumn;
    @FXML
    private TableColumn<Employees, String> empLastNameColumn;
    @FXML
    private TableColumn<Employees, String> empEmailColumn;
    @FXML
    private TableColumn<Employees, String> empPhoneNumberColumn;
    @FXML
    private TableColumn<Employees, Date> empBirthDateColumn;
    @FXML
    private Button searchEmpsBtn;
    @FXML
    private TextField idText;
    @FXML
    private Button updateMailBtn;
    @FXML
    private TextField phoneText;
    @FXML
    private TextField birthText;
    @FXML
    private Button updatePhoneBtn;
    @FXML
    private TextField newPhoneText;

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        empIdColumn.setCellValueFactory(cellData -> cellData.getValue().employeeIdProperty().asObject());
        empNameColumn.setCellValueFactory(cellData -> cellData.getValue().firstNameProperty());
        empLastNameColumn.setCellValueFactory(cellData -> cellData.getValue().lastNameProperty());
        empEmailColumn.setCellValueFactory(cellData -> cellData.getValue().emailProperty());
        empPhoneNumberColumn.setCellValueFactory(cellData -> cellData.getValue().phoneNoProperty());
        empBirthDateColumn.setCellValueFactory(cellData -> cellData.getValue().BirthDateProperty());

        
    }

    @FXML
    private void searchEmployee(ActionEvent event) throws ClassNotFoundException, SQLException {
        try {
            //Get Employee information
            Employees emp = EmployeesDAO.searchEmployee(empIdText.getText());
            //Populate Employee on TableView and Display on TextArea
            populateAndShowEmployee(emp);
        } catch (SQLException e) {
            e.printStackTrace();
            resultArea.setText("Error occurred while getting employee information from DB.\n" + e);
            throw e;
        }
    }

    @FXML
   private void deleteEmployee (ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        try {
            EmployeesDAO.deleteEmpWithId(empIdText.getText());
            resultArea.setText("Employee deleted! Employee id: " + empIdText.getText() + "\n");
        } catch (SQLException e) {
            resultArea.setText("Problem occurred while deleting employee " + e);
            throw e;
        }
    }

    @FXML
   private void updateEmployeeEmail (ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        try {
            EmployeesDAO.updateEmpEmail(empIdText.getText(),newEmailText.getText());
            resultArea.setText("Email has been updated for, employee id: " + empIdText.getText() + "\n");
        } catch (SQLException e) {
            resultArea.setText("Problem occurred while updating email: " + e);
        }
    }

    @FXML
   private void insertEmployee (ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        try {
            EmployeesDAO.insertEmp(idText.getText(),nameText.getText(),surnameText.getText(),emailText.getText(),phoneText.getText(),birthText.getText());
            resultArea.setText("Employee inserted! \n");
        } catch (SQLException e) {
            resultArea.setText("Problem occurred while inserting employee " + e);
            throw e;
        }
    }

    @FXML
    private void searchEmployees(ActionEvent event) throws SQLException, ClassNotFoundException  {
        try {
            //Get all Employees information
            ObservableList<Employees> empData = EmployeesDAO.searchEmployees();
            //Populate Employees on TableView
            populateEmployees(empData);
        } catch (SQLException e){
            System.out.println("Error occurred while getting employees information from DB.\n" + e);
            throw e;
        }
    }

    private void populateEmployee (Employees emp) throws ClassNotFoundException {
        //Declare and ObservableList for table view
        ObservableList<Employees> empData = FXCollections.observableArrayList();
        //Add employee to the ObservableList
        empData.add(emp);
        //Set items to the employeeTable
        employeeTable.setItems(empData);
    }
    //Set Employee information to Text Area
    private void setEmpInfoToTextArea ( Employees emp) {
        resultArea.setText("First Name: " + emp.getFirstName() + "\n" +
                "Last Name: " + emp.getLastName());
    }

    //Populate Employee for TableView and Display Employee on TextArea
    private void populateAndShowEmployee(Employees emp) throws ClassNotFoundException {
        if (emp != null) {
            populateEmployee(emp);
            setEmpInfoToTextArea(emp);
        } else {
            resultArea.setText("This employee does not exist!\n");
        }
    }
    
    
    //Populate Employees for TableView
    private void populateEmployees (ObservableList<Employees> empData) throws ClassNotFoundException {
        //Set items to the employeeTable
        employeeTable.setItems(empData);
    }

    @FXML
    private void updateEmployeePhone(ActionEvent event) throws SQLException, ClassNotFoundException  {
        try {
            EmployeesDAO.updateEmpPhone(empIdText.getText(),newPhoneText.getText());
            resultArea.setText("Phone has been updated for, employee id: " + empIdText.getText() + "\n");
        } catch (SQLException e) {
            resultArea.setText("Problem occurred while updating phone: " + e);
        }
    }
    
}