package HW_6;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class B06_02 {
    public static void main(String[] args) {
        String text = """
                Call me at +380(67)-123-4567 or 0671234567.
                Also reachable via (050)123-45-67 or 050-765-43-21.
                My office: +380 44 123 45 67, home: 380931234567.
                """;

        String regex = "\\+?\\d{1,3}?[-\\s.]?\\(?\\d{2,3}\\)?[-\\s.]?\\d{2,3}[-\\s.]?\\d{2}[-\\s.]?\\d{2}";

        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(text);

        System.out.println("Знайдені номери телефонів:");
        while (m.find()) {
            System.out.println(m.group());
        }
    }
}

