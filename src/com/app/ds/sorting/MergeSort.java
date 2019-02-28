package com.app.ds.sorting;

import java.util.Arrays;

public class MergeSort {

    public static void main(String[] args) {
        int[] a = new int[] {5,6,3,2,9,0,1,22};
        mergeSort(a);
        System.out.println(Arrays.toString(a));
    }

    private static void mergeSort(int[] a) {
        mergeSort(a,new int[a.length],0,a.length-1);
    }

    private static void mergeSort(int[] a,int[] temp, int leftStart, int rightEnd) {
        if(leftStart >=rightEnd){
            return;
        }
        int middle = (leftStart+rightEnd)/2;
        mergeSort(a,temp,leftStart,middle);
        mergeSort(a,temp,middle+1,rightEnd);
        mergeHalves(a,temp,leftStart,rightEnd);
    }

    private static void mergeHalves(int[] a,int[] temp,int leftStart, int rightEnd) {
        int leftEnd = (leftStart+rightEnd)/2;
        int rightStart = leftEnd+1;
        int size = rightStart - leftStart + 1;
    }
}
