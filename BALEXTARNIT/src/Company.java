class Company {
    private String name;

    public Company(String name) {
        this.name = name;
    }

    public boolean scheduleVehicle(Passenger passenger, Location pickupLocation, Location destinationLocation, int seatsRequired) {
        boolean success = Math.random() > 0.3;

        if (success) {
            System.out.println(name + ": Successfully scheduled a vehicle for " + passenger +
                               " from " + pickupLocation + " to " + destinationLocation +
                               " (Seats: " + seatsRequired + ")");
        } else {
            System.out.println(name + ": Failed to schedule a vehicle for " + passenger +
                               " from " + pickupLocation + ". No vehicles available!");
        }
        return success;
    }
}
