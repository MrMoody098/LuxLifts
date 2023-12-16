package App.Vehicles;

import App.DataTypes.VehicleType;

public class HelicopterType implements VehicleType {
    @Override
    public String getType() {
        return "HELICOPTER";
    }
}
