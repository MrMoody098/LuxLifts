package App.Vehicles.Types;

import App.Map.CustomMap;
import App.Map.Location;
import App.Vehicles.Vehicle;

import java.io.FileNotFoundException;
import java.io.IOException;

public class AirVehicle extends Vehicle {
    private static int[] surrogates = {0x1F695};
    //
    public static String AirPlane = new String(surrogates, 0, surrogates.length);
    public AirVehicle(String registrationNumber, double driverRating, String driverName, String phoneNumber, Location location) {
        super(registrationNumber, driverRating, driverName, phoneNumber, location);

    }

    @Override
    public Location MoveTo(Location destination, CustomMap customMap) throws IOException, InterruptedException {
        customMap.addElement(this,"@");
        while (GetLocation().getX() != destination.getX() || GetLocation().getY() != destination.getY()) {
            customMap.addElement(this,"@");
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
            System.out.println("");
            Thread.sleep(1000);
        }
        System.out.println("");
        Thread.sleep(1000);
        return GetLocation();
    }
}
