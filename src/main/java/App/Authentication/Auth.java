package App.Authentication;
import App.DataTypes.Passenger;
import App.Map.Location;

import java.io.*;
import java.security.NoSuchAlgorithmException;

/**
 * Class representing user authentication and registration functionality.
 */
public class Auth {

    // File paths for user and vehicle data
    public static String USER_CSV_FILE = "src/main/java/App/UserData/Users.csv";
    public static String VEHICLE_CSV_FILE = "src/main/java/App/VehicleGenerator/Vehicles.csv";

    /**
     * Authenticates a user based on provided credentials.
     * @param username The username of the user.
     * @param password The password of the user.
     * @return A Passenger object if credentials are correct, otherwise null.
     */
    public static Passenger login(String username, String password) {
        String line;

        try (BufferedReader br = new BufferedReader(new FileReader(USER_CSV_FILE))) {
            // Read each line in the user data file
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                String storedUsername = data[0].trim();
                String storedPassword = data[1].trim();

                // Verify the entered password against the stored hashed password
                if (username.equals(storedUsername) && Encryption.verifyPassword(password, storedPassword)) {
                    return new Passenger(username, new Location(5, 5));
                }
            }
        } catch (IOException | NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Registers a new user with the provided credentials.
     * @param username The username of the new user.
     * @param password The password of the new user.
     * @return A Passenger object if registration is successful, otherwise null.
     * @throws FileNotFoundException If the user data file is not found.
     */
    public static Passenger signup(String username, String password) throws FileNotFoundException {
        String line;

        // Check if the username already exists
        try (BufferedReader br = new BufferedReader(new FileReader(USER_CSV_FILE))) {
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                String storedUsername = data[0].trim();

                if (username.equals(storedUsername)) {
                    return null;  // Username already exists
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // If the username doesn't exist, add the new user with hashed password to the CSV file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(USER_CSV_FILE, true))) {
            String hashedPassword = Encryption.encrypt(password);
            writer.write(username + "," + hashedPassword);
            writer.newLine();
            System.out.println("Signup successful!");
            return new Passenger(username, new Location(5, 5));
        } catch (IOException | NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }
}
