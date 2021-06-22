package ru.cetelem.com.references;

import java.lang.ref.WeakReference;
import java.util.ArrayList;

//WeakReference хранит ссылку до первой сборки мусора
public class WeekReferenceExample {

    public static void main(String[] args) throws InterruptedException {

        MyObject myObject = new MyObject();

        WeakReference<MyObject> weakReference = new WeakReference<>(myObject);
        myObject = null;

        System.out.println(weakReference.get());
        System.gc();
        System.gc();
        System.gc();
        System.gc();
        System.gc();
        System.gc();
        System.gc();
        System.out.println(weakReference.get());
    }

}

class MyObject{

    @Override
    protected void finalize() throws Throwable {

        System.out.println("finalize");

    }
}
