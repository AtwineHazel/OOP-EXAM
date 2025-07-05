import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CompanyTest {

    @Test
    void testScheduleVehicleSuccess() {
        Company balextranit = new Company("BALEXTRANIT (U) LTD");
        Passenger testPassenger = new Passenger();
        Location pickup = new Location(10, 20);
        Location destination = new Location(50, 60);
        int seats = 1;

        boolean successFound = false;

        for (int i = 0; i < 10; i++) {
            boolean result = balextranit.scheduleVehicle(testPassenger, pickup, destination, seats);
            if (result) {
                successFound = true;
                break;
            }
        }

        assertTrue(successFound, "scheduleVehicle should sometimes return true for success.");
    }

    @Test
    void testScheduleVehicleFailure() {
        Company balextranit = new Company("BALEXTRANIT (U) LTD");
        Passenger testPassenger = new Passenger();
        Location pickup = new Location(10, 20);
        Location destination = new Location(50, 60);
        int seats = 1;

        boolean failureFound = false;

        for (int i = 0; i < 10; i++) {
            boolean result = balextranit.scheduleVehicle(testPassenger, pickup, destination, seats);
            if (!result) {
                failureFound = true;
                break;
            }
        }

        assertTrue(failureFound, "scheduleVehicle should sometimes return false for failure.");
    }
}
