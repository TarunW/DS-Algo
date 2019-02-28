package com.app.ds.sorting;

import java.util.Arrays;

public class InsertionSort {

    public static void main(String[] args) {
        int[] a = new int[] {5,6,3,2,9,0,1,22};
        insertionSort(a);
        System.out.println(Arrays.toString(a));
    }

    public static void insertionSort(int[] a) {

        for (int i = 0; i < a.length ; i++) {
            int value = a[i];
            int hole = i;
            while (hole >= 1 && a[hole-1] > value ) {
                a[hole] = a[hole-1];
                hole --;
            }
            a[hole] = value;
        }

    }

}
