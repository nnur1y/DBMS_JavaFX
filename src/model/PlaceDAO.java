/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import database.DbConnection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Admin
 */
public class PlaceDAO {
    private static Place getPlaceFromResultSet(ResultSet rs) throws SQLException
    {
        Place place = null;
        if (rs.next()) {
            place = new Place();
            place.setPlaceId(rs.getInt("PLACE_ID"));
            place.setName(rs.getString("NAME"));
            place.setFloor(rs.getInt("FLOOR"));
           
        }
        return place;
    }
    
     private static ObservableList<Place> getPlaceList(ResultSet rs) throws SQLException, ClassNotFoundException {
         ObservableList<Place> placeList = FXCollections.observableArrayList();
        while (rs.next()) {
            Place place = new Place();
            place.setPlaceId(rs.getInt("PLACE_ID"));
            place.setName(rs.getString("NAME"));
            place.setFloor(rs.getInt("FLOOR"));
           
           
            placeList.add(place);
        }
        
        return placeList;
    }
      public static ObservableList<Place> searchPlace () throws SQLException, ClassNotFoundException {
        //Declare a SELECT statement
        String selectStmt = "SELECT * FROM Place order by place_id";
        //Execute SELECT statement
        try {
           
            ResultSet rsPlace = DbConnection.dbExecuteQuery(selectStmt);
            
            ObservableList<Place> PlaceList = getPlaceList(rsPlace);
            
            return PlaceList;
        } catch (SQLException e) {
            System.out.println("SQL select operation has been failed: " + e);
            //Return exception
            throw e;
        }
    }
     }

