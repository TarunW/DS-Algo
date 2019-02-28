package com.app.ds.problems;

public class SortArrayofZeroOneAndTwo {

    public static void main(String[] args) {
        int[] arr = {1, 0, 1, 2, 1, 2, 1, 0, 1, 0, 0};
        SortArrayofZeroOneAndTwo app = new SortArrayofZeroOneAndTwo();
        app.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print("  " + arr[i]);

        }

    }

    public void sort(int[] arr) {
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("Input is null");
        }

        int lo = 0;
        int hi = arr.length - 1;
        int mid = 0;

        int temp = 0;

        while (mid <= hi) {
            if (arr[mid] == 0) {
                temp = arr[lo];
                arr[lo] = arr[mid];
                arr[mid] = temp;
                lo++;
                mid++;
            } else if (arr[mid] == 1) {
                mid++;
            } else {
                temp = arr[hi];
                arr[hi] = arr[mid];
                arr[mid] = temp;
                hi--;
            }

        }


    }
}
