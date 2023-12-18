package App.Vehicles;

import App.Map.Location;
import App.Map.MapItem;

public class Yacht extends Vehicle implements Type,MapItem {

    public Yacht(String registrationNumber, double driverRating, String driverName, String phoneNumber, Location location) {
        super(registrationNumber, driverRating, driverName, phoneNumber, location);
        this.setType(VehicleType.YACHT);
    }

    @Override
    public void sail() {
        //can only sail on water
    }

    @Override
    public void drive() {
        
    }

    @Override
    public void fly() {
        
    }

    @Override
    public void land() {
        
    }
}
