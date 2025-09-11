import java.util.Locale;
import java.util.Scanner;

public class A_01_05 {
    public static void main(String[] args){
        Locale.setDefault(Locale.US);

        Scanner in = new Scanner(System.in);
        int num1 = in.nextInt();
        int num2 = in.nextInt();

        System.out.println(num1 + ": " + (int) Math.ceil(Math.log10(num1)));
        System.out.println(num2 + ": " + Integer.toString(num2).length());

        double h = 2.0 / ((1.0 / num1) + (1.0 / num2));
        System.out.printf("H = %.2f%n", h);
        in.close();
    }
}
