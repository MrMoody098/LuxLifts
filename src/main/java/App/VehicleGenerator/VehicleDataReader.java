package App.VehicleGenerator;

import App.Map.Location;
import App.Vehicles.*;
//mport App.Vehicles.Taxi.LuxuryCar;
//import App.Vehicles.Taxi.Taxi;
import App.Vehicles.Taxi.Taxi;
import App.Vehicles.Taxi.Taxis;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class VehicleDataReader {
    private static String csvFilePath = "LuxLifts/src/main/java/App/VehicleGenerator/Vehicles.csv";
    private static Scanner scanner = new Scanner(System.in);

        public static double getAverageDriverRating(double[] driverRating) {
            // Calculate the average driver rating
            double sum = 0;
            for (double rating : driverRating) {
                sum += rating;
            }
            return sum / driverRating.length;
        }
    

    public static List<Vehicle> returnVehicleList() throws FileNotFoundException {
        List<Vehicle> vehicleList = new ArrayList<>();

        try (BufferedReader csvReader = new BufferedReader(new FileReader(csvFilePath))) {
            String line;
            // Skip the header line
            csvReader.readLine();

            while ((line = csvReader.readLine()) != null) {

                String[] data = line.split(",");
                if (data.length >= 5) {
                    String regNum = data[0];
                    String typeString = data[1];
                    String[] driverRatingStr = data[2].split(",");
                    double[] driverRating = new double[driverRatingStr.length];
                    for (int i = 0; i < driverRatingStr.length; i++) {
                        driverRating[i] = Double.parseDouble(driverRatingStr[i]);
                    }
                    double driverAverage = getAverageDriverRating(driverRating);
                    String driverName = data[3];
                    String phoneNumber = data[4];
                    int x = Integer.parseInt(data[5]);
                    int y = Integer.parseInt(data[6]);
                
                switch (typeString.toUpperCase()) {
                    case "LIMO":
                        vehicleList.add(new Limo(regNum, driverAverage, driverName, phoneNumber, new Location(x, y)));
                        break;
                    case "HELICOPTER":
                        vehicleList.add(new Helicopter(regNum, driverAverage, driverName, phoneNumber, new Location(x, y)));
                        break;
                    case "PRIVATE_JET":
                        vehicleList.add(new PrivateJet(regNum, driverAverage, driverName, phoneNumber, new Location(x, y)));
                        break;
                    case "YACHT":
                        vehicleList.add(new Yacht(regNum, driverAverage, driverName, phoneNumber, new Location(x, y)));
                        break;
                        
                    case "TAXI":
                        Taxis[] taxiTypes = Taxis.values();
                        Taxis randomTaxiType = taxiTypes[new Random().nextInt(taxiTypes.length)];
                        vehicleList.add(new Taxi(randomTaxiType, regNum, driverAverage, driverName, phoneNumber, new Location(x, y)));
                        break;
                    default:
                        System.out.println("Unknown vehicle type: " + typeString);
                        break;
                }
            } else {
                System.out.println("hahahah");
            }
        }
    } catch (IOException e) {
        throw new RuntimeException(e);
    }
    return vehicleList;
}


}
