package App.Vehicles;

import App.Map.CustomMap;
import App.Map.Location;
import App.Vehicles.Types.AirVehicle;

public class Helicopter extends AirVehicle {
    // use super to call the constructor of the parent class
    public Helicopter(String registrationNumber, double driverRating, String driverName, String phoneNumber, Location location) {
        super(registrationNumber, driverRating, driverName, phoneNumber, location);
        this.setType(VehicleType.HELICOPTER);
    }
}
