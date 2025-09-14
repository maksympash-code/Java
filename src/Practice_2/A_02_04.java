package Practice_2;

import java.util.Locale;
import java.util.Scanner;

public class A_02_04 {
    static double ln1pSeries(double x, double eps) {
        if (!(Math.abs(x) < 1.0)) throw new IllegalArgumentException("|x| must be < 1");
        if (eps <= 0)               throw new IllegalArgumentException("eps must be > 0");

        double sum = 0.0;
        int k = 1;
        double term = x;

        while (Math.abs(term) > eps) {
            sum += term;
            k++;
            term = -term * x * (k - 1) / k;
            if (k > 10_000_000) break;
        }
        return sum;
    }

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        try (Scanner in = new Scanner(System.in)) {
            System.out.print("Enter x (|x|<1) and eps (>0): ");
            double x = in.nextDouble();
            double eps = in.nextDouble();

            double approx = ln1pSeries(x, eps);
            double exact = Math.log1p(x);

            System.out.printf("Series sum ≈ %.12f%n", approx);
            System.out.printf("Math.log1p(x)= %.12f%n", exact);
            System.out.printf("Abs error    = %.12e%n", Math.abs(approx - exact));
        }
    }
}
