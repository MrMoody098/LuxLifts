package App.Vehicles;

import App.DataTypes.VehicleType;

public class YachtType implements VehicleType {
    @Override
    public String getType() {
        return "YACHT";
    }
}
