package App.Map;

import App.Authentication.Auth;
import App.Map.MapItems.HeliPad;
import App.Map.MapItems.MapItem;
import App.Map.MapItems.MapLocation;
import App.Map.MapItems.Water;
import App.VehicleGenerator.CsvDataReader;
import App.Vehicles.Vehicle;
import java.io.IOException;
import java.util.*;

import App.DataTypes.*; // Assuming this package exists

/**
 * CustomMap class represents a grid-based map with Vehicles.
 */
public class CustomMap {

    private Map<Location, String> mapElements; // Map to store elements and their symbols at specific locations
    private DoubleLinkedList<Vehicle> Vehicles; // List to store Vehicles on the map
    private List<MapLocation> MapLocations = CsvDataReader.returnMapLocations(); // List of MapLocations
    private List<Water> WaterLocations = CsvDataReader.returnWaterLocations(); // List of Water locations
    private List<HeliPad> HeliPads = CsvDataReader.returnHelipadList(); // List of HeliPads

    // Method to print the names of MapLocations
    public void PrintMapLocations(){
        int count =1;
        for(MapLocation location:MapLocations){
            System.out.println(count +": "+location.getName());
            count++;
        }
    }

    public List<MapLocation> returnMapLocations(){
        return MapLocations;
    }
    // Constructor for CustomMap class
    public CustomMap() throws IOException {
        this.mapElements = new HashMap<>();
        this.Vehicles = new DoubleLinkedList<>();
    }

    // Method to initialize the map with Vehicles
    public void initializeVehicles() throws IOException {
        for (Vehicle vehicle : getVehicles().getAll()) {
            addElement(vehicle,"V"); // Add Vehicle to the map and list
            Vehicles.add(vehicle);
        }
    }

    // Method to add various MapItems (MapLocations, HeliPads, Water) to the map
    public void intiializeMapItems(){
        for (MapLocation mapLocation : MapLocations) {
            addElement(mapLocation, mapLocation.symbol);
        }
        for (HeliPad heliPad : HeliPads) {
            addElement(heliPad, "H");
        }
        for (Water water : WaterLocations) {
            addElement(water, "W");
        }
    }

    // Method to add Vehicles to the map
    public void addVehicles() throws IOException {
        System.out.println("Vehicles added successfully!");
        List<Vehicle> returnedList = CsvDataReader.returnVehicleList();
        for (Vehicle vehicle : returnedList) {
            Vehicles.add(vehicle);
            addElement(vehicle, "V");
        }
    }

    // Method to add a user to the map
    public void addUser(Passenger user) {
        addElement(user,"U");
    }

    // Method to display the initial state of the map
    public void firstMap() {
        for (int i = 9; i >= 0; i--) {
            for (int j = 0; j < 10; j++) {
                Location currentLocation = new Location(j, i);
                String element = "."; // Default to "." for an empty map
                System.out.print(element + "   ");
            }
            System.out.println();
        }
    }

    // Method to add a MapItem to the map
    public void addElement(MapItem element,String symbol) {
        Location location = element.GetLocation();
        mapElements.put(location,symbol); // Add the element to the map
    }

    // Method to remove a MapItem from the map
    public void removeElement(MapItem element, String symbol) {
        Location location = element.GetLocation();
        System.out.println("Removing " + element.getClass().getSimpleName() +
                " from map coordinates: " + location);

        mapElements.remove(location);
    }

    // Method to get Vehicles in contact range of a user
    public DoubleLinkedList<Vehicle> getVehiclesInContactRange(Passenger user, int r) {
        Location userLocation = user.GetLocation();
        int x = userLocation.getX();
        int y = userLocation.getY();

        DoubleLinkedList<Vehicle> allVehicles = getVehicles();
        DoubleLinkedList<Vehicle> VehiclesInContact = new DoubleLinkedList<>();

        // Iterate through all Vehicles and check if they are within the specified range
        for (Vehicle vehicle : allVehicles.getAll()) {
            Location vehicleLocation = vehicle.GetLocation();
            int vehicleX = vehicleLocation.getX();
            int vehicleY = vehicleLocation.getY();

            // Check if the vehicle is within the square of side length 2r centered at the user's location
            if (Math.abs(vehicleX - x) <= r && Math.abs(vehicleY - y) <= r) {
                VehiclesInContact.add(vehicle);
            }
        }
        return VehiclesInContact;
    }

    // Method to display the current state of the map
    public void displayMap(Passenger user) throws IOException {
        emptyMapElements();
        addUser(user);
        initializeVehicles();
        intiializeMapItems();
        for (int i = 9; i >= 0; i--) {
            for (int j = 0; j < 10; j++) {
                Location currentLocation = new Location(j, i);
                String element = mapElements.getOrDefault(currentLocation, ".");
                System.out.print(element + "  ");
            }
            System.out.println();
        }
    }
    public void displayMap() throws IOException {
        emptyMapElements();

        initializeVehicles();
        intiializeMapItems();
        for (int i = 9; i >= 0; i--) {
            for (int j = 0; j < 10; j++) {
                Location currentLocation = new Location(j, i);
                String element = mapElements.getOrDefault(currentLocation, ".");
                System.out.print(element + "  ");
            }
            System.out.println();
        }
    }
    public void emptyMapElements(){
        this.mapElements.clear();
    }

    // Method to check if coordinates are within the bounds of the map
    private boolean isWithinMapBounds(int x, int y) {
        return x >= 0 && x < 10 && y >= 0 && y < 10;
    }

    // Method to get the list of Vehicles on the map
    public DoubleLinkedList<Vehicle> getVehicles() {
        return Vehicles;
    }
}
