package HW_2;

import java.util.Scanner;

public class B_02_03 {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        System.out.print("Enter n: ");
        int n = in.nextInt();
        System.out.print("Enter a, b: ");
        int a = in.nextInt();
        int b = in.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++){
            arr[i] = in.nextInt();
        }

        for (int i = 0; i < n; i++){
            if (a < b)
                if (arr[i] >= a && arr[i] <= b)
                    System.out.println(arr[i]);
            else
                if (arr[i] >= b && arr[i] <= a)
                    System.out.println(arr[i]);
        }
        in.close();
    }
}
