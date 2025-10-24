package Practice_7;

import java.io.*;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;

public class A07_01 {

    public static void main(String[] args) {
        String inp = "src/Practice_7/input.bin";
        String out = "src/Practice_7/output.bin";

        int[] arr = {65, 0, 1, 2, -1, 876, 234};

//        write(inp, arr);
        arr = read(inp);
        System.out.println(Arrays.toString(arr));

        var lst = new ArrayList<Integer>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 0)
                lst.add(i);
        }

        write(out, lst);

    }

    public static int[] read(String inp){
        int[] result;
        try {
            var f_inp = new DataInputStream(
                    new FileInputStream(inp)
            );
            int count = (int) new File(inp).length() / Integer.BYTES;
            result = new int[count];

            for (int i = 0; i < count; i++) {
                result[i] = f_inp.readInt();
            }

            f_inp.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return result;
    }

    public static void write(String out, ArrayList<Integer> lst){
        try {
            var f_out = new DataOutputStream(
                    new FileOutputStream(out)
            );

            for (int n : lst)
                f_out.writeInt(n);

            f_out.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static int[] readWithByteBuffer(String inp) {
        int[] result;
        try {
            var f_inp = new FileInputStream(inp);
            ByteBuffer bb = ByteBuffer.wrap(f_inp.readAllBytes());
            result = new int[bb.capacity() / Integer.BYTES];

            for (int i = 0; i < result.length; i++) {
                result[i] = bb.getInt();
            }

            f_inp.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return result;
    }

    public static void writeWithByteBuffer(String out, ArrayList<Integer> lst) {
        try {
            var f_out = new FileOutputStream(out);
            ByteBuffer bb = ByteBuffer.allocate(lst.size() * Integer.BYTES);

            for (int n : lst)
                bb.putInt(n);

            f_out.write(bb.array());
            f_out.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
