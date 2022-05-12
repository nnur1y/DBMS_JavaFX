/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
/**
 *
 * @author Admin
 */


import javafx.beans.property.*;
import java.sql.Date;
/**
 *
 * @author Admin
 */


public class Menu {
    
    private IntegerProperty food_id;
    private StringProperty title;
    private StringProperty position;
    private IntegerProperty price;
    private IntegerProperty place_id;
    private IntegerProperty amount;
    
    

public Menu() {
        this.food_id = new SimpleIntegerProperty();
        this.title = new SimpleStringProperty();
        this.position = new SimpleStringProperty();
        this.price = new SimpleIntegerProperty();
        this.place_id = new SimpleIntegerProperty();
        this.amount = new SimpleIntegerProperty();
        

    }

public int getFoodId() {
        return food_id.get();
    }
    public void setFoodId(int food_id){
        this.food_id.set(food_id);
    }
    public IntegerProperty FoodIdProperty(){
        return food_id;
    }
    
    public String getTitle () {
        return title.get();
    }
    public void setTitle(String title){
        this.title.set(title);
    }
    public StringProperty TitleProperty() {
        return title;
    }
    //position
    public String getPosition () {
        return position.get();
    }
    public void setPosition (String position){
        this.position.set(position);
    }
    public StringProperty PositionProperty() {
        return position;
    }
    
   
    //price
    public int getPrice () {
        return price.get();
    }
    public void setPrice (int price){
        this.price.set(price);
    }
    public IntegerProperty PriceProperty() {
        return price;
    }
    //place_id
    public int getPlaceId() {
        return place_id.get();
    }
    public void setPlaceId(int place_id){
        this.place_id.set(place_id);
    }
    public IntegerProperty PlaceIdProperty(){
        return place_id;
    }
    
    //v
    public int getAmount () {
        return amount.get();
    }
    public void setAmount (int amount){
        this.amount.set(amount);
    }
    public IntegerProperty AmountProperty() {
        return amount;
    }
    
   

}