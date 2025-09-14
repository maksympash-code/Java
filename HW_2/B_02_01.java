package HW_2;

import java.util.Scanner;

public class B_02_01 {

    static float minArray(float[] arr){
        float minArray = arr[0];

        for (int i = 1; i < arr.length; i++){
            if (arr[i] < minArray)
                minArray = arr[i];
        }
        return minArray;
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int n = in.nextInt();
        float[] arr = new float[n];

        for (int i = 0; i < n; i++){
            arr[i] = in.nextFloat();
        }

        System.out.println("Min = " + minArray(arr));
        in.close();
    }
}
