package ru.cetelem.com.collections;

import java.util.*;
import java.util.concurrent.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class CopyOnWriteArrayLIstVsSyncArrayList {


    static ExecutorService executorService = Executors.newFixedThreadPool(2);
    static CountDownLatch countDownLatch = new CountDownLatch(2);

    public static void main(String[] args) throws InterruptedException, ExecutionException {

         List<Integer> collect = IntStream.range(0, 100_000_000)
                .boxed().collect(Collectors.toList());

         List<Integer> copyList = new CopyOnWriteArrayList<>(collect);
         List<Integer> syncList = new ArrayList<>(collect);

      //  syncList = Collections.synchronizedList(syncList);



        Future<Long> copyListResult = executorService.submit(new ListRunner(copyList));
        Future<Long> syncListResult = executorService.submit(new ListRunner(syncList));

        countDownLatch.await();

        Long copyListResultLong = copyListResult.get();
        Long syncListResultLong = syncListResult.get();

        System.out.println(copyListResultLong);
        System.out.println(syncListResultLong);

    }

    static class ListRunner implements Callable<Long> {

        List<Integer> list;

        public ListRunner(List<Integer> list) {
            this.list = list;
        }

        @Override
        public Long call() throws Exception {
            countDownLatch.countDown();
            System.out.println("STARTED " + Thread.currentThread().getName());
            long start = System.currentTimeMillis();
            Iterator<Integer> iterator = list.iterator();
            while (iterator.hasNext()){
                iterator.next();
            }
            return System.currentTimeMillis() - start;
        }
    }

    public static synchronized void fillList(List<Integer> copyList){
        IntStream.range(0,100_000_0)
                .forEach(copyList::add);
    }

}








