package com.learn.concurrency.problem1114;

//Title: 1114. Print in Order
//Link: https://leetcode.com/problems/print-in-order/description/
public class MainApp {
    public static void main(String[] args) throws InterruptedException {

        int[] order = new int[]{1, 3, 2};

        Foo foo = new Foo();
        Thread[] threads = new Thread[3];

        for (int i = 0; i < 3; i++) {
            final int threadNum = order[i];
            threads[i] = new Thread(() -> {
                try {
                    switch (threadNum) {
                        case 1:
                            foo.first(() -> System.out.print("first"));
                            break;
                        case 2:
                            foo.second(() -> System.out.print("second"));
                            break;
                        case 3:
                            foo.third(() -> System.out.print("third"));
                            break;
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }

        for (Thread thread : threads) {
            thread.start();
        }

        for (Thread thread : threads) {
            thread.join();
        }

        System.out.println(); // In một dòng mới sau khi hoàn thành
    }
}
