package ru.cetelem.com.concurent;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorsExample {

    public static void main(String[] args) {

        ExecutorService executorService = Executors.newFixedThreadPool(1000000);

        while (true){
            executorService.submit(() -> {
                try {
                    Thread.sleep(100);
                    System.out.println(Thread.currentThread());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }



    }

}
