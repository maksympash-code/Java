package HW_5;

import java.util.Scanner;

public class B05_02 {

    public static boolean propA(String s) {
        if (s.isEmpty())
            return false;

        char first = s.charAt(0);
        if (!Character.isDigit(first) || first == '0')
            return false;

        int letters = 0;

        for (int i = 1; i < s.length(); i++) {
            if (!Character.isLetter(s.charAt(i)))
                return false;
            letters++;
        }

        return letters == (first - '0');
    }

    public static boolean propB(String s) {
        int len = s.length();

        int digitCount = 0, val = -1;

        for (int i = 0; i < len; i++) {
            char ch = s.charAt(i);
            if (Character.isDigit(ch)) {
                digitCount++;
                val = ch - '0';
            }
            else if (!Character.isLetter(ch))
                return false;
        }

        return digitCount == 1 && val == len;
    }

    public static boolean propC(String s) {
        int sum = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (Character.isDigit(ch))
                sum += ch - '0';
            else if (!Character.isLetter(ch))
                return false;
        }

        return sum == s.length();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        System.out.println("a) " + propA(s));
        System.out.println("b) " + propB(s));
        System.out.println("c) " + propC(s));
    }
}

