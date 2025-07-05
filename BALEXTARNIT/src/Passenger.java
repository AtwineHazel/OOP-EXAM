class Passenger {
    private static int nextId = 1;
    private int passengerId;

    public Passenger() {
        this.passengerId = nextId++;
    }

    public int getPassengerId() {
        return passengerId;
    }

    @Override
    public String toString() {
        return "Passenger-" + passengerId;
    }
}