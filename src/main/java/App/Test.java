package App;

import App.Map.CustomMap;
import App.Map.Location;
import App.Vehicles.Helicopter;
import App.Vehicles.VehicleType;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Test {
    public static void main(String[] args) throws IOException {
        Helicopter heli = new Helicopter("ABC386",5,
                "Liam Davis","5308",new Location(0,0));
        CustomMap customMap = new CustomMap();
        Location brokerStree = new Location(2,4);
        heli.MoveTo(brokerStree,customMap);
    }
    }

