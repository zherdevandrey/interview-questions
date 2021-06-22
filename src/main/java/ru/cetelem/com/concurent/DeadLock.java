package ru.cetelem.com.concurent;

import lombok.AllArgsConstructor;
import lombok.Setter;

public class DeadLock {

    public static void main(String[] args) {
        ResourceA resourceA = new ResourceA();
        ResourceB resourceB = new ResourceB();

        resourceA.setResourceB(resourceB);
        resourceB.setResourceA(resourceA);

        Thread thread1 = new Thread(resourceA::getResource);
        Thread thread2 = new Thread(resourceB::getResource);

        thread1.start();
        thread2.start();
    }


    @Setter
    static class ResourceA {
        private ResourceB resourceB;

        public synchronized int getResource() {
            System.out.println("ResourceA " + Thread.currentThread());
            return resourceB.getI();
        }

        public synchronized int getI() {
            System.out.println("ResourceA " + Thread.currentThread());
            return 1;
        }
    }

    @Setter
    static class ResourceB {
        private ResourceA resourceA;

        public synchronized int getResource() {
            System.out.println("ResourceB " + Thread.currentThread());
            return resourceA.getI();
        }

        public synchronized int getI() {
            System.out.println("ResourceB " + Thread.currentThread());
            return 1;
        }
    }
}
