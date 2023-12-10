package App.Vehicles;

import App.Map.Location;
import App.Map.MapItem;

public class Yacht extends Vehicle implements WaterVehicle,MapItem {

    public Yacht(String registrationNumber, double driverRating, String driverName, String phoneNumber, Location location) {
        super(registrationNumber, driverRating, driverName, phoneNumber, location);
    }

    @Override
    public void sail() {
        //can only sail on water
    }
}
