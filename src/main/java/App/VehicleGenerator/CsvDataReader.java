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

/**
 * Class responsible for reading data from CSV files and creating corresponding objects.
 */
public class CsvDataReader {
    // File paths for CSV data
    private static String VEHICLE_CSV = "LuxLifts/src/main/java/App/VehicleGenerator/Vehicles.csv";
    private static String MAP_LOCATION_CSV = "LuxLifts/src/main/java/App/Map/MapItems/MapLocations.csv";
    private static String HELIPAD_LOCATIONS_CSV = "LuxLifts/src/main/java/App/Map/MapItems/HelipadLocations.csv";
    private static String WATER_LOCATIONS_CSV = "LuxLifts/src/main/java/App/Map/MapItems/WaterLocations.csv";
    private static Scanner scanner = new Scanner(System.in);

    /**
     * Calculates the average driver rating from an array of ratings.
     *
     * @param driverRating Array of driver ratings.
     * @return The average driver rating.
     */
    public static double getAverageDriverRating(double[] driverRating) {
        // Calculate the average driver rating
        double sum = 0;
        for (double rating : driverRating) {
            sum += rating;
        }
        return sum / driverRating.length;
    }

    /**
     * Returns a list of water locations read from the CSV file.
     *
     * @return List of Water objects representing water locations.
     */
    public static List<Water> returnWaterLocations() {
        List<Water> waterLocations = new ArrayList<>();
        //try reading file at WATER_LOCATION_CSV file path
        try (BufferedReader csvReader = new BufferedReader(new FileReader(WATER_LOCATIONS_CSV))) {
            String line;
            // Skip the header line
            csvReader.readLine();

            while ((line = csvReader.readLine()) != null) {
                //split the data on each line at the "," so i can get each piece of data by index
                String[] data = line.split(",");
                //if the data is long enough
                if (data.length >= 1) {
                    //take the first value as the X
                    String X = data[0];
                    int x = Integer.parseInt(X);
                    //take the second value as the Y
                    String Y = data[1];
                    int y = Integer.parseInt(Y);
                    //store X,Y in a Location
                    Location location = new Location(x, y);
                    //Add The Location as Water Object to your Water List
                    waterLocations.add(new Water(location));
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        //return populated list of waterLocations read from csv
        return waterLocations;
    }

    /**
     * Returns a list of map locations read from the CSV file.
     *
     * @return List of MapLocation objects representing map locations.
     */
    public static List<MapLocation> returnMapLocations() {
        //get list of all locations stored in MAP_LOCATION_CSV file path
        List<Location> locations = returnLocations(MAP_LOCATION_CSV);
        //create a new list With MapLocation type
        List<MapLocation> mapLocations = new ArrayList<>();
        //for each location in MAP_LOCATION_CSV add the location to the List<MapLocation>
        for (Location location : locations) {
            mapLocations.add(new MapLocation(location, location.getName()));
        }
        //return the populated mapLocations List
        return mapLocations;
    }

    /**
     * Returns a list of helipads read from the CSV file.
     *
     * @return List of HeliPad objects representing helipads.
     */
    public static List<HeliPad> returnHelipadList() {
        //get list of all locations stored in HELIPAD_LOCATIONS_CSV file path
        List<Location> locations = returnLocations(HELIPAD_LOCATIONS_CSV);
        //create a new list With HeliPad type
        List<HeliPad> heliPads = new ArrayList<>();
        //for each location in HELIPAD_LOCATIONS_CSV add the location to the List<HeliPad>
        for (Location location : locations) {
            heliPads.add(new HeliPad(location, location.getName()));
        }
        //return populated HeliPad List
        return heliPads;
    }

    /**
     * Reads locations from a CSV file and returns a list of Location objects.
     *
     * @param dir The directory of the CSV file.
     * @return List of Location objects representing map locations.
     */
    public static List<Location> returnLocations(String dir) {
        // Initialize a list to store the map locations
        List<Location> mapLocations = new ArrayList<>();

        try (BufferedReader csvReader = new BufferedReader(new FileReader(dir))) {
            String line;
            // Skip the header line
            csvReader.readLine();

            // Read each line from the CSV file
            while ((line = csvReader.readLine()) != null) {
                // Split the line into an array of data
                String[] data = line.split(",");
                // Extract data for each location
                String Name = data[0];
                String X = data[1];
                int x = Integer.parseInt(X);
                String Y = data[2];
                int y = Integer.parseInt(Y);
                // Create a new Location object and add it to the list
                Location location = new Location(x, y, Name);
                mapLocations.add(location);
            }
        } catch (IOException e) {
            // Handle IOException by throwing a RuntimeException
            throw new RuntimeException(e);
        }

        // Return the list of map locations
        return mapLocations;
    }

    /**
     * Reads vehicles from a CSV file and returns a list of Vehicle objects.
     *
     * @return List of Vehicle objects representing vehicles.
     * @throws IOException If an I/O error occurs.
     */
    public static List<Vehicle> returnVehicleList() throws IOException {
        // Initialize a list to store the vehicles
        List<Vehicle> vehicleList = new ArrayList<>();

        try (BufferedReader csvReader = new BufferedReader(new FileReader(VEHICLE_CSV))) {
            String line;
            // Skip the header line
            csvReader.readLine();

            // Read each line from the CSV file
            while ((line = csvReader.readLine()) != null) {
                // Split the line into an array of data
                String[] data = line.split(",");
                if (data.length >= 2) {
                    // Extract vehicle details from CSV
                    String regNum = data[0];
                    String typeString = data[1];
                    String[] driverRatingStr = data[2].split(";");
                    double[] driverRating = new double[driverRatingStr.length];
                    double DriverAverage = getAverageDriverRating(driverRating);

                    // Convert driver ratings to doubles
                    for (int i = 0; i < driverRatingStr.length; i++) {
                        driverRating[i] = Double.parseDouble(driverRatingStr[i]);
                    }

                    // Extract additional vehicle details
                    String driverName = data[3];
                    String phoneNumber = data[4];
                    int x = Integer.parseInt(data[5]) - 1;
                    int y = Integer.parseInt(data[6]) - 1;

                    // Create vehicle based on type
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

        // Return the list of vehicles
        return vehicleList;
    }
}
