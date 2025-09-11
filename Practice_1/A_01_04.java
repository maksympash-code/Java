import java.util.Locale;
import java.util.Scanner;

public class A_01_04 {
    public static void main(String[] args){
        Locale.setDefault(Locale.US);

        Scanner in = new Scanner(System.in);
        System.out.print("Enter a double number: ");

        double num = in.nextDouble();

        System.out.println((int) num);
        System.out.println(num - (int) num);

        in.close();
    }
}
