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

/**
 *
 * @author Admin
 */
public class MenuDAO {
     public static Menu searchMenu (String menuId) throws SQLException, ClassNotFoundException {
        String selectStmt = "SELECT * FROM menu WHERE food_id="+menuId;
        try {
            ResultSet rsMenu = DbConnection.dbExecuteQuery(selectStmt);
            Menu menu = getMenuFromResultSet(rsMenu);
            
            return menu;
        } catch (SQLException e) {
            System.out.println("While searching an employee with " + menuId + " id, an error occurred: " + e);
            throw e;
        }
    }
     
    
   
   
    
    
    
    private static Menu getMenuFromResultSet(ResultSet rs) throws SQLException
    {
        Menu menu = null;
        if (rs.next()) {
            menu = new Menu();
            menu.setFoodId(rs.getInt("FOOD_ID"));
            menu.setTitle(rs.getString("TITLE"));
            menu.setPosition(rs.getString("POSITION"));
            menu.setPrice(rs.getInt("PRICE"));
            menu.setPlaceId(rs.getInt("PLACE_ID"));
            menu.setAmount(rs.getInt("AMOUNT"));
            
        }
        return menu;
    }
    
    
   
    public static ObservableList<Menu> searchMenus () throws SQLException, ClassNotFoundException {
        //Declare a SELECT statement
        String selectStmt = "SELECT * FROM Menu order by food_id";
        //Execute SELECT statement
        try {
           
            ResultSet rsMenu = DbConnection.dbExecuteQuery(selectStmt);
            
            ObservableList<Menu> menuList = getMenuList(rsMenu);
            
            return menuList;
        } catch (SQLException e) {
            System.out.println("SQL select operation has been failed: " + e);
            //Return exception
            throw e;
        }
    }
 
    private static ObservableList<Menu> getMenuList(ResultSet rs) throws SQLException, ClassNotFoundException {
       
        ObservableList<Menu> menuList = FXCollections.observableArrayList();
        while (rs.next()) {
            Menu menu = new Menu();
            menu.setFoodId(rs.getInt("FOOD_ID"));
            menu.setTitle(rs.getString("TITLE"));
            menu.setPosition(rs.getString("POSITION"));
            menu.setPrice(rs.getInt("PRICE"));
            menu.setPlaceId(rs.getInt("PLACE_ID"));
            menu.setAmount(rs.getInt("AMOUNT"));
            //Add employee to the ObservableList
            menuList.add(menu);
        }
        
        return menuList;
    }
    
    
    
    public static void updateMenuPrice(String foodId, String price) throws SQLException, ClassNotFoundException {
        //Declare a UPDATE statement
        String updateStmt =
                "BEGIN\n" +
                        "   UPDATE Menu\n" +
                        "      SET PRICE = '" + price + "'\n" +
                        "    WHERE FOOD_ID = " + foodId + ";\n" +
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
    
    
    
 
    
  
    public static void insertMenu(String id, String title, String position, String price, String place_id, String amount) throws SQLException, ClassNotFoundException {
        //Declare a DELETE statement
        String updateStmt =
                "BEGIN\n" +
                        "INSERT INTO Menu\n" +
                        "(FOOD_ID, TITLE, POSITION, PRICE, PLACE_id, AMOUNT)\n" +
                        "VALUES\n" +
                        "('"+id+"', '"+title+"', '"+position+"','"+price+"','"+place_id+"','"+amount+"');\n" +
                        "END;";
        
        try {
            DbConnection.dbExecuteUpdate(updateStmt);
        } catch (SQLException e) {
            System.out.print("Error occurred while Insert Operation: " + e);
            throw e;
        }
    } 

}

    

