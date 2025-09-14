package HW_2;

import java.util.Scanner;

public class B_02_09 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        System.out.print("Enter n: ");
        int n = in.nextInt();

        n =  n & 0xFF;

        int result = ((n << 1) & 0xFF ) | ((n >> 7) & 1);
        System.out.println(result);
        in.close();
    }
}
