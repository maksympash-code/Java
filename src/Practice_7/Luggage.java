package Practice_7;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Luggage implements Serializable {

    @Serial
    private final static long serialVersionUID = 1;

    public String name;
    public int count;
    public double weight;

    Luggage(String name, int count, double weight) {
        this.name = name;
        this.count = count;
        this.weight = weight;
    }

    public static void write(String out, List<Luggage> lst) {
        try {
            var f = new ObjectOutputStream(
                    new FileOutputStream(out)
            );

            for (var luggage: lst)
                f.writeObject(luggage);

            f.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static List<Luggage> read(String inp) {
        List<Luggage> lst = new ArrayList<>();

        try {
            var f = new ObjectInputStream(
                    new FileInputStream(inp)
            );

            while (true) {
                try {
                    lst.add((Luggage) f.readObject());
                } catch (EOFException | ClassNotFoundException e) {
                    break;
                }
            }

            f.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return lst;
    }

}
