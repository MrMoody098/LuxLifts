package org.example;

import org.example.DataTypes.Location;
import org.example.DataTypes.vehicleType;

public class Vehicle {
    private String registrationNumber;
    private double driverRating;
    private vehicleType type;
    private boolean isAvailable;
    private Location location;

    public Vehicle(String registrationNumber, double driverRating, vehicleType type, Location location) {
        this.registrationNumber = registrationNumber;
        this.driverRating = driverRating;
        this.type = type;
        this.location = location;
    }
//getter and setter methods for all the above variables
    public String getRegistrationNumber() {
        return registrationNumber;
    }
    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }
    public double getDriverRating() {
       return driverRating;
    }
    public void setDriverRating(double driverRating) {
        this.driverRating = driverRating;
    }
    public vehicleType getType() {
        return type;
    }
    public void setType(vehicleType type) {
        this.type = type;
    }
    public boolean isAvailable() {
        return isAvailable;
    }
    public void setAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }
    public void printVehicleDetails() {
        System.out.println("Registration Number: " + this.registrationNumber);
        System.out.println("Driver Rating: " + this.driverRating);
        System.out.println("Vehicle Type: " + this.type);
        System.out.println("Is Available: " + this.isAvailable);
    }
    public Location getLocation() {
        return location;
    }
}

