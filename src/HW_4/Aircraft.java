package HW_4;

import java.util.Objects;

// Базовий літак. Сортує за дальністю польоту (rangeKm)
public abstract class Aircraft implements Comparable<Aircraft> {
    private String model;
    private int rangeKm;
    private int capacity;
    private int payloadKg;

    public Aircraft() { }

    public Aircraft(String model, int rangeKm, int capacity, int payloadKg) {
        this.model = model;
        this.rangeKm = rangeKm;
        this.capacity = capacity;
        this.payloadKg = payloadKg;
    }

    public Aircraft(Aircraft other) {
        this(other.model, other.rangeKm, other.capacity, other.payloadKg);
    }

    public abstract double fuelPer100km();

    public String getModel() { return model; }
    public void setModel(String model) { this.model = model; }
    public int getRangeKm() { return rangeKm; }
    public void setRangeKm(int rangeKm) { this.rangeKm = rangeKm; }
    public int getCapacity() { return capacity; }
    public void setCapacity(int capacity) { this.capacity = capacity; }
    public int getPayloadKg() { return payloadKg; }
    public void setPayloadKg(int payloadKg) { this.payloadKg = payloadKg; }

    @Override public int compareTo(Aircraft o) {
        return Integer.compare(this.rangeKm, o.rangeKm); // сортування за дальністю
    }

    @Override public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Aircraft a)) return false;
        return rangeKm == a.rangeKm &&
                capacity == a.capacity &&
                payloadKg == a.payloadKg &&
                Objects.equals(model, a.model);
    }

    @Override public String toString() {
        return String.format("%s{range=%dkm, seats=%d, payload=%dkg, fuel/100=%.1f}",
                model, rangeKm, capacity, payloadKg, fuelPer100km());
    }
}

