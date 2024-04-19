package homeworks.hw1.scooter;

public class ScooterRentalTester {

    public static void main(String[] args) {
        // Create a rental company
        RentalCompany rentalCompany = new RentalCompany();

        // Add a scooter to the rental company's fleet
        Scooter scooter = new Scooter();
        scooter.setModel("Sparrow X10");
        rentalCompany.addScooter(scooter);

        // Rent the scooter
        rentalCompany.rentScooter(scooter.getId());

        // Start location: Home
        double homeX = 41.788399;
        double homeY = 44.818880;

        // Destination location: University
        double universityX = 41.7121106;
        double universityY = 44.7489232;

        // Travel from home to university
        System.out.println("Traveling from home to the university...");
        scooter.setX(universityX);
        scooter.setY(universityY);

        // Leave the scooter at the university
        rentalCompany.returnScooter(scooter.getId(), universityX, universityY);

        // Wait for one hour (simulate time passing)
        try {
            Thread.sleep(3600000); // 1 hour = 3600000 milliseconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Rent the scooter again
        rentalCompany.rentScooter(scooter.getId());

        // Return to home
        System.out.println("Traveling from the university back to home...");
        scooter.setX(homeX);
        scooter.setY(homeY);

        // Leave the scooter near home
        rentalCompany.returnScooter(scooter.getId(), homeX, homeY);

        // Display all scooters to check their status
        System.out.println("All scooters in the fleet:");
        rentalCompany.displayAllScooters();
    }
}
