package Practice_2;

import java.util.Scanner;

public class A_02_03 {
    static long recursiveFib(int n){
        if (n <= 1) return 1;
        return recursiveFib(n - 1) + recursiveFib(n - 2);
    }

    static long iterativeFib (int n){
        if (n <= 1) return 1;
        long prev = 0;
        long curr = 1;
        for (int i = 2; i <= n; i++){
            long temp = curr + prev;
            prev = curr;
            curr = temp;
        }
        return curr;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter n: ");
        int n = in.nextInt();

        System.out.println("Recursive: " + recursiveFib(n));
        System.out.println("Iterative: " + iterativeFib(n));
    }
}
