package HW_9;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.*;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class B09_01 {

    private static final long T1 = 500;
    private static final long T2 = 800;
    private static final long T3 = 1200;

    public static void main(String[] args) throws InterruptedException {
        Path input = Paths.get("src/HW_9/input.txt");
        Path out1 = Paths.get("src/HW_9/output_worker1.txt");
        Path out2 = Paths.get("src/HW_9/output_worker2.txt");

        BlockingQueue<Job> queue = new LinkedBlockingQueue<>();

        Thread reader = new Thread(new Reader(input, queue, T1), "Reader");
        Thread worker1 = new Thread(new Worker(queue, T2, out1, 1), "Worker-1");
        Thread worker2 = new Thread(new Worker(queue, T3, out2, 2), "Worker-2");

        reader.start();
        worker1.start();
        worker2.start();

        reader.join();
        worker1.join();
        worker2.join();

        System.out.println("Файли: " + out1 + " та " + out2);
    }

    private static class Job {
        final String line;
        final boolean poison;

        Job(String line, boolean poison) {
            this.line = line;
            this.poison = poison;
        }

        static Job poison() {
            return new Job(null, true);
        }
    }

    private static class Reader implements Runnable {
        private final Path input;
        private final BlockingQueue<Job> queue;
        private final long period;

        Reader(Path input, BlockingQueue<Job> queue, long period) {
            this.input = input;
            this.queue = queue;
            this.period = period;
        }

        @Override
        public void run() {
            try (BufferedReader br = Files.newBufferedReader(input)) {
                String line;
                while ((line = br.readLine()) != null) {
                    queue.put(new Job(line, false));
                    Thread.sleep(period);
                }
                queue.put(Job.poison());
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
                Thread.currentThread().interrupt();
            }
        }
    }

    private static class Worker implements Runnable {
        private final BlockingQueue<Job> queue;
        private final long workTime;
        private final Path output;
        private final int id;

        Worker(BlockingQueue<Job> queue, long workTime, Path output, int id) {
            this.queue = queue;
            this.workTime = workTime;
            this.output = output;
            this.id = id;
        }

        @Override
        public void run() {
            try (BufferedWriter bw = Files.newBufferedWriter(output)) {
                while (true) {
                    Job job = queue.take();
                    if (job.poison) {
                        queue.put(job);
                        break;
                    }
                    Thread.sleep(workTime);
                    String processed = processLine(job.line);
                    bw.write(processed);
                    bw.newLine();
                }
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
                Thread.currentThread().interrupt();
            }
        }

        private String processLine(String line) {
            if (id == 1) {
                return line.toUpperCase();
            } else {
                return new StringBuilder(line).reverse().toString();
            }
        }
    }
}
