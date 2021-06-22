package com.example;

import lombok.Data;

import java.util.LinkedList;

public class TreeExample {

    public static void main(String[] args) {

        Tree root = new Tree(20,
                new Tree(7,
                        new Tree(4),
                        new Tree(9)),

                new Tree(35,
                        new Tree(31),
                        new Tree(40))
        );

        System.out.println(root.sum());
    }


}

@Data
class Tree {
    private int value;
    private Tree left;
    private Tree right;

    public Tree(int value, Tree left, Tree right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }

    public Tree(int value) {
        this.value = value;
    }

    public int sum() {
        int sum = value;

        if (left != null) {
            sum += left.sum();
        }

        if (right != null) {
            sum += right.sum();
        }
        return sum;
    }

    public int deepSum(){
        LinkedList<Tree> stack = new LinkedList<>();
        stack.addFirst(this);

        int sum = 0;
        while (!stack.isEmpty()){
            Tree node = stack.removeFirst();
            int val = node.value;
            sum += val;

            if (node.left != null){
                stack.addFirst(node.left);
            }

            if (node.right != null){
                stack.addFirst(node.right);
            }
        }

        return sum;
    }
}
