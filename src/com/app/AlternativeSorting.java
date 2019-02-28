package com.app;

import java.util.Arrays;

public class AlternativeSorting {
	
	public static void main(String[] args) {
		
		int a[] = {7, 1, 2, 3, 4, 5, 6 , 10 ,11};
		
		 Arrays.sort(a);
		 int j = 0 , k = a.length;
		 for (int i = 0; i < a.length/2; i++) {
			System.out.print(a[j] + "  ");
			System.out.print(a[k-1] + "  ");
			j++;			
			k--;
		}
		
	}

}
