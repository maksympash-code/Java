package Practice_6;

import java.nio.file.*;
import java.io.IOException;

public class B06_04 {
    public static void main(String[] args) throws IOException {
        String in  = Files.readString(Path.of("src/Practice_6/input.txt"));

        String out = in.replaceAll("(?<!\\d)([+-]?)\\.(\\d+)", "$10.$2");

        out = out.replaceAll("([+-]?\\d+)\\.(?![\\d.])", "$1.0");

        Files.writeString(Path.of("src/Practice_6/output.txt"), out);
    }
}
