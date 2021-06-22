package ru.cetelem.com.concurent2;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

import static ru.cetelem.com.concurent.Utils.sleep;

public class ProducerConsumerExample {


    public static void main(String[] args) {

        Queue<Integer> integers = new ArrayBlockingQueue<Integer>(10);

        new Thread(() -> {

            int i = 0;
            while (true){
                i++;
                sleep(1000);
                integers.add(i);
            }

        }).start();


        new Thread(() -> {

            int i = 0;
            while (true){
                sleep(1000);

                Integer poll = integers.poll();

                if (poll != null){
                    System.out.println(poll);
                }

                System.out.println(poll);
            }

        }).start();


    }


}
