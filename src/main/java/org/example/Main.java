package org.example;
import org.example.DataTypes.Location;

import java.io.FileNotFoundException;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws FileNotFoundException {
        LoginSignupTest();
        MapTest();
    }
    public static void LoginSignupTest() throws FileNotFoundException {
        boolean logged = false;
        while(!logged){
            System.out.println("1.Login\n2.Signup");
            String choice  = scanner.next();
            if(Objects.equals(choice, "1") || choice.equalsIgnoreCase("LOGIN")){
                System.out.println("Username:");
                String username = scanner.next();
                System.out.println("Password:");
                String password = scanner.next();
                if(Auth.login(username,password)){logged = true;}
                else{
                    System.out.println("Login Failed Try again");}
            }
            else if(choice.equals("2") || choice.equalsIgnoreCase("SIGNUP")){
                System.out.println("Username:");
                String username = scanner.next();
                System.out.println("Password:");
                String password = scanner.next();
                if(Auth.signup(username,password)){logged = true;}
                else{
                    System.out.println("Login Failed Try again");}
            }
        }
    }
    public static void MapTest(){
        CustomMap customMap = new CustomMap();
        System.out.println("This is the inital map");
        customMap.displayMap();

        customMap.addVehicles();

        // Display the map
        customMap.displayMap();
    }

}