package HW_2;

import java.util.Scanner;

public class B_02_08 {
    static int counter(int[] arr){
        int counter = 0;

        for (int i = 0; i < arr.length - 1; i++){
            if (arr[i] == 0 || arr[i + 1] == 0) continue;
            if (arr[i] * arr[i + 1] < 0)
                counter++;
        }
        return counter;
    }
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++){
            arr[i] = in.nextInt();
        }

        System.out.println(counter(arr));
        in.close();
    }
}
