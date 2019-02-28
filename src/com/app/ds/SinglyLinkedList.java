package com.app.ds;

import java.util.LinkedList;
import java.util.UUID;

public class SinglyLinkedList<T> {

	public transient Node tail, head;

	public transient int size = 0;



	public SinglyLinkedList() {

	}

    public static SinglyLinkedList dummy10Strings() {
        SinglyLinkedList<String> list = new SinglyLinkedList<>();
        for(int i =0; i <10 ; i++){
            list.add(UUID.randomUUID().toString());

        }
        return list;
    }

    public void add(T data) {
		Node newNode = new Node(data);
		if (tail == null) {
			head = tail = newNode;
		} else {
			Node temp = tail;
			tail = newNode;
			temp.nextNode = newNode;
		}
        size++;
	}

	public boolean delete(T data) {

        LinkedList<String> ll;
		if(head.data == data){			
			head = head.nextNode;
            size--;
			return true;
		}
				
		Node temp = head.nextNode;
		Node prev = head;
		
		while (temp.nextNode != null) {
			if (temp.data.equals(data)) {
                prev.nextNode = temp.nextNode;
                size--;
                return  true;
			}
			prev = temp;
			temp = temp.nextNode;
		}

		if(temp != null && temp.data.equals(data)){
		    prev.nextNode = null;
		    tail = prev;
            size--;
        }
     return false;
	}
	
	public void delRec(T data){
		
	}

	public boolean contains(T item) {
		Node currentNode = head;
		while (currentNode != null) {
			if (currentNode.data.equals(item)) {
				return true;
			}
			currentNode = currentNode.nextNode;
		}
		return false;
	}

	public void print() {
		Node temp = head;
		while (temp != null) {
			System.out.print(temp.data + " , ");
			temp = temp.nextNode;
		}
		System.out.println();
	}
}
