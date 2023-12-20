package App.Map.MapItems;

import App.Map.CustomMap;
import App.Map.Location;

import java.io.FileNotFoundException;

public class Water implements MapItem {
    public Location location;

    public Water(Location location) {
        this.location = location;
    }

    @Override
    public Location SetLocation(int x, int y) {
        return this.location = new Location(x, y);
    }

    @Override
    public Location GetLocation() {
        return this.location;
    }

    @Override
    public Location UpdateLocation(int x, int y) {
        SetLocation(location.getY() + x, location.getY() + y);
        return this.location;
    }

    @Override
    public Location MoveTo(Location destination, CustomMap customMap) throws FileNotFoundException {
        return null;
    }


}
