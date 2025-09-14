package HW_2;

import java.util.Scanner;

public class B_02_05 {

    static float average (float[] arr){
        float sum = 0;

        for (float v : arr) {
            sum += v;
        }
        return sum / arr.length;
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        float[] arr = new float[n];

        for (int i = 0; i < n; i++){
            arr[i] = in.nextFloat();
        }

        System.out.println(average(arr));
        in.close();
    }
}
