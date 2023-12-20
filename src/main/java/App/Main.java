package App;
import App.Authentication.Auth;
import App.DataTypes.DoubleLinkedList;
import App.DataTypes.Passenger;
import App.Map.CustomMap;
import App.Map.Location;
import App.VehicleGenerator.CsvGenerator;
import App.Vehicles.Vehicle;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

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

    // Constructor for Main class
    public Main() throws FileNotFoundException {
    }

    /**
     * The main method to run the program.
     *
     * @param args Command-line arguments (not used in this program).
     * @throws FileNotFoundException If a file required for the program is not found.
     */
    public static void main(String[] args) throws IOException {
        // Test the Login and Signup functionality
        // Test the Map functionality

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
    public static Passenger LoginSignupTest() throws FileNotFoundException {
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

    // Method to handle the signup process
    public static Passenger SignUp() throws FileNotFoundException {
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
    public static void MapTest() throws IOException {
        // Display program logo
        logo();
        System.out.println("\nThis is the initial map:");

        customMap.firstMap(); // Display the initial map

        System.out.println("Do you want to see vehicles on the map?");
        String input = scanner.nextLine();
        if (input.equalsIgnoreCase("yes")) {
            System.out.println("\nPlease first Login/Signup");
            user = LoginSignupTest(); // Get the current user through login or signup
        } else {
            System.out.println("You first need to login/signup");
        }

        AddVehicleTest(); // Test adding vehicles to the map

        AddUser(); // Add the user to the map

        // Test getting vehicles in contact range and display details
        DoubleLinkedList<Vehicle> vehiclesInContact = customMap.getVehiclesInContactRange(user, 2);
        System.out.println("Vehicles in contact range:");
        if (vehiclesInContact.size() == 0) {
            System.out.println("No vehicles, sorry bestie");
        } else {
            for (Vehicle vehicle : vehiclesInContact.getAll()) {
                vehicle.printVehicleDetails();
                System.out.println();
            }
        }

        System.out.println("");
    }

    // Method to test adding vehicles to the map
    public static void AddVehicleTest() throws IOException {
        customMap.addMapItems(); // Add MapItems (MapLocations, HeliPads, Water) to the map
        customMap.displayMap(); // Display the updated map
    }

    // Method to add the user to the map
    public static void AddUser() {
        System.out.println("Adding the user to the map.");

        System.out.println("Enter the initial location for the user (x, y):");

        System.out.print("X: ");
        int x = scanner.nextInt();
        System.out.print("Y: ");
        int y = scanner.nextInt();

        user.SetLocation(x, y);
        customMap.addElement(user, "U"); // Add the user to the map with the letter "U"

        System.out.println("User added to the map.");
        customMap.displayMap();
    }

    // Method to move a vehicle based on user input
    public static void MoveVehicle() {
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

            customMap.displayMap(); // Display the updated map
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
                } catch (FileNotFoundException e) {
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
