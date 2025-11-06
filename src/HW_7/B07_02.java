package HW_7;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class B07_02 {

    public static void main(String[] args) {
        String fileAll = "src/HW_7/toys.dat";
        String fileFiltered = "src/HW_7/filtered_toys.dat";
        int childAge = 5;

        List<Toy> toys = new ArrayList<>();
        toys.add(new Toy("М'яч", 150.0, 3, 10));
        toys.add(new Toy("Конструктор LEGO", 950.0, 6, 14));
        toys.add(new Toy("Лялька Барбі", 400.0, 4, 9));
        toys.add(new Toy("Пазл", 120.0, 5, 12));
        toys.add(new Toy("Брязкальце", 80.0, 0, 2));

        writeToys(fileAll, toys);

        List<Toy> loaded = readToys(fileAll);
        System.out.println("Зчитано з файлу:");
        loaded.forEach(System.out::println);

        List<Toy> suitable = filterByAge(loaded, childAge);

        writeToys(fileFiltered, suitable);
        System.out.println("\nПідходять для віку " + childAge + " років:");
        suitable.forEach(System.out::println);
    }

    public static void writeToys(String fileName, List<Toy> toys) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName))) {
            out.writeObject(toys);
        } catch (IOException e) {
            System.err.println("Помилка запису: " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    public static List<Toy> readToys(String fileName) {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileName))) {
            return (List<Toy>) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Помилка читання: " + e.getMessage());
            return new ArrayList<>();
        }
    }

    public static List<Toy> filterByAge(List<Toy> toys, int age) {
        List<Toy> result = new ArrayList<>();
        for (Toy t : toys) {
            if (age >= t.getMinAge() && age <= t.getMaxAge()) {
                result.add(t);
            }
        }
        return result;
    }
}

class Toy implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private final String name;
    private final double price;
    private final int minAge;
    private final int maxAge;

    public Toy(String name, double price, int minAge, int maxAge) {
        this.name = name;
        this.price = price;
        this.minAge = minAge;
        this.maxAge = maxAge;
    }

    public String getName() { return name; }
    public double getPrice() { return price; }
    public int getMinAge() { return minAge; }
    public int getMaxAge() { return maxAge; }

    @Override
    public String toString() {
        return String.format("Toy{name='%s', price=%.2f, age=%d-%d}", name, price, minAge, maxAge);
    }
}

