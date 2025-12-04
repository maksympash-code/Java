package HW_11;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.GZIPInputStream;

public class B11_05 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Введіть українську назву міста (наприклад: київ):");
        String city = in.nextLine().trim().toLowerCase();

        city = city.replaceAll("\\s+", "-");

        String url = buildUrl(city);

        System.out.println("URL: " + url);

        String html = getHTML(url);

        if (html == null || html.isEmpty()) {
            System.out.println("Не вдалося завантажити сторінку.");
            return;
        }

        List<String> forecast = parseForecastFromJson(html);

        if (forecast.isEmpty()) {
            System.out.println("Не вдалося знайти прогноз на сторінці.");
        } else {
            String todayDate = forecast.get(0).split(":")[0];
            System.out.println("Поточна дата: " + todayDate);

            System.out.println("Прогноз на 7 днів (мін / макс):");
            for (String line : forecast) {
                System.out.println(line);
            }
        }

        in.close();
    }

    private static String buildUrl(String cityUa) {
        try {
            String path = "погода-" + cityUa;
            String encodedPath = URLEncoder.encode(path, StandardCharsets.UTF_8);
            return "https://ua.sinoptik.ua/" + encodedPath;
        } catch (Exception e) {
            throw new RuntimeException("Помилка кодування URL", e);
        }
    }

    public static List<String> parseForecastFromJson(String html) {
        List<String> result = new ArrayList<>();

        Pattern scriptPattern = Pattern.compile(
                "<script[^>]*id=\"preloaded-state\"[^>]*>(.*?)</script>",
                Pattern.DOTALL
        );
        Matcher scriptMatcher = scriptPattern.matcher(html);

        if (!scriptMatcher.find()) {
            return result;
        }

        String json = scriptMatcher.group(1);

        Pattern dayPattern = Pattern.compile(
                "\\{\\s*\"date\"\\s*:\\s*\"(\\d{4}-\\d{2}-\\d{2})\""
                        + ".*?\"temperature\"\\s*:\\s*\\{\\s*\"min\"\\s*:\\s*(-?\\d+)"
                        + "\\s*,\\s*\"max\"\\s*:\\s*(-?\\d+)",
                Pattern.DOTALL
        );

        Matcher m = dayPattern.matcher(json);
        int count = 0;

        while (m.find() && count < 7) {
            String date = m.group(1);
            String tmin = m.group(2);
            String tmax = m.group(3);

            String line = String.format("%s: min %s, max %s", date, tmin, tmax);
            result.add(line);
            count++;
        }

        return result;
    }


    public static String getHTML(String url) {
        URI uri = URI.create(url);

        HttpClient client = HttpClient.newBuilder()
                .followRedirects(HttpClient.Redirect.NORMAL)
                .build();

        HttpRequest request = HttpRequest.newBuilder(uri)
                .GET()
                .header("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) "
                        + "AppleWebKit/537.36 (KHTML, like Gecko) "
                        + "Chrome/120.0.0.0 Safari/537.36")
                .header("accept-language", "uk-UA,uk;q=0.9")
                .header("accept-encoding", "gzip")
                .build();

        try {
            HttpResponse<byte[]> response =
                    client.send(request, HttpResponse.BodyHandlers.ofByteArray());

            System.out.println("HTTP status: " + response.statusCode());

            if (response.statusCode() != 200) {
                return "";
            }

            byte[] bodyBytes = response.body();

            if (bodyBytes.length >= 2
                    && (bodyBytes[0] == (byte) 0x1f)
                    && (bodyBytes[1] == (byte) 0x8b)) {

                try (GZIPInputStream gis = new GZIPInputStream(new ByteArrayInputStream(bodyBytes));
                     ByteArrayOutputStream baos = new ByteArrayOutputStream()) {

                    byte[] buffer = new byte[8192];
                    int len;
                    while ((len = gis.read(buffer)) != -1) {
                        baos.write(buffer, 0, len);
                    }

                    return baos.toString(StandardCharsets.UTF_8);
                }
            } else {
                return new String(bodyBytes, StandardCharsets.UTF_8);
            }

        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}