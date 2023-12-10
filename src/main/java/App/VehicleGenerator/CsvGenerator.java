package App.VehicleGenerator;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class CsvGenerator {

    public enum VehicleType {
        LIMO,
        HELICOPTER,
        PRIVATE_JET,
        YACHT,
    }

    public static void main(String[] args) {
        String csvFilePath = "C:\\Users\\ticta\\MyRepos\\LuxLifts\\LuxLifts\\src\\main\\java\\App\\Vehicles\\Vehicles.csv";

        try (FileWriter csvWriter = new FileWriter(csvFilePath)) {
            // Write header to the CSV file
            csvWriter.append("RegistrationNumber,Type,DriverRating,DriverName,PhoneNumber,Location\n");

            // Generate 20 entries
            for (int i = 0; i < 20; i++) {
                VehicleType type = VehicleType.values()[new Random().nextInt(VehicleType.values().length)];
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

    private static String generateRegistrationNumber() {
        // Generate a random registration number
        return "ABC" + new Random().nextInt(1000);
    }

    private static String generateDriverRating() {
        // Generate a comma-separated string of random driver ratings
        return String.format("%d,%d,%d,%d,%d",
                new Random().nextInt(5) + 1,
                new Random().nextInt(5) + 1,
                new Random().nextInt(5) + 1,
                new Random().nextInt(5) + 1,
                new Random().nextInt(5) + 1);
    }

    private static String generateDriverName() {
        // Generate a random driver name (placeholder)
        String[] names = {
                //100 random names to pick from
                "Sophia Adams", "Ethan Baker", "Olivia Carter", "Liam Davis", "Ava Edwards",
                // ... (remaining names)
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
