package App.Vehicles;

import App.Map.Location;
import App.DataTypes.VehicleType;
import App.Map.MapItem;

public class Limo extends Vehicle implements LandVehicle, MapItem {
    public Limo(String registrationNumber, double driverRating, String driverName, String phoneNumber, Location location) {
        super(new LimoType(), registrationNumber, driverRating, driverName, phoneNumber, location);
    }
    @Override
    public void drive() {

    }
}
