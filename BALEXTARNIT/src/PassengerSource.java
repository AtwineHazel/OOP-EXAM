
public class PassengerSource {
    private Company company;

    public PassengerSource(Company company) {
        this.company = company;
        System.out.println("PassengerSource created, connected to " + company.getClass().getSimpleName() + ".");
    }

    public boolean requestPickup() {
        Passenger newPassenger = new Passenger();
        System.out.println("\n" + newPassenger + " is requesting a pickup...");

        Location pickupLocation = new Location((int)(Math.random() * 101), (int)(Math.random() * 101));
        Location destinationLocation = new Location((int)(Math.random() * 101), (int)(Math.random() * 101));

        System.out.println("  Pickup Location: " + pickupLocation);
        System.out.println("  Destination Location: " + destinationLocation);

        boolean success = company.scheduleVehicle(newPassenger, pickupLocation, destinationLocation, 1);

        return success;
    }

    public static void main(String[] args) {
        Company balextranit = new Company("BALEXTRANIT (U) LTD");

        PassengerSource individualCaller = new PassengerSource(balextranit);

        System.out.println("\n--- First Request ---");
        boolean request1Success = individualCaller.requestPickup();
        System.out.println("Request 1 Status: " + (request1Success ? "Scheduled!" : "Lost fare."));

        System.out.println("\n--- Second Request ---");
        boolean request2Success = individualCaller.requestPickup();
        System.out.println("Request 2 Status: " + (request2Success ? "Scheduled!" : "Lost fare."));

        System.out.println("\n--- Third Request ---");
        boolean request3Success = individualCaller.requestPickup();
        System.out.println("Request 3 Status: " + (request3Success ? "Scheduled!" : "Lost fare."));

        System.out.println("\n--- Fourth Request ---");
        boolean request4Success = individualCaller.requestPickup();
        System.out.println("Request 4 Status: " + (request4Success ? "Scheduled!" : "Lost fare."));
    }
}
