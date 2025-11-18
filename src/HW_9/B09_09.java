package HW_9;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadLocalRandom;

public class B09_09 {

    // Налаштування моделі
    private static final int N_CONVEYORS = 3;
    private static final int PARTS_COUNT  = 40;
    private static final int K_QUEUE      = 3;

    // Інтервали часу (мс)
    private static final long T1 = 200;
    private static final long T2 = 600;
    private static final long T3 = 500;
    private static final long T4 = 1500;

    public static void main(String[] args) throws InterruptedException {
        Semaphore conveyors = new Semaphore(N_CONVEYORS, true);
        QueueStats stats = new QueueStats(K_QUEUE);

        List<Thread> details = new ArrayList<>();

        long startSim = System.currentTimeMillis();

        for (int i = 0; i < PARTS_COUNT; i++) {
            Detail d = new Detail(i + 1, conveyors, stats, T3, T4);
            details.add(d);
            d.start();

            long sleep = randomBetween(T1, T2);
            Thread.sleep(sleep);
        }

        for (Thread d : details) {
            d.join();
        }

        long endSim = System.currentTimeMillis();

        System.out.println("=== Результати моделювання ===");
        System.out.println("Кількість конвеєрів: " + N_CONVEYORS);
        System.out.println("Кількість деталей:   " + PARTS_COUNT);
        System.out.println("Поріг K (мін. розмір черги): " + K_QUEUE);
        System.out.println("Тривалість моделювання: " + (endSim - startSim) + " мс");

        System.out.println("Сумарний час очікування в черзі ");
        System.out.println("для деталей, що потрапили в чергу розміром >= " +
                K_QUEUE + ": " + stats.getTotalWaitForAtLeastK() + " мс");
    }

    private static long randomBetween(long min, long max) {
        return ThreadLocalRandom.current().nextLong(min, max + 1);
    }

    private static class Detail extends Thread {
        private final int id;
        private final Semaphore conveyors;
        private final QueueStats stats;
        private final long t3, t4;

        public Detail(int id, Semaphore conveyors, QueueStats stats,
                      long t3, long t4) {
            this.id = id;
            this.conveyors = conveyors;
            this.stats = stats;
            this.t3 = t3;
            this.t4 = t4;
        }

        @Override
        public void run() {
            try {
                boolean counted = false;
                long waitStart = 0;

                if (!conveyors.tryAcquire()) {
                    waitStart = System.currentTimeMillis();

                    counted = stats.onEnterQueue();

                    conveyors.acquire();
                    long waitEnd = System.currentTimeMillis();

                    long myWait = waitEnd - waitStart;
                    stats.onLeaveQueue(counted, myWait);
                }

                long processTime = randomBetween(t3, t4);
                System.out.printf("Деталь #%d на конвеєрі (%.0f мс)%n",
                        id, (double) processTime);
                Thread.sleep(processTime);

                conveyors.release();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }


    private static class QueueStats {
        private final int K;
        private int queueSize = 0;
        private long totalWaitForAtLeastK = 0L;

        public QueueStats(int k) {
            this.K = k;
        }


        public synchronized boolean onEnterQueue() {
            queueSize++;
            return queueSize >= K;
        }

        public synchronized void onLeaveQueue(boolean counted, long waitTime) {
            queueSize--;
            if (counted) {
                totalWaitForAtLeastK += waitTime;
            }
        }

        public synchronized long getTotalWaitForAtLeastK() {
            return totalWaitForAtLeastK;
        }
    }
}
