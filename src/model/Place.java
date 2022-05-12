package model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Admin
 */
public class Place {
    private IntegerProperty place_id;
    private StringProperty name;
    private IntegerProperty floor;

        
public Place() {
        this.place_id = new SimpleIntegerProperty();
        this.name = new SimpleStringProperty();
        this.floor = new SimpleIntegerProperty();
       

    }

public int getPlaceId() {
        return place_id.get();
    }
    public void setPlaceId(int place_id){
        this.place_id.set(place_id);
    }
    public IntegerProperty PlaceIdProperty(){
        return place_id;
    }
    
    public String getName () {
        return name.get();
    }
    public void setName(String name){
        this.name.set(name);
    }
    public StringProperty NameProperty() {
        return name;
    }
    
    
    
    public int getFloor () {
        return floor.get();
    }
    public void setFloor (int floor){
        this.floor.set(floor);
    }
    public IntegerProperty FloorProperty() {
        return floor;
    }
}