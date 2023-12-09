package App;
import App.Authentication.Auth;

import java.io.FileNotFoundException;
import java.util.Objects;
import java.util.Scanner;

/**
 * The main class for testing the Login, Signup, and Map functionalities.
 */
public class Main {
    // Scanner object for user input
    public static Scanner scanner = new Scanner(System.in);

    /**
     * The main method to run the program.
     * @param args Command-line arguments (not used in this program).
     * @throws FileNotFoundException If a file required for the program is not found.
     */
    public static void main(String[] args) throws FileNotFoundException {
        // Test the Login and Signup functionality
        LoginSignupTest();

        // Test the Map functionality
        MapTest();
    }

    /**
     * Method to test the Login and Signup functionality.
     * @throws FileNotFoundException If a file required for authentication is not found.
     */
    public static void LoginSignupTest() throws FileNotFoundException {
        boolean logged = false;
        while (!logged) {
            System.out.println("1. Login\n2. Signup");
            String choice = scanner.next();
            if (Objects.equals(choice, "1") || choice.equalsIgnoreCase("LOGIN")) {
                // User chose to login
                System.out.println("Username:");
                String username = scanner.next();

                System.out.println("Password:");
                String password = scanner.next();

                // Attempt to login using Auth class
                if (Auth.login(username, password)) {
                    logged = true;
                } else {
                    System.out.println("Login Failed. Try again.");
                }
            } else if (choice.equals("2") || choice.equalsIgnoreCase("SIGNUP")) {
                // User chose to signup
                System.out.println("Username:");
                String username = scanner.next();
                System.out.println("Password:");
                String password = scanner.next();

                // Attempt to signup using Auth class
                if (Auth.signup(username, password)) {
                    logged = true;
                } else {
                    System.out.println("Signup Failed. Try again.");
                }
            }
        }
    }

    /**
     * Method to test the Map functionality.
     */
    public static void MapTest() {
        // Create a CustomMap object
        CustomMap customMap = new CustomMap();
        System.out.println("This is the initial map:");
        customMap.displayMap();
        boolean loop=true;
        while (true) {
            // Add vehicles to the map
            customMap.addVehicles();
            // Display the updated map
            customMap.displayMap();
            System.out.println("Want to add more?");
            String addMore = scanner.next();
            if (addMore=="no".toUpperCase()){
                loop =false;
            }
        }
    }
}
