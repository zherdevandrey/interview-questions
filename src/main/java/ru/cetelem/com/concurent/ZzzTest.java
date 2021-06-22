package ru.cetelem.com.concurent;

import lombok.SneakyThrows;

public class ZzzTest {

    public static void main(String[] args) throws InterruptedException {

        MyThread myThread = new MyThread();
        myThread.start();


        synchronized (myThread){
            myThread.wait();
        }

        System.out.println(Thread.currentThread() + " is finished");

    }

}

class MyThread extends Thread{

    @SneakyThrows
    @Override
    public void run() {
        synchronized (this){
            System.out.println("sleep!!!!");
            sleep(3000);
            System.out.println("done!!!!");
            this.notifyAll();
        }
    }
}
