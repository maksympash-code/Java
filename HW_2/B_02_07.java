package HW_2;

import java.util.Scanner;

public class B_02_07 {
    static float avarage(int[] arr){
        float avarage = 0;

        for (int v: arr){
            avarage += v;
        }
        return avarage / arr.length;
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        System.out.print("Enter n: ");
        int n = in.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++){
            arr[i] = in.nextInt();
        }

        float avarage = avarage(arr);
        for (int i = 0; i < n; i++){
            if (arr[i] - avarage < 0)
                arr[i] = (int) (avarage - arr[i]);
            else
                arr[i] = (int) (arr[i] - avarage);
        }

        for (int v: arr)
            System.out.print(v + " ");
        in.close();
    }
}
