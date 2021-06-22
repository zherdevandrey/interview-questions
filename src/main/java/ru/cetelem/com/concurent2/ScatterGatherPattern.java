package ru.cetelem.com.concurent2;

import lombok.AllArgsConstructor;
import lombok.SneakyThrows;

import java.util.Set;
import java.util.concurrent.*;

public class ScatterGatherPattern {


    public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {
        CountDownLatch countDownLatch = new CountDownLatch(3);
        Set<String> set = new CopyOnWriteArraySet<String>();
//
//        CustomThread thread_1 = new CustomThread(set, countDownLatch);
//        CustomThread thread_2 = new CustomThread(set, countDownLatch);
//        CustomThread thread_3 = new CustomThread(set, countDownLatch);
//
//        ExecutorService executorService = Executors.newFixedThreadPool(10);
//
//        executorService.submit(thread_1);
//        executorService.submit(thread_2);
//        executorService.submit(thread_3);
//
//        boolean await = countDownLatch.await(3, TimeUnit.SECONDS);
//
//        System.out.println(await);
//
//        System.out.println("executorService shutdown");
//        executorService.shutdown();;
//
//
//        set.forEach(System.out::println);


        CompletableFuture<Void> a1 = CompletableFuture.runAsync(() -> new CustomThread(set).start());
        CompletableFuture<Void> a2 = CompletableFuture.runAsync(() -> new CustomThread(set).start());
        CompletableFuture<Void> a3 = CompletableFuture.runAsync(() -> new CustomThread(set).start());



        CompletableFuture<Void> voidCompletableFuture = CompletableFuture.allOf(a1, a2, a3);

        voidCompletableFuture.get(3, TimeUnit.SECONDS);

        set.forEach(System.out::println);
    }


}

@AllArgsConstructor
class CustomThread extends Thread {

    Set<String> set;

    @SneakyThrows
    @Override
    public void run() {
        Thread.sleep(1000);
        set.add(Thread.currentThread().getName());

    }
}