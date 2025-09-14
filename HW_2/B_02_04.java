package HW_2;

import java.util.Scanner;

public class B_02_04 {

    static int vectorAdd(int[] vector1, int[] vector2){
        int sum = 0;

        for (int i = 0; i < vector1.length; i++){
            sum += vector1[i] * vector2[i];
        }

        return sum;
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        System.out.print("Enter n: ");
        int n = in.nextInt();
        int[] vector1 = new int[n];
        int[] vector2 = new int[n];

        for (int i = 0; i < n; i++){
            vector1[i] = in.nextInt();
        }

        for (int i = 0; i < n; i++){
            vector2[i] = in.nextInt();
        }

        System.out.println(vectorAdd(vector1, vector2));
        in.close();
    }
}
