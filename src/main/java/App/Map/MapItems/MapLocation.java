package App.Map.MapItems;

import App.Map.CustomMap;
import App.Map.Location;
import App.Map.MapItems.MapItem;

import java.io.FileNotFoundException;

public class MapLocation  implements MapItem {
    public Location location;
    public String name;
    public MapLocation(Location location,String Name){
        this.location = location;
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    @Override
    public Location SetLocation(int x, int y) {
        return this.location = new Location(x,y);
    }

    @Override
    public Location GetLocation() {
        return this.location;
    }

    @Override
    public Location UpdateLocation(int x, int y) {
        SetLocation(location.getY()+x, location.getY()+y);
        return this.location;
    }

    @Override
    public Location MoveTo(Location destination, CustomMap customMap) throws FileNotFoundException {
        return null;
    }
}
