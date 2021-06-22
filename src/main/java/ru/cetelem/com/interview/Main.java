package ru.cetelem.com.interview;


import lombok.Getter;
import lombok.Setter;

import java.util.List;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        List<Integer> list = new java.util.LinkedList<>();

        list.add(1);
        list.add(2);
        list.add(3);

        list.add(2, 5);

        list.forEach(System.out::println);

    }


}

@Setter
@Getter
class Node {
    private Integer value;
    private Node next;
    private Node prev;
}

class LinkedList {
    private Node head;
    private Node tail;

    public void remove(Integer value) {
        Node current = head;

        while (current.getNext() != null) {

            if (current.getValue() == value) {
                if (current == head) {
                    head = current.getNext();
                    head.setPrev(null);
                }
                if (current == tail) {
                    tail = current.getPrev();
                    tail.setNext(null);
                }
                Node prev = current.getPrev();
                Node next = current.getNext();
                prev.setNext(next);
                next.setPrev(prev);
                return;
            }else {
                current = current.getNext();
            }

        }
    }

    public void add(Integer prev, Integer next, Integer value) {

    }
}



