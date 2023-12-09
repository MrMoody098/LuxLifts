package App.Vehicles;

import App.DataTypes.Location;
import App.DataTypes.VehicleType;
import App.Vehicles.AirVehicle;
import App.Vehicles.Vehicle;

public class Helicopter extends Vehicle implements AirVehicle {
    // use super to call the constructor of the parent class
    public Helicopter(String registrationNumber, double driverRating, int x, int y) {
        super(registrationNumber, driverRating, new Location(x, y));
        this.setType(VehicleType.HELICOPTER);
    }

    @Override
    public void fly() {
        
    }

    @Override
    public void land() {

    }
}
