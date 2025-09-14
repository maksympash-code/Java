package HW_2;

import java.util.Scanner;

public class B_02_10 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter n (0 - 255): ");
        int n = in.nextInt();
        int counter = 0;


        n = n & 0xFF;
        int[] bits = new int[8];
        for (int i = 0; i < 8; i++) {
            bits[7 - i] = (n >> i) & 1;
        }

        for (int i = 0; i < bits.length - 1; i++) {
            if (bits[i] == 1 && bits[i + 1] == 1)
                counter++;
        }

        System.out.println(counter);
        in.close();
    }
}

