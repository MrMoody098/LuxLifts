package App.Map;

import java.util.Objects;

public class Location  {
    private int x;
    private int y;
    public String name;

    public Location(int x, int y) {
        this.x = x;
        this.y = y;

    }
    public Location(int x,int y,String name){
        this.x = x;
        this.y = y;
        this.name = name;
    }
    public String getName(){return name;}
    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public Location getLocation(){
        return this;
    }
    
     @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Location location = (Location) obj;
        return x == location.x && y == location.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }

}

