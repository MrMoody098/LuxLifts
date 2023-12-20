package App.Authentication;
import App.DataTypes.Passenger;
import App.Map.Location;

import java.io.*;
import java.security.NoSuchAlgorithmException;

//this class should be able to login/signup a user
public class Auth{
    public static String USER_CSV_FILE = "/LuxLifts/src/main/java/App/UserData/User.java";
    public static String VEHICLE_CSV_FILE = "LuxLifts/src/main/java/App/VehicleGenerator/Vehicles.csv";

    // Updated login method using1 password hashing
    //returns a user if the credentials are correct
    //else returns null
    public static Passenger login(String username, String password) {
        String line;

        try (BufferedReader br = new BufferedReader(new FileReader(USER_CSV_FILE))) {
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                String storedUsername = data[0].trim();
                String storedPassword = data[1].trim();

                // Verify the entered password against the stored hashed password
                if (username.equals(storedUsername) && Encryption.verifyPassword(password, storedPassword)) {
                    return new Passenger(username,new Location(5,5));
                }
            }
        } catch (IOException | NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }

    //returns a user if the credentials are correct
    //else returns null
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
            return new Passenger(username,new Location(5,5));
        } catch (IOException | NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }
}