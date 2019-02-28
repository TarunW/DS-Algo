package com.app.ds.problems;

import com.app.ds.Node;
import com.app.ds.SinglyLinkedList;

import java.util.Arrays;

public class SortLinkedList {

    public static void main(String[] args) {
        SinglyLinkedList list = SinglyLinkedList.dummy10Strings();
        list.print();
        System.out.print("***" + list.size);
        doWork(list.head);

        int[] a = new int[]{7,1,2,4,3,5,6};
        System.out.printf(Arrays.toString(a));
        //insertionSort(a);
        System.out.printf(Arrays.toString(a));
    }

    public static void doWork(Node head) {

    }



}
