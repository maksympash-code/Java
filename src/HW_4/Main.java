package HW_4;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Airline company = new Airline();

        company.add(new PassengerPlane("Boeing-737", 3500, 160));
        company.add(new PassengerPlane("A320",       3200, 150));
        company.add(new CargoPlane("AN-124",         4800, 120000));
        company.add(new CargoPlane("Boeing-747F",    7200, 137000));
        company.add(new PassengerPlane("Embraer-190",2800, 100));

        System.out.println("=== Флот компанії ===");
        company.getFleet().forEach(System.out::println);

        System.out.println("\nЗагальна місткість: " + company.totalCapacity() + " місць");
        System.out.println("Загальна вантажопідйомність: " + company.totalPayloadKg() + " кг");

        System.out.println("\n=== Сортування за дальністю (зрост.) ===");
        company.sortByRange();
        company.getFleet().forEach(System.out::println);

        System.out.println("\n=== Літаки з витратою пального у діапазоні [2600; 8000] л/100км ===");
        List<Aircraft> byFuel = company.findByFuelConsumption(2600, 8000);
        byFuel.forEach(System.out::println);
    }
}

