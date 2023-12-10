package App.Vehicles;

import App.Map.Location;
import App.DataTypes.VehicleType;
import App.Map.MapItem;

public class Limo extends Vehicle implements LandVehicle, MapItem {
    //use super to call the constructor of the parent class
    public Limo(String registrationNumber, double driverRating, String driverName, String phoneNumber, Location location) {
        super(registrationNumber, driverRating, driverName, phoneNumber, location);
        this.setType(VehicleType.HELICOPTER);
    }
    @Override
    public void drive() {

    }
}
