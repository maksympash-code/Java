package Practice_5;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Scanner;


public class A05_03 {
    public static void main(String[] args) {

        a("input.txt", "output_a.txt");
        b("input.txt", "output_b.txt");
        c("input.txt", "output_c.txt");

    }


    public static void a(String input, String output) {

        try {
            FileReader fr = new FileReader(input);
//            BufferedReader br = new BufferedReader(fr);
            Scanner sc = new Scanner(fr);

            String longestWord = "";
            while (sc.hasNext()) {
                String word = sc.next();
                if (word.length() > longestWord.length())
                    longestWord = word;
            }

            FileWriter fw = new FileWriter(output);
            PrintWriter pw = new PrintWriter(fw);

            pw.print(longestWord);

            sc.close();
            pw.close();
        } catch (java.io.IOException e) {
            System.err.println(e);
        }
    }


    public static void b(String input, String output) {
        File fileIpn = new File(input);
        File fileOut = new File(output);
        Path pathInp = fileIpn.toPath();
        Path pathOut = fileOut.toPath();

        try {
            BufferedReader br = Files.newBufferedReader(pathInp);

            int count = 0;
            while (true) {
                String line = br.readLine();
                if (line == null) {
                    break;
                }
                String[] arr = line.split("\\s+");
                count += arr.length;
            }

            br.close();

            BufferedWriter bw = Files.newBufferedWriter(pathOut);
            bw.write(Integer.toString(count));
            bw.close();

        } catch (IOException e) {
            System.err.println(e);
        }
    }


    public  static void c(String input, String output) {
        Path pathInp = Path.of(input);
        Path pathOut = Path.of(output);

        try {
            List<String> lst = Files.readAllLines(pathInp);
            for (int i = 0; i < lst.size(); i++) {
                String line = lst.get(i).trim().replaceAll("\\s+", " ");
                lst.set(i, line);
            }

            Files.write(pathOut, lst);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
