package App.Vehicles;

import App.DataTypes.VehicleType;

public class PrivateJetType implements VehicleType {
    @Override
    public String getType() {
        return "PRIVATE_JET";
    }
}
