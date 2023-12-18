package App.Map;

import App.DataTypes.DoubleLinkedList;
import App.UserData.User;
import App.VehicleGenerator.VehicleDataReader;

import App.Vehicles.Vehicle;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import App.DataTypes.*;

import static App.VehicleGenerator.VehicleDataReader.returnVehicleList;

/**
 * CustomMap class represents a grid-based map with vehicles.
 */
public class CustomMap {
    private Map<Location, String> mapElements;
    private DoubleLinkedList<Vehicle> vehicles;
    

    public CustomMap() {
        this.mapElements = new HashMap<>();
        this.vehicles = new DoubleLinkedList<>();
        
        initializeMap();
    }

    /**
     * Initializes the map 
     */
    private void initializeMap() {
        List<Vehicle> vehicleList = VehicleDataReader.returnVehicleList();
        for (Vehicle vehicle : vehicleList) {
            addElement(vehicle, "V");
            vehicles.add(vehicle);
        }
    }

    /**
     * Adds vehicles to the map based on user input.
     */
    public void addVehicles() {
        System.out.println("Vehicles added successfully!");
        List<Vehicle> returnedList = VehicleDataReader.returnVehicleList();

        for (Vehicle vehicle : returnedList) {
            if (isWithinMapBounds(vehicle.GetLocation().getX(), vehicle.GetLocation().getY())) {
                vehicles.add(vehicle);
                addElement(vehicle, "V");
            } else {
                System.out.println("Invalid coordinates for vehicle: (" +
                        vehicle.GetLocation().getX() + ", " + vehicle.GetLocation().getY() + ")");
            }
        }
    }
    
    public void addUser() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter your username:");
        String username = scanner.nextLine();

        System.out.println("Enter your x-coordinate:");
        int x = scanner.nextInt();

        System.out.println("Enter your y-coordinate:");
        int y = scanner.nextInt();

        Location location = new Location(x, y);

        if (isWithinMapBounds(x, y) && !mapElements.containsKey(location)) {
            User user = new User(username, location);

            addElement(user, "U");

            System.out.println("User added successfully!");
        } else {
            System.out.println("Invalid coordinates or location already occupied.");
        }

        
    }

    
    

    public void addElement(MapItem element, String symbol) {
        Location location = element.GetLocation();
        System.out.println("Adding " + element.getClass().getSimpleName() +
                " at map coordinates: " + location);
    
        if (isWithinMapBounds(location.getX()-1, location.getY()-1)) {
            mapElements.put(location, symbol);
        } else {
            System.out.println("Invalid coordinates: (" + location.getX() + ", " + location.getY() + ")");

        }
    }

    private void removeElement(MapItem element) {
        Location location = element.GetLocation();
        System.out.println("Removing " + element.getClass().getSimpleName() +
                " from map coordinates: " + location);

        mapElements.remove(location);
    }
    
    

    

    /**
     * Displays the current state of the map.
     */
    //DanielMoody Hi i changed this so that that is flipped  making 0,0 xy start in the bottom left corner
    public void displayMap() {
        for (int i = 9; i >= 0; i--) {
            for (int j = 0; j < 10; j++) {
                Location currentLocation = new Location(j, i);
                String element = mapElements.getOrDefault(currentLocation, ".");
                System.out.print(element + "  ");
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
        return x >= 0 && x < 10 && y >= 0 && y < 10;
    }

    /**
     * Gets the list of vehicles on the map.
     * @return The list of vehicles.
     */
    public DoubleLinkedList<Vehicle> getVehicles() {
        return vehicles;
    }
}
