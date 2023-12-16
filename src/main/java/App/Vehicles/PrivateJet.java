package App.Vehicles;

import App.Map.Location;
import App.DataTypes.VehicleType;

public class PrivateJet extends Vehicle implements AirVehicle {
    //use super to call the constructor of the parent class
    public PrivateJet(String registrationNumber, double driverRating, String driverName, String phoneNumber, Location location) {
        super(new PrivateJetType(),registrationNumber, driverRating, driverName, phoneNumber, location);
        
    }


    @Override
    public void fly() {

    }

    @Override
    public void land() {

    }
}
