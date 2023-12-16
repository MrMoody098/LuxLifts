package App.UserData;
import App.Map.*;
import App.Map.CustomMap;
import App.Map.Location;

public class User implements MapItem {
    private String username;
    private Location location;

    public User(String username, Location location) {
        this.username = username;
        this.location = location;
    }

    @Override
    public Location SetLocation(int x, int y) {
        location = new Location(x, y);
        return location;
    }

    @Override
    public Location GetLocation() {
        return this.location;
    }

    @Override
    public Location UpdateLocation(int x, int y) {
        int currentX = location.getX();
        int currentY = location.getY();
        return SetLocation(currentX + x, currentY + y);
    }

}