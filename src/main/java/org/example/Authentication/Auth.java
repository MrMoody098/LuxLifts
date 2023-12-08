package org.example.Authentication;
import java.io.*;

//this class should be able to login/signup a user
public class Auth {
    public static String CSV_FILE = "src/main/java/org/example/UserData/Users.csv";

    //this method should be able to login a user
    public static boolean login(String username, String password) {
        // Read our Users.csv file and check if the username and password match
        String line;

        try (BufferedReader br = new BufferedReader(new FileReader(CSV_FILE))) {
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                String storedUsername = data[0].trim();
                String storedPassword = data[1].trim();

                if (username.equals(storedUsername) && password.equals(storedPassword)) {
                    return true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    //this method should be able to signup a user
    public static boolean signup(String username, String password) throws FileNotFoundException {
        String line;
        // Check if the username already exists
        try (BufferedReader br = new BufferedReader(new FileReader(CSV_FILE))) {
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                String storedUsername = data[0].trim();
                String storedPassword = data[1].trim();

                if (username.equals(storedUsername) && password.equals(storedPassword)) {
                    return false;  // Username already exists
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

// If the username doesn't exist, add the new user to the CSV file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(CSV_FILE, true))) {
            writer.write(username + "," + password);
            writer.newLine();
            System.out.println("Signup successful!");
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
}