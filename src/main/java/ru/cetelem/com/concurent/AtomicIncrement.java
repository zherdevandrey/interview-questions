package ru.cetelem.com.concurent;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIncrement {

    private static AtomicInteger sum = new AtomicInteger(0);

    public static void main(String[] args) throws InterruptedException {

        Thread thread_1 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                sum.incrementAndGet();
            }
        });
        Thread thread_2 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                sum.incrementAndGet();
            }
        });

        thread_1.start();
        thread_2.start();

        Thread.sleep(200);
        System.out.println(sum);
    }




}
