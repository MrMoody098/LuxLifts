package App.Vehicles.Taxi;

import App.Map.Location;

import App.Map.MapItem;
import App.Vehicles.Types.LandVehicle;
import App.Vehicles.Vehicle;


public class Taxi extends LandVehicle {
    private Taxis taxiType;

    public Taxi(Taxis taxiType, String registrationNumber, double driverRating, String driverName, String phoneNumber, Location location) {
        super(registrationNumber, driverRating, driverName, phoneNumber, location);
        this.taxiType = taxiType;

        switch (taxiType) {
            case Bugatti:
                setTaxiType(Taxis.Bugatti);
                break;
            case Bentley:
                setTaxiType(Taxis.Bentley);
                break;
            case Ferrari:
                setTaxiType(Taxis.Ferrari);
                break;
            case Porsche:
                setTaxiType(Taxis.Porsche);
                break;
            default:
                // Default to Ferrari if an invalid choice is made
                setTaxiType(Taxis.Ferrari);
        }
    }

    public Taxis getTaxiType() {
        return taxiType;
    }

    public void setTaxiType(Taxis taxiType) {
        this.taxiType = taxiType;
    }



}