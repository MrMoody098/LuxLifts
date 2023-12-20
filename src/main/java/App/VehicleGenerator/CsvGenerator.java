package App.VehicleGenerator;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class CsvGenerator {

    

    public static void main(String[] args) {

        String csvFilePath = "LuxLifts/src/main/java/App/VehicleGenerator/Vehicles.csv";

        try (FileWriter csvWriter = new FileWriter(csvFilePath)) {
            // Write header to the CSV file
            csvWriter.append("RegistrationNumber,Type,DriverRating,DriverName,PhoneNumber,Location\n");

            // Generate 10 entries
            for (int i = 0; i < 10; i++) {
                String type = getRandomVehicleType();
                String regNum = generateRegistrationNumber();
                String driverRating = generateDriverRating(); // Updated to return a String
                String driverName = generateDriverName();
                String phoneNumber = generatePhoneNumber();
                int[] location = generateLocation();

                // Write entry to the CSV file
                csvWriter.append(String.format("%s,%s,%s,%s,%s,%s,%s\n",
                        regNum, type, driverRating, driverName, phoneNumber, location[0], location[1]));
            }

            System.out.println("CSV file generated successfully!");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String getRandomVehicleType() {
        String[] allVehicleTypes = {"LIMO", "HELICOPTER", "PRIVATE_JET", "YACHT", "TAXI"};
        String type = allVehicleTypes[new Random().nextInt(allVehicleTypes.length)];
        return type;
    }

    private static String generateRegistrationNumber() {
        // Generate a random registration number
        return "ABC" + new Random().nextInt(1000);
    }

    private static String generateDriverRating() {
        // Generate a String such as {1;3;5;6} that is 4 random doubles seperated by a semicolone  of random driver ratings
        Random random = new Random();
        StringBuilder ratingStringBuilder = new StringBuilder();

        for (int i = 0; i < 4; i++) {
            // Generate a random double between 1 and 5 (adjust the range as needed)
            int randomRating = random.nextInt(5);

            // Append the random rating to the StringBuilder
            ratingStringBuilder.append(randomRating);

            // If it's not the last rating, add a semicolon as a separator
            if (i < 3) {
                ratingStringBuilder.append(";");
            }
        }

        return ratingStringBuilder.toString();
    }

    private static String generateDriverName() {
        // Generate a random driver name (placeholder)
        String[] names = {
                //100 random names to pick from
                "Sophia Adams", "Ethan Baker", "Olivia Carter", "Liam Davis", "Ava Edwards", "Daniel Moody", "Mia the driver"
                
        };
        return names[new Random().nextInt(names.length)];
    }

    private static String generatePhoneNumber() {
        // Generate a random phone number (placeholder)
        return "555-" + String.format("%04d", new Random().nextInt(10000));
    }

    private static int[] generateLocation() {
        // Generate random x, y coordinates within the bounds of a 10x10 grid
        int x = new Random().nextInt(10);
        int y = new Random().nextInt(10);
        return new int[]{x, y};
    }
}
