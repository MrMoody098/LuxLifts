package App.Vehicles.Taxi;

import App.Map.Location;
import App.Vehicles.Types.LandVehicle;

public class Taxi extends LandVehicle {
    private final Taxis Brand; 
    public Taxi(Taxis Brand,String registrationNumber, double driverRating, String driverName, String phoneNumber, Location location) {
        super(registrationNumber, driverRating, driverName, phoneNumber, location);
        this.Brand = Brand;
    }

    public Taxis getBrand() {
        return Brand;
    }
    public String printDetails(){
        return ("Brand:"+getBrand()
                +" RegistrationNum:"+ getRegistrationNumber()
                +"\nDriverRating"+ getDriverRating()
                +" Drivername:" +getDriverName()+
                "\nPhoneNumber:"+getPhoneNumber()+" Location:"+getLocation());
    }
}