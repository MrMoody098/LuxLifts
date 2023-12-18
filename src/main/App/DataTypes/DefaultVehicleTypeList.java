package main.App.DataTypes;

import java.util.Random;

public class DefaultVehicleTypeList implements VehicleTypeList {
    private static final String[] VEHICLE_TYPES = {"LIMO", "HELICOPTER", "PRIVATE_JET", "YACHT", "TAXI"};

    @Override
    public String getRandomVehicleType() {
        int randomIndex = new Random().nextInt(VEHICLE_TYPES.length);
        return VEHICLE_TYPES[randomIndex];
    }
}

