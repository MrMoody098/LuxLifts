package main.App.VehicleGenerator;
import main.App.Map.Location;
import main.App.DataTypes.VehicleType;
import main.App.Vehicles.*;
import main.App.Vehicles.AirVehicles.Helicopter;
import main.App.Vehicles.AirVehicles.PrivateJet;
import main.App.Vehicles.Limo.Limo;
import main.App.Vehicles.Taxi.Bentley;
import main.App.Vehicles.Taxi.Bugatti;
import main.App.Vehicles.Taxi.Ferrari;
import main.App.Vehicles.Taxi.LuxuryCar;
import main.App.Vehicles.Taxi.Porsche;
import main.App.Vehicles.Taxi.Taxi;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class VehicleDataReader {
    private static String csvFilePath = "/Users/miaborko/LuxLifts/LuxLifts/src/main/java/App/VehicleGenerator/Vehicles.csv";
    private static Scanner scanner = new Scanner(System.in);

        public static double getAverageDriverRating(double[] driverRating) {
            // Calculate the average driver rating
            double sum = 0;
            for (double rating : driverRating) {
                sum += rating;
            }
            return sum / driverRating.length;
        }

    public static List<Vehicle> returnVehicleList() {
        List<Vehicle> vehicleList = new ArrayList<>();

        try (BufferedReader csvReader = new BufferedReader(new FileReader(csvFilePath))) {
            String line;
            // Skip the header line
            csvReader.readLine();

            while ((line = csvReader.readLine()) != null) {
                String[] data = line.split(",");
                String regNum = data[0];
                String typeString = data[1];
                String[] driverRatingStr = data[2].split(",");
                double[] driverRating = new double[driverRatingStr.length];
                double DriverAverage =getAverageDriverRating(driverRating);
                for (int i = 0; i < driverRatingStr.length; i++) {
                    driverRating[i] = Double.parseDouble(driverRatingStr[i]);
                }
                String driverName = data[3];
                String phoneNumber = data[4];
                int x = Integer.parseInt(data[5]);
                int y = Integer.parseInt(data[6]);

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
                    
                        // Define named constants for luxury car options
                        final int FERRARI_OPTION = 1;
                        final int BUGATTI_OPTION = 2;
                        final int BENTLEY_OPTION = 3;
                        final int PORSCHE_OPTION = 4;
                    
                        // Print the available luxury car options
                        System.out.println(FERRARI_OPTION + ". Ferrari");
                        System.out.println(BUGATTI_OPTION + ". Bugatti");
                        System.out.println(BENTLEY_OPTION + ". Bentley");
                        System.out.println(PORSCHE_OPTION + ". Porsche");
                    
                        int choice = scanner.nextInt();
                        LuxuryCar luxuryCar;
                    
                        // Switch based on user's choice using named constants
                        switch (choice) {
                            case FERRARI_OPTION:
                                luxuryCar = new Ferrari();
                                break;
                            case BUGATTI_OPTION:
                                luxuryCar = new Bugatti();
                                break;
                            case BENTLEY_OPTION:
                                luxuryCar = new Bentley();
                                break;
                            case PORSCHE_OPTION:
                                luxuryCar = new Porsche();
                                break;
                            default:
                                // Default to Ferrari if an invalid choice is made
                                luxuryCar = new Ferrari();
                        }
                    
                        vehicleList.add(new Taxi(regNum, DriverAverage, driverName, phoneNumber, new Location(x, y), luxuryCar));
                        break;
                    }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return vehicleList;
    }


}

