package App.Map.MapItems;

import App.Map.CustomMap;
import App.Map.Location;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Interface representing a map item that can be placed on a map.
 */
public interface MapItem {


    /**
     * Sets the location of the map item to the specified coordinates.
     *
     * @param x The x-coordinate of the new location.
     * @param y The y-coordinate of the new location.
     * @return The updated location.
     */
    Location SetLocation(int x, int y);

    /**
     * Gets the current location of the map item.
     *
     * @return The current location of the map item.
     */
    Location GetLocation();

    /**
     * Updates the location of the map item by moving a specified amount from the current location.
     *
     * @param x The amount to move in the x-direction.
     * @param y The amount to move in the y-direction.
     * @return The updated location.
     */
    Location UpdateLocation(int x, int y);

    /**
     * Moves the map item to the specified destination on the map.
     *
     * @param destination The destination location.
     * @param customMap   The custom map on which the map item is moving.
     * @return The final location after moving to the destination.
     * @throws FileNotFoundException If the file is not found while moving.
     */
    Location MoveTo(Location destination, CustomMap customMap) throws IOException, InterruptedException;
}
