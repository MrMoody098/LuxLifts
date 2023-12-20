package App.Vehicles.Types;

import App.Map.CustomMap;
import App.Map.Location;

import App.Vehicles.Vehicle;

import java.io.FileNotFoundException;

public class AirVehicle extends Vehicle {
    public AirVehicle(String registrationNumber, double driverRating, String driverName, String phoneNumber, Location location) {
        super(registrationNumber, driverRating, driverName, phoneNumber, location);

    }

    @Override
    public Location MoveTo(Location destination, CustomMap customMap) throws FileNotFoundException {
        customMap.addElement(this,"V");
        while (GetLocation().getX() != destination.getX() || GetLocation().getY() != destination.getY()) {
            customMap.addElement(this,"V");
            int MyX = GetLocation().getX();
            int MyY = GetLocation().getY();
            int destinationX = destination.getX();
            int destinationY = destination.getY();

            System.out.println("MyX:" + MyX + " MyY:" + MyY);

            //If MyX is smaller than the destination X Increment MyX by 1
            if (MyX < destinationX) {SetLocation(MyX += 1,MyY);}

                //else if Myx is bigger than the destination X Decrement Myx by 1
            else if (MyX > destinationX) {SetLocation(MyX -= 1,MyY);}

            //If MyY is smaller than then destination Y Increment: MyY by 1
            if (MyY < destinationY) {SetLocation(MyX,MyY += 1);}

                //else if myy is bigger than then destination Y Decrement: Mby by 1
            else if (MyY > destinationY) {SetLocation(MyX,MyY -= 1);}

            //display updated position
            customMap.displayMap();
        }
        customMap.displayMap();
        return GetLocation();
    }
}
