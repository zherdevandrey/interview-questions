package ru.cetelem.com.concurent;

import java.util.concurrent.locks.Lock;

import static ru.cetelem.com.concurent.Utils.getLock;
import static ru.cetelem.com.concurent.Utils.sleep;

public class TryLockClass {

    static Lock lock = getLock();

    public static void main(String[] args) {


        new Thread(() -> {
            lock.lock();
            System.out.println("Thread1 WORKING");
            sleep(1000);
            lock.unlock();
        }).start();

        new Thread(() -> {

            while (true){
                if (lock.tryLock()){
                    System.out.println(Thread.currentThread() + "Thread2 WORKING");
                    break;
                }else {
                    System.out.println(Thread.currentThread() + "Thread2 WAITING");
                    sleep(100);
                }
            }

        }).start();

    }

}
