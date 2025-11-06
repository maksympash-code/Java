package HW_7;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class B07_01 {

    public static void main(String[] args) {
        String fileF = "src/HW_7/F.bin";
        String fileG = "src/HW_7/G.bin";

        double[] numbers = {2.5, -1.2, 4.7, 8.0, 0.5, 3.3};
        double a = 2.0;

        writeToFile(fileF, numbers);

        List<Double> list = readFromFile(fileF);
        System.out.println("F: " + list);

        List<Double> filtered = filter(list, a);
        writeToFile(fileG, filtered);
        System.out.println("G: " + readFromFile(fileG));

    }

    public static void writeToFile(String fileName, double[] arr) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName))) {
            out.writeObject(arr);
        } catch (IOException e) {
            System.err.println("Помилка запису: " + e.getMessage());
        }
    }

    public static void writeToFile(String fileName, List<Double> list) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName))) {
            out.writeObject(list);
        } catch (IOException e) {
            System.err.println("Помилка запису: " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    public static List<Double> readFromFile(String fileName) {
        List<Double> result = new ArrayList<>();
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileName))) {
            Object obj = in.readObject();

            if (obj instanceof double[]) {
                for (double d : (double[]) obj) result.add(d);
            } else if (obj instanceof List) {
                result = (List<Double>) obj;
            }

        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Помилка читання: " + e.getMessage());
        }
        return result;
    }

    public static List<Double> filter(List<Double> arr, double a) {
        List<Double> result = new ArrayList<>();
        for (double num : arr) {
            if (num > a) result.add(num);
        }
        return result;
    }
}

