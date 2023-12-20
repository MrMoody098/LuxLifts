package App.Map;

import java.util.Objects;

/**
 * Class representing a location with x and y coordinates on the map.
 */
public class Location {
    private int x;
    private int y;
    public String name;

    /**
     * Initializes a location with specified x and y coordinates.
     *
     * @param x The x-coordinate of the location.
     * @param y The y-coordinate of the location.
     */
    public Location(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Initializes a location with specified x and y coordinates and a name.
     *
     * @param x    The x-coordinate of the location.
     * @param y    The y-coordinate of the location.
     * @param name The name associated with the location.
     */
    public Location(int x, int y, String name) {
        this.x = x;
        this.y = y;
        this.name = name;
    }

    /**
     * Gets the name associated with the location.
     *
     * @return The name of the location.
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the x-coordinate of the location.
     *
     * @return The x-coordinate of the location.
     */
    public int getX() {
        return this.x;
    }

    /**
     * Gets the y-coordinate of the location.
     *
     * @return The y-coordinate of the location.
     */
    public int getY() {
        return this.y;
    }

    /**
     * Gets the current location.
     *
     * @return The current location.
     */
    public Location getLocation() {
        return this;
    }

    /**
     * Checks if two locations are equal based on their x and y coordinates.
     *
     * @param obj The object to compare.
     * @return True if the locations are equal, false otherwise.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Location location = (Location) obj;
        return x == location.x && y == location.y;
    }

    /**
     * Generates a hash code for the location based on its x and y coordinates.
     *
     * @return The hash code of the location.
     */
    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    /**
     * Converts the location to a string representation.
     *
     * @return The string representation of the location.
     */
    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }
}