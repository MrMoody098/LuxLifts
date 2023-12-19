package App.Vehicles.Types;

import App.Map.CustomMap;
import App.Map.Location;
import App.Vehicles.Vehicle;

public class WaterVehicle extends Vehicle {
    public WaterVehicle(String registrationNumber, double driverRating, String driverName, String phoneNumber, Location location) {
        super(registrationNumber, driverRating, driverName, phoneNumber, location);
    }


    @Override
    public Location MoveTo(Location destination, CustomMap customMap) {
        return null;
    }
}
