package HW_11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.time.LocalTime;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class B11_01 {

    private static final String URL =
            "https://www.timeanddate.com/worldclock/ukraine/kyiv";

    private static final Pattern TIME_PATTERN = Pattern.compile(
            "<span\\s+id=ct[^>]*>(\\d{2}:\\d{2}:\\d{2})</span>"
    );

    public static void main(String[] args) {
        try {
            String html = downloadPage(URL);

            String webTimeStr = extractTimeFromHtml(html);
            if (webTimeStr == null) {
                System.out.println("Не вдалося знайти час.");
                return;
            }

            LocalTime webTime = LocalTime.parse(webTimeStr);
            LocalTime localTime = LocalTime.now();

            long diffSeconds = Duration.between(localTime, webTime).getSeconds();
            long absDiff = Math.abs(diffSeconds);

            System.out.println("Час з сайту:      " + webTime);
            System.out.println("Час на комп'ютері: " + localTime);
            System.out.println("Різниця: " + absDiff + " с"
                    + (diffSeconds > 0 ? " (комп'ютер відстає)" :
                    diffSeconds < 0 ? " (комп'ютер поспішає)" : ""));

            if (absDiff <= 5) {
                System.out.println("Збігається");
            } else {
                System.out.println("Не збігається(розбіжність більше 5 секунд).");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static String downloadPage(String urlString) throws IOException {
        URL url = new URL(urlString);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.setRequestProperty("User-Agent", "Java-WebClient-Student/1.0");

        StringBuilder sb = new StringBuilder();

        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(connection.getInputStream()))) {

            String line;
            while ((line = reader.readLine()) != null) {
                sb.append(line).append('\n');
            }
        }

        return sb.toString();
    }

    private static String extractTimeFromHtml(String html) {
        Matcher matcher = TIME_PATTERN.matcher(html);
        if (matcher.find()) {
            return matcher.group(1);
        }
        return null;
    }
}
