package App.Map;

import App.VehicleGenerator.CsvDataReader;
import App.VehicleGenerator.VehicleDataReader;
import App.Vehicles.Helicopter;
import App.Vehicles.Vehicle;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import App.DataTypes.*;
import App.Map.MapItems.HeliPad;
import App.Map.MapItems.MapItem;
import App.Map.MapItems.MapLocation;
import App.Map.MapItems.Water;



/**
 * CustomMap class represents a grid-based map with vehicles.
 */
public class CustomMap {
    private Map<Location, String> mapElements;
    private DoubleLinkedList<Vehicle> vehicles;
    private List<MapLocation> MapLocations = CsvDataReader.returnMapLocations();
    private List<Water>WaterLocations = CsvDataReader.returnWaterLocations();
    private List<HeliPad> HeliPads = CsvDataReader.returnHelipadList();
    public void PrintMapLocations(){
        int count =1;
        for(MapLocation location:MapLocations){
            System.out.println(count +": "+location.getName());
            count++;
        }
    }

    public CustomMap() throws FileNotFoundException {
        this.mapElements = new HashMap<>();
        this.vehicles = new DoubleLinkedList<>();
        
        
    }

    /**
     * Initializes the map 
     */
    public void initializeMap() throws IOException {
        List<Vehicle> vehicleList = CsvDataReader.returnVehicleList();
        for (Vehicle vehicle : vehicleList) {
            addElement((MapItem) vehicle, "V");
            vehicles.add(vehicle);
        }
    }

    /**
     * Adds vehicles to the map based on user input.
     */
    public void addVehicles() throws IOException {
        System.out.println("Vehicles added successfully!");
        List<Vehicle> returnedList = CsvDataReader.returnVehicleList();

        for (Vehicle vehicle : returnedList) {
//            if (isWithinMapBounds(vehicle.GetLocation().getX(), vehicle.GetLocation().getY())) {
            vehicles.add(vehicle);
                addElement((MapItem) vehicle, "V");
           // } else {
//                System.out.println("Invalid coordinates for vehicle: (" +
//                        vehicle.GetLocation().getX() + ", " + vehicle.GetLocation().getY() + ")");
            //}
        }
    }

    public void addMapItems(){
        for (MapLocation mapLocation:MapLocations){
            addElement(mapLocation,"M");
        }
        for(HeliPad heliPad:HeliPads){
            addElement(heliPad,"H");
        }
        for(Water water:WaterLocations){
            addElement(water,"W");
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
            Passenger user = new Passenger(username, location);

            addElement(user, "U");

            System.out.println("User added successfully!");
        } else {
            System.out.println("Invalid coordinates or location already occupied.");
        }

        
    }

    
    

    public void addElement(MapItem element, String symbol) {
        Location location = element.GetLocation();
//        System.out.println("Adding " + element.getClass().getSimpleName() +
//                " at map coordinates: " + location);
                mapElements.put(location, symbol);
    }


    private void removeElement(MapItem element) {
        Location location = element.GetLocation();
        System.out.println("Removing " + element.getClass().getSimpleName() +
                " from map coordinates: " + location);

        mapElements.remove(location);
    }

    public DoubleLinkedList<Vehicle> getVehiclesInContactRange(Passenger user, int r) {
        Location userLocation = user.GetLocation();
        int x = userLocation.getX();
        int y = userLocation.getY();

        DoubleLinkedList<Vehicle> allVehicles = getVehicles();
        DoubleLinkedList<Vehicle> vehiclesInContact = new DoubleLinkedList<>();

        for (Vehicle vehicle : allVehicles.getAll()) {
            Location vehicleLocation = vehicle.GetLocation();
            int vehicleX = vehicleLocation.getX();
            int vehicleY = vehicleLocation.getY();

            // Check if the vehicle is within the square of side length 2r centered at the user's location
            if (Math.abs(vehicleX - x) <= r && Math.abs(vehicleY - y) <= r) {
                vehiclesInContact.add(vehicle);
            }
        }
        return vehiclesInContact;
        
    }

    public void firstMap() {
        for (int i = 9; i >= 0; i--) {
            for (int j = 0; j < 10; j++) {
                Location currentLocation = new Location(j, i);
                String element = mapElements.getOrDefault(currentLocation, ".");  // Default to "." if no element at the location
                System.out.print(element + "   ");
            }
            System.out.println();
        }
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
    
                // Check if there's a vehicle at the current location and update the symbol
                for (Vehicle vehicle : vehicles.getAll()) {
                    if (vehicle.GetLocation().equals(currentLocation)) {
                        element = "V";
                    }
                }
    
                System.out.print(element + "   ");
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