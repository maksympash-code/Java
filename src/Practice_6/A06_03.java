package Practice_6;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class A06_03 {
    public static void main(String[] args) throws IOException {
        String s = Files.readString(Path.of("src/Practice_6/input.txt"));

        String rgx = "[A-ZА-ЯІЇҐЄ].*?[.!?](?<![A-ZА-ЯІЇҐЄ.]\\w\\.)(?=\\s|$)";

        Pattern p = Pattern.compile((rgx));
        Matcher m = p.matcher(s);
        while (m.find()){
            System.out.println(m.group());
        }
    }
}
