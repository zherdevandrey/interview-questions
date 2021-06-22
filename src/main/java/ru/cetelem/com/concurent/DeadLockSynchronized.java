package ru.cetelem.com.concurent;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public class DeadLockSynchronized {


    public static void main(String[] args) throws InterruptedException {

        Account first = new Account(200);
        Account second = new Account(200);

        // new PaymentService().transfer(first, second, 100);

        Thread thread1 = new Thread(() -> transfer(first, second, 100));
        Thread thread2 = new Thread(() -> transfer(second, first, 100));

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.println(first);
        System.out.println(second);

    }

    public static void transfer(Account from, Account to, int amount) {



        synchronized (from) {
            synchronized (to) {
                from.deduct(amount);
                to.add(amount);
            }
        }

    }

}




@Data
@AllArgsConstructor
@NoArgsConstructor
class Account {

    private int sum;

    public void deduct(int amount) {
        sum = sum - amount;
    }

    public void add(int amount) {
        sum = sum + amount;
    }

}
