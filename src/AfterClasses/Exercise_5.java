package AfterClasses;

import java.util.Scanner;

public class Exercise_5 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++){
            arr[i] = in.nextInt();
        }

        int max = arr[0];
        for (int i = 1; i < n; i++){
            if (arr[i] > max)
                max = arr[i];
        }

        int min = arr[0];
        for (int i = 1; i < n; i++){
            if (arr[i] < min)
                min = arr[i];
        }

        int sum = 0;
        for (int i = 0; i < n; i++){
            sum += arr[i];
        }

        System.out.println("Max = " + max);
        System.out.println("Min = " + min);
        System.out.println("Avarage = " + sum / n);


        in.close();
    }
}
