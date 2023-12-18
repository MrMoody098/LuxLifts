package main.App.Vehicles.Taxi;

<<<<<<< HEAD:src/main/App/Vehicles/Taxi/Taxi.java
import main.App.DataTypes.VehicleType;
import main.App.Map.Location;
import main.App.Map.MapItem;
import main.App.Vehicles.LandVehicle;
import main.App.Vehicles.Vehicle;
=======
import App.Map.Location;
import App.Map.MapItem;
//import App.Vehicles.LandVehicle;
import App.Vehicles.Type;
import App.Vehicles.Vehicle;
import App.Vehicles.VehicleType;

import java.util.Scanner;
>>>>>>> ace8bf0a15169c1d3ba64c2d06ab466e98025c9b:src/main/java/App/Vehicles/Taxi/Taxi.java

public class Taxi extends Vehicle implements Type {
    private Taxis taxiType;

<<<<<<< HEAD:src/main/App/Vehicles/Taxi/Taxi.java
    
    public Taxi(String registrationNumber, double driverRating, String driverName, String phoneNumber, Location location, LuxuryCar luxuryCar) {
        // Call the super constructor with specific VehicleType.TAXI
        super(VehicleType.TAXI, registrationNumber, driverRating, driverName, phoneNumber, location);
        this.luxuryCar = luxuryCar;
=======
    public Taxi(Taxis taxiType, String registrationNumber, double driverRating, String driverName, String phoneNumber, Location location) {
        super(registrationNumber, driverRating, driverName, phoneNumber, location);
        this.taxiType = taxiType;

        switch (taxiType) {
            case Bugatti:
                setTaxiType(Taxis.Bugatti);
                break;
            case Bentley:
                setTaxiType(Taxis.Bentley);
                break;
            case Ferrari:
                setTaxiType(Taxis.Ferrari);
                break;
            case Porsche:
                setTaxiType(Taxis.Porsche);
                break;
            default:
                // Default to Ferrari if an invalid choice is made
                setTaxiType(Taxis.Ferrari);
        }
>>>>>>> ace8bf0a15169c1d3ba64c2d06ab466e98025c9b:src/main/java/App/Vehicles/Taxi/Taxi.java
    }

    public Taxis getTaxiType() {
        return taxiType;
    }

    public void setTaxiType(Taxis taxiType) {
        this.taxiType = taxiType;
    }

    @Override
<<<<<<< HEAD:src/main/App/Vehicles/Taxi/Taxi.java
    public Location MoveTo(Location Destination) {
        return null;
    }

    @Override
    public boolean CanDrive() {
        return false;
=======
    public void drive() {
    
    }


    @Override
    public void fly() {
        
    }

    @Override
    public void land() {
       
    }

    @Override
    public void sail() {
        
>>>>>>> ace8bf0a15169c1d3ba64c2d06ab466e98025c9b:src/main/java/App/Vehicles/Taxi/Taxi.java
    }
}