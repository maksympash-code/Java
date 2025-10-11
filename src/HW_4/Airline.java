package HW_4;

import java.util.*;
import java.util.stream.Collectors;

// Авіакомпанія: зберігає флот і надає агрегати/пошук/сортування
public class Airline {
    private final List<Aircraft> fleet = new ArrayList<>();

    public void add(Aircraft a) { fleet.add(a); }
    public List<Aircraft> getFleet() { return Collections.unmodifiableList(fleet); }

    public int totalCapacity() {
        return fleet.stream().mapToInt(Aircraft::getCapacity).sum();
    }

    public int totalPayloadKg() {
        return fleet.stream().mapToInt(Aircraft::getPayloadKg).sum();
    }

    public void sortByRange() {
        Collections.sort(fleet); // використовує Comparable
    }

    public List<Aircraft> findByFuelConsumption(double min, double max) {
        return fleet.stream()
                .filter(a -> {
                    double f = a.fuelPer100km();
                    return f >= min && f <= max;
                })
                .collect(Collectors.toList());
    }
}

