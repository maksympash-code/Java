package HW_5;

import java.util.Scanner;

public class B05_01 {
    public static boolean isValid(String s) {
        boolean inside = false;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                if (inside)
                    return false;
                inside = true;
            }
            else if (ch == ')') {
                if (!inside)
                    return false;
                inside = false;
            }
        }
        return !inside;
    }

    public static String removeParenthesized(String s) {
        StringBuilder out = new StringBuilder(s.length());
        boolean inside = false;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') { inside = true; continue; }
            if (ch == ')') { inside = false; continue; }
            if (!inside) out.append(ch);
        }
        return out.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();

        if (!isValid(line)) {
            System.out.println("Дужки розставлені неправильно");
            return;
        }
        System.out.println(removeParenthesized(line));
    }
}
