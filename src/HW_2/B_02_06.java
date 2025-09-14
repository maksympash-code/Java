package HW_2;

import java.util.Scanner;

public class B_02_06 {
    static float average_harmonic(float[] arr){
        float sum = 0;

        for (float v: arr){
            sum += 1 / v;
        }

        return arr.length / sum;
    }
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        System.out.print("Enter n: ");
        int n = in.nextInt();
        float[] arr = new float[n];

        for (int i = 0; i < n; i++){
            arr[i] = in.nextFloat();
        }

        System.out.println("Average Harmonic = " + average_harmonic(arr));
        in.close();
    }
}
