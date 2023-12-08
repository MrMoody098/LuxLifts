package org.example;
import org.example.DataTypes.Location;

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
