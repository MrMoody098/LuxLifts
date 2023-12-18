package main.App.Vehicles;

import main.App.DataTypes.VehicleType;
import main.App.Map.Location;
import main.App.Map.MapItem;

public class Yacht extends Vehicle implements WaterVehicle,MapItem {

    public Yacht(String registrationNumber, double driverRating, String driverName, String phoneNumber, Location location) {
        super(VehicleType.YACHT, registrationNumber, driverRating, driverName, phoneNumber, location);
    }

    @Override
    public Location MoveTo(Location Destination) {
        return null;
    }

    @Override
    public boolean CanSail() {
        return false;
    }
}
