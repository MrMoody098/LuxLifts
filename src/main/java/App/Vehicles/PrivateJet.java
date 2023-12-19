package App.Vehicles;

import App.Map.Location;
import App.Vehicles.Types.AirVehicle;

public class PrivateJet extends AirVehicle {
    //use super to call the constructor of the parent class
    public PrivateJet(String registrationNumber, double driverRating, String driverName, String phoneNumber, Location location) {
        super(registrationNumber, driverRating, driverName, phoneNumber, location);
        this.setType(VehicleType.PRIVATE_JET);
    }
}
