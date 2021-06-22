package ru.cetelem.com.concurent;

import lombok.AllArgsConstructor;

import java.util.concurrent.CountDownLatch;

public class CountDownLaunch {

    public static void main(String[] args) throws InterruptedException {

        CountDownLatch countDownLatch = new CountDownLatch(3);

        new MyThread(countDownLatch).start();
        new MyThread(countDownLatch).start();
        new MyThread(countDownLatch).start();


        countDownLatch.await();

        System.out.println("FINISHED");
    }

    @AllArgsConstructor
    static class MyThread extends Thread{

        private CountDownLatch countDownLatch;

        @Override
        public void run() {
            System.out.println("WORKING");
            Utils.sleep(1000);
            System.out.println("WORK DONE");
            countDownLatch.countDown();
            Utils.sleep(100);
            System.out.println("OTHER WORK");
        }
    }



}
