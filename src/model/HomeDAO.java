/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import database.DbConnection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

/**
 *
 * @author Admin
 */
public class HomeDAO {
 
       public static ObservableList<Employees> searchBirthday() throws SQLException, ClassNotFoundException {
        //Declare a SELECT statement
    
        String selectStmt = "Select first_name, last_name, position from employees where to_char(birth_date, 'dd.mm')  =  to_char(sysdate, 'dd.mm')";
        //Execute SELECT statement
        
        try {
            //Get ResultSet from dbExecuteQuery method
            ResultSet rsEmps = DbConnection.dbExecuteQuery(selectStmt);
            //Send ResultSet to the getEmployeeList method and get employee object
            ObservableList<Employees> empList = getEmployeeList(rsEmps);
            //Return employee object
            return empList;
        } catch (SQLException e) {
            System.out.println("SQL select operation has been failed: " + e);
            //Return exception
            throw e;
        }
    }
    private static ObservableList<Employees> getEmployeeList(ResultSet rs) throws SQLException, ClassNotFoundException {
        //Declare a observable List which comprises of Employee objects
        ObservableList<Employees> empList = FXCollections.observableArrayList();
        while (rs.next()) {
            Employees emp = new Employees();
            emp.setFirstName(rs.getString("FIRST_NAME"));
            emp.setLastName(rs.getString("LAST_NAME"));
            emp.setPosition(rs.getString("POSITION"));
            empList.add(emp);
        }
        //return empList (ObservableList of Employees)
        return empList;
    }
    
    
    
    
}
