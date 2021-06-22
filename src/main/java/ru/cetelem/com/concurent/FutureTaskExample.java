package ru.cetelem.com.concurent;

import java.awt.*;
import java.util.ArrayList;
import java.util.concurrent.*;

import static ru.cetelem.com.concurent.Utils.sleep;

public class FutureTaskExample {

    public static void main(String[] args) throws InterruptedException {

        ArrayList<FutureTask<Integer>> futureTasks = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            Callable<Integer> callable = () -> {
               // sleep(100);
                int a = 0;
                for (int j = 0; j < 10000000; j++) {
                    a++;
                }
                return 1;
            };
            futureTasks.add(new FutureTask<>(callable));
        }

        ExecutorService executorService = Executors.newFixedThreadPool(10);

        futureTasks.forEach(executorService::submit);

        futureTasks.forEach(task -> task.cancel(true));

        Thread.sleep(1000);


            futureTasks.forEach(task -> {

                if (task.isDone()){
                    Integer integer = null;
                    try {
                        integer = task.get();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (ExecutionException e) {
                        e.printStackTrace();
                    }
                    System.out.println(integer);
                }

            });



    }

}
