
package App.VehicleGenerator;

import App.Map.MapItems.HeliPad;
import App.Map.Location;
import App.Map.MapItems.MapLocation;
import App.Map.MapItems.Water;
import App.Vehicles.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class CsvDataReader {
    private static String VEHICLE_CSV = "LuxLifts/src/main/java/App/VehicleGenerator/Vehicles.csv";
    private static String MAP_LOCATION_CSV = "LuxLifts/src/main/java/App/Map/MapItems/MapLocations.csv";
    private static String HELIPAD_LOCATIONS_CSV = "LuxLifts/src/main/java/App/Map/MapItems/HelipadLocations.csv";
    private static String WATER_LOCATIONS_CSV = "LuxLifts/src/main/java/App/Map/MapItems/WaterLocations.csv";
    private static Scanner scanner = new Scanner(System.in);

    public static double getAverageDriverRating(double[] driverRating) {
        // Calculate the average driver rating
        double sum = 0;
        for (double rating : driverRating) {
            sum += rating;
        }
        return sum / driverRating.length;
    }
    public static List<Water> returnWaterLocations(){
        List<Water> waterLocations = new ArrayList<>();

        try (BufferedReader csvReader = new BufferedReader(new FileReader(WATER_LOCATIONS_CSV))) {
            String line;
            // Skip the header line
            csvReader.readLine();

            while ((line = csvReader.readLine()) != null) {

                String[] data = line.split(",");
                if (data.length >= 1) {
                    String X = data[0];
                    int x = Integer.parseInt(X);
                    String Y = data[1];
                    int y = Integer.parseInt(Y);
                    Location location = new Location(x,y);
                    waterLocations.add(new Water(location));
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return waterLocations;
    }
    public static List<MapLocation> returnMapLocations(){
        List<Location> locations = returnLocations(MAP_LOCATION_CSV);
        List<MapLocation> mapLocations = new ArrayList<>();
        for(Location location:locations){
            mapLocations.add(new MapLocation(location, location.getName()));
        }
        return mapLocations;
    }

    public static List<HeliPad> returnHelipadList(){
        List<Location> locations =returnLocations(HELIPAD_LOCATIONS_CSV);
        List<HeliPad> heliPads = new ArrayList<>();
        for(Location location:locations){
            heliPads.add(new HeliPad(location, location.getName()));
        }
        return heliPads;
    }


    public static List<Location> returnLocations(String dir) {
        List<Location> mapLocations = new ArrayList<>();

        try (BufferedReader csvReader = new BufferedReader(new FileReader(dir))) {
            String line;
            // Skip the header line
            csvReader.readLine();

            while ((line = csvReader.readLine()) != null) {

                String[] data = line.split(",");
                    String Name = data[0];
                    String X = data[1];
                    int x = Integer.parseInt(X);
                    String Y = data[2];
                    int y = Integer.parseInt(Y);
                    Location location = new Location(x,y,Name);
                   mapLocations.add(location);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return mapLocations;
    }

    public static List<Vehicle> returnVehicleList() throws IOException {
        List<Vehicle> vehicleList = new ArrayList<>();

        try (BufferedReader csvReader = new BufferedReader(new FileReader(VEHICLE_CSV))) {
            String line;
            // Skip the header line
            csvReader.readLine();

            while ((line = csvReader.readLine()) != null) {

                String[] data = line.split(",");
                if (data.length >= 2) {
                    String regNum = data[0];
                    String typeString = data[1];
                    String[] driverRatingStr = data[2].split(";");
                    double[] driverRating = new double[driverRatingStr.length];
                    double DriverAverage = getAverageDriverRating(driverRating);
                    for (int i = 0; i < driverRatingStr.length; i++) {
                        driverRating[i] = Double.parseDouble(driverRatingStr[i]);
                    }
                    String driverName = data[3];
                    String phoneNumber = data[4];
                    int x = Integer.parseInt(data[5]) - 1;
                    int y = Integer.parseInt(data[6]) - 1;

                    switch (typeString) {
                        case "LIMO":
                            vehicleList.add(new Limo(regNum, DriverAverage, driverName, phoneNumber, new Location(x, y)));
                            break;
                        case "HELICOPTER":
                            vehicleList.add(new Helicopter(regNum, DriverAverage, driverName, phoneNumber, new Location(x, y)));
                            break;
                        case "PRIVATE_JET":
                            vehicleList.add(new PrivateJet(regNum, DriverAverage, driverName, phoneNumber, new Location(x, y)));
                            break;
                        case "YACHT":
                            vehicleList.add(new Yacht(regNum, DriverAverage, driverName, phoneNumber, new Location(x, y)));
                            break;
                    }
                }
            }
        }
        return vehicleList;
    }
}
