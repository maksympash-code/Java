package HW_5;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class B05_10 {
    public static void main(String[] args) throws IOException {
        List<String> lines = Files.readAllLines(Path.of("src/HW_5/input.txt"));
        List<Fruit> fruits = new ArrayList<>();

        for (String line : lines) {
            String[] parts = line.trim().split("\\s+");
            if (parts.length == 3) {
                fruits.add(new Fruit(parts[0], parts[1], parts[2]));
            }
        }

        String targetCountry = "Spain";
        List<Fruit> fromCountry = new ArrayList<>();
        for (Fruit f : fruits) {
            if (f.getCountry().equalsIgnoreCase(targetCountry)) {
                fromCountry.add(f);
            }
        }

        List<String> fromCountryLines = new ArrayList<>();
        for (Fruit f : fromCountry) {
            fromCountryLines.add(f.toString());
        }
        Files.write(Path.of("src/HW_5/from_country.txt"), fromCountryLines);

        Map<String, Integer> typeCount = new LinkedHashMap<>();
        for (Fruit f : fruits) {
            String type = f.getType();
            Integer old = typeCount.get(type);
            if (old == null)
                old = 0;
            typeCount.put(type, old + 1);
        }

        // підготовка рядків для запису
        List<String> countLines = new ArrayList<>();
        for (Map.Entry<String, Integer> e : typeCount.entrySet()) {
            countLines.add(e.getKey() + " " + e.getValue());
        }
        Files.write(Path.of("src/HW_5/type_count.txt"), countLines);

    }
}

class Fruit {
    private final String type;
    private final String variety;
    private final String country;

    public Fruit(String type, String variety, String country) {
        this.type = type;
        this.variety = variety;
        this.country = country;
    }

    public String getType()    { return type; }
    public String getVariety() { return variety; }
    public String getCountry() { return country; }

    @Override
    public String toString() {
        return type + " " + variety + " " + country;
    }
}
