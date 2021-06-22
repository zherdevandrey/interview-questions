package ru.cetelem.com.concurent2;

import lombok.SneakyThrows;

import java.util.TreeMap;

import static ru.cetelem.com.concurent.Utils.sleep;

public class Interview {
    public static void main(String[] args) {

        Service service = new Service();

        service.test();

    }
}

class Service{
    int[] arr = new int[1_000];
     boolean finish;

    void fillArray(){
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }
        finish = true;
        System.out.println("FILL FINISHED " + finish);
    }

    @SneakyThrows
    void print() {
        while (true){
            sleep(1000);
            System.out.println("IS FINISHED " + finish);
            if (finish){
                for (int i = 0; i < arr.length; i++) {
                    System.out.println(arr[i]);
                }
            }
        }
    }

    @SneakyThrows
    void test(){
        Thread thread1 = new Thread(this::fillArray);
        Thread thread2 = new Thread(this::print);

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();
    }
}