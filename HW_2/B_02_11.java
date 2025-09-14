package HW_2;

import java.util.Scanner;

public class B_02_11 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        System.out.print("Enter n: ");
        int n = in.nextInt();
        int bit = in.nextInt();

        n = n & 0xFF;
        int low = n & ((1 << bit) - 1);
        int high = (n >> (bit + 1) << bit);
        int result = low | high;
        System.out.println(result);

        in.close();
    }
}
