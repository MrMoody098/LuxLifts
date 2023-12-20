package App.Vehicles;

import App.Map.Location;
import App.Vehicles.Types.LandVehicle;

public class Limo extends LandVehicle {
    public Limo(String registrationNumber, double driverRating, String driverName, String phoneNumber, Location location) {
        super(registrationNumber, driverRating, driverName, phoneNumber, location);
        this.setType(VehicleType.HELICOPTER);
    }
}
