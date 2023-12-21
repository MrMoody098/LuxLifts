package App.VehicleGenerator;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

/**
 * The CsvGenerator class generates a CSV file containing vehicle information.
 */
public class CsvGenerator {

    /**
     * The main method that generates the CSV file.
     *
     * @param args Command-line arguments (not used in this application).
     */
    public static void main(String[] args) {

        // Specify the file path for the CSV file
        String csvFilePath = "src/main/java/App/VehicleGenerator/Vehicles.csv";

        try (FileWriter csvWriter = new FileWriter(csvFilePath)) {
            // Write header to the CSV file
            csvWriter.append("RegistrationNumber,Type,DriverRating,DriverName,PhoneNumber,Location\n");

            // Generate 10 entries
            for (int i = 0; i < 10; i++) {
                String type = getRandomVehicleType();
                String regNum = generateRegistrationNumber();
                String driverRating = generateDriverRating();
                String driverName = generateDriverName();
                String phoneNumber = generatePhoneNumber();
                int[] location = generateLocation();
                boolean isAvailable = generateIsAvailable();

                // Write entry to the CSV file
                csvWriter.append(String.format("%s,%s,%s,%s,%s,%s,%s\n",
                        regNum, type, driverRating, driverName, phoneNumber, location[0], location[1]));
            }

            System.out.println("CSV file generated successfully!");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Generates a random vehicle type.
     *
     * @return A random vehicle type.
     */
    private static String getRandomVehicleType() {
        String[] allVehicleTypes = {"LIMO", "HELICOPTER", "PRIVATE_JET", "YACHT", "TAXI"};
        return allVehicleTypes[new Random().nextInt(allVehicleTypes.length)];
    }

    /**
     * Generates a random availability status for a vehicle.
     *
     * @return A random boolean value indicating availability.
     */
    private static boolean generateIsAvailable() {
        return new Random().nextBoolean();
    }

    /**
     * Generates a random registration number for a vehicle.
     *
     * @return A random registration number.
     */
    private static String generateRegistrationNumber() {
        return "ABC" + new Random().nextInt(1000);
    }

    /**
     * Generates a string representation of driver ratings based on four random doubles.
     *
     * @return A string of four driver ratings.
     */
    private static String generateDriverRating() {
        Random random = new Random();
        StringBuilder ratingStringBuilder = new StringBuilder();

        for (int i = 0; i < 4; i++) {
            double randomRating = 1.0 + random.nextDouble() * 4.0;
            ratingStringBuilder.append(randomRating);

            if (i < 3) {
                ratingStringBuilder.append(";");
            }
        }

        return ratingStringBuilder.toString();
    }

    /**
     * Generates a random driver name.
     *
     * @return A random driver name.
     */
    private static String generateDriverName() {
        String[] names = {
                "Sophia Adams", "Ethan Baker", "Olivia Carter", "Liam Davis", "Ava Edwards", "Daniel Moody", "Mia the driver"
        };
        return names[new Random().nextInt(names.length)];
    }

    /**
     * Generates a random phone number.
     *
     * @return A random phone number.
     */
    private static String generatePhoneNumber() {
        return "555-" + String.format("%04d", new Random().nextInt(10000));
    }

    /**
     * Generates random x, y coordinates within the bounds of a 10x10 grid.
     *
     * @return An array representing x and y coordinates.
     */
    private static int[] generateLocation() {
        int x = new Random().nextInt(10);
        int y = new Random().nextInt(10);
        return new int[]{x, y};
    }
}
