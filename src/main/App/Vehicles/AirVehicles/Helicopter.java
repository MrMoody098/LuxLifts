package main.App.Vehicles.AirVehicles;

import main.App.DataTypes.VehicleType;
import main.App.Map.Location;
import main.App.Vehicles.AirVehicles.AirVehicle;
import main.App.Vehicles.Vehicle;

public class Helicopter extends Vehicle implements AirVehicle {
    // use super to call the constructor of the parent class
    public Helicopter(String registrationNumber, double driverRating, String driverName, String phoneNumber, Location location) {
        super(VehicleType.HELICOPTER,registrationNumber, driverRating, driverName, phoneNumber, location);
        
    }


    @Override
    public Location MoveTo(Location Destination) {
        return null;
    }

    @Override
    public boolean CanLand() {
        return false;
    }
}
