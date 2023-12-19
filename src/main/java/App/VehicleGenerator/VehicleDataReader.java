package App.VehicleGenerator;

import App.Map.Location;
import App.Vehicles.*;
//mport App.Vehicles.Taxi.LuxuryCar;
//import App.Vehicles.Taxi.Taxi;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class VehicleDataReader {
    private static String csvFilePath = "LuxLifts/src/main/java/App/VehicleGenerator/Vehicles.csv";
    private static String MapLocationCSV = "LuxLifts/src/main/java/App/Map/MapLocations.csv";
    private static Scanner scanner = new Scanner(System.in);

    public static double getAverageDriverRating(double[] driverRating) {
        // Calculate the average driver rating
        double sum = 0;
        for (double rating : driverRating) {
            sum += rating;
        }
        return sum / driverRating.length;
    }

    public static List<Location> returnMapLocations() {
        List<Location> mapLocations = new ArrayList<>();

        try (BufferedReader csvReader = new BufferedReader(new FileReader(MapLocationCSV))) {
            String line;
            // Skip the header line
            csvReader.readLine();

            while ((line = csvReader.readLine()) != null) {

                String[] data = line.split(",");
                if (data.length >= 2) {
                    String Name = data[0];
                    String X = data[1];
                    int x = Integer.parseInt(X);
                    String Y = data[2];
                    int y = Integer.parseInt(Y);
                    Location location = new Location(x,y,Name);
                   mapLocations.add(location);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return mapLocations;
    }

    public static List<Vehicle> returnVehicleList() throws IOException {
        List<Vehicle> vehicleList = new ArrayList<>();

        try (BufferedReader csvReader = new BufferedReader(new FileReader(csvFilePath))) {
            String line;
            // Skip the header line
            csvReader.readLine();

            while ((line = csvReader.readLine()) != null) {

                String[] data = line.split(",");
                if (data.length >= 2) {
                    String regNum = data[0];
                    String typeString = data[1];
                    String[] driverRatingStr = data[2].split(",");
                    double[] driverRating = new double[driverRatingStr.length];
                    double DriverAverage = getAverageDriverRating(driverRating);
                    for (int i = 0; i < driverRatingStr.length; i++) {
                        driverRating[i] = Double.parseDouble(driverRatingStr[i]);
                    }
                    String driverName = data[3];
                    String phoneNumber = data[4];
                    int x = Integer.parseInt(data[5]) - 1;
                    int y = Integer.parseInt(data[6]) - 1;

                    VehicleType type;
                    switch (typeString) {
                        case "Limo":
                            vehicleList.add(new Limo(regNum, DriverAverage, driverName, phoneNumber, new Location(x, y)));
                            break;
                        case "Helicopter":
                            vehicleList.add(new Helicopter(regNum, DriverAverage, driverName, phoneNumber, new Location(x, y)));
                            break;
                        case "PrivateJet":
                            vehicleList.add(new PrivateJet(regNum, DriverAverage, driverName, phoneNumber, new Location(x, y)));
                            break;
                        case "Yacht":
                            vehicleList.add(new Yacht(regNum, DriverAverage, driverName, phoneNumber, new Location(x, y)));
                            break;
                        case "Taxi":
                            // For the taxi, allow the user to choose a luxury car
                            System.out.println("Choose a luxury car for the taxi:");
                    }
                }
            }
        }
        return vehicleList;
    }
}
