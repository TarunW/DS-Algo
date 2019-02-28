package com.app.ds.problems;

import com.app.ds.Node;
import com.app.ds.SinglyLinkedList;

public class FindListIntersection {

    public static <E> boolean doWork(SinglyLinkedList<E> list1, SinglyLinkedList<E> list2) {
        SinglyLinkedList bigList, smallList;
        if (list1.size > list2.size) {
            bigList = list1;
            smallList = list2;
        } else {
            bigList = list2;
            smallList = list1;
        }

        int diff = bigList.size - smallList.size;
        Node head1 = bigList.head;
        Node head2 = smallList.head;

        for (int i = 0; i < diff; i++) {
            head1 = head1.nextNode;
        }

        while (head1 != null && head2 != null){
            if(head1 == head2){
                System.out.println(head1.data);
                return true;
            }
            head1 = head1.nextNode;
            head2 = head2.nextNode;
        }
        return false;
    }

    public static void main(String[] args) {

        SinglyLinkedList<Integer> list1 = new SinglyLinkedList<>();
        for (int i = 0; i < 10; i++) {
            list1.add(i);
        }

        SinglyLinkedList<Integer> list2 = new SinglyLinkedList<>();
        for (int i = 0; i < 5; i++) {
            list2.add(i);
        }

        SinglyLinkedList<Integer> list3 = new SinglyLinkedList<>();
        for (int i = 10; i < 15; i++) {
            list3.add(i);
        }

        list1.tail.nextNode = list3.head;
        list2.tail.nextNode = list3.head;

        list1.print();

        list2.print();
        System.out.println(doWork(list1, list2));
    }
}
