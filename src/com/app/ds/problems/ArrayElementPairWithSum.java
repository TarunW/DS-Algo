package com.app.ds.problems;

import oracle.sysman.emSDK.emd.dtd.In;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ArrayElementPairWithSum {

    public static void main(String[] args) {
        int[] a = new int[]{1, 3, 4, 5, 7, 8, 9};
        int sum = 8;
        int[] pair = hasPairWithSumSorted(a, sum);
        System.out.println(Arrays.toString(pair));
        System.out.println(a[pair[0]]+a[pair[1]]);


        a = new int[]{10,12,23,44,10, 3, 4, 2, 7, 8, 9};
        boolean found = hasPairWithSumUnSorted(a, sum);
        System.out.println("Found : " + found);
    }

    private static boolean hasPairWithSumUnSorted(int[] a, int sum) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < a.length; i++) {
            if(set.contains(sum-a[i])){
                return true;
            }
            set.add(a[i]);
        }
        return false;
    }

    private static int[] hasPairWithSumSorted(int[] a, int sum) {
        int low = 0;
        int high = a.length - 1;
        while (low <= high) {
            int sumOfPairs = a[low] + a[high];
            if (sumOfPairs == sum) {
                return new int[] {low,high};
            } else if (sumOfPairs >= sum) {
                high--;
            } else {
                low++;
            }
        }
        return new int[]{-1,-1};
    }


}
