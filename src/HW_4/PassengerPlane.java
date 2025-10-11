package HW_4;

// Пасажирський літак
public class PassengerPlane extends Aircraft {

    public PassengerPlane() { }

    public PassengerPlane(String model, int rangeKm, int seats) {
        super(model, rangeKm, seats, 0);
    }

    public PassengerPlane(PassengerPlane other) {
        this(other.getModel(), other.getRangeKm(), other.getCapacity());
    }

    @Override
    public double fuelPer100km() {
        return 2500 + 3.5 * getCapacity();
    }
}
