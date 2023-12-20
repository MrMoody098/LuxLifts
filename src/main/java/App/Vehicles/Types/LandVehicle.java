package App.Vehicles.Types;

import App.Map.CustomMap;
import App.Map.Location;

import App.Vehicles.Vehicle;

public class LandVehicle extends Vehicle {
    public LandVehicle(String registrationNumber, double driverRating, String driverName, String phoneNumber, Location location) {
        super(registrationNumber, driverRating, driverName, phoneNumber, location);
    }

    @Override
    public Location MoveTo(Location destination, CustomMap customMap) {

            while (GetLocation().getX() != destination.getX() || GetLocation().getX() != destination.getY()) {
                if (GetLocation().equals(destination)) {
                    System.out.println("Already at the destination.");
                }
                customMap.addElement(this, "V");
                customMap.displayMap();

                //Loop MoveOn X axis towards destination
                while (GetLocation().getX() != destination.getX()) {
                    System.out.println("MyX:" + GetLocation().getX() + " MyY:" + GetLocation().getY());

                    //If MyX is smaller than the destination X Increment MyX by 1
                    if (GetLocation().getX() < destination.getX()) {
                        SetLocation(GetLocation().getX() + 1, GetLocation().getY());
                    }
                    //else if Myx is bigger than the destination X Decrement Myx by 1
                    else if (GetLocation().getX() > destination.getX()) {
                        SetLocation(GetLocation().getX() - 1, GetLocation().getY());
                    }

                }
                //Loop MoveOn Y axis towards destination

                while (GetLocation().getY() != destination.getY()) {
                    System.out.println("MyX:" + GetLocation().getX() + " MyY:" + GetLocation().getY());
                    //If MyY is smaller than the destination Increment: MyY by 1
                    if (GetLocation().getY() < destination.getY()) {
                        SetLocation(GetLocation().getX(), GetLocation().getY() + 1);
                    }

                    //else if myy is bigger than th destination Y Decrement: Mby by 1
                    else if (GetLocation().getY() > destination.getY()) {
                        SetLocation(GetLocation().getX(), GetLocation().getY() - 1);
                    }
                }
                //display updated position
                customMap.displayMap();

            }
            return GetLocation();
        }
    }

