package ru.cetelem.com.concurent;

public class IncrementTypes {

    public static void main(String[] args) {
        int x = 10, c = 10;
        final int y = 13 - x++;
        final int z = 13 - ++c;

        System.out.println("y: " + y + ", z: " + z);
    }

}
