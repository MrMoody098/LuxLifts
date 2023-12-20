package App.Map;

import App.Map.MapItems.HeliPad;
import App.Map.MapItems.MapItem;
import App.Map.MapItems.MapLocation;
import App.Map.MapItems.Water;
import App.VehicleGenerator.CsvDataReader;

import App.Vehicles.Vehicle;

import java.io.IOException;
import java.util.*;

import App.DataTypes.*;



/**
 * CustomMap class represents a grid-based map with Vehicles.
 */
public class CustomMap {
    private Map<Location, String> mapElements;
    private DoubleLinkedList<Vehicle> Vehicles;
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
    public CustomMap() throws IOException {
        this.mapElements = new HashMap<>();
        this.Vehicles = new DoubleLinkedList<>();
        
        initializeMap();
    }

    /**
     * Initializes the map 
     */
    public void initializeMap() throws IOException {
        List<Vehicle> vehicleList = CsvDataReader.returnVehicleList();
        for (Vehicle vehicle : vehicleList) {
            addElement(vehicle, "V");
            Vehicles.add(vehicle);
        }
    }

    /**
     * Adds Vehicles to the map based on user input.
     */
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
    public void addVehicles() throws IOException {
        System.out.println("Vehicles added successfully!");
        List<Vehicle> returnedList = CsvDataReader.returnVehicleList();

        for (Vehicle vehicle : returnedList) {
//            if (isWithinMapBounds(vehicle.GetLocation().getX(), vehicle.GetLocation().getY())) {
                Vehicles.add(vehicle);
                addElement(vehicle, "V");
           // } else {
//                System.out.println("Invalid coordinates for vehicle: (" +
//                        vehicle.GetLocation().getX() + ", " + vehicle.GetLocation().getY() + ")");
            //}
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
        System.out.println("Adding " + element.getClass().getSimpleName() +
                " at map coordinates: " + location);
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
        DoubleLinkedList<Vehicle> VehiclesInContact = new DoubleLinkedList<>();

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
     * Gets the list of Vehicles on the map.
     * @return The list of Vehicles.
     */
    public DoubleLinkedList<Vehicle> getVehicles() {
        return Vehicles;
    }
}
