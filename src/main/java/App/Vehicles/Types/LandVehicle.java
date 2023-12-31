package App.Vehicles.Types;

import App.Map.CustomMap;
import App.Map.Location;
import App.Vehicles.Vehicle;

import java.io.IOException;

public class LandVehicle extends Vehicle {
        private static int[] surrogates = {0x1F695};
        //
        public static String taxi = new String(surrogates, 0, surrogates.length);
    // Constructor
    public LandVehicle(String registrationNumber, double driverRating, String driverName, String phoneNumber, Location location) {
        super(registrationNumber, driverRating, driverName, phoneNumber, location);
    }

    // MoveTo method to navigate the land vehicle to a destination on the map
    @Override
    public Location MoveTo(Location destination, CustomMap customMap) throws InterruptedException, IOException {
        // Display the initial state of the map
        customMap.addElement(this, "V");
        customMap.displayMap();
        Thread.sleep(1000);

        // Move on the X axis towards the destination first
        while (GetLocation().getX() != destination.getX()) {
            Thread.sleep(1000);
            customMap.addElement(this,"V");
            System.out.println("MyX:" + GetLocation().getX() + " MyY:" + GetLocation().getY());
            int MyX = GetLocation().getX();
            int destinationX = destination.getX();

            // Increment MyX b 1 by if smaller than the destination X
            if (GetLocation().getX() < destination.getX()) {
                this.SetLocation(GetLocation().getX() + 1, GetLocation().getY());
            } else if (GetLocation().getX() > destination.getX()) {
                // Decrement MyX by 1 if bigger than the destination X
                this.SetLocation(GetLocation().getX() - 1, GetLocation().getY());
            }
            customMap.displayMap();
        }
        // Move on the Y axis towards the destination second
        while (GetLocation().getY() != destination.getY()) {
            customMap.addElement(this,taxi);
            int MyY = GetLocation().getY();
            int destinationY = destination.getY();
            System.out.println("MyX:" + GetLocation().getX() + " MyY:" + MyY);

            // Increment MyY by 1 if smaller than the destination Y
            if (MyY < destinationY) {
                this.SetLocation(this.GetLocation().getX(), MyY + 1);
            } else if (MyY > destinationY) {
                // Decrement MyY by 1 if bigger than the destination Y
                this.SetLocation(this.GetLocation().getX(), MyY - 1);
            }
            Thread.sleep(1000);

            customMap.displayMap();
        }
        Thread.sleep(1000);

        // Display the updated position on the map
        customMap.displayMap();

        return GetLocation();  // Return the final location
    }
}
