package Practice_2;

import java.util.Scanner;

public class A_02_02 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter n: ");
        int n = in.nextInt();
        System.out.print("Enter k: ");
        int k = in.nextInt();

        int mask = 1 << k;
        int result = n ^ mask;

        System.out.println("Result = " + result);
        in.close();
    }
}
