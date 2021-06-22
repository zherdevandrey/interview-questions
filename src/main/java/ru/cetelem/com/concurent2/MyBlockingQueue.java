package ru.cetelem.com.concurent2;

import lombok.AllArgsConstructor;
import lombok.SneakyThrows;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

import static ru.cetelem.com.concurent.Utils.sleep;


public class MyBlockingQueue<E> {

    private int maxSize;
    private Queue<E> queue = new LinkedList<>();
    private ReentrantLock lock = new ReentrantLock();
    private Condition isFull = lock.newCondition();
    private Condition isEmpty = lock.newCondition();

    public MyBlockingQueue(int maxSize) {
        this.maxSize = maxSize;
    }

    @SneakyThrows
    public void add(E e) {
        lock.lock();

        try {

            if (queue.size() == maxSize) {
                isFull.await();
            }

            queue.offer(e);
            isEmpty.signalAll();


        } finally {
            lock.unlock();
        }


    }

    @SneakyThrows
    public E pool() {
        lock.lock();
        try {
            if (queue.size() == 0) {
                isEmpty.await();
            }
            E remove = queue.remove();
            isFull.signalAll();
            return remove;
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {

        MyBlockingQueue<Integer> integerMyBlockingQueue = new MyBlockingQueue<Integer>(2);

        new Thread(() -> {

            int i = 0;

            while (true){
                sleep(1000);
                integerMyBlockingQueue.add(i);
                i++;
            }


        }).start();

        new Thread(() -> {


            while (true){

                Integer pool = integerMyBlockingQueue.pool();

                if (pool != null){
                    System.out.println(pool);
                }

            }


        }).start();


    }

}
