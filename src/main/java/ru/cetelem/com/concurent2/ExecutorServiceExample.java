package ru.cetelem.com.concurent2;

import java.awt.*;
import java.util.ArrayList;
import java.util.concurrent.*;

public class ExecutorServiceExample {

    public static void main(String[] args) throws InterruptedException {


        ArrayList<Callable<String>> futures = new ArrayList<>();

        ExecutorService executorService = Executors.newFixedThreadPool(10);

        executorService.invokeAll(futures);


    }

}
