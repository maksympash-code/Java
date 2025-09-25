package HW_2;

import java.util.Scanner;

public class B_02_17_h {
    static double arctg_x(double x, double eps){
        if (eps <= 0) throw new IllegalArgumentException("eps must be > 0");
        if (Math.abs(x) >= 1) throw new IllegalArgumentException("|x| must be < 1");
        if (x == 0.0) return 0.0;

        double a = x;
        double p = 0.0;
        int k = 0;

        while (Math.abs(a) > eps) {
            p += a;
            k++;
            a = -x * x * (2.0 * k - 1) / (2.0 * k + 1);

            if (k > 50_000_000) throw new IllegalArgumentException("Too large");
        }

        double full = Math.atan(a);
        return full - p;
    }

    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            System.out.print("Enter x (|x|<1) and eps (>0): ");
            double x = in.nextDouble();
            double eps = in.nextDouble();

            double tail = arctg_x(x, eps);
            System.out.printf("Sum of terms with |term| <= eps: %.12f%n", tail);
        }
    }
}
