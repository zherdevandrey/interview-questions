package ru.cetelem.com.concurent2;

import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import ru.cetelem.com.concurent.Utils;

import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierExample {

    public static void main(String[] args) throws InterruptedException {

        CyclicBarrier cyclicBarrier = new CyclicBarrier(2, new Marathon());

        new Runner(cyclicBarrier).start();
        new Runner(cyclicBarrier).start();

        Thread.sleep(10000);

    }

}


@AllArgsConstructor
class Marathon extends Thread {

    @Override
    public void run() {
        System.out.println("BABAH BABAH BABAH");
    }
}


@AllArgsConstructor
class Runner extends Thread {

    private CyclicBarrier cyclicBarrier;

    @SneakyThrows
    @Override
    public void run() {
        System.out.println(Thread.currentThread() + " started");
        //Utils.sleep(1000);
        cyclicBarrier.await();
        System.out.println(Thread.currentThread() + " finished");
    }
}
