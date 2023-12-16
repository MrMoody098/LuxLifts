package App.Vehicles.Taxi;

import App.DataTypes.VehicleType;



public class TaxiType implements VehicleType {
    private LuxuryCar luxuryCar;

    public TaxiType(LuxuryCar luxuryCar) {
        this.luxuryCar = luxuryCar;
    }

    @Override
    public String getType() {
        return "TAXI";
    }

    public LuxuryCar getLuxuryCar() {
        return luxuryCar;
    }
}

    
