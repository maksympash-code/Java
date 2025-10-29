package HW_6;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class B06_01 {
    public static void main(String[] args) {
        String text = "Meeting on 26.05.2023 and next deadline __.__.____ or maybe 26.05.2025.";

        String regex = "\\b\\d{2}\\.\\d{2}\\.\\d{4}\\b|__\\.__\\.____";

        String today = LocalDate.now().format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));

        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(text);
        String result = m.replaceAll(today);

        System.out.println(text);
        System.out.println(result);
    }
}

