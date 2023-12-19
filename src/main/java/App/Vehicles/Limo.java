package App.Vehicles;

import App.Map.Location;
import App.Map.MapItem;

public class Limo extends Vehicle implements Type, MapItem {
    public Limo(String registrationNumber, double driverRating, String driverName, String phoneNumber, Location location) {
        super( registrationNumber, driverRating, driverName, phoneNumber, location);
        this.setType(VehicleType.HELICOPTER);
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
    @Override
    public void sail() {
        
    }

    @Override
    public boolean MoveTo(Location destination) {
        return false;
    }
}
