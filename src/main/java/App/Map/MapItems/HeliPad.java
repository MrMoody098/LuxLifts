package App.Map.MapItems;

import App.Map.CustomMap;
import App.Map.Location;

import java.io.FileNotFoundException;

/**
 * Class representing a helipad on the map.
 * Implements the MapItem interface to interact with the map.
 */
public class HeliPad implements MapItem {
    private Location location;
    private String name;

    /**
     * Initializes a helipad with a location and name.
     *
     * @param location The initial location of the helipad.
     * @param name     The name of the helipad.
     */
    public HeliPad(Location location, String name) {
        this.location = location;
        this.name = name;
    }

    /**
     * Gets the name of the helipad.
     *
     * @return The name of the helipad.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the helipad.
     *
     * @param name The new name to be set.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Sets the location of the helipad to the specified coordinates.
     *
     * @param x The x-coordinate of the new location.
     * @param y The y-coordinate of the new location.
     * @return The updated location.
     */
    @Override
    public Location SetLocation(int x, int y) {
        return this.location = new Location(x, y);
    }

    /**
     * Gets the current location of the helipad.
     *
     * @return The current location of the helipad.
     */
    @Override
    public Location GetLocation() {
        return this.location;
    }

    /**
     * Updates the location of the helipad by moving a specified amount from the current location.
     *
     * @param x The amount to move in the x-direction.
     * @param y The amount to move in the y-direction.
     * @return The updated location.
     */
    @Override
    public Location UpdateLocation(int x, int y) {
        SetLocation(location.getX() + x, location.getY() + y);
        return this.location;
    }

    /**
     * Moves the helipad to the specified destination on the map.
     *
     * @param destination The destination location.
     * @param customMap   The custom map on which the helipad is moving.
     * @return The final location after moving to the destination.
     * @throws FileNotFoundException If the file is not found while moving.
     */
    @Override
    public Location MoveTo(Location destination, CustomMap customMap) throws FileNotFoundException {
        // Not implemented for a helipad, returns null
        return null;
    }
}
