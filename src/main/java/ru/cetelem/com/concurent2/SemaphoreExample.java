package ru.cetelem.com.concurent2;

import lombok.AllArgsConstructor;
import lombok.SneakyThrows;

import java.util.concurrent.Semaphore;

public class SemaphoreExample {

    public static void main(String[] args) {

        Semaphore semaphore = new Semaphore(2);

        while (true){
            new Person(semaphore).start();
        }


    }

}

@AllArgsConstructor
class Person extends Thread{

    Semaphore semaphore;


    @SneakyThrows
    @Override
    public void run() {

        semaphore.acquire();

        System.out.println("operation started");

        sleep(1000);


        System.out.println("operation finished");

        semaphore.release();



    }
}
