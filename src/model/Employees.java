/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
import javafx.beans.property.*;
import java.sql.Date;
/**
 *
 * @author Admin
 */


public class Employees {
    
    private IntegerProperty employee_id;
    private StringProperty first_name;
    private StringProperty last_name;
    private StringProperty position;
    private IntegerProperty salary;
    private SimpleObjectProperty<Date> birth_date;
    private StringProperty phone_no;
    private StringProperty email;

public Employees() {
        this.employee_id = new SimpleIntegerProperty();
        this.first_name = new SimpleStringProperty();
        this.last_name = new SimpleStringProperty();
        this.email = new SimpleStringProperty();
        this.phone_no = new SimpleStringProperty();
        this.birth_date = new SimpleObjectProperty<>();
        this.position = new SimpleStringProperty();
        this.salary = new SimpleIntegerProperty();

    }

public int getEmployeeId() {
        return employee_id.get();
    }
    public void setEmployeeId(int employeeId){
        this.employee_id.set(employeeId);
    }
    public IntegerProperty employeeIdProperty(){
        return employee_id;
    }
    //first_name
    public String getFirstName () {
        return first_name.get();
    }
    public void setFirstName(String firstName){
        this.first_name.set(firstName);
    }
    public StringProperty firstNameProperty() {
        return first_name;
    }
    //last_name
    public String getLastName () {
        return last_name.get();
    }
    public void setLastName(String lastName){
        this.last_name.set(lastName);
    }
    public StringProperty lastNameProperty() {
        return last_name;
    }
    //email
    public String getEmail () {
        return email.get();
    }
    public void setEmail (String email){
        this.email.set(email);
    }
    public StringProperty emailProperty() {
        return email;
    }
    //phone_number
    public String getPhoneNo() {
        return phone_no.get();
    }
    public void setPhoneNo (String phoneNumber){
        this.phone_no.set(phoneNumber);
    }
    public StringProperty phoneNoProperty() {
        return phone_no;
    }
    //hire_date
    public Object getBirthDate(){
        return birth_date.get();
    }
    public void setBirthDate(Date birth_date){
        this.birth_date.set(birth_date);
    }
    public SimpleObjectProperty<Date> BirthDateProperty(){
        return birth_date;
    }
    //job_id
    public String getPosition () {
        return position.get();
    }
    public void setPosition (String position){
        this.position.set(position);
    }
    public StringProperty PositionProperty() {
        return position;
    }
    //salary
    public int getSalary() {
        return salary.get();
    }
    public void setSalary(int salary){
        this.salary.set(salary);
    }
    public IntegerProperty salaryProperty(){
        return salary;
    }
    
   

}