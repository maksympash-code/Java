package HW_2;

import java.util.Scanner;

public class B_02_13 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        System.out.print("Enter n: ");
        short n = in.nextShort();

        int value = n & 0xFFFF;

        int first = -1, last = -1;
        for (int i = 0; i < 16; i++){
            if (((value >> i) & 1) == 1){
                if (first == -1) first = i;
                last = i;
            }
        }

        System.out.println("First = " + first);
        System.out.println("Last = " + last);
    }
}
