package App;

import App.Map.CustomMap;
import App.Map.Location;
import App.Vehicles.Helicopter;

import App.Vehicles.Limo;
import App.Vehicles.Taxi.Taxis;
import App.Vehicles.VehicleType;

import java.io.IOException;

public class Test {
    public static void main(String[] args) throws IOException {
        CustomMap customMap = new CustomMap();
        customMap.addMapItems();
        customMap.displayMap();
//      ///***  //make a test helicopter
//        Helicopter heli = new Helicopter("ABC386",5,
//                "Liam Davis","5308",new Location(0,0));
//        //make a test taxi
//        Limo limo = new Limo("ABC2323",5.0,"john",
//                "098020292",new Location(0,0));
//        CustomMap customMap = new CustomMap();
//        Location brokerStree = new Location(8,6);
//       heli.MoveTo(brokerStree,customMap);
//        System.out.println("\n\n");
//        limo.MoveTo(brokerStree,customMap);//
    }
    }

