package App.Vehicles;

import App.Map.Location;
import App.DataTypes.VehicleType;

public class Helicopter extends Vehicle implements AirVehicle {
    // use super to call the constructor of the parent class
    public Helicopter(String registrationNumber, double driverRating, String driverName, String phoneNumber, Location location) {
        super(registrationNumber, driverRating, driverName, phoneNumber, location);
        this.setType(VehicleType.HELICOPTER);
    }

    @Override
    public void fly() {
    //can only pickup and drop off on landing pads however can fly straight over roads and water so it is the fastest vehicle
    }

    @Override
    public void land() {

    }
}
