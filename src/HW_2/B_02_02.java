package HW_2;

import java.util.Scanner;

public class B_02_02 {
    static float maxArray(float[] arr){
        float maxArray = arr[0];

        for (int i = 1; i < arr.length; i++){
            if (arr[i] > maxArray)
                maxArray = arr[i];
        }
        return maxArray;
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        float[] arr = new float[n];

        for (int i = 0; i < n; i++){
            arr[i] = in.nextFloat();
        }

        System.out.println("Max = " + maxArray(arr));
        in.close();
    }
}
