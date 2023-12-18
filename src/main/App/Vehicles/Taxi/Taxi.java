package main.App.Vehicles.Taxi;

import main.App.DataTypes.VehicleType;
import main.App.Map.Location;
import main.App.Map.MapItem;
import main.App.Vehicles.LandVehicle;
import main.App.Vehicles.Vehicle;

public class Taxi extends Vehicle implements LandVehicle, MapItem {
    private LuxuryCar luxuryCar;

    
    public Taxi(String registrationNumber, double driverRating, String driverName, String phoneNumber, Location location, LuxuryCar luxuryCar) {
        // Call the super constructor with specific VehicleType.TAXI
        super(VehicleType.TAXI, registrationNumber, driverRating, driverName, phoneNumber, location);
        this.luxuryCar = luxuryCar;
    }

   
    public LuxuryCar getLuxuryCar() {
        return luxuryCar;
    }

    
    public void setLuxuryCar(LuxuryCar luxuryCar) {
        this.luxuryCar = luxuryCar;
    }

    @Override
    public Location MoveTo(Location Destination) {
        return null;
    }

    @Override
    public boolean CanDrive() {
        return false;
    }
}