package ru.cetelem.com.concurent2;

import lombok.AllArgsConstructor;
import lombok.SneakyThrows;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchExample {

    public static void main(String[] args) {

        CountDownLatch countDownLatch = new CountDownLatch(2);

        MyThread first = new MyThread(countDownLatch);
        MyThread second = new MyThread(countDownLatch);

        first.start();
        second.start();

    }
}

@AllArgsConstructor
class MyThread extends Thread {

    private CountDownLatch countDownLatch;

    @SneakyThrows
    @Override
    public void run() {
        sleep(1000);
        System.out.println("working " + Thread.currentThread().getName());
        countDownLatch.countDown();
        System.out.println("finished " + Thread.currentThread().getName());
    }
}