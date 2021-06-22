package ru.cetelem.com.concurent;

import lombok.SneakyThrows;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;

import static ru.cetelem.com.concurent.Utils.getLock;

public class Condition {

    static Lock lock = getLock();
    static java.util.concurrent.locks.Condition condition = lock.newCondition();
    static int sum = 0;

    public static void main(String[] args) {


        new AccountMinus().start();
        new AccountPlus().start();
    }

    static class AccountPlus extends Thread {
        @SneakyThrows
        @Override
        public void run() {
            lock.lock();
            System.out.println("ADDING 10 TO SUM");
            Thread.sleep(1000);
            sum += 10;
            condition.signal();
            lock.unlock();
        }
    }

    static class AccountMinus extends Thread {
        @SneakyThrows
        @Override
        public void run() {

            if (sum < 10) {
                lock.lock();
                System.out.println("SUM < 10");
                condition.await(1, TimeUnit.SECONDS);
                System.out.println("SUM = " + sum);
                lock.unlock();
            }
            System.out.println("SUM > 10");
            sum -= 10;

            System.out.println("FINAL " + sum);

        }
    }
}
