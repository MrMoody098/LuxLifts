package App;

import App.VehicleGenerator.VehicleDataReader;
import App.Vehicles.Vehicle;

import java.util.List;

public class Test {
    public static void main(String[] args) {
        List<Vehicle> list= VehicleDataReader.returnVehicleList();
        for(Vehicle v: list){

            System.out.println( v.getRegistrationNumber());
        }
    }
}
