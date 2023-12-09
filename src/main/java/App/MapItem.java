package App;

import App.DataTypes.Location;

public interface MapItem {

    public Location SetLocation(int x ,int y);

    public Location GetLocation();

    public Location UpdateLocation(int x,int y);

}
