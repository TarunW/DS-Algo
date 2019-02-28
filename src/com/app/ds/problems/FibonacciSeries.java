package com.app.ds.problems;

import java.time.Instant;

public class FibonacciSeries {

    public static void main(String[] args) {
        int n = 20;

        int[] memo = new int[n + 1];

        Long startTime = Instant.now().toEpochMilli();
        for (int c = 0; c <= n; c++) {
            System.out.print(" " + fibRecursive(c));
        }
        Long endTime = Instant.now().toEpochMilli();
        System.out.println("Time taken recursive: " + (endTime - startTime));

        startTime = Instant.now().toEpochMilli();
        for (int c = 0; c <= n; c++) {
            System.out.print(" " + fibRecursive(c, memo));
        }
        endTime = Instant.now().toEpochMilli();
        System.out.println("Time taken with memo: " + (endTime - startTime));

        startTime = Instant.now().toEpochMilli();
        fibIterative(n);
        endTime = Instant.now().toEpochMilli();
        System.out.println("Time taken iterative: " + (endTime - startTime));
    }

    private static int fibRecursive(int a) {
        if (a <= 0) {
            return 0;
        } else if (a == 1) {
            return 1;
        }
        return fibRecursive(a - 1) + fibRecursive(a - 2);
    }

    private static int fibRecursive(int a, int[] memo) {
        if (a <= 0) {
            return 0;
        } else if (a == 1) {
            return 1;
        } else if (memo[a] == 0) {
            memo[a] = fibRecursive(a - 1) + fibRecursive(a - 2);
        }
        return memo[a];
    }

    private static void fibIterative(int c) {

        if (c < 0) {
            System.out.print(" " + 0);
            return;
        }
        if (c == 1) {
            System.out.print(" " + 1);
            return;
        } else {
            int t1=0 ,t2=1;
            System.out.print(" "+t1+" "+t2);
            for (int i = 2; i <= c; i++) {
                int next = t1 + t2;
                System.out.print(" "+ next);
                t1 = t2;
                t2 = next;
            }
        }
    }


}
