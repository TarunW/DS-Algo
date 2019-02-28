package com.app.ds.problems;

import com.app.ds.Node;
import com.app.ds.SinglyLinkedList;

public class NthNodeFromLast {

    public static void main(String[] args) {
        SinglyLinkedList<String> list = new SinglyLinkedList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");
        list.add("6");
        list.add("7");
        list.add("8");


        list.print();
        Node node = doWork(list, 1);
        System.out.println(node.data);
    }

    public static Node doWork(SinglyLinkedList list, int nth) {

        Node tempNode = list.head;
        Node nthFromTheEnd = list.head;
        for (int i = 1; i <= nth; i++) {
            tempNode = tempNode.nextNode;
        }

        while (tempNode != null) {
            tempNode = tempNode.nextNode;
            nthFromTheEnd = nthFromTheEnd.nextNode;
        }
        return nthFromTheEnd;
    }

}
