package Practice_2;

import java.util.Scanner;

public class A_02_01 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int k = in.nextInt();
        int counter = 0;

        int[] arr = new int[k];

        for (int i = 0; i < k; i++)
            arr[i] = in.nextInt();

        for (int i = 0; i < k; i++){
            if (arr[i] % k == 0)
                counter++;
        }

        System.out.println(counter);
    }
}
