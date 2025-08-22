package com.learn.antAssement;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;

public class Question1 {
    public static void main(String[] args) throws InterruptedException {
        final int n = 5;
        ExecutorService executor = Executors.newFixedThreadPool(n);

        CountDownLatch readyLatch = new CountDownLatch(n);
        CountDownLatch startLatch = new CountDownLatch(1);

        for (int i = 1; i <= n; i++) {
            final int carId = i;
            executor.submit(() -> {
                try {
                    System.out.printf("Car %d: already on the starting line\n", carId);
                    readyLatch.countDown();
                    startLatch.await();

                    int runTime = ThreadLocalRandom.current().nextInt(500, 2000);
                    Thread.sleep(runTime);

                    System.out.printf("Car %d: finish after %d ms\n", carId, runTime);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            });
        }

        readyLatch.await();
        System.out.println("All car already. Start!!!");
        startLatch.countDown();
        executor.shutdown();
    }
}
