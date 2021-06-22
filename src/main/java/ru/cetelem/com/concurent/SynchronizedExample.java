package ru.cetelem.com.concurent;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public class SynchronizedExample {

    public static void main(String[] args) throws InterruptedException {
        Resource resource = new Resource();
        resource.setSum(5);
        Thread thread1 = new Thread(resource::testYield);
        Thread thread2 = new Thread(resource::testYield);
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        Thread.sleep(100);
        System.out.println(resource.getSum());
    }
}


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
class Resource {

    private int sum;

    public void increase() {
        synchronized (this) {
            System.out.println("1" + Thread.currentThread());
            Thread.yield();
            int sum1 = this.sum;
            System.out.println("2" + Thread.currentThread() + " " + sum1);
            sum1++;
            System.out.println("3" + Thread.currentThread() + " " + sum1);
            this.sum = sum1;
            System.out.println("4" + Thread.currentThread());
        }
    }

    public void testYield() {

        for (int i = 0; i < 1000; i++) {
            System.out.println(i + " before " + Thread.currentThread());
            Thread.yield();
            System.out.println(i + " after " + Thread.currentThread());
        }

    }


}