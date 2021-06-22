package ru.cetelem.com.concurent;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.concurrent.locks.Lock;


public class ReentrantLock {

    public static void main(String[] args) throws InterruptedException {
        CommonResource resource = new CommonResource();
        resource.setSum(5);
        Thread thread1 = new Thread(resource::increase);
        Thread thread2 = new Thread(resource::increase);
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        Thread.sleep(100);
        System.out.println(resource.getSum());
    }
}


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
class CommonResource {

    private int sum;
    Lock lock = new java.util.concurrent.locks.ReentrantLock();

    public void increase() {

        lock.lock();

        System.out.println("1" + Thread.currentThread());
        Thread.yield();
        int sum1 = this.sum;
        System.out.println("2" + Thread.currentThread() + " " + sum1);
        sum1++;
        System.out.println("3" + Thread.currentThread() + " " + sum1);
        this.sum = sum1;
        System.out.println("4" + Thread.currentThread());

        lock.unlock();

    }



}