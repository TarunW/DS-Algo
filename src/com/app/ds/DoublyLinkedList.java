package com.app.ds;

import java.util.LinkedList;

public class DoublyLinkedList<T> {

    transient Node tail, head;

    transient int size = 0;


    private static class Node<T> {
        T data;
        Node next;
        Node prev;

        public Node(T data) {
            this.data = data;
            next = null;
            prev = null;
        }
    }

    public DoublyLinkedList() {

    }

    public void add(T data) {
        Node newNode = new Node(data);
        if (tail == null) {
            head = tail = newNode;
        } else {
            Node temp = tail;
            tail = newNode;
            temp.next = newNode;
            newNode.prev = temp;
        }
        size++;
    }

    public boolean delete(T data) {



        Node temp = head;

        while (temp != null) {
            if (temp.data.equals(data)) {

                Node prev = temp.prev;
                Node next = temp.next;

                if(prev == null){
                    head = next;
                }else{
                    prev.next = next;
                    temp.prev = null;
                }
                if(next == null){
                    tail = prev;
                } else{
                    next.prev = prev;
                    temp.next = null;
                }

                temp.data = null;
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

    public void delRec(T data) {

    }

    public boolean contains(T item) {
        Node currentNode = head;
        while (currentNode != null) {
            if (currentNode.data.equals(item)) {
                return true;
            }
            currentNode = currentNode.next;
        }
        return false;
    }

    public void print() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " , ");
            temp = temp.next;
        }
        System.out.println();
    }
}
