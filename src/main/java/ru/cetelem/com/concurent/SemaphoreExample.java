package ru.cetelem.com.concurent;

import lombok.SneakyThrows;

import java.util.concurrent.Semaphore;

public class SemaphoreExample {


    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(2);

        Person person1 = new Person(semaphore);
        Person person2 = new Person(semaphore);
        Person person3 = new Person(semaphore);
        Person person4 = new Person(semaphore);

        person1.start();
        person2.start();
        person3.start();
        person4.start();
    }

    static class Person extends Thread {
        Semaphore table;

        public Person(Semaphore table) {
            this.table = table;
        }

        @SneakyThrows
        @Override
        public void run() {
            table.acquire();
            System.out.println("Start Eating " + Thread.currentThread());
            sleep(100);
            System.out.println("Finish Eating " + Thread.currentThread());
            table.release();
        }
    }

}
