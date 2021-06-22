package ru.cetelem.com.concurent;

import lombok.SneakyThrows;

public class WaitNotifyFirst {

    public static void main(String[] args) throws InterruptedException {

        MyThad myThad = new MyThad();
        myThad.start();

        synchronized (myThad){
            myThad.wait();
        }

        System.out.println(Thread.currentThread() + " is finished");
    }


}


class MyThad extends Thread{
    @SneakyThrows
    @Override
    public void run() {
        synchronized (this){
            for (int i = 0; i < 5; i++) {
                System.out.println("I'M WORKING " + i);
                sleep(1000);
            }
            notify();
        }

    }
}