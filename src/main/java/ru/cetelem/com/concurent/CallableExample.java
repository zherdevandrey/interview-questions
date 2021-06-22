package ru.cetelem.com.concurent;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class CallableExample {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        FutureTask<Integer> futureTask = new FutureTask<>(() -> {

            int a = 0;
            for (int i = 0; i < 10; i++) {
                Thread.sleep(100);
                a++;
            }
            return a;
        });

        new Thread(futureTask).start();

        while (true){
            if (futureTask.isDone()){
                System.out.println(futureTask.get());
                break;
            }
        }


    }

}
