package App.DataTypes;

import App.Map.CustomMap;
import App.Map.Location;
import App.Map.MapItems.MapItem;

/**
 * Class representing a Passenger in a transportation application.
 * Implements the MapItem interface to interact with the map.
 */
public class Passenger implements MapItem {
    private String username;
    private Location location;

    /**
     * Initializes a Passenger with a username and current location.
     *
     * @param username        The username of the passenger.
     * @param currentLocation The initial location of the passenger.
     */
    public Passenger(String username, Location currentLocation) {
        this.username = username;
        this.location = currentLocation;
    }

    /**
     * Gets the username of the passenger.
     *
     * @return The username of the passenger.
     */
    public String GetUsername() {
        return username;
    }

    /**
     * Sets the username of the passenger.
     *
     * @param username The new username to be set.
     * @return The updated username.
     */
    public String SetUsername(String username) {
        this.username = username;
        return this.username;
    }

    /**
     * Sets the location of the passenger to the specified coordinates.
     *
     * @param x The x-coordinate of the new location.
     * @param y The y-coordinate of the new location.
     * @return The updated location.
     */
    @Override
    public Location SetLocation(int x, int y) {
        // Move the Passenger to the new location (x, y)
        location = new Location(x, y);
        return location;
    }

    /**
     * Gets the current location of the passenger.
     *
     * @return The current location of the passenger.
     */
    @Override
    public Location GetLocation() {
        // Return the current location of the Passenger
        return this.location;
    }

    /**
     * Updates the location of the passenger by moving a specified amount from the current location.
     *
     * @param x The amount to move in the x-direction.
     * @param y The amount to move in the y-direction.
     * @return The updated location.
     */
    @Override
    public Location UpdateLocation(int x, int y) {
        // Move the Passenger by the specified amount from their current location
        int currentX = location.getX();
        int currentY = location.getY();
        return SetLocation(currentX + x, currentY + y);
    }

    /**
     * Moves the passenger to the specified destination on the map.
     *
     * @param destination The destination location.
     * @param customMap   The custom map on which the passenger is moving.
     * @return The final location after moving to the destination.
     */
    @Override
    public Location MoveTo(Location destination, CustomMap customMap) {
        SetLocation(destination.getX(), destination.getY());
        return GetLocation();
    }
}