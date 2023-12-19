package App.Authentication;
import App.DataTypes.Passenger;
import App.Map.Location;

import java.io.*;
import java.security.NoSuchAlgorithmException;

//this class should be able to login/signup a user
public class Auth { 
    public static String CSV_FILE = "LuxLifts/src/main/java/App/VehicleGenerator/Vehicles.csv";

    //this method should be able to login a user
    // Updated login method using1 password hashing
    public static Passenger login(String username, String password) {
        String line;

        try (BufferedReader br = new BufferedReader(new FileReader(CSV_FILE))) {
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

    // Updated signup method using password hashing
    public static Passenger signup(String username, String password) throws FileNotFoundException {
        String line;

        // Check if the username already exists
        try (BufferedReader br = new BufferedReader(new FileReader(CSV_FILE))) {
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
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(CSV_FILE, true))) {
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