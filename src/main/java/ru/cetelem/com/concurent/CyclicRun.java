package ru.cetelem.com.concurent;

import lombok.AllArgsConstructor;
import lombok.SneakyThrows;

import java.util.concurrent.CyclicBarrier;

public class CyclicRun {

    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(3, new Marafon());
        new Runner(cyclicBarrier).start();
        System.out.println(cyclicBarrier.getNumberWaiting());
        new Runner(cyclicBarrier).start();
        System.out.println(cyclicBarrier.getNumberWaiting());
        new Runner(cyclicBarrier).start();
        System.out.println(cyclicBarrier.getNumberWaiting());

    }

    static class Marafon extends Thread{
        @Override
        public void run() {
            System.out.println("MARAFON STARTED");
        }
    }


    @AllArgsConstructor
    static class Runner extends Thread{

        private CyclicBarrier cyclicBarrier;

        @SneakyThrows
        @Override
        public void run() {
            System.out.println(Thread.currentThread() + " started");
            Utils.sleep(1000);
            cyclicBarrier.await();
            System.out.println(Thread.currentThread() + " finished");
        }
    }

}
