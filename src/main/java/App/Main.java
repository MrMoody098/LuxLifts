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
public class Main implements VehicleHiringTest{
    private static Passenger user;
    public static CustomMap customMap;

    static {
        try {
            customMap = new CustomMap();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    // Scanner object for passenger input
    public static Scanner scanner = new Scanner(System.in);

    public Main() throws FileNotFoundException {
    }

    /**
     * The main method to run the program.
     * @param args Command-line arguments (not used in this program).
     * @throws FileNotFoundException If a file required for the program is not found.
     */
    public static void main(String[] args) throws IOException {
        // Test the Login and Signup functionality
        // Test the Map functionality

        
        
        MapTest ();

    }
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
     * @throws FileNotFoundException If a file required for authentication is not found.
     */
    public static Passenger LoginSignupTest() throws FileNotFoundException {
        Passenger passenger = null;
        //while passenger is still null loop
        while (passenger==null) {

            //prompt choice between 1.login and 2.signup
            System.out.println("1. Login\n2. Signup");
            //store choice as String
            String choice = scanner.next();
            //if the choice = 1,or LOGIN case ignored then do this
            if (Objects.equals(choice, "1") || choice.equalsIgnoreCase("LOGIN"))
            {
                //store the return of login could be null if unsuccessful
                passenger=Login();
            }
                //if the choice = 2,or SIGNUP case ignored then do this
            else if (choice.equals("2") || choice.equalsIgnoreCase("SIGNUP")){
                    //store Passenger return from signup could be null if unsuccessful
                    passenger =SignUp();
            }

        }//return passenger cant be null as the while loop wont stop until passenger is not null
        return passenger;
    }

    public static Passenger SignUp() throws FileNotFoundException {// passenger chose to signup
        System.out.println("passengername:");
        String passengername = scanner.next();
        System.out.println("Password:");
        String password = scanner.next();

        // Attempt to signup using Auth class
        return Auth.signup(passengername,password);
    }
public static Passenger Login(){ // passenger chose to login
    System.out.println("username:");
    String passengerName = scanner.next();

    System.out.println("Password:");
    String password = scanner.next();

    // Attempt to login using Auth class
    return Auth.login(passengerName,password);
    }
    /**
     * Method to test the Map functionality.
     */


    public static void MapTest() throws IOException {
        //we need to also add the user to this map
        // Create a CustomMap object
        logo();
        System.out.println("\nThis is the inital map:");
        
        customMap.firstMap();

        System.out.println("Do you want to see vehicles on the map?");
        String input = scanner.nextLine();
        if (input.equalsIgnoreCase("yes")){
            System.out.println("\nPlease first Login/Signup");
            user = LoginSignupTest();
            //customMap.initializeMap();
        }else{
            System.out.println("You first need to login/signup");
        }

        AddvehicleTest();

        
        AddUser();
        DoubleLinkedList<Vehicle> vehiclesInContact = customMap.getVehiclesInContactRange(user, 2);
        System.out.println("Vehicles in contact range:");
        if (vehiclesInContact.size()==0){
                System.out.println("no vehicles sorry bestie");
            }else{
                for (Vehicle vehicle : vehiclesInContact.getAll()) {
                    vehicle.printVehicleDetails();;
                    System.out.println(); 
                }
        }

        System.out.println("");
        
    }

    public static void AddvehicleTest() throws IOException {
            // Add vehicles to the map
            //customMap.addVehicles();
            customMap.addMapItems();
            // Display the updated map
            customMap.displayMap();
    }

    public static void AddUser() {
        System.out.println("Adding the user to the map.");
    
        System.out.println("Enter the initial location for the user (x, y):");

        System.out.print("X: ");
        int x = scanner.nextInt();
        System.out.print("Y: ");
        int y = scanner.nextInt();

        user.SetLocation(x, y);
        customMap.addElement(user, "U");

        System.out.println("passenger added to the map.");
        customMap.displayMap();
    /* 
        // Use the existing user (assumed to be already signed up)
        Passenger existingUser = user;
    
        if (existingUser != null) {
            existingUser.SetLocation(x, y);
    
            // Add the existing user to the map with the letter "U"
            customMap.addElement(existingUser, "U");
    
            System.out.println("User added to the map.");
            customMap.displayMap();
        } else {
            System.out.println("User not found. Please sign up or log in first.");
        }*/

    }
        
    

    public static void MoveVehicle(){
        System.out.println("would like to move a vehicle? by regNumber\n1.Yes\n2.No");
        String moveByReg = scanner.next();
        if(moveByReg.equalsIgnoreCase("yes")||moveByReg.equals("1")){
            DoubleLinkedList<Vehicle> vehicles = customMap.getVehicles();

            System.out.println("Enter the regNumber of the vehicle you would like to move");
            String regNum = scanner.next();
            System.out.println("Perfect and where would you like to move it? (x,y)");
            System.out.print("X: ");
            int x = scanner.nextInt();
            System.out.println("Y: ");
            int y = scanner.nextInt();

            for (Vehicle vehicle : vehicles.getAll()) {
                if (vehicle.getRegistrationNumber().equals(regNum)) {
                    vehicle.SetLocation(x, y);
                }
            }
            
        customMap.displayMap();
        }
    }
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
    private List<String> getRegistrationNumbers(DoubleLinkedList<Vehicle> vehicles) {
        List<String> vehicleRegistrationNumbers = new ArrayList<>();

        for (Vehicle vehicle : vehicles.getAll()) {
            vehicleRegistrationNumbers.add(vehicle.getRegistrationNumber());
        }

        return vehicleRegistrationNumbers;
    }


}