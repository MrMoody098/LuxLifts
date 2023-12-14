package App.Vehicles.Taxi;

import App.Map.Location;
import App.DataTypes.VehicleType;
import App.Map.MapItem;
import App.Vehicles.LandVehicle;
import App.Vehicles.Vehicle;

import java.util.Scanner;

public class Taxi extends Vehicle implements LandVehicle, MapItem {
    private LuxuryCar luxuryCar;

    
    public Taxi(String registrationNumber, double driverRating, String driverName, String phoneNumber, Location location, LuxuryCar luxuryCar) {
        // Call the super constructor with specific VehicleType.TAXI
        super(new TaxiType(luxuryCar), registrationNumber, driverRating, driverName, phoneNumber, location);
        this.luxuryCar = luxuryCar;
    }

   
    public LuxuryCar getLuxuryCar() {
        return luxuryCar;
    }

    
    public void setLuxuryCar(LuxuryCar luxuryCar) {
        this.luxuryCar = luxuryCar;
    }

    @Override
    public void drive() {
        // Implement drive method for Taxi
        // ...
    }
}