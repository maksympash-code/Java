package AfterClasses;

import java.util.Scanner;

public class Exercise_1 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        double x = in.nextDouble();

        System.out.println((double) n / x);
        System.out.println(n % (int) x);

        in.close();
    }
}
