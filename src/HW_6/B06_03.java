package HW_6;

import java.util.regex.Pattern;

public class B06_03 {
    public static void main(String[] args) {
        String expr1 = "+2 - 57*33 + 25 / -4";   // true
        String expr2 = "2 + * 3";                // false
        String expr3 = "-15/ 5 + 10 - -7";       // true
        String expr4 = "25 +";                   // false

        System.out.println(expr1 + " → " + isValid(expr1));
        System.out.println(expr2 + " → " + isValid(expr2));
        System.out.println(expr3 + " → " + isValid(expr3));
        System.out.println(expr4 + " → " + isValid(expr4));
    }

    public static boolean isValid(String expr) {
        expr = expr.trim();

        String regex = "^[+-]?\\d+(\\s*[*/+\\-]\\s*[+-]?\\d+)*$";

        return Pattern.matches(regex, expr);
    }
}

