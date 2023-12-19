package App.Vehicles;

import App.Map.Location;
import App.Map.MapItem;
import App.Vehicles.Types.WaterVehicle;

public class Yacht extends WaterVehicle {

    public Yacht(String registrationNumber, double driverRating, String driverName, String phoneNumber, Location location) {
        super(registrationNumber, driverRating, driverName, phoneNumber, location);
        this.setType(VehicleType.YACHT);
    }


}
