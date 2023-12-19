//package name
package App.Vehicles;

import App.Map.Location;
import App.Map.MapItem;


public abstract class Vehicle implements MapItem {
    private int Speed;
    private Location location;
     private String registrationNumber;
     private String phoneNumber;
    private double driverRating;
    private VehicleType type;
    private boolean isAvailable;
    

    public Vehicle(String registrationNumber, double driverRating, String driverName, String phoneNumber, Location location) {
        this.registrationNumber = registrationNumber;
        this.driverRating = driverRating;
        this.location = location;
    }



    //getter and setter methods for all the above variables
    public String getRegistrationNumber() {
        return registrationNumber;
    }
    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }
    public double getDriverRating() {
       return driverRating;
    }
    public void setDriverRating(double driverRating) {
        this.driverRating = driverRating;
    }
    public VehicleType getType() {
        return type;
    }
    public void setType(VehicleType type) {
        this.type = type;
    }
    
    public boolean isAvailable() {
        return isAvailable;
    }
    public void setAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }
    public void printVehicleDetails() {
        System.out.println("Registration Number: " + this.registrationNumber);
        System.out.println("Driver Rating: " + this.driverRating);
        System.out.println("Vehicle Type: " + this.type);
        System.out.println("Is Available: " + this.isAvailable);
    }
    public int getSpeed() {
        return Speed;
    }

    @Override
    public Location SetLocation(int x, int y) {
        //move the Passenger to the new location x,y
        location = new Location(x,y);
        return location;
    }

    @Override
    public Location GetLocation() {
        //return the current location of the Passenger
        return this.location;
    }

    @Override
    public Location UpdateLocation(int x, int y) {
        //move the Passenger x,y amount from their current location
        int CurrentX = location.getX();
        int CurrentY = location.getY();
        return SetLocation(CurrentX + x, CurrentY + y);
    }
    @Override
    public String toString() {
        return "Vehicle type: " + this.getClass().getSimpleName() +
            ", Registration Number: " + getRegistrationNumber() +
            ", Driver Rating: " + getDriverRating() +
            ", Location: " + GetLocation();
    }
}

