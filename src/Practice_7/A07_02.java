package Practice_7;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

public class A07_02 {
    public static void main(String[] args) {
        String inp = "src/Practice_7/input.bin";
        String out = "src/Practice_7/output.bin";

        Luggage[] array = {
                new Luggage("John", 10, 500.0),
                new Luggage("James", 1, 5.0),
                new Luggage("Vasya z rayouny", 3, 20.0),
        };


        List<Luggage> lst = List.of(array);

        Luggage.write(inp, lst);

        System.out.println(Luggage.read(inp));
    }


}
