package App.Map;

import App.Vehicles.Helicopter;
import App.Vehicles.Vehicle;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * CustomMap class represents a grid-based map with vehicles.
 */
public class CustomMap {
    private char[][] grid;
    private List<Vehicle> vehicles; // Use custom data structures instead of built-in ones

    /**
     * Constructs a CustomMap object with a 10x10 grid and initializes it.
     */
    public CustomMap() {
        this.grid = new char[10][10];
        this.vehicles = new ArrayList<>();
        initializeMap();
    }

    /**
     * Initializes the map with empty '.' characters.
     */
    private void initializeMap() {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                grid[i][j] = '.';
            }
        }
    }

    /**
     * Adds vehicles to the map based on user input.
     */
    public void addVehicles() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of vehicles you want to add to the map:");
        int numberOfVehicles = scanner.nextInt();

        for (int i = 0; i < numberOfVehicles; i++) {
            System.out.println("Enter the (x,y) coordinate for vehicle " + (i + 1) + ":");
            int x = scanner.nextInt();
            int y = scanner.nextInt();

            Location vehicleLocation = new Location(x, y);

            // Create a new vehicle with a placeholder type (you can modify as needed)
            Helicopter heli = new Helicopter("2343",2.3,x,y);
            addVehicleToMap(heli);
            vehicles.add(heli);
        }

        System.out.println("Vehicles added successfully!");
    }

    /**
     * Adds a vehicle to the map at the specified coordinates.
     * @param vehicle The vehicle to be added to the map.
     */
    private void addVehicleToMap(Vehicle vehicle) {
        Location location = vehicle.GetLocation();
        int x = location.getX();
        int y = location.getY();

        System.out.println("Adding vehicle at map coordinates: (" + x + ", " + y + ")");

        if (isWithinMapBounds(x, y)) {
            grid[x - 1][y - 1] = 'V';
        }
    }

    /**
     * Displays the current state of the map.
     */
    //DanielMoody Hi i changed this so that that is flipped  making 0,0 xy start in the bottom left corner
    public void displayMap() {
        for (int i = grid.length - 1; i >= 0; i--) {
            for (int j = 0; j < grid[i].length; j++) {
                System.out.print(grid[i][j] + "  ");
            }
            System.out.println();
        }
    }

    /**
     * Checks if the given coordinates are within the bounds of the map.
     * @param x The x-coordinate.
     * @param y The y-coordinate.
     * @return True if the coordinates are within bounds, false otherwise.
     */
    private boolean isWithinMapBounds(int x, int y) {
        return x >= 0 && x < grid.length && y >= 0 && y < grid[0].length;
    }

    /**
     * Gets the list of vehicles on the map.
     * @return The list of vehicles.
     */
    public List<Vehicle> getVehicles() {
        return vehicles;
    }
}
