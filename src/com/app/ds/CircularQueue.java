package com.app.ds;

public class CircularQueue<E> {


    public Node<E> tailNode;

    int size;

    public CircularQueue() {
    }

    public static void main(String[] args) {
        CircularQueue<String> queue = new CircularQueue<>();
        queue.enqueue("Tarun");
        queue.enqueue("Walia1");
        queue.enqueue("Walia2");
        queue.enqueue("Walia3");
        System.out.println(queue);
        queue.printElements();
    }

    E getData() {
        return null;
    }

    public void enqueue(E data) {
        Node<E> node = new Node<>(data);
        if (tailNode == null) {
            tailNode = node;
            tailNode.nextNode = tailNode;
        } else {
            node.nextNode = tailNode.nextNode;
            tailNode.nextNode = node;
        }
        size++;
    }

    public E dequeue() {
        Node<E> head = tailNode.nextNode;
        if (head == null) {
            return null;
        }

        if(head.nextNode == head){
            tailNode = null;
            size = 0;
            return tailNode.data;
        }

        tailNode.nextNode = head.nextNode;
        head.nextNode = null;
        return head.data;
    }

    public void printElements() {
        Node head = tailNode.nextNode;
        System.out.println("Head : " + head.data);
       do{
            System.out.print(head.data+"  ");
            head = head.nextNode;
        } while (head != tailNode.nextNode);
        System.out.println();
    }
}
