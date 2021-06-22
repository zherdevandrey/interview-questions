package ru.cetelem.com.references;

import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

//метод remove ReferenceQueue в случае наличия ссылки на объект зависает
//если объект был подвержен сборке мусора, то remove вернет nulll
//нужен для проверки освобождения ресурсов
public class PhantomReferenceExample {

    public static void main(String[] args) throws InterruptedException {

        MyObject3 myObject = new MyObject3();


        ReferenceQueue<MyObject3> referenceQueue = new ReferenceQueue<>();
        PhantomReference<MyObject3> phantomReference = new PhantomReference<>(myObject, referenceQueue);

        myObject = null;


        Thread thread = new Thread(() -> {
            try {
                System.out.println("_______");
                referenceQueue.remove();
                System.out.println("REFERENCE WAS REMOVED");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        thread.start();
        thread.join();

        System.gc();

        System.out.println("AFTER GC " + phantomReference.get());
    }

}

class MyObject3{

    @Override
    protected void finalize() throws Throwable {

        System.out.println("finalize");

    }
}
