package ru.cetelem.com.concurent;

public class VolatileTopic {

    private static int sum = 0;

    public static void main(String[] args) throws InterruptedException {
        Thread thread_1 = new Thread(() -> {
            while (sum < 5) {

                System.out.println("WRITE VAL" +  (++sum));
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread thread_2 = new Thread(() -> {

            int localVar = sum;
            while (sum < 5) {

                if (localVar != sum){
                    System.out.println("READ " + sum);
                }
            }
        });

        thread_1.start();
        thread_2.start();


        Thread.sleep(1000);
    }

}
