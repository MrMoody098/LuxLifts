package org.example;

import java.util.HashMap;
import java.util.Map;

public class Mapp {
    private char[][] grid;
    private Map<String, Location> vehicleLocations;

    public Map<String, Location> getVehicleLocations() {
        return vehicleLocations;
    }

    public void setVehicleLocations(Map<String, Location> vehicleLocations) {
        this.vehicleLocations = vehicleLocations;
    }

    public Mapp(int rows, int columns) {
        this.grid = new char[rows][columns];
        this.vehicleLocations = new HashMap<>();
        initializeMap();
    }

    private void initializeMap() {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                grid[i][j] = '.';
            }
        }
    }

    public void addVehicle(String registrationNumber, Location location) {
        vehicleLocations.put(registrationNumber, location);
        updateMap();
    }

    private void updateMap() {
        initializeMap();
        for (Map.Entry<String, Location> entry : vehicleLocations.entrySet()) {
            int x = entry.getValue().getX();
            int y = entry.getValue().getY();
            if (isWithinMapBounds(x, y)) {
                grid[x][y] = 'V';
            }
        }
    }

    public void displayMap() {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("-----------");
    }

    private boolean isWithinMapBounds(int x, int y) {
        return x >= 0 && x < grid.length && y >= 0 && y < grid[0].length;
    }
}
