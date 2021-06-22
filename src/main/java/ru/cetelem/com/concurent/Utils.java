package ru.cetelem.com.concurent;

import java.util.concurrent.locks.Lock;

public class Utils {

    public static void sleep(int sec)  {
        try {
            Thread.sleep(sec);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static Lock getLock()  {
        return new java.util.concurrent.locks.ReentrantLock();
    }

}
