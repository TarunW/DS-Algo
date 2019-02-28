package com.app.ds.problems;

import com.app.ds.CircularQueue;
import com.app.ds.Node;
import com.app.ds.SinglyLinkedList;

public class LoopInCircularQueue {

    public static void main(String[] args) {

        CircularQueue<Integer> queue = new CircularQueue<>();
        for(int i =0; i <10 ; i++){
            queue.enqueue(i);
        }

        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
        for(int i =0; i <10 ; i++){
            list.add(i);
        }

       System.out.println("In this queue loop exist");
//        queue.printElements();
       System.out.println(isLoopExist(queue.tailNode));

 //       System.out.println("In this list loop does not exist");
//        System.out.println(isLoopExist(list.head));

//        System.out.println("Find loop start in the queue");
  //     System.out.println(findLoopStartNode(queue.tailNode).data);

    //    System.out.println("Find loop start in the list");

      //  System.out.println(findLoopStartNode(list.head));

        SinglyLinkedList<Integer> list2 = new SinglyLinkedList<>();
        for(int i =0; i <50 ; i++){
            list2.add(i);
        }

        list2.tail.nextNode = list2.head.nextNode.nextNode.nextNode.nextNode.nextNode.nextNode;
        System.out.println(list2.tail.nextNode.data);
        System.out.println(isLoopExist(list2.head));

        System.out.println(findLoopStartNode(list2.head));



    }

    public static boolean isLoopExist(Node head){
        Node slowPointer = head;
        Node fastPointer = head;
        while (fastPointer != null && fastPointer.nextNode != null){
            fastPointer = fastPointer.nextNode.nextNode;
            slowPointer = slowPointer.nextNode;
            if(fastPointer == slowPointer){
                return true;
            }
        }
        return false;
    }

    public static Node findLoopStartNode(Node head){
        Node slowPointer = head;
        Node fastPointer = head;
        boolean loopExist = false;
        int movedU = 0;
        while (fastPointer != null && fastPointer.nextNode != null){
            fastPointer = fastPointer.nextNode.nextNode;
            slowPointer = slowPointer.nextNode;
            System.out.println("Moved upped  : "  + ++movedU);
            if(fastPointer == slowPointer){
                loopExist = true;
                break;
            }
        }
        int moved = 0;
        if(loopExist){
            slowPointer = head;
            while (slowPointer != fastPointer){
                slowPointer = slowPointer.nextNode;
                fastPointer = fastPointer.nextNode;
                System.out.println("Moved " + ++moved);
            }
            return slowPointer;
        }else{
            return null;
        }


    }
}
