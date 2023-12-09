package App.Vehicles;

import App.Map.Location;
import App.DataTypes.VehicleType;
import App.Map.MapItem;

public class Taxi extends Vehicle implements LandVehicle, MapItem {
    //use super to call the constructor of the parent class
    public Taxi(String registrationNumber, double driverRating, Location location) {
        super(registrationNumber, driverRating, location);
        this.setType(VehicleType.HELICOPTER);
    }
    @Override
    public void drive() {

    }
}
