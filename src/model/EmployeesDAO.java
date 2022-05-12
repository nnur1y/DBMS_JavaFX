/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import database.DbConnection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/**
 *
 * @author Admin
 */



public class EmployeesDAO {
   
    
    //SELECT an Employee
    
    public static Employees searchEmployee (String empId) throws SQLException, ClassNotFoundException {
        String selectStmt = "SELECT * FROM employees WHERE employee_id="+empId;
        try {
            ResultSet rsEmp = DbConnection.dbExecuteQuery(selectStmt);
            Employees employee = getEmployeeFromResultSet(rsEmp);
            
            return employee;
        } catch (SQLException e) {
            System.out.println("While searching an employee with " + empId + " id, an error occurred: " + e);
            throw e;
        }
    }
     
    
   
   
    
    
    
    private static Employees getEmployeeFromResultSet(ResultSet rs) throws SQLException
    {
        Employees emp = null;
        if (rs.next()) {
            emp = new Employees();
            emp.setEmployeeId(rs.getInt("EMPLOYEE_ID"));
            emp.setFirstName(rs.getString("FIRST_NAME"));
            emp.setLastName(rs.getString("LAST_NAME"));
            emp.setPosition(rs.getString("POSITION"));
            emp.setSalary(rs.getInt("SALARY"));
            emp.setBirthDate(rs.getDate("BIRTH_DATE"));
            emp.setPhoneNo(rs.getString("PHONE_NO"));
            emp.setEmail(rs.getString("EMAIL"));
            
            
        }
        return emp;
    }
    
    
   
    public static ObservableList<Employees> searchEmployees () throws SQLException, ClassNotFoundException {
        //Declare a SELECT statement
        String selectStmt = "SELECT * FROM employees order by employee_id";
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
    //Select * from employees operation
    private static ObservableList<Employees> getEmployeeList(ResultSet rs) throws SQLException, ClassNotFoundException {
        //Declare a observable List which comprises of Employee objects
        ObservableList<Employees> empList = FXCollections.observableArrayList();
        while (rs.next()) {
            Employees emp = new Employees();
            emp.setEmployeeId(rs.getInt("EMPLOYEE_ID"));
            emp.setFirstName(rs.getString("FIRST_NAME"));
            emp.setLastName(rs.getString("LAST_NAME"));
            emp.setPosition(rs.getString("POSITION"));
            emp.setSalary(rs.getInt("SALARY"));
            emp.setBirthDate(rs.getDate("BIRTH_DATE"));
            emp.setPhoneNo(rs.getString("PHONE_NO"));
            emp.setEmail(rs.getString("EMAIL"));
            //Add employee to the ObservableList
            empList.add(emp);
        }
        //return empList (ObservableList of Employees)
        return empList;
    }
    
    //UPDATE an employee's email address
    
    public static void updateEmpEmail (String empId, String empEmail) throws SQLException, ClassNotFoundException {
        //Declare a UPDATE statement
        String updateStmt =
                "BEGIN\n" +
                        "   UPDATE employees\n" +
                        "      SET EMAIL = '" + empEmail + "'\n" +
                        "    WHERE EMPLOYEE_ID = " + empId + ";\n" +
                        "   COMMIT;\n" +
                        "END;";
        //Execute UPDATE operation
        try {
            DbConnection.dbExecuteUpdate(updateStmt);
        } catch (SQLException e) {
            System.out.print("Error occurred while UPDATE Operation: " + e);
            throw e;
        }
    }
    
    public static void updateEmpPhone (String empId, String empPhone) throws SQLException, ClassNotFoundException {
        //Declare a UPDATE statement
        String updateStmt =
                "BEGIN\n" +
                        "   UPDATE employees\n" +
                        "      SET PHONE_NO = '" + empPhone + "'\n" +
                        "    WHERE EMPLOYEE_ID = " + empId + ";\n" +
                        "   COMMIT;\n" +
                        "END;";
        //Execute UPDATE operation
        try {
            DbConnection.dbExecuteUpdate(updateStmt);
        } catch (SQLException e) {
            System.out.print("Error occurred while UPDATE Operation: " + e);
            throw e;
        }
    }
    
    
    //DELETE an employee
    
    public static void deleteEmpWithId (String empId) throws SQLException, ClassNotFoundException {
        //Declare a DELETE statement
        String updateStmt =
                "BEGIN\n" +
                        "   DELETE FROM employees\n" +
                        "         WHERE employee_id ="+ empId +";\n" +
                        "   COMMIT;\n" +
                        "END;";
        
        try {
            DbConnection.dbExecuteUpdate(updateStmt);
        } catch (SQLException e) {
            System.out.print("Error occurred while DELETE Operation: " + e);
            throw e;
        }
    }
    
    //INSERT an employee
  
    public static void insertEmp (String id, String name, String lastname, String email, String phone, String birthday) throws SQLException, ClassNotFoundException {
        //Declare a DELETE statement
        String updateStmt =
                "BEGIN\n" +
                        "INSERT INTO employees\n" +
                        "(EMPLOYEE_ID, FIRST_NAME, LAST_NAME, EMAIL, PHONE_NO, BIRTH_DATE)\n" +
                        "VALUES\n" +
                        "('"+id+"', '"+name+"', '"+lastname+"','"+email+"','"+phone+"','"+birthday+"');\n" +
                        "END;";
        
        try {
            DbConnection.dbExecuteUpdate(updateStmt);
        } catch (SQLException e) {
            System.out.print("Error occurred while Insert Operation: " + e);
            throw e;
        }
    } 

    public static ObservableList<Employees> getEmployeeList() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
