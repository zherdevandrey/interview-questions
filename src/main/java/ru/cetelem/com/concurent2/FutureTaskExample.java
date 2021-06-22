package ru.cetelem.com.concurent2;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FutureTaskExample {

    public static void execute(String[] args) throws ExecutionException, InterruptedException {
        java.util.concurrent.FutureTask<String> futureTask = new java.util.concurrent.FutureTask<String>(() -> {
            Thread.sleep(1000);
            return "HELLO";
        });
        ExecutorService executorService = Executors.newFixedThreadPool(20);
        executorService.submit(futureTask);
        System.out.println(futureTask.get());
    }

}
