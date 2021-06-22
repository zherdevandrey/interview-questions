package ru.cetelem.com.references;

import java.awt.*;
import java.lang.ref.SoftReference;
import java.util.ArrayList;

// SoftReference хранит ссылку до того когда забьется память
// по идее после того как память будет забита soft reference должна быть равна null
public class SoftReferenceExample {


    public static void main(String[] args) throws InterruptedException {

        MyObject2 myObject = new MyObject2();

        SoftReference<MyObject2> softReference = new SoftReference<>(myObject);
        myObject = null;

        System.out.println(softReference.get());
        System.gc();
        System.gc();
        System.gc();
        System.gc();

        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < 999_999_99; i++) {
            list.add(i);
        }

        System.gc();
        System.gc();
        System.gc();
        System.gc();
        System.out.println(softReference.get());
    }

}

class MyObject2 {

    @Override
    protected void finalize() throws Throwable {

        System.out.println("finalize");

    }
}
