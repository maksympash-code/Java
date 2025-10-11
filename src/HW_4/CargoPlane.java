package HW_4;

//Вантажний літак
public class CargoPlane extends Aircraft {

    public CargoPlane() { }

    public CargoPlane(String model, int rangeKm, int payloadKg) {
        super(model, rangeKm, 0, payloadKg);
    }

    public CargoPlane(CargoPlane other) {
        this(other.getModel(), other.getRangeKm(), other.getPayloadKg());
    }

    @Override
    public double fuelPer100km() {
        return 2200 + 0.08 * getPayloadKg();
    }
}

