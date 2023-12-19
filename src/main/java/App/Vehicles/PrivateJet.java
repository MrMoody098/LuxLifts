package App.Vehicles;

import App.Map.Location;

public class PrivateJet extends Vehicle implements Type {
    //use super to call the constructor of the parent class
    public PrivateJet(String registrationNumber, double driverRating, String driverName, String phoneNumber, Location location) {
        super(registrationNumber, driverRating, driverName, phoneNumber, location);
        this.setType(VehicleType.PRIVATE_JET);
    }

    @Override
    public boolean MoveTo(Location destination) {
        return false;
    }
}
