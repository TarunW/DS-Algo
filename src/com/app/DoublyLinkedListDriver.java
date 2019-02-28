package com.app;


import com.app.ds.DoublyLinkedList;

public class DoublyLinkedListDriver {

    public static void main(String[] args) {
        DoublyLinkedList<String> list = new DoublyLinkedList<>();

        list.add("Tarun");
        list.add("Arjun");
        list.add("Krishna");
        list.add("Karan");
        list.add("Bhishm");
        list.add("Dron");
        list.add("Kripa");

        list.print();

        System.out.println(       list.delete("Tarun"));

        list.print();

        System.out.println(       list.delete("Krishna"));
        list.print();

        list.delete("Kripa");

        list.add("Kripa-achrya");
        System.out.println(        list.delete("Bhishm"));

        list.print();

        System.out.println(        list.delete("Kripa"));

        list.print();

        //System.out.println(list.contains("Kripa"));
        //System.out.println(list.contains("Krishna"));

    }

}
