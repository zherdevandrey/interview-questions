package ru.cetelem.com.concurent;

import lombok.AllArgsConstructor;

import java.util.concurrent.Phaser;

public class PhaserExample {

    public static void main(String[] args) {

        Phaser phaser = new Phaser(1);

        new JobExecutor(phaser).start();
        new JobExecutor(phaser).start();

        phaser.arriveAndAwaitAdvance();
        System.out.println("PHASE " + phaser.getPhase() + "FINISHED");

        phaser.arriveAndAwaitAdvance();
        System.out.println("PHASE " + phaser.getPhase() + "FINISHED");

        phaser.arriveAndAwaitAdvance();
        System.out.println("PHASE " + phaser.getPhase() + "FINISHED");

    }

    @AllArgsConstructor
    static class JobExecutor extends Thread{

        private Phaser phaser;

        @Override
        public void run() {

            phaser.arriveAndAwaitAdvance();
            System.out.println(Thread.currentThread() + " FIRST JOB");

            phaser.arriveAndAwaitAdvance();
            System.out.println(Thread.currentThread() + " SECOND JOB");

            phaser.arriveAndAwaitAdvance();
            System.out.println(Thread.currentThread() + " THIRD JOB");

        }
    }

}
