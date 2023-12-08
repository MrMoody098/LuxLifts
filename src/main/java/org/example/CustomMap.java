package org.example;

import org.example.DataTypes.Location;

import org.example.DataTypes.VehicleType;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//import org.example.DataTypes.Location;
//import org.example.DataTypes.vehicleType;

public class CustomMap {
    private char[][] grid;
    private List<Vehicle> vehicles; //use your own data structures not build in

    public CustomMap() {
        this.grid = new char[10][10];
        this.vehicles = new ArrayList<>();
        initializeMap();
    }

    private void initializeMap() {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                grid[i][j] = '.';
            }
        }
    }

    public void addVehicles() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of vehicles you want to add to the map:");
        int numberOfVehicles = scanner.nextInt();

        for (int i = 0; i < numberOfVehicles; i++) {
            System.out.println("Enter the (x,y) coordinate for vehicle " + (i + 1) + ":");
            int x = scanner.nextInt();
            int y = scanner.nextInt();

            Location vehicleLocation = new Location(x, y);

            Vehicle newVehicle = new Vehicle("Vehicle" + (i + 1), 3.7, VehicleType.limo, vehicleLocation);
                                                                                //this is the abstract part
          
            

            addVehicleToMap(newVehicle);
            vehicles.add(newVehicle);
        }

        System.out.println("Vehicles added successfully!");
    }

    private void addVehicleToMap(Vehicle vehicle) {
        Location location = vehicle.getLocation();
        int x = location.getX(); // this is -1 bc java decided to go from 0 that's why it wasn't right
        int y = location.getY();
    
        System.out.println("Adding vehicle at map coordinates: (" + x  + ", " + y +")");

        if (isWithinMapBounds(x, y)) {
            grid[x-1][y-1] = 'V';
        }
    }

    public void displayMap() {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                System.out.print(grid[i][j] + "  ");
            }
            System.out.println();
        }
        
    }

    private boolean isWithinMapBounds(int x, int y) {
        return x >= 0 && x < grid.length && y >= 0 && y < grid[0].length;
    }

    public List<Vehicle> getVehicles() {
        return vehicles;
    }
}

