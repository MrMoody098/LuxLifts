package App.Map.MapItems;

import App.Map.CustomMap;
import App.Map.Location;

import java.io.FileNotFoundException;

public interface MapItem {
    public Location SetLocation(int x , int y);
    public Location GetLocation();
    public Location UpdateLocation(int x,int y);
    public Location MoveTo(Location destination, CustomMap customMap) throws FileNotFoundException;


}
