package org.example;

import org.example.DataTypes.vehicleType;

public class Vehicle {
    String registrationNumber;
    double driverRating;
    vehicleType type;
    public Vehicle(String registrationNumber, double driverRating, vehicleType type) {
        this.registrationNumber = registrationNumber;
        this.driverRating = driverRating;
        this.type = type;
    }
}
