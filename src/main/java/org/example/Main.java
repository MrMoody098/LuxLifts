package org.example;
import org.example.DataTypes.Location;
// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        
        
        CustomMap customMap = new CustomMap();
        System.out.println("This is the inital map");
        customMap.displayMap();

        customMap.addVehicles();

        // Display the map
        customMap.displayMap();

    }
    }