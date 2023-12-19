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
            case BUGATTI:
                setTaxiType(Taxis.BUGATTI);
                break;
            case BENTLEY:
                setTaxiType(Taxis.BENTLEY);
                break;
            case FERRARI:
                setTaxiType(Taxis.FERRARI);
                break;
            case PORSCHE:
                setTaxiType(Taxis.PORSCHE);
                break;
            default:
                // Default to Ferrari if an invalid choice is made
                setTaxiType(Taxis.FERRARI);
        }
    }

    

    public Taxis getTaxiType() {
        return taxiType;
    }

    public void setTaxiType(Taxis taxiType) {
        this.taxiType = taxiType;
    }



}