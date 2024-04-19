package homeworks.hw1.scooter;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a rental company that manages a fleet of scooters.
 */
public class RentalCompany {

    private int uid = 0;

    List<Scooter> scooters = new ArrayList<>();

    /**
     * Retrieves a list of available scooters.
     *
     * @return A list of available scooters.
     */
    public List<Scooter> availableScooters() {
        List<Scooter> result = new ArrayList<>();
        for (Scooter scooter : scooters) {
            if (scooter.isAvailable()) {
                result.add(scooter);
            }
        }
        return result;
    }

    /**
     * Adds a new scooter to the company's fleet.
     *
     * @param scooter The scooter to be added.
     */
    public void addScooter(Scooter scooter) {
        scooter.setId(uid++);
        scooters.add(scooter);
    }

    /**
     * Removes a scooter from the company's fleet.
     *
     * @param id The ID of the scooter to be removed.
     * @return True if the scooter was successfully removed, false otherwise.
     */
    public boolean removeScooter(int id) {
        boolean removed = false;
        for (Scooter scooter : scooters) {
            if (scooter.getId() == id) {
                scooters.remove(scooter);
                removed = true;
                break;
            }
        }
        return removed;
    }

    /**
     * Rents a scooter with the specified ID.
     *
     * @param id The ID of the scooter to be rented.
     */
    public void rentScooter(int id) {
        for (Scooter scooter : scooters) {
            if (scooter.getId() == id && scooter.isAvailable()) {
                scooter.setAvailable(false);
                // Additional logic for rental process can be added here
                return;
            }
        }
        System.out.println("Scooter with ID " + id + " is not available for rent.");
    }

    /**
     * Returns a rented scooter to the rental company.
     *
     * @param id The ID of the scooter to be returned.
     * @param x  The latitude coordinate of the return location.
     * @param y  The longitude coordinate of the return location.
     */
    public void returnScooter(int id, double x, double y) {
        for (Scooter scooter : scooters) {
            if (scooter.getId() == id) {
                scooter.setAvailable(true);
                scooter.setLastKnownLatitude(x);
                scooter.setLastKnownLongitude(y);
                // Additional logic for return process can be added here
                return;
            }
        }
        System.out.println("Scooter with ID " + id + " is not found.");
    }

    /**
     * Displays information about all scooters in the company's fleet.
     */
    public void displayAllScooters() {
        for (Scooter scooter : scooters) {
            System.out.println(scooter.toString());
        }
    }
}
