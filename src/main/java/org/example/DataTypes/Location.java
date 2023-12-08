package org.example.DataTypes;

public class Location {
    //Represents a location on the map using x and y coordinates.
    int x;
    int y;
    public Location(int x, int y) {
        this.x = x;
        this.y =y;
    }

    public int getX() {
        return this.x;
    }
    public int getY(){
        return this.y;
    }
    public void setX(){
        this.x = x;
    }
    public void setY(){
        this.y = y;
    }
}
