package ru.cetelem.com.concurent2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class StopThreadITenMin {

    public static void main(String[] args) {

        ExecutorService executorService = Executors.newFixedThreadPool(10);

        executorService.submit(() -> {


            while (!Thread.currentThread().isInterrupted()){

                //
            }


        });




        executorService.shutdown();



    }


}
