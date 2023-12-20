package App.Map.MapItems;

import App.Map.CustomMap;
import App.Map.Location;

import java.io.FileNotFoundException;

/**
 * Class representing a water area on the map.
 * Implements the MapItem interface to interact with the map.
 */
public class Water implements MapItem {
    public Location location;

    /**
     * Initializes a water area with a location.
     *
     * @param location The initial location of the water area.
     */
    public Water(Location location) {
        this.location = location;
    }

    /**
     * Sets the location of the water area to the specified coordinates.
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
     * Gets the current location of the water area.
     *
     * @return The current location of the water area.
     */
    @Override
    public Location GetLocation() {
        return this.location;
    }

    /**
     * Updates the location of the water area by moving a specified amount from the current location.
     *
     * @param x The amount to move in the x-direction.
     * @param y The amount to move in the y-direction.
     * @return The updated location.
     */
    @Override
    public Location UpdateLocation(int x, int y) {
        SetLocation(location.getY() + x, location.getY() + y);
        return this.location;
    }

    /**
     * Moves the water area to the specified destination on the map.
     *
     * @param destination The destination location.
     * @param customMap   The custom map on which the water area is moving.
     * @return The final location after moving to the destination.
     * @throws FileNotFoundException If the file is not found while moving.
     */
    @Override
    public Location MoveTo(Location destination, CustomMap customMap) throws FileNotFoundException {
        // Not implemented for water area, returns null
        return null;
    }
}
