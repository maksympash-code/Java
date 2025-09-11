import java.util.Scanner;


public class B_01_05 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        System.out.print("Enter two numbers(N, M): ");

        int N = in.nextInt();
        int M = in.nextInt();

        for (int i = 0; i < N; i++){
            System.out.println((int) (Math.random() * M));
        }

        // for console input
        int args_num1 = Integer.parseInt(args[0]);
        int args_num2 = Integer.parseInt(args[1]);
        for (int i = 0; i < args_num1; i++){
            System.out.println((int) (Math.random() * args_num2));
        }

        in.close();
    }
}
