package main.App.Vehicles.Limo;

import main.App.DataTypes.VehicleType;
import main.App.Map.Location;
import main.App.Map.MapItem;
import main.App.Vehicles.LandVehicle;
import main.App.Vehicles.Vehicle;

public class Limo extends Vehicle implements LandVehicle, MapItem {
    public Limo(String registrationNumber, double driverRating, String driverName, String phoneNumber, Location location) {
        super(VehicleType.LIMO, registrationNumber, driverRating, driverName, phoneNumber, location);
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
