package com.app;

public class BubbleSort {

	public static void sort1(int[] arr) {

		boolean swapped = true;
		for (int pass = 1; pass < arr.length & swapped; pass++) {
			swapped = false;
			for (int j = 0; j < arr.length - 1; j++) {
				if (arr[j] > arr[j+1]) {
					int t = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = t;
					swapped = true;					
				}
			}

		}

	}
	
	public static void sortRecursiveMax(int[] arr, int pos) {

		if(pos >= arr.length-1) return;
		
		if (arr[pos] > arr[pos+1]) {
			int t = arr[pos];
			arr[pos] = arr[pos + 1];
			arr[pos + 1] = t;						
		}					
		sortRecursiveMax(arr, pos+1);
	}
	
	public static void passRecursive(int[] arr, int pass) {

		if(pass > arr.length) return;		
		sortRecursiveMax(arr,arr.length-pass);
		passRecursive(arr, pass+1);
	}
	

	public static void print(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + "  ");
		}
		System.out.println();
	}

	public static void main(String[] args) {

		int[] a = { 9, 2, 8, 4, 0, 1, 20, 90, 32, 12 };

		// int[] a = { 1, 2, 3, 4, 5, 6 };

		//sort1(a);
		passRecursive(a, 0);
		print(a);

	}

}
