import java.util.Scanner;

public class B_01_04 {
    public static void main(String[] args){

        Scanner in = new Scanner(System.in);
        System.out.print("Enter three numbers: ");

        int num1 = in.nextInt();
        int num2 = in.nextInt();
        int num3 = in.nextInt();

        double mg = Math.cbrt(num1 * num2 * num3);

        System.out.printf("Middle geometry = %.4f", mg);
    }
}
