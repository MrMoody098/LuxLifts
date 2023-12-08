package org.example.Authentication;
import java.io.*;
import java.security.NoSuchAlgorithmException;

//this class should be able to login/signup a user
public class Auth {
    public static String CSV_FILE = "src/main/java/org/example/UserData/Users.csv";

    //this method should be able to login a user
    // Updated login method using password hashing
    public static boolean login(String username, String password) {
        String line;

        try (BufferedReader br = new BufferedReader(new FileReader(CSV_FILE))) {
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                String storedUsername = data[0].trim();
                String storedPassword = data[1].trim();

                // Verify the entered password against the stored hashed password
                if (username.equals(storedUsername) && Encryption.verifyPassword(password, storedPassword)) {
                    return true;
                }
            }
        } catch (IOException | NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Updated signup method using password hashing
    public static boolean signup(String username, String password) throws FileNotFoundException {
        String line;

        // Check if the username already exists
        try (BufferedReader br = new BufferedReader(new FileReader(CSV_FILE))) {
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                String storedUsername = data[0].trim();

                if (username.equals(storedUsername)) {
                    return false;  // Username already exists
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
            return true;
        } catch (IOException | NoSuchAlgorithmException e) {
            e.printStackTrace();
            return false;
        }
    }
}