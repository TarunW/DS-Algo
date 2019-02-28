package com.app.ds.sorting;

import java.util.Arrays;

public class QuickSort {
    public static void quickSort(int a[], int left,int right){
        if(left >= right){
            return;
        }
        int pivot = a[(left+right)/2];
        int index = partition(a,left,right,pivot);
        quickSort(a,left,index-1);
        quickSort(a,index,right);
    }

    private static int partition(int[] a, int left, int right, int pivot) {
        while (left <= right){
            while (a[left] <pivot){
                left++;
            }
            while (a[right] > pivot){
                right--;
            }
            if(left <=right){
                swap(a,left,right);
                left++;
                right--;
            }

        }
        return left;
    }

    private static void swap(int[] a, int left, int right) {
        int temp = a[left];
        a[left] = a[right];
        a[right] = temp;
    }

    public static void main(String[] args) {
        int[] a = new int[] {5,6,3,2,9,0,1,22};
        quickSort(a,0,a.length-1);
        System.out.println(Arrays.toString(a));
    }
}
