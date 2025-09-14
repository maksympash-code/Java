package HW_2;

import java.util.Scanner;

public class B_02_16 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter two numbers(short type): ");
        short n1 = in.nextShort();
        short n2 = in.nextShort();

        int value1 = n1 & 0xFFFF;
        int value2 = n2 & 0xFFFF;

        int counter = 0;
        for (int i = 0; i < 16; i++) {
            int bit1 = (value1 >> i) & 1;
            int bit2 = (value2 >> i) & 1;
            if (bit1 == bit2)
                counter++;
        }

        System.out.println(counter);
        in.close();
    }
}

