package HW_12;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class B12_01 {

    public static String solve(Scanner sc) {
        String directionLine = readNonEmptyLine(sc);
        if (directionLine == null) {
            return "NO";
        }
        String direction = directionLine.trim().toLowerCase();

        String requiredLine = readNonEmptyLine(sc);
        if (requiredLine == null) {
            return "NO";
        }
        int requiredCredits = Integer.parseInt(requiredLine.trim());

        String moneyLine = readNonEmptyLine(sc);
        if (moneyLine == null) {
            return "NO";
        }
        int initialMoney = Integer.parseInt(moneyLine.trim());

        Student student = StudentFactory.createStudent(direction, requiredCredits, initialMoney);

        // подальші команди
        while (sc.hasNextLine()) {
            String line = sc.nextLine().trim();
            if (line.isEmpty()) {
                continue;
            }

            String[] parts = line.split("\\s+");
            if (parts.length < 2) {
                continue;
            }

            String cmd = parts[0];

            if ("teach".equals(cmd)) {
                if (parts.length < 3) continue;
                String type = parts[1];
                int credits = Integer.parseInt(parts[2]);

                StudentVisitor visitor;
                if ("humanitarian".equals(type)) {
                    visitor = new TeachHumanitarianVisitor(credits);
                } else if ("natural".equals(type)) {
                    visitor = new TeachNaturalVisitor(credits);
                } else {
                    continue;
                }
                student.accept(visitor);

            } else if ("obtain".equals(cmd)) {
                if (parts.length < 3) continue;
                String what = parts[1];
                int amount = Integer.parseInt(parts[2]);

                StudentVisitor visitor;
                if ("scholarship".equals(what)) {
                    visitor = new ScholarshipVisitor(amount);
                } else if ("help".equals(what)) {
                    visitor = new HelpVisitor(amount);
                } else {
                    continue;
                }
                student.accept(visitor);

            } else if ("pay".equals(cmd)) {
                if (parts.length < 3) continue;
                String where = parts[1];
                int amount = Integer.parseInt(parts[2]);

                StudentVisitor visitor;
                if ("hostel".equals(where)) {
                    visitor = new PayHostelVisitor(amount);
                } else if ("canteen".equals(where)) {
                    visitor = new PayCanteenVisitor(amount);
                } else {
                    continue;
                }
                student.accept(visitor);
            }
        }

        if (!student.isExpelled() && student.getCredits() >= student.getRequiredCredits()) {
            return "YES";
        } else {
            return "NO";
        }
    }

    private static String readNonEmptyLine(Scanner sc) {
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            if (!line.trim().isEmpty()) {
                return line;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        System.out.println("Введіть шлях до папки з input-файлами (наприклад: src/HW_12):");
        String dirPath = console.nextLine().trim();
        console.close();

        File dir = new File(dirPath);
        if (!dir.isDirectory()) {
            System.out.println("Неправильна папка: " + dirPath);
            return;
        }

        for (int i = 1; i <= 14; i++) {
            String inName = String.format("input%02d.txt", i);
            String outName = String.format("output%02d.txt", i);

            File inFile = new File(dir, inName);
            File outFile = new File(dir, outName);

            if (!inFile.isFile()) {
                System.out.println("Файл " + inFile.getPath() + " не знайдено, пропускаю.");
                continue;
            }

            try (Scanner fileScanner = new Scanner(inFile);
                 PrintWriter out = new PrintWriter(outFile)) {

                String answer = solve(fileScanner);
                out.println(answer);

                System.out.println(inName + " -> " + outName + " : " + answer);
            } catch (FileNotFoundException e) {
                System.out.println("Помилка з файлом: " + e.getMessage());
            }
        }

        System.out.println("Готово. Перевірте outputNN.txt у папці " + dir.getPath());
    }
}