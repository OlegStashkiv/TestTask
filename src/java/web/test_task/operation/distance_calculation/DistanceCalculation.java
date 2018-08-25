/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web.test_task.operation.distance_calculation;

import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;


/**
 *
 * @author Oleg Stashkiv
 */
@Named
@SessionScoped
public class DistanceCalculation implements Serializable {
    private String latitudeA;
    private String longitudeA;
    private String latitudeB;
    private String longitudeB;
    private String result;
    private String message;
    
    public static final double R = 6000;
    

    // empty constructor
    public DistanceCalculation() {}
    
    // Getter and Setter

    public String getLatitudeA() {
        return latitudeA;
    }

    public void setLatitudeA(String latitudeA) {
        this.latitudeA = latitudeA;
    }

    public String getLongitudeA() {
        return longitudeA;
    }

    public void setLongitudeA(String longitudeA) {
        this.longitudeA = longitudeA;
    }

    public String getLatitudeB() {
        return latitudeB;
    }

    public void setLatitudeB(String latitudeB) {
        this.latitudeB = latitudeB;
    }

    public String getLongitudeB() {
        return longitudeB;
    }

    public void setLongitudeB(String longitudeB) {
        this.longitudeB = longitudeB;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

   
  
    // search for the shortest distance
    public void Calculation(){
   
    double d;
    double x;
    double y;
    double z;
    double c;
    double a;
    
    //search From chord length
    x = (Math.cos(Math.toRadians(Double.parseDouble(latitudeB))) * Math.cos(Math.toRadians(Double.parseDouble(longitudeB)))) - (Math.cos(Math.toRadians(Double.parseDouble(latitudeA)))* Math.cos(Math.toRadians(Double.parseDouble(longitudeA)))); 
    y = (Math.cos(Math.toRadians(Double.parseDouble(latitudeB)))* Math.sin(Math.toRadians(Double.parseDouble(longitudeB)))) - (Math.cos(Math.toRadians(Double.parseDouble(latitudeA)))* Math.sin(Math.toRadians(Double.parseDouble(longitudeA))));
    z  = Math.sin(Math.toRadians(Double.parseDouble(latitudeB))) - Math.sin(Math.toRadians(Double.parseDouble(latitudeA)));
    c = Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2) + Math.pow(z, 2));
    a = 2 * Math.asin(c/2); 
    d = R * a;
   
   result = String.format("%.2f", d) + " км";
   message = "Результат";}

}
