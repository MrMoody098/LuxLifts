package App;

import App.Authentication.Auth;
import App.DataTypes.DoubleLinkedList;
import App.DataTypes.Passenger;
import App.Map.CustomMap;
import App.Map.Location;
import App.VehicleGenerator.CsvGenerator;
import App.Vehicles.Vehicle;

import java.io.FileNotFoundException;
import java.util.Objects;
import java.util.Scanner;

/**
 * The main class for testing the Login, Signup, and Map functionalities.
 */
public class Main {
    private static Passenger user;
    public static CustomMap customMap;

    static {
        try {
            customMap = new CustomMap();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    // Scanner object for user input
    public static Scanner scanner = new Scanner(System.in);

    public Main() throws FileNotFoundException {
    }

    /**
     * The main method to run the program.
     * @param args Command-line arguments (not used in this program).
     * @throws FileNotFoundException If a file required for the program is not found.
     */
    public static void main(String[] args) throws FileNotFoundException {
        // Test the Login and Signup functionality
        // Test the Map functionality
        
        user = LoginSignupTest();
        CsvGenerator.main(null);
        MapTest ();

    }

    /**
     * Method to test the Login and Signup functionality.
     * @throws FileNotFoundException If a file required for authentication is not found.
     */
    public static Passenger LoginSignupTest() throws FileNotFoundException {
        //Passenger user = null;
        //while user is still null loop
        while (user==null) {

            //prompt choice between 1.login and 2.signup
            System.out.println("1. Login\n2. Signup");
            //store choice as String
            String choice = scanner.next();
            //if the choice = 1,or LOGIN case ignored then do this
            if (Objects.equals(choice, "1") || choice.equalsIgnoreCase("LOGIN"))
            {
                //store the return of login could be null if unsuccessful
                user=Login();
            }
                //if the choice = 2,or SIGNUP case ignored then do this
            else if (choice.equals("2") || choice.equalsIgnoreCase("SIGNUP")){
                    //store Passenger return from signup could be null if unsuccessful
                    user =SignUp();
            }

        }//return user cant be null as the while loop wont stop until user is not null
        return user;
    }

    public static Passenger SignUp() throws FileNotFoundException {// User chose to signup
        System.out.println("Username:");
        String username = scanner.next();
        System.out.println("Password:");
        String password = scanner.next();

        // Attempt to signup using Auth class
        return Auth.signup(username,password);
    }
public static Passenger Login(){ // User chose to login
    System.out.println("Username:");
    String username = scanner.next();

    System.out.println("Password:");
    String password = scanner.next();

    // Attempt to login using Auth class
    return Auth.login(username,password);
    }
    /**
     * Method to test the Map functionality.
     */
    public static void MapTest() throws FileNotFoundException {
        //we need to also add the user to this map

        // Create a CustomMap object
        System.out.println("This is the initial map:");
        customMap.displayMap();
        AddvehicleTest();
        DoubleLinkedList<Vehicle> vehiclesInContact = customMap.getVehiclesInContactRange(user, 2);
        //MoveVehicle();
        AddUser();
    }
    public static void AddvehicleTest() throws FileNotFoundException {
            // Add vehicles to the map
            customMap.addVehicles();
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
        }
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
}
