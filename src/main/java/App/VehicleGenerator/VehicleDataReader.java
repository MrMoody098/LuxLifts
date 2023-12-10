package App.VehicleGenerator;

import App.Map.Location;
import App.DataTypes.VehicleType;
import App.Vehicles.*;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class VehicleDataReader {
    private static String csvFilePath = "C:\\Users\\ticta\\MyRepos\\LuxLifts\\LuxLifts\\src\\main\\java\\App\\Vehicles\\Vehicles.csv";
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
                VehicleType type = VehicleType.valueOf(data[1]);
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

                // Create a new Vehicle object with the average driver rating
                switch (type) {
                    case LIMO:
                        vehicleList.add(new Limo(regNum, DriverAverage, driverName, phoneNumber, new Location(x, y)));
                        break;
                    case HELICOPTER:
                        vehicleList.add(new Helicopter(regNum, DriverAverage, driverName, phoneNumber, new Location(x, y)));
                        break;
                    case PRIVATE_JET:
                        vehicleList.add(new PrivateJet(regNum, DriverAverage, driverName, phoneNumber, new Location(x, y)));
                        break;
                    case YACHT:
                        vehicleList.add(new Yacht(regNum, DriverAverage, driverName, phoneNumber, new Location(x, y)));
                        break;
                    default:
                        System.out.println("Invalid vehicle type");
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

