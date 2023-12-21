package App;
import App.Authentication.Auth;
import App.DataTypes.DoubleLinkedList;
import App.DataTypes.Node;
import App.DataTypes.Passenger;
import App.Map.CustomMap;
import App.Map.Location;
import App.Map.MapItems.MapLocation;
import App.VehicleGenerator.CsvGenerator;
import App.Vehicles.Vehicle;

import java.awt.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;
import java.util.List;

/**
 * The main class for testing the Login, Signup, and Map functionalities.
 */
public class Main implements VehicleHiringTest {
    private static Passenger user; // Static variable to store the current user
    public static CustomMap customMap; // Static variable to store the CustomMap object

    // Static block to initialize the CustomMap object
    static {
        try {
            customMap = new CustomMap();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    // Scanner object for passenger input
    public static Scanner scanner = new Scanner(System.in);

    /**
     * The main method to run the program.
     *
     * @param args Command-line arguments (not used in this program).
     * @throws FileNotFoundException If a file required for the program is not found.
     */
    public static void main(String[] args) throws IOException, InterruptedException {
        // Test the Login and Signup functionality
//        // Test the Map functionality
//        logo();
//        user = LoginSignupTest();
        user = new Passenger("johnny",new Location(0,0));
        MapTest();
    }

    // Method to display the program logo
    public static void logo() {
        System.out.println("__        __   _                            _         ");
        System.out.println(" \\ \\      / /__| | ___ ___  _ __ ___   ___  | |_ ___   ");
        System.out.println("  \\ \\ /\\ / / _ \\ |/ __/ _ \\| '_ ` _ \\ / _ \\ | __/ _ \\  ");
        System.out.println("   \\ V  V /  __/ | (_| (_) | | | | | |  __/ | || (_) | ");
        System.out.println("    \\_/\\_/ \\___|_|\\___\\___/|_| |_| |_|\\___|  \\__\\___/  ");
        System.out.println();
        System.out.println(" _               _     _  __ _       ");
        System.out.println("| |   _   ___  _| |   (_)/ _| |_ ___ ");
        System.out.println("| |  | | | \\ \\/ / |   | | |_| __/ __|");
        System.out.println("| |__| |_| |>  <| |___| |  _| |\\__ \\");
        System.out.println("|_____\\__,_/_/\\_\\_____|_|_|  \\__|___/");
    }

    /**
     * Method to test the Login and Signup functionality.
     *
     * @throws FileNotFoundException If a file required for authentication is not found.
     */
    public static Passenger LoginSignupTest() throws IOException {
        Passenger passenger = null;
        // Loop until a valid passenger is obtained
        while (passenger == null) {
            // Prompt for choice between login and signup
            System.out.println("1. Login\n2. Signup");
            // Store choice as String
            String choice = scanner.next();
            // If the choice is 1 or LOGIN (case-insensitive), attempt login
            if (Objects.equals(choice, "1") || choice.equalsIgnoreCase("LOGIN")) {
                // Store the return of login (could be null if unsuccessful)
                passenger = Login();
            }
            // If the choice is 2 or SIGNUP (case-insensitive), attempt signup
            else if (choice.equals("2") || choice.equalsIgnoreCase("SIGNUP")) {
                // Store Passenger returned from signup (could be null if unsuccessful)
                passenger = SignUp();
            }
        }
        // Return passenger; it cannot be null as the loop won't stop until passenger is not null
        return passenger;
    }

    public static Passenger SignUp() throws IOException {// passenger chose to signup
        System.out.println("Username:");
        String passengerName = scanner.next();
        System.out.println("Password:");
        String password = scanner.next();
        // Attempt to signup using Auth class
        return Auth.signup(passengerName, password);
    }

    // Method to handle the login process
    public static Passenger Login() {
        System.out.println("Username:");
        String passengerName = scanner.next();
        System.out.println("Password:");
        String password = scanner.next();

        // Attempt to login using Auth class
        return Auth.login(passengerName, password);
    }

    /**
     * Method to test the Map functionality.
     */
    public static void MapTest() throws IOException, InterruptedException {
        // Display program logo
        System.out.println("\nThis is the initial map:");
        AddUser();
        customMap.displayMap(user); // Display the updated map
        Thread.sleep(900);
        customMap.addVehicles();
        System.out.println("displaying vehicles");
        customMap.displayMap(user);
        Thread.sleep(900);
        // Test getting vehicles in contact range and display details
        DoubleLinkedList<Vehicle> vehiclesInContact = customMap.getVehiclesInContactRange(user, 2);
        System.out.println("Vehicles in contact range:");
        if (vehiclesInContact.size() == 0) {
            System.out.println("No vehicles found");
        } else {
            for (Vehicle vehicle : vehiclesInContact.getAll()) {
                Thread.sleep(900);
                vehicle.printVehicleDetails();
                System.out.println();
            }
        }

        System.out.println("pick a vehicle by reg");
        String reg = scanner.next();
        for (Vehicle vehicle : customMap.getVehicles().getAll()) {
            if (vehicle.getRegistrationNumber().equals(reg)) {
                try {
                    System.out.println("pick a destination");
                    customMap.PrintMapLocations();
                    String des = scanner.next();
                    for (MapLocation mapLocation : customMap.returnMapLocations()) {
                        if (mapLocation.getName().equalsIgnoreCase(des)) {
                            Location destination = mapLocation.GetLocation();
                            Thread.sleep(1200);
                            System.out.println("Destination: "+destination.getX()+" "+destination.getY());
                            Thread.sleep(1200);
                            vehicle.MoveTo(new Location(user.GetLocation().getX(), user.GetLocation().getY()), customMap);
                            Thread.sleep(1200);
                            System.out.println("Driver arrived at user!!");
                            Thread.sleep(1200);
                            Location location = vehicle.MoveTo(destination, customMap);
                            user.SetLocation(location.getX(), location.getY());
                            Thread.sleep(1200);
                            System.out.println("You have arrived your destiantion");
                            Thread.sleep(900);
                            System.out.println("inital Driver rating "+vehicle.getDriverRating());
                            System.out.println("Rate Driver 0-5");
                            double rating = scanner.nextDouble();
                            vehicle.updateDriverRating(rating);
                            System.out.println("You rated "+vehicle.getDriverName());
                            System.out.println(vehicle.getDriverName()+" "+ vehicle.getType());
                            System.out.println("Thank you for using LuxLifts :)");
                        }
                    }

                } catch (FileNotFoundException e) {
                    // Handle the exception (e.g., print an error message)
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    // Method to test adding vehicles to the map

    // Method to add the user to the map
    public static void AddUser() throws IOException {
        System.out.println("Adding the user to the map.");
        System.out.println("Enter user X");
        int X = scanner.nextInt();
        System.out.println("Enter user Y");
        int Y = scanner.nextInt();
        user.SetLocation(X,Y);
    }

    // Method to move a vehicle based on user input
    public static void MoveVehicle() throws IOException {
        System.out.println("Would you like to move a vehicle? Enter 'yes' to proceed or 'no' to skip:");
        String moveByReg = scanner.next();
        if (moveByReg.equalsIgnoreCase("yes") || moveByReg.equals("1")) {
            DoubleLinkedList<Vehicle> vehicles = customMap.getVehicles();

            System.out.println("Enter the registration number of the vehicle you would like to move:");
            String regNum = scanner.next();
            System.out.println("Enter the new location (x, y) where you would like to move the vehicle:");
            System.out.print("X: ");
            int x = scanner.nextInt();
            System.out.print("Y: ");
            int y = scanner.nextInt();

            // Move the selected vehicle to the new location
            for (Vehicle vehicle : vehicles.getAll()) {
                if (vehicle.getRegistrationNumber().equals(regNum)) {
                    vehicle.SetLocation(x, y);
                }
            }
            customMap.displayMap(user);
        }
    }



    // Interface methods to test the VehicleHiring functionalities
    @Override
    public boolean testAddToMap(String registrationNumber, Location location) {
        for (Vehicle vehicle : customMap.getVehicles().getAll()) {
            if (vehicle.getRegistrationNumber().equals(registrationNumber) && !customMap.getVehicles().contains(vehicle)) {
                customMap.addElement(vehicle, "V");
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean testMoveVehicle(String registrationNumber, Location location) {
        for (Vehicle vehicle : customMap.getVehicles().getAll()) {
            if (vehicle.getRegistrationNumber().equals(registrationNumber)) {
                try {
                    Location finalLocation = vehicle.MoveTo(location, customMap);
                    return finalLocation.equals(location);
                } catch (InterruptedException | IOException e) {
                    // Handle the exception (e.g., print an error message)
                    e.printStackTrace();
                    return false;
                }
            }
        }
        return false; // Vehicle not found
    }

    @Override
    public boolean testRemoveVehicle(String registrationNumber) {
        // Find the vehicle by registration number
        for (Vehicle vehicle : customMap.getVehicles().getAll()) {
            if (vehicle.getRegistrationNumber().equals(registrationNumber)) {
                // Remove the vehicle from the map
                customMap.getVehicles().remove(vehicle);
                customMap.removeElement(vehicle, "V");
                return true;
            }
        }
        return false; // Vehicle not found
    }

    @Override
    public Location testGetVehicleLoc(String registrationNumber) {
        for (Vehicle vehicle : customMap.getVehicles().getAll()) {
            if (vehicle.getRegistrationNumber().equals(registrationNumber)) {
                // Return the current location of the vehicle
                return vehicle.GetLocation();
            }
        }
        return null;
    }

    @Override
    public List<String> testGetVehiclesInRange(Location location, int r) {
        DoubleLinkedList<Vehicle> vehiclesInContact = customMap.getVehiclesInContactRange(new Passenger("Test", location), r);
        return getRegistrationNumbers(vehiclesInContact);
    }

    // Helper method to get registration numbers from a list of vehicles
    private List<String> getRegistrationNumbers(DoubleLinkedList<Vehicle> vehicles) {
        List<String> vehicleRegistrationNumbers = new ArrayList<>();

        for (Vehicle vehicle : vehicles.getAll()) {
            vehicleRegistrationNumbers.add(vehicle.getRegistrationNumber());
        }

        return vehicleRegistrationNumbers;
    }
}

