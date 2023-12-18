package main.App;

import main.App.Authentication.Auth;
import main.App.DataTypes.DoubleLinkedList;
import main.App.DataTypes.Passenger;
import main.App.Map.CustomMap;
import main.App.Vehicles.Vehicle;

import java.io.FileNotFoundException;
import java.util.Objects;
import java.util.Scanner;

/**
 * The main class for testing the Login, Signup, and Map functionalities.
 */
public class Main {
    private static Passenger passenger;
    public static CustomMap customMap = new CustomMap();

    // Scanner object for passenger input
    public static Scanner scanner = new Scanner(System.in);

    /**
     * The main method to run the program.
     * @param args Command-line arguments (not used in this program).
     * @throws FileNotFoundException If a file required for the program is not found.
     */
    public static void main(String[] args) throws FileNotFoundException {
        // Test the Login and Signup functionality
        // Test the Map functionality
        passenger = LoginSignupTest();
        MapTest ();

    }

    /**
     * Method to test the Login and Signup functionality.
     * @throws FileNotFoundException If a file required for authentication is not found.
     */
    public static Passenger LoginSignupTest() throws FileNotFoundException {
        //Passenger passenger = null;
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
    System.out.println("passengername:");
    String passengername = scanner.next();

    System.out.println("Password:");
    String password = scanner.next();

    // Attempt to login using Auth class
    return Auth.login(passengername,password);
    }
    /**
     * Method to test the Map functionality.
     */
    public static void MapTest() {
        //we need to also add the passenger to this map

        // Create a CustomMap object
        System.out.println("This is the initial map:");
        customMap.displayMap();
        AddvehicleTest();
        MoveVehicle();
        Addpassenger();
    }
    public static void AddvehicleTest(){
            // Add vehicles to the map
            customMap.addVehicles();
            // Display the updated map
            customMap.displayMap();
    }
    public static void Addpassenger(){
        System.out.println("Adding the passenger to the map.");

        System.out.println("Enter the initial location for the passenger (x, y):");
        System.out.print("X: ");
        int x = scanner.nextInt();
        System.out.print("Y: ");
        int y = scanner.nextInt();

        passenger.SetLocation(x, y);
        customMap.addElement(passenger, "U");

        System.out.println("passenger added to the map.");
        customMap.displayMap();
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
