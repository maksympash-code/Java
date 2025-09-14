package HW_2;

import java.util.Scanner;

public class B_02_14 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        System.out.print("Enter n: ");
        short n = in.nextShort();
        int counter = 0;

        int value = n & 0xFFFF;

        for (int i = 0; i < 16; i++){
            if (((value >> i) & 1) == 1)
                counter++;
        }

        System.out.println(counter);
        in.close();
    }
}
