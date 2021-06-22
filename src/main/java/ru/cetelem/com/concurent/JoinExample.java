package ru.cetelem.com.concurent;

import lombok.*;

import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

public class JoinExample {


    private String st = "";

    public static void main(String[] args) throws InterruptedException {

        Callable callable = () -> {
            Thread.sleep(1000);
            return "Callable";
        };

        FutureTask<String> futureTask = new FutureTask<>(callable);


        Executors.newFixedThreadPool(10)
                .submit(futureTask);

        futureTask.cancel(true);

        Thread.sleep(2000);

        System.out.println("FINISH");




    }

    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    @Setter
    static class MyThread extends Thread {

        private Resource resource;

        @SneakyThrows
        @Override
        public void run() {

            Thread.sleep(1000);
            synchronized(resource){

                boolean b = Thread.holdsLock(resource);
                System.out.println(b);
                super.run();



            }


        }
    }

    static class MyResource {

    }


}
