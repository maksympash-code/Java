package Practice_6;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class A06_04 {
    public static void main(String[] args) throws IOException {
        String DATE1 = "(?<d1>\\d{1,2})\\.(?<m1>\\d{1,2}).(?<y1>\\d{4})";
        String DATE2 = "(?<m2>\\d{1,2})-(?<d2>\\d{1,2})-(?<y2>\\d{4})";
        String DATE3 = "(?<y3>\\d{4})/(?<m3>\\d{1,2})/(?<d3>\\d{1,2})";

        String DATE = DATE1 + "|" + DATE2 + "|" + DATE3;

        String s = Files.readString(Path.of("src/Practice_6/input.txt"));

        Pattern p = Pattern.compile(DATE);
        Matcher m = p.matcher(s);

        String res = m.replaceAll(match -> replace((Matcher) match));
        System.out.println(res);

    }

    public static String replace(Matcher m){
        String date = m.group();
        String day, month, year;

        if (date.contains(".")){
            day = m.group("d1");
            month = m.group("m1");
            year = m.group("y1");
        }
        else if (date.contains("-")){
            day = m.group("d2");
            month = m.group("m2");
            year = m.group("y2");
        }
        else {
            day = m.group("d3");
            month = m.group("m3");
            year = m.group("y3");
        }

        if (day.length() < 2) day = "0" + day;
        if (month.length() < 2) month = "0" + month;

        date = day + "." + month + "." + year;

        return date;
    }
}
