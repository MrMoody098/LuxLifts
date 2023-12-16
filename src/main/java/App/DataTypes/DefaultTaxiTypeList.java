package App.DataTypes;

import java.util.Random;

public class DefaultTaxiTypeList implements TaxiTypeList {
    private static final String[] TAXI_TYPES = {"FERRARI", "BUGATTI", "BENTLEY", "PORSCHE"};

    @Override
    public String getRandomTaxiType() {
        int randomIndex = new Random().nextInt(TAXI_TYPES.length);
        return TAXI_TYPES[randomIndex];
    }
}