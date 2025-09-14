package HW_2;

import java.util.Scanner;

public class B_02_12 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        System.out.print("Enter n: ");
        int n = in.nextInt();
        int k = in.nextInt();

        n = n & 0xFF;
        int mask = ~(1 << k);
        int result = n & mask;

        System.out.println(result);
        in.close();
    }
}
