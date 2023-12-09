package App.DataTypes;

import App.MapItem;

public class Passenger implements MapItem {
    private String username;
    private Location location;

    public Passenger(String username, Location currentLocation) {
        this.username = username;
        this.location = currentLocation;
    }

    @Override
    public Location SetLocation(int x, int y) {
        //move the Passenger to the new location x,y
        location = new Location(x,y);
        return location;
    }

    @Override
    public Location GetLocation() {
        //return the current location of the Passenger
        return this.location;
    }

    @Override
    public Location UpdateLocation(int x, int y) {
        //move the Passenger x,y amount from their current location
        int CurrentX = location.getX();
        int CurrentY = location.getY();
        return SetLocation(CurrentX + x, CurrentY + y);
    }
}

